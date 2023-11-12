import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PathFinderFrontendFD implements PathFinderFrontendInterface{
  private Scanner userInput; // scanner
  private PathFinderBackendInterface backend; // backend

  /**
   * Constructor initalizes scanner and backend to utilize methods
   * @param userInput scanner object
   * @param backend backend
   */
  public PathFinderFrontendFD(Scanner userInput, PathFinderBackendInterface backend) {
    this.userInput = userInput;
    this.backend = backend;
  }

  /**
   * Helper method to display a row of dashes for cleaner interface
   */
  private void hr() {
    System.out.println("-------------------------------------------------------------------------------");
  }

  /**
   * Method contains switch command that utilizes the user input when the main command is run and runs
   * the appropriate command based on user input
   */
  @Override
  public void runCommandLoop() {
    hr(); // display welcome message
    System.out.println("Welcome to the Path Finder App!");
    hr();

    char command = '\0';
    while (command != 'Q') { // main loop continues until user chooses to quit
      command = this.mainMenuPrompt();
      switch (command) {
        case 'L': // System.out.println(" [L]oad data from file");
          loadDataCommand();
          break;
        case 'P': // System.out.println("Find Shortest [P]ath");
          String[] paths = findShortestPathPrompt();
          findShortestPathCommand(paths[0], paths[1], paths[2]);
          break;
        case 'D': // System.out.println("Find Shortest [D]istance");
          String[] paths2 = findShortestDistancePrompt();
          findShortestDistanceCommand(paths2[0], paths2[1], paths2[2]);
          break;
        case 'S': // System.out.println("Display [S]tatistics for dataset");
          displayStatsCommand();
          break;
        case 'Q': // System.out.println("[Q]uit");
          // do nothing, containing loop condition will fail
          break;
        default:
          System.out.println(
              "Didn't recognize that command. Please type one of the letters presented within ()s to identify the command you would like to choose.");
          break;
      }
    }

    hr(); // thank user before ending this application
    System.out.println("Thank you for using the Path Finder App!");
    hr();
  }

  /**
   * Prints out options for the user to choose from. Based on the cs400 course staff implementation
   * for CHSearchFrontendFD.
   * @return the character that the user selected
   */
  @Override
  public char mainMenuPrompt() {
    // display menu of choices
    System.out.println("Choose a command from the list below:");
    System.out.println("    (L)oad data from file");
    System.out.println("    Find Shortest (P)ath");
    System.out.println("    Find Shortest (D)istance");
    System.out.println("    Display (S)tatistics for dataset");
    System.out.println("    (Q)uit");
    System.out.print("Choose command: ");
    String input = userInput.nextLine().trim(); // read user's input
    if (input.length() == 0) // if user's choice is blank, return null character
      return '\0';
    // otherwise, return an uppercase version of the first character in input
    return Character.toUpperCase(input.charAt(0));
  }

  /**
   * Prompt user to enter filename, and display error message when loading fails.
   * @author cs400 course staff
   */
  @Override
  public void loadDataCommand() {
    System.out.print("Enter the name of the file to load: ");
    String filename = userInput.nextLine().trim();
    try {
      backend.loadData(filename);
      System.out.println("Successfully loaded " + filename);
    } catch (FileNotFoundException e) {
      System.out.println("Error: Could not find or load file: " + filename);
    }
  }

  /**
   * Prompts user to enter the start middle and end locations that they would like to develop a path from
   * @return the three locations used by user
   */
  @Override
  public String[] findShortestPathPrompt() {
        System.out.println("Here are the list of locations: ");
    System.out.println("Memorial Union, Union South, College Library, DeLuca Biochemistry Building, Van Hise Hall, Van Vleck Hall, George Moss Humanities Building, Steenbock Library, Memorial Library, Mark H Ingraham Hall, Chamberlin Hall, William H Sewell Social Sciences Building, Computer Science Building, Nicholas Recreation Center, Kohl Center, Noland Zoology Building, Biochemical Science Building, Chemistry Building, College of Engineering, Department of Mechanical Engineering, Russell Laboratories, College of Agriculture");
    System.out.print("Enter the name of the location your path will start at, press enter to state location: ");
    String firstlocation = userInput.nextLine();
    System.out.print("Enter the name of the location that your path must pass through, press enter to state location: ");
    String middlelocation = userInput.nextLine();
    System.out.print("Enter the name of the location your path will end at, press enter to find path: ");
    String endlocation = userInput.nextLine();
    String[] paths = new String[3];
    paths[0] = firstlocation;
    paths[1] = middlelocation;
    paths[2] = endlocation;
    return paths;
  }

  /**
   * Utilizes the backend method to print out the shortest path that the user has asked for
   * @param start of the path
   * @param middle middle location ot pass through
   * @param end of the path
   */
  @Override
  public void findShortestPathCommand(String start, String middle, String end) {
    String result = backend.findShortestPath(start, middle, end);

    if (result != null) {
      System.out.println("Path: \n");
      System.out.println(result);
    } else
      System.out.println("No paths found.");
  }

  /**
   * Prompts user to enter a start, middle, and end location to find the shortest distance between while also
   * following the program's rules
   * @return the start and end locations the user would like to find distance for
   */
  @Override
  public String[] findShortestDistancePrompt() {
        System.out.println("Here are the list of locations: ");
    System.out.println("Memorial Union, Union South, College Library, DeLuca Biochemistry Building, Van Hise Hall, Van Vleck Hall, George Moss Humanities Building, Steenbock Library, Memorial Library, Mark H Ingraham Hall, Chamberlin Hall, William H Sewell Social Sciences Building, Computer Science Building, Nicholas Recreation Center, Kohl Center, Noland Zoology Building, Biochemical Science Building, Chemistry Building, College of Engineering, Department of Mechanical Engineering, Russell Laboratories, College of Agriculture");
    System.out.print("Enter the name of the location your path will start at, press enter to state location: ");
    String firstlocation = userInput.nextLine();
    System.out.print("Enter the name of the location that your path must pass through, press enter to state location: ");
    String middlelocation = userInput.nextLine();
    System.out.print("Enter the name of the location your path will end at, press enter to find path: ");
    String endlocation = userInput.nextLine();
    String[] paths = new String[3];
    paths[0] = firstlocation;
    paths[1] = middlelocation;
    paths[2] = endlocation;
    return paths;
  }

  /**
   * Utilizes the backend method to print out the distance for the shortest path that the user has
   * requested
   * @param start of path
   * @param middle location that the path must pass through
   * @param end of path
   */
  @Override
  public void findShortestDistanceCommand(String start, String middle, String end) {
    double result = backend.findShortestDistance(start, middle, end);
    if (result != 0 && !start.equals(end)) {
      System.out.print("Distance between locations: ");
      System.out.println(result);
    } else if (start.equals(end) && start.equals(middle)) {
      System.out.println("Start, middle, and end location are the same location.");
    } else
      System.out.println("No paths found.");
  }

  /**
   * Prints out the statistics for the locations across campus
   */
  @Override
  public void displayStatsCommand() {
    System.out.println(backend.getStatisticsString());
  }
}

