import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.stream.file.FileSource;
import org.graphstream.stream.file.FileSourceFactory;

public class LocationReaderDW implements LocationReaderInterface {

  List<LocationInterface> locations = new ArrayList<>();

  /**
   * read and process a .dot file and turn into a list of locations
   * @param filename file to be read
   * @return a list of each location separated
   * @throws FileNotFoundException if the given file doesn't exist
   */
  @Override
  public List<LocationInterface> readLocationsFromFile(String filename) throws FileNotFoundException {
    Graph g = new MultiGraph("Madison Locations");
    try {
      FileSource fs = FileSourceFactory.sourceFor(filename);
      fs.addSink(g);
      try {
        fs.readAll(filename); // read graph
      } catch (IOException e) {
        throw new FileNotFoundException("Error: file not found");
      } finally {
        fs.removeSink(g);
      }
    } catch (IOException e) {
      throw new FileNotFoundException("Error: file not found");
    }


    int i = 0; // counter to traverse through the graph
    while (g.getNode(i) != null) { // add all locations and edges
      LocationDW loc = new LocationDW(g.getNode(i).toString(),
          Double.parseDouble(g.getNode(i).getAttribute("x").toString()),
          Double.parseDouble(g.getNode(i).getAttribute("y").toString()),
          (int) Double.parseDouble((g.getNode(i).getAttribute("ID").toString())));

      locations.add(loc);
      i++;
    }

    for (int l = 0; l < locations.size(); l++) {
      boolean areEdges = true;
      int j = 0;
      while (areEdges) {
        try {
          if (g.getNode(l).getLeavingEdge(j).getSourceNode().equals(g.getNode(l))) { // find leaving edges
            LocationDW edgeLoc = new LocationDW(g.getNode(l).getLeavingEdge(j).getTargetNode().toString(),
                Double.parseDouble(g.getNode(l).getLeavingEdge(j).getTargetNode().getAttribute("x").toString()),
                Double.parseDouble(g.getNode(l).getLeavingEdge(j).getTargetNode().getAttribute("y").toString()),
                (int) Double.parseDouble((g.getNode(l).getLeavingEdge(j).getTargetNode().getAttribute("ID").toString())));
            for (int k = 0; k < locations.size(); k++) {
              if (locations.get(k).getID() == edgeLoc.getID()) {
                EdgeDW edge = new EdgeDW(locations.get(l), locations.get(k));
                locations.get(l).addEdge(edge); // add to the location's list of leaving edges if not already there
              }
            }
          }
        } catch (IndexOutOfBoundsException e) { // stop looking once all are entered
          areEdges = false;
        }
        j++;
      }
    }


    return locations;
  }
  public List<LocationInterface> getLocations(){
	return locations;
  }

}
