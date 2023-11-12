import static org.junit.jupiter.api.Assertions.*;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Scanner;
class BackendDeveloperTests {

  /**
   * Tests for an example graph that findShortestDistance() and findShortestPath() 
   * work for valid inputs. 
   * 
   * (The shortest path works without taking into consideration the middle node.
   * Expected to return just the shortest path between start and end nodes.)
   */
  @Test
  void test1() {
    
    DijkstraGraphAE<LocationInterface, EdgeAbstract> dk = new DijkstraGraphAE<LocationInterface, EdgeAbstract>();
    LocationReaderInterface testReader = new LocationReaderBD();
    
    PathFinderBackendBD bd = new PathFinderBackendBD(dk, testReader);
        
    
    LocationInterface A = new LocationBD("A", 0, 2, 1243);
    LocationInterface B = new LocationBD("B", 5, 4, 1244);
    LocationInterface M = new LocationBD("M", 1, 9, 1245);
    LocationInterface G = new LocationBD("G", 3, 4, 1246);
    LocationInterface E = new LocationBD("E", 1, 4, 1247);
    LocationInterface F = new LocationBD("F", 1, 8, 1248);
    LocationInterface D = new LocationBD("D", 1, 4, 1249);
    LocationInterface H = new LocationBD("H", 6, 7, 1250);
    LocationInterface L = new LocationBD("L", 2, 4, 1251);
    LocationInterface I = new LocationBD("I", 1, 5, 1252);
    
    dk.insertNode(A);
    dk.insertNode(B);
    dk.insertNode(M);
    dk.insertNode(G);
    dk.insertNode(E);
    dk.insertNode(F);
    dk.insertNode(D);
    dk.insertNode(H);
    dk.insertNode(L);
    dk.insertNode(I);
    
    
    testReader.getLocations().add(A);
    testReader.getLocations().add(B);
    testReader.getLocations().add(M);
    testReader.getLocations().add(G);
    testReader.getLocations().add(E);
    testReader.getLocations().add(F);
    testReader.getLocations().add(D);
    testReader.getLocations().add(H);
    testReader.getLocations().add(L);
    testReader.getLocations().add(I);
    
    EdgeAbstract aTob = new EdgeBD(A, B);
    EdgeAbstract aTom = new EdgeBD(A, M);
    EdgeAbstract aToh = new EdgeBD(A, H);
    EdgeAbstract dToa = new EdgeBD(D, A);
    EdgeAbstract dTog = new EdgeBD(D, G);
    EdgeAbstract iTod = new EdgeBD(I, D);
    EdgeAbstract iTol = new EdgeBD(I, L);
    EdgeAbstract iToh = new EdgeBD(I, H);
    EdgeAbstract hToi = new EdgeBD(H, I);
    EdgeAbstract hTob = new EdgeBD(H, B);
    EdgeAbstract bTom = new EdgeBD(B, M);
    EdgeAbstract mToe = new EdgeBD(M, E);
    EdgeAbstract mTof = new EdgeBD(M, F);
    EdgeAbstract fToG = new EdgeBD(F, G);
    EdgeAbstract gToL = new EdgeBD(G, L);
    
    dk.insertEdge(A, B, aTob);
    dk.insertEdge(A, M, aTom);
    dk.insertEdge(A, H, aToh);
    dk.insertEdge(D, A, dToa);
    dk.insertEdge(D, G, dTog);
    dk.insertEdge(I, D, iTod);
    dk.insertEdge(I, L, iTol);
    dk.insertEdge(I, H, iToh);
    dk.insertEdge(H, I, hToi);
    dk.insertEdge(H, B, hTob);
    dk.insertEdge(B, M, bTom);
    dk.insertEdge(M, E, mToe);
    dk.insertEdge(M, F, mTof);
    dk.insertEdge(F, G, fToG);
    dk.insertEdge(G, L, gToL);
        
    //Doesn't need to consider the middle node
    assertEquals(bd.findShortestDistance("D", "H", "I"), 15.431482460540948);
    
    String path = "D -> A -> H -> I";

    assertEquals(bd.findShortestPath("D", "H", "I"), path);

  }
  
  
  /**
   * Tests the loadData() method in backend. 
   * 
   * Supposed to rely on placeholder class for the method. Placeholder class adds nodes and edges
   * when the filename is null. 
   * 
   * Also tests the getStatistics() method in the backend
   */
  @Test
  void test2() {
    DijkstraGraphAE<LocationInterface, EdgeAbstract> dk = new DijkstraGraphAE<LocationInterface, EdgeAbstract>();
    LocationReaderInterface testReader = new LocationReaderBD();
    
    PathFinderBackendBD bd = new PathFinderBackendBD(dk, testReader);
        
    
    assertEquals(bd.getStatisticsString(), "Dataset contains 0 locations with 0 total paths between all of the locations.");   
    
    try {
      bd.loadData(null);
    } catch (FileNotFoundException e) {
      assertTrue(false);
    }
    
    assertEquals(bd.getStatisticsString(), "Dataset contains 3 locations with 2 total paths between all of the locations.");    
    
  }
  
