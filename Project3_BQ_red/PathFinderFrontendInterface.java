public interface PathFinderFrontendInterface {
  //public LocationFrontendXX(Scanner userInput,PathFinderBackendInterface backend);
  public void runCommandLoop();
  public char mainMenuPrompt();
  public void loadDataCommand();
  public String[] findShortestPathPrompt();

  public void findShortestPathCommand(String start, String middle, String end);
  public String[] findShortestDistancePrompt();

  public void findShortestDistanceCommand(String start, String middle, String end);

  public void displayStatsCommand();
}

