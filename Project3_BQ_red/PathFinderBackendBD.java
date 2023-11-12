import java.io.FileNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;

public class PathFinderBackendBD implements PathFinderBackendInterface{


  private DijkstraGraphInterface<LocationInterface, EdgeAbstract> graph; //Stores graph of locations
  private LocationReaderInterface readLocation; //

  /**
   * Backend object.
   * 
   * @param graph - the graph object for the project
   * @param readLocation - required to load in the dataset into a graph data structure. 
   */
  public PathFinderBackendBD(DijkstraGraphInterface<LocationInterface, EdgeAbstract> graph, LocationReaderInterface readLocation) {
    this.graph = graph;
    this.readLocation = readLocation;
  }

  @Override
  /**
   * Loads in all of the locations and edges in the file
   * 
   * @param filename - path & filename to insert data from
   */
  public void loadData(String filename) throws FileNotFoundException {
    List<LocationInterface> locations = readLocation.readLocationsFromFile(filename);
    for(LocationInterface l : locations) {
      graph.insertNode(l);
    }

    int counter= 0;
    for(LocationInterface l : locations) {
      for(EdgeAbstract e : l.getEdges()) {
        graph.insertEdge(l, e.getEnd(), e);

      }
    }
  }

  /**
   * Helper method for inserting nodes (locations) and edges (distances between locations)
   *
   * @param location - item inserted into the graph
   */
  private void addLocation(LocationInterface location) {

    graph.insertNode(location);
    for(EdgeAbstract e : location.getEdges()) {
        graph.insertNode(e.getEnd());
        graph.insertEdge(location, e.getEnd(), e);
    }
  }


@Override
  /**
   * Returns the shortest path between the start and destination
   * 
   * @param start - start location 
   * @param destination - end location 
   */
  public String findShortestPath(String start, String middle, String destination) throws NoSuchElementException{

    LocationInterface startLocation = null;
    LocationInterface endLocation = null;
    LocationInterface middleLocation = null;

    for(LocationInterface l : readLocation.getLocations()){
        if(l.getName().equals(start)){
                startLocation = l;
        }
        if(l.getName().equals(destination)){
                endLocation = l;
        }
        if(l.getName().equals(middle)){
                middleLocation = l;
        }

    }

    List<LocationInterface> routeToMiddle = graph.shortestPathData(startLocation, middleLocation);
    List<LocationInterface> routeMiddleToEnd = graph.shortestPathData(middleLocation, endLocation);
    String result = "";

    for(LocationInterface d : routeToMiddle) {
      result += d.getName() + " -> ";
    }

    for(LocationInterface d : routeMiddleToEnd) {
      if(d.getName().equals(middle)) {
        continue;
      }
      result += d.getName() + " -> ";
    }

    result = result.substring(0, result.length()-4);

    return result;

  }


@Override
  /**
   * Calculates the shortest distance between 2 locations and returns the distance 
   * 
   * @param start - start location 
   * @param destination - end location 
   */
  public double findShortestDistance(String start, String middle, String destination) throws NoSuchElementException{

//    double paths = graph.shortestPathCost(start, destination);
//    
//    List<String> route = graph.shortestPathData(start, destination);
//    
//    boolean traveledMiddle = false;
//    
//    for(String s : route) {
//      if(s.equals(middle)) {
//        traveledMiddle = true;
//        break;
//      }
//    }
//    
//    if(!traveledMiddle) {
//      double distanceToMiddle = graph.shortestPathCost(start, middle);
//      double distanceMiddleToEnd = graph.shortestPathCost(middle, destination);
//      
//      return distanceToMiddle + distanceMiddleToEnd;
//    }
//    return paths;


    LocationInterface startLocation = null;
    LocationInterface endLocation = null;
    LocationInterface middleLocation = null;

    for(LocationInterface l : readLocation.getLocations()){
        if(l.getName().equals(start)){
                startLocation = l;
        }
        if(l.getName().equals(destination)){
                endLocation = l;
        }
        if(l.getName().equals(middle)){
                middleLocation = l;
        }

    }
    double distanceToMiddle = graph.shortestPathCost(startLocation, middleLocation);
    double distanceMiddleToEnd = graph.shortestPathCost(middleLocation, endLocation);

    return distanceToMiddle + distanceMiddleToEnd;
  }

@Override
  /**
   * Displays statistics containing the number of locations in the map, 
   */
  public String getStatisticsString() {

    return "Dataset contains " + graph.getNodeCount() + " locations with " + graph.getEdgeCount() + " total paths between all of the locations.";
  }



}
