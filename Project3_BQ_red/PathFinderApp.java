import java.util.Scanner;

public class PathFinderApp {


    public static void main(String[] args) {

    // Use data wrangler's code to load post data
    LocationReaderDW locationLoader = new LocationReaderDW();

    // Use algorithm engineer's code to store and search for data
    DijkstraGraphInterface<LocationInterface, EdgeAbstract> dij = new DijkstraGraphAE<LocationInterface, EdgeAbstract>();

    Scanner scanner = new Scanner(System.in);

    PathFinderBackendBD backend = new PathFinderBackendBD(dij, locationLoader);

    PathFinderFrontendFD frontend = new PathFinderFrontendFD(scanner, backend);

    frontend.runCommandLoop();

  }

}