  @Test
  /**
   * Tests for an example graph that findShortestDistance() and findShortestPath() 
   * work for invalid inputs.
   * 
   * NoSuchElementException expected to be thrown and caught
   */
  void test3() {
    DijkstraGraphAE<LocationInterface, EdgeAbstract> dk = new DijkstraGraphAE<LocationInterface, EdgeAbstract>();
    LocationReaderInterface testReader = new LocationReaderBD();
    
    PathFinderBackendBD bd = new PathFinderBackendBD(dk, testReader);
        
    
    LocationInterface A = new LocationBD("A", 0, 2, 1243);
    LocationInterface B = new LocationBD("B", 5, 4, 1244);
    LocationInterface M = new LocationBD("M", 1, 9, 1245);
    LocationInterface G = new LocationBD("G", 3, 4, 1246);
    LocationInterface E = new LocationBD("E", 1, 4, 1247);
    LocationInterface F = new LocationBD("F", 1, 8, 1248);
    LocationInterface D = new LocationBD("D", 1, 4, 1249);
    LocationInterface H = new LocationBD("H", 6, 7, 1250);
    LocationInterface L = new LocationBD("L", 2, 4, 1251);
    LocationInterface I = new LocationBD("I", 1, 5, 1252);
    
    dk.insertNode(A);
    dk.insertNode(B);
    dk.insertNode(M);
    dk.insertNode(G);
    dk.insertNode(E);
    dk.insertNode(F);
    dk.insertNode(D);
    dk.insertNode(H);
    dk.insertNode(L);
    dk.insertNode(I);
    
    
    testReader.getLocations().add(A);
    testReader.getLocations().add(B);
    testReader.getLocations().add(M);
    testReader.getLocations().add(G);
    testReader.getLocations().add(E);
    testReader.getLocations().add(F);
    testReader.getLocations().add(D);
    testReader.getLocations().add(H);
    testReader.getLocations().add(L);
    testReader.getLocations().add(I);
    
    EdgeAbstract aTob = new EdgeBD(A, B);
    EdgeAbstract aTom = new EdgeBD(A, M);
    EdgeAbstract aToh = new EdgeBD(A, H);
    EdgeAbstract dToa = new EdgeBD(D, A);
    EdgeAbstract dTog = new EdgeBD(D, G);
    EdgeAbstract iTod = new EdgeBD(I, D);
    EdgeAbstract iTol = new EdgeBD(I, L);
    EdgeAbstract iToh = new EdgeBD(I, H);
    EdgeAbstract hToi = new EdgeBD(H, I);
    EdgeAbstract hTob = new EdgeBD(H, B);
    EdgeAbstract bTom = new EdgeBD(B, M);
    EdgeAbstract mToe = new EdgeBD(M, E);
    EdgeAbstract mTof = new EdgeBD(M, F);
    EdgeAbstract fToG = new EdgeBD(F, G);
    EdgeAbstract gToL = new EdgeBD(G, L);
    
    dk.insertEdge(A, B, aTob);
    dk.insertEdge(A, M, aTom);
    dk.insertEdge(A, H, aToh);
    dk.insertEdge(D, A, dToa);
    dk.insertEdge(D, G, dTog);
    dk.insertEdge(I, D, iTod);
    dk.insertEdge(I, L, iTol);
    dk.insertEdge(I, H, iToh);
    dk.insertEdge(H, I, hToi);
    dk.insertEdge(H, B, hTob);
    dk.insertEdge(B, M, bTom);
    dk.insertEdge(M, E, mToe);
    dk.insertEdge(M, F, mTof);
    dk.insertEdge(F, G, fToG);
    dk.insertEdge(G, L, gToL);
    
    try {
      bd.findShortestPath("D", "L", "I");
      assertTrue(false);
    }
    catch(NoSuchElementException e) {
      //Code expected here
    }
    catch(Exception e) {
      assertTrue(false);
    }
    
    
    try {
      bd.findShortestDistance("D", "L", "I");
      assertTrue(false);
    }
    catch(NoSuchElementException e) {
      //Code expected here
    }
    catch(Exception e) {
      assertTrue(false);
    }
  }
  
