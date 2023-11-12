import java.util.ArrayList;
import java.util.List;

public class LocationDW implements LocationInterface {
  String name; // name of location
  double x; // x-coordinate
  double y; // y-coordinate
  List<EdgeAbstract> edgesLeaving = new ArrayList<>(); // array of edges leaving this location
  int id; // id of this location

  public LocationDW(String name, double x, double y, int id) {
    this.name = name;
    this.x = x;
    this.y = y;
    this.id = id;
  }

  /**
   * getter for the name of this location
   * @return name of this location
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * getter for the x-coordinate of this location
   * @return x-coordinate of this location
   */
  @Override
  public double getX() {
    return x;
  }

  /**
   * getter for the y-coordinate of this location
   * @return y-coordinate of this location
   */
  @Override
  public double getY() {
    return y;
  }

  /**
   * getter for the edges leaving this location
   *
   * @return an array of edges leaving this location
   */
  @Override
  public List<EdgeAbstract> getEdges() { return edgesLeaving; }

  /**
   * Allows to add edges to this location
   * @param edge to be added
   */
  public void addEdge(EdgeAbstract edge) {
    edgesLeaving.add(edge);
  }


  /**
   * getter for the ID of this location
   * @return the ID of this location
   */
  @Override
  public int getID() {
    return id;
  }
}
