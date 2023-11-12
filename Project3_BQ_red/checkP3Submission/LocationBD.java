import java.util.ArrayList;
import java.util.List;

public class LocationBD implements LocationInterface{

  double x;
  double y;
  int id;
  String name;
  List<EdgeAbstract> edges;
  
  public LocationBD(String name, int x, int y, int id) {
    this.x = x;
    this.y = y;
    this.id = id;
    this.name = name;
    edges = new ArrayList<EdgeAbstract>();
  }
  @Override
  public double getX() {
    // TODO Auto-generated method stub
    return this.x;
  }

  @Override
  public double getY() {
    // TODO Auto-generated method stub
    return this.y;
  }

  @Override
  public List<EdgeAbstract> getEdges() {
    return edges;
  }

  @Override
  public int getID() {
    // TODO Auto-generated method stub
    return this.id;
  }

  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return this.name;
  }
  
  
  @Override
  public void addEdge(EdgeAbstract edge) {
    // TODO Auto-generated method stub
    edges.add(edge);
  }  
}

