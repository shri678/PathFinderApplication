import java.util.List;

public interface LocationInterface {
  //public LocationInterface(String name, double x, double y, int id);
  public String getName();
  public double getX();
  public double getY();
  public List<EdgeAbstract> getEdges();
  public void addEdge(EdgeAbstract edge);
  public int getID();
}
