import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataWranglerTests {
  /**
   * test to make sure an exception is thrown when the given file does not exist
   * even when it is of the correct type.
   */
  @Test
  void test1() {
    LocationReaderDW reader = new LocationReaderDW();
    try {
      reader.readLocationsFromFile("filedoesntexist.dot");
      Assertions.fail();
    } catch (FileNotFoundException e) {
      Assertions.assertTrue(true);
    }
  }

  /**
   * makes sure that when read, all expected elements are present in the list when returned. Calls
   * the size() of the list, compared to the expected 22 locations in the file.
   */
  @Test
  void test2() {
    LocationReaderDW reader = new LocationReaderDW();
    try {
      List<LocationInterface> locations
          = reader.readLocationsFromFile("madisonlocation.dot");
      Assertions.assertEquals(false, locations.isEmpty());
      Assertions.assertEquals(22, locations.size());
    } catch (Exception e) {
      Assertions.fail();
    }
  }

  /**
   * checks that all the data within the read locations from the list line up with
   * the information in the file. This also tests that the location class is working
   * as intended. tests conducted by comparing the expected values to the actual ones.
   */
  @Test
  void test3() {
    LocationReaderDW reader = new LocationReaderDW();
    try {
      List<LocationInterface> locations
          = reader.readLocationsFromFile("madisonlocation.dot");
      Assertions.assertEquals(11, locations.get(10).getID());
      Assertions.assertEquals("Chamberlin Hall", locations.get(10).getName());
      Assertions.assertEquals(6.6670401, locations.get(10).getX());
      Assertions.assertEquals(10.74088916, locations.get(10).getY());

    } catch (Exception e) {
      Assertions.fail();
    }
  }

  /**
   * makes sure the correct edges are returned for a given location. compares the expected edges
   * start and end locations from the file to the actual ones and that the weight is returning
   * the expected result. also tests that the edge class is working as intended and
   * that edges are properly being added.
   */
  @Test
  void test4() {
    LocationReaderDW reader = new LocationReaderDW();
    try {
      List<LocationInterface> locations
          = reader.readLocationsFromFile("madisonlocation.dot");
      List<EdgeInterface> edges = locations.get(10).getEdges();

      Assertions.assertEquals("Chamberlin Hall", edges.get(0).getStart().getName());
      Assertions.assertEquals("Department of Mechanical Engineering", edges.get(0).getEnd().getName());
      Assertions.assertEquals("Chamberlin Hall", edges.get(2).getStart().getName());
      Assertions.assertEquals("Memorial Union", edges.get(2).getEnd().getName());
      Assertions.assertEquals(9.117158965744414, edges.get(0).getWeight());

    } catch (IOException e) {
      Assertions.fail();
    }
  }

  /**
   * makes sure that location and edge classes all have working getters setters and constructors
   * independent of reading from the file.
   */
  @Test
  void test5() {
    try {
      LocationDW location = new LocationDW("House", 12, 51, 1);
      LocationDW location1 = new LocationDW("School", 22, 30, 2);
      EdgeDW edge = new EdgeDW(location, location1);
      location.addEdge(edge);

      List<EdgeInterface> edges = new ArrayList<>();
      edges.add(edge);
      Assertions.assertEquals("House", location.getName());
      Assertions.assertEquals(12, location.getX());
      Assertions.assertEquals(51, location.getY());
      Assertions.assertEquals(1, location.getID());
      Assertions.assertEquals(2, location1.getID());
      Assertions.assertEquals(edges, location.getEdges());
      Assertions.assertEquals(location, location.getEdges().get(0).getStart());
      Assertions.assertEquals(location1, location.getEdges().get(0).getEnd());

    } catch (Exception e) {
      Assertions.fail();
    }
  }
}