  @Test
  /**
   *  
   * Tests for an example graph that findShortestDistance() and findShortestPath() 
   * work for valid inputs.(The shortest path works with taking into consideration the middle node.)
   * 
   * Tests getStatistics() for when a file isn't loaded
   */
  void test4() {
    DijkstraGraphAE<LocationInterface, EdgeAbstract> dk = new DijkstraGraphAE<LocationInterface, EdgeAbstract>();
    LocationReaderInterface testReader = new LocationReaderBD();
    
    PathFinderBackendBD bd = new PathFinderBackendBD(dk, testReader);
        
    
    LocationInterface A = new LocationBD("A", 0, 2, 1243);
    LocationInterface B = new LocationBD("B", 5, 4, 1244);
    LocationInterface M = new LocationBD("M", 1, 9, 1245);
    LocationInterface G = new LocationBD("G", 3, 4, 1246);
    LocationInterface E = new LocationBD("E", 1, 4, 1247);
    LocationInterface F = new LocationBD("F", 1, 8, 1248);
    LocationInterface D = new LocationBD("D", 1, 4, 1249);
    LocationInterface H = new LocationBD("H", 6, 7, 1250);
    LocationInterface L = new LocationBD("L", 2, 4, 1251);
    LocationInterface I = new LocationBD("I", 1, 5, 1252);
    
    dk.insertNode(A);
    dk.insertNode(B);
    dk.insertNode(M);
    dk.insertNode(G);
    dk.insertNode(E);
    dk.insertNode(F);
    dk.insertNode(D);
    dk.insertNode(H);
    dk.insertNode(L);
    dk.insertNode(I);
    
    
    testReader.getLocations().add(A);
    testReader.getLocations().add(B);
    testReader.getLocations().add(M);
    testReader.getLocations().add(G);
    testReader.getLocations().add(E);
    testReader.getLocations().add(F);
    testReader.getLocations().add(D);
    testReader.getLocations().add(H);
    testReader.getLocations().add(L);
    testReader.getLocations().add(I);
    
    EdgeAbstract aTob = new EdgeBD(A, B);
    EdgeAbstract aTom = new EdgeBD(A, M);
    EdgeAbstract aToh = new EdgeBD(A, H);
    EdgeAbstract dToa = new EdgeBD(D, A);
    EdgeAbstract dTog = new EdgeBD(D, G);
    EdgeAbstract iTod = new EdgeBD(I, D);
    EdgeAbstract iTol = new EdgeBD(I, L);
    EdgeAbstract iToh = new EdgeBD(I, H);
    EdgeAbstract hToi = new EdgeBD(H, I);
    EdgeAbstract hTob = new EdgeBD(H, B);
    EdgeAbstract bTom = new EdgeBD(B, M);
    EdgeAbstract mToe = new EdgeBD(M, E);
    EdgeAbstract mTof = new EdgeBD(M, F);
    EdgeAbstract fToG = new EdgeBD(F, G);
    EdgeAbstract gToL = new EdgeBD(G, L);
    
    dk.insertEdge(A, B, aTob);
    dk.insertEdge(A, M, aTom);
    dk.insertEdge(A, H, aToh);
    dk.insertEdge(D, A, dToa);
    dk.insertEdge(D, G, dTog);
    dk.insertEdge(I, D, iTod);
    dk.insertEdge(I, L, iTol);
    dk.insertEdge(I, H, iToh);
    dk.insertEdge(H, I, hToi);
    dk.insertEdge(H, B, hTob);
    dk.insertEdge(B, M, bTom);
    dk.insertEdge(M, E, mToe);
    dk.insertEdge(M, F, mTof);
    dk.insertEdge(F, G, fToG);
    dk.insertEdge(G, L, gToL);
    
    assertEquals(bd.findShortestDistance("D", "H", "M"), 19.611719551007674);
    
    String path2 = "D -> A -> H -> B -> M";

    assertEquals(bd.findShortestPath("D", "H", "M"), path2);
    
    
    //getStatistics()
    assertEquals(bd.getStatisticsString(), "Dataset contains 10 locations with 15 total paths between all of the locations.");
  }
  
