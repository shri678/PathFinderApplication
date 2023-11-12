public class EdgeDW extends EdgeAbstract implements EdgeInterface{
  LocationInterface start; // start location (predecessor)
  LocationInterface end; // end location (successor)

  public EdgeDW(LocationInterface start, LocationInterface end) {
    this.start = start;
    this.end = end;
  }

  /**
   * getter for the start location of an edge
   * @return the location object representing the predecessor of the edge
   */
  @Override
  public LocationInterface getStart() {
    return start;
  }

  /**
   * getter for the end location of an edge
   * @return the location object representing the successor of the edge
   */
  @Override
  public LocationInterface getEnd() {
    return end;
  }

  /**
   * calculates and returns the weight of an edge given using distance formula
   * @return the weight or distance between nodes (edge)
   */
  @Override
  public double getWeight() {
    return Math.hypot(end.getY() - start.getY(), end.getX() - start.getX());
  }

  @Override
  public double doubleValue() {
    return getWeight();
  }

  @Override
  public float floatValue() {
    return 0;
  }

  @Override
  public int intValue() {
    return 0;
  }

  @Override
  public long longValue() {
    return 0;
  }
}

