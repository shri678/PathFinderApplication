import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.util.Scanner;

public class FrontendDeveloperTests {

  protected PathFinderFrontendFD frontend;

  /**
   * Tests the shortest distance commend when the strings entered for start and end locations are identical
   */
  @Test
  public void test1() {
    TextUITester tester = new TextUITester("");

    frontend = new PathFinderFrontendFD(new Scanner(System.in), new PathFinderBackendFD());

    String test = "hi";
    frontend.findShortestDistanceCommand(test, test, test);
    String output = tester.checkOutput();

    Assertions.assertEquals("Start, middle, and end location are the same location." + System.lineSeparator(), output);
  }

  /**
   * Tests the load data command (currently even though file is not valid, since backend is not implemented, no error is thrown. tester will be updated when backend is implemented)
   */
  @Test
  public void test2() {
    TextUITester tester = new TextUITester("randomfile.txt");

    frontend = new PathFinderFrontendFD(new Scanner(System.in), new PathFinderBackendFD());
    frontend.loadDataCommand();
    String output = tester.checkOutput();

    Assertions.assertEquals("Enter the name of the file to load: Successfully loaded randomfile.txt" + System.lineSeparator(), output);
  }

  /**
   * Tests the command loop when Q is entered to quit the program. Mainly tests to make sure that the commands are outputted and formatted correctly
   */
  @Test
  public void test3() {
    TextUITester tester = new TextUITester("Q\n");

    frontend = new PathFinderFrontendFD(new Scanner(System.in), new PathFinderBackendFD());
    frontend.runCommandLoop();
    String output = tester.checkOutput();

    Assertions.assertEquals("-------------------------------------------------------------------------------" + System.lineSeparator() +
        "Welcome to the Path Finder App!" + System.lineSeparator() +
        "-------------------------------------------------------------------------------" + System.lineSeparator() +
        "Choose a command from the list below:" + System.lineSeparator() +
        "    (L)oad data from file" + System.lineSeparator() +
        "    Find Shortest (P)ath" + System.lineSeparator() +
        "    Find Shortest (D)istance" + System.lineSeparator() +
        "    Display (S)tatistics for dataset" + System.lineSeparator() +
        "    (Q)uit" + System.lineSeparator() +
        "Choose command: -------------------------------------------------------------------------------" + System.lineSeparator() +
        "Thank you for using the Path Finder App!" + System.lineSeparator() +
        "-------------------------------------------------------------------------------" + System.lineSeparator(), output);

  }

  /**
   * Tester for the shortest path prompt which prompts the user to enter the start and end location for the paths
   */
  @Test
  public void test4() {
    TextUITester tester = new TextUITester("hi\nhello\nhello\n");

    frontend = new PathFinderFrontendFD(new Scanner(System.in), new PathFinderBackendFD());
    frontend.findShortestPathPrompt();
    String output = tester.checkOutput();

    Assertions.assertEquals("Enter the name of the location your path will start at, press enter to state location: Enter the name of the location that your path must pass through, press enter to state location: Enter the name of the location your path will end at, press enter to find path: ", output);
  }

  /**
   * Tester for the shortest distance prompt which prompts the user to enter the start and end location for the paths to calculate distance
   */
  @Test
  public void test5() {
    TextUITester tester = new TextUITester("hi\nhello\nhello\n");

    frontend = new PathFinderFrontendFD(new Scanner(System.in), new PathFinderBackendFD());
    frontend.findShortestDistancePrompt();
    String output = tester.checkOutput();

    Assertions.assertEquals("Enter the name of the location your path will start at, press enter to state location: Enter the name of the location that your path must pass through, press enter to state location: Enter the name of the location your path will end at, press enter to find path: ", output);
  }
}