  @Test
  /**
   * Edge cases, if the middle string in findShortestDistance or findShortestPath is the same as the start or end string, 
   * then it should just return the shortest path between the start and end strings.
   */
  void test5() {
    
    DijkstraGraphAE<LocationInterface, EdgeAbstract> dk = new DijkstraGraphAE<LocationInterface, EdgeAbstract>();
    LocationReaderInterface testReader = new LocationReaderBD();
    
    PathFinderBackendBD bd = new PathFinderBackendBD(dk, testReader);
        
    
    LocationInterface A = new LocationBD("A", 0, 2, 1243);
    LocationInterface B = new LocationBD("B", 5, 4, 1244);
    LocationInterface M = new LocationBD("M", 1, 9, 1245);
    LocationInterface G = new LocationBD("G", 3, 4, 1246);
    LocationInterface E = new LocationBD("E", 1, 4, 1247);
    LocationInterface F = new LocationBD("F", 1, 8, 1248);
    LocationInterface D = new LocationBD("D", 1, 4, 1249);
    LocationInterface H = new LocationBD("H", 6, 7, 1250);
    LocationInterface L = new LocationBD("L", 2, 4, 1251);
    LocationInterface I = new LocationBD("I", 1, 5, 1252);
    
    dk.insertNode(A);
    dk.insertNode(B);
    dk.insertNode(M);
    dk.insertNode(G);
    dk.insertNode(E);
    dk.insertNode(F);
    dk.insertNode(D);
    dk.insertNode(H);
    dk.insertNode(L);
    dk.insertNode(I);
    
    
    testReader.getLocations().add(A);
    testReader.getLocations().add(B);
    testReader.getLocations().add(M);
    testReader.getLocations().add(G);
    testReader.getLocations().add(E);
    testReader.getLocations().add(F);
    testReader.getLocations().add(D);
    testReader.getLocations().add(H);
    testReader.getLocations().add(L);
    testReader.getLocations().add(I);
    
    EdgeAbstract aTob = new EdgeBD(A, B);
    EdgeAbstract aTom = new EdgeBD(A, M);
    EdgeAbstract aToh = new EdgeBD(A, H);
    EdgeAbstract dToa = new EdgeBD(D, A);
    EdgeAbstract dTog = new EdgeBD(D, G);
    EdgeAbstract iTod = new EdgeBD(I, D);
    EdgeAbstract iTol = new EdgeBD(I, L);
    EdgeAbstract iToh = new EdgeBD(I, H);
    EdgeAbstract hToi = new EdgeBD(H, I);
    EdgeAbstract hTob = new EdgeBD(H, B);
    EdgeAbstract bTom = new EdgeBD(B, M);
    EdgeAbstract mToe = new EdgeBD(M, E);
    EdgeAbstract mTof = new EdgeBD(M, F);
    EdgeAbstract fToG = new EdgeBD(F, G);
    EdgeAbstract gToL = new EdgeBD(G, L);
    
    dk.insertEdge(A, B, aTob);
    dk.insertEdge(A, M, aTom);
    dk.insertEdge(A, H, aToh);
    dk.insertEdge(D, A, dToa);
    dk.insertEdge(D, G, dTog);
    dk.insertEdge(I, D, iTod);
    dk.insertEdge(I, L, iTol);
    dk.insertEdge(I, H, iToh);
    dk.insertEdge(H, I, hToi);
    dk.insertEdge(H, B, hTob);
    dk.insertEdge(B, M, bTom);
    dk.insertEdge(M, E, mToe);
    dk.insertEdge(M, F, mTof);
    dk.insertEdge(F, G, fToG);
    dk.insertEdge(G, L, gToL);
    
    //Check distance and path when middle is equal to start or end node
    assertEquals(bd.findShortestDistance("D", "D", "M"), 9.307135789365265);
    
    String path2 = "D -> A -> M";

    assertEquals(bd.findShortestPath("D", "D", "M"), path2);
    
    //Distance is same when middle is start or end node
    assertEquals(bd.findShortestDistance("D", "M", "M"), 9.307135789365265);

    //Confirms path is the same when middle is start or end node
    assertEquals(bd.findShortestPath("D", "M", "M"), path2);
    
  }

