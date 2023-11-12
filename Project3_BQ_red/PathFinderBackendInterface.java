import java.io.FileNotFoundException;

public interface PathFinderBackendInterface {
  // public PathFinderBackendInterface();
  public void loadData(String filename) throws FileNotFoundException;
  public String findShortestPath(String start, String middle, String destination);
  public double findShortestDistance(String start, String middle, String destination);
  public String getStatisticsString();
}