  @Test
  /**
   * Testing DataWrangler's code for a file that exists in the directory. 
   * 
   * No exception expected to be returned. 
   */
  void CodeReviewOfDataWrangler(){
    LocationReaderDW reader = new LocationReaderDW();
    try {
      
      assertEquals(true, reader.getLocations().isEmpty()); //Checks the locations before (empty) and after (full)
      
      List<LocationInterface> locations = reader.readLocationsFromFile("madisonlocation.dot"); //File exists

      assertEquals(false, locations.isEmpty()); //checks list of locations isn't empty
      assertEquals(22, locations.size()); //Checking the number of locations is correct      
      
      assertEquals(false, reader.getLocations().isEmpty());
      
    } catch (Exception e) {
      assertTrue(false);
    }
  }
  
  @Test
  /**
   * Testing DataWrangler's code for a file that does not exist in the directory
   * 
   * Exception expected to return
   */
  void CodeReviewOfDataWrangler2(){
    LocationReaderDW reader = new LocationReaderDW();
    try {
      List<LocationInterface> locations = reader.readLocationsFromFile("failingFile.dot"); //File does not exists      

      assertTrue(false); //If no exception, test fails
    } 
    catch(FileNotFoundException e) {
      //Code expected to reach here
    }
    catch (Exception e) {
      assertTrue(false);//If no exception, test fails
    }
    
  }

  @Test
  /**
   * Tests how Backend's code integrates with Frontend's code. Loads in an invalid file and checks 
   * output when receiving Statistics.
   */
  void IntegrationTest1(){
    TextUITester tester = new TextUITester("L\ninvalidFile.dot\nS\nQ\n");
    PathFinderFrontendFD location =new PathFinderFrontendFD(new Scanner(System.in),
    new PathFinderBackendBD(new DijkstraGraphAE<LocationInterface, EdgeAbstract>(), new LocationReaderBD()));
    location.runCommandLoop();
    String output = tester.checkOutput();

    //Make sure statistics returns the right string
    if(output.contains("Dataset contains 0 locations with 0 total paths between all of the locations.")){
      
      //Expected to reach here
    }else {
            assertTrue(false);
    }
  }


  @Test
  /**
   * Tests how Backend's code integrates with Frontend (text output) and DataWrangler's (Reading file) code. 
   * Loads in a valid file and checks output when receiving Statistics and also checks output when finding 
   * the shortest path between 2 buildings. 
   */
  void IntegrationTest2(){
    TextUITester tester = new TextUITester("L\nmadisonlocation.dot\nS\nP\nCollege Library\nCollege Library\nChemistry Building\nQ\n");
    PathFinderFrontendFD location =new PathFinderFrontendFD(new Scanner(System.in),
    new PathFinderBackendBD(new DijkstraGraphAE<LocationInterface, EdgeAbstract>(), new LocationReaderDW()));
    location.runCommandLoop();
    String output = tester.checkOutput();

    //Make sure statistics returns the right string and 
    //output for finding shortest path is correct
    if(output.contains("Dataset contains 22 locations with 64 total paths between all of the locations") && output.contains("College Library -> Steenbock Library -> Chemistry Building")){
      //Expected to reach here
    }else {
            assertTrue(false);
    }
  }
}

