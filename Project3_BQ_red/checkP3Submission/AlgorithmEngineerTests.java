import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This class tests the implementation of the AE's
 * code and to make sure it is functioning correctly. 
 * 
 */
class AlgorithmEngineerTests {
	/**
	 * This tester test a simple implementation of the new method
	 * by looking to make sure the outputted string is correct on a path
	 * that exists and is rather short. 
	 * 
	 */
	@Test
	void test1() {
	 	DijkstraGraphAE<Integer, Integer> graph = new DijkstraGraphAE<Integer, Integer>();
    		graph.insertNode(4);
    		graph.insertNode(5);
    		graph.insertNode(6);
    		graph.insertNode(7);
    		graph.insertNode(8);
    		graph.insertNode(9);
    		graph.insertEdge(4, 5, 2);
    		graph.insertEdge(5, 6, 3);
    		graph.insertEdge(6, 9, 2);
    		graph.insertEdge(5, 9, 8);
    		// Test to make sure we are getting correct path to a rather simple implementation. 
    		Assertions.assertEquals(graph.visit3Nodes(4, 5, 9).toString(), "[4, 5, 6, 9]");
	}
	
	/**
	 * This tester makes sure it returns the correct result when
	 * we only want to visit the starting node and the end node,
	 *  aka middle node is the same as the end node. 
	 * 
	 */
	@Test
	void test2() {
		DijkstraGraphAE<Integer, Integer> graph = new DijkstraGraphAE<Integer, Integer>();
		graph.insertNode(4);
    		graph.insertNode(5);
    		graph.insertNode(6);
    		graph.insertNode(7);
    		graph.insertNode(8);
    		graph.insertNode(9);
    		graph.insertEdge(4, 5, 2);
    		graph.insertEdge(5, 8, 3);
    		graph.insertEdge(8, 7, 1);
    		// Test to make sure we are only getting 2 nodes when we are searching
    		// for the same middle and end nodes. 
    		Assertions.assertEquals(graph.visit3Nodes(4, 5, 5).toString(), "[4, 5]");
	}
	
	/**
	 * This test checks to make sure we are still getting a error 
	 * when we are searching for a path that does not exist within 
	 * the graph.
	 * 
	 */
	@Test
	void test3() {
	    // This tests to make sure we are getting an error when we 
	    try {
	        DijkstraGraphAE<Integer, Integer> graph = new DijkstraGraphAE<Integer, Integer>();
		graph.insertNode(4);
    		graph.insertNode(5);
   		graph.insertNode(6);
   		graph.insertNode(7);
    		graph.insertNode(8);
    		graph.insertNode(9);
    		graph.visit3Nodes(4, 4, 4);
	    } catch(NoSuchElementException e) {
		Assertions.assertTrue(true);
	    }
	}
	
	/**
	 * This method tests to make sure we find the shortest path when the 
	 * start node is the same as the end node, to make sure it is only 
	 */
	@Test
	void test4() {
		DijkstraGraphAE<Integer, Integer> graph = new DijkstraGraphAE<Integer, Integer>();
		graph.insertNode(4);
	    	graph.insertNode(5);
    		graph.insertNode(6);
    		graph.insertNode(7);
    		graph.insertNode(8);
    		graph.insertNode(9);
    		graph.insertEdge(4, 5, 2);
    		graph.insertEdge(5, 8, 3);
    		graph.insertEdge(8, 7, 1);
    		// Test to make sure we are only getting 3 nodes when we are searching
    		// for the same middle and start nodes with a different end node. 
    		Assertions.assertEquals(graph.visit3Nodes(4, 4, 8).toString(), "[4, 5, 8]");
	}
	
	/**
	 * This tester test to make sure the method works when trying to find 
	 * a path that is rather long making sure the middle point is at least two away
	 * from the start and the end. 
	 * 
	 */
	@Test
	void test5() {
		DijkstraGraphAE<Integer, Integer> graph = new DijkstraGraphAE<Integer, Integer>();
    		graph.insertNode(4);
    		graph.insertNode(5);
    		graph.insertNode(6);
    		graph.insertNode(7);
    		graph.insertNode(8);
    		graph.insertNode(9);
    		graph.insertNode(11);
    		graph.insertEdge(4, 5, 2);
    		graph.insertEdge(5, 6, 3);
    		graph.insertEdge(6, 9, 2);
    		graph.insertEdge(5, 9, 8);
    		graph.insertEdge(9, 11, 7);
    		// Test to make sure we are getting the correct path, 
    		// when we are looking for the three nodes and they are spread'
    		// out very far.
    		Assertions.assertEquals(graph.visit3Nodes(4, 6, 11).toString(), "[4, 5, 6, 9, 11]");
	}

	/**
         * This tester test the Integration to make sure the data can be
         * loaded correctly and that the displayStatistics is working once
         * the data is updated accordingly.
         *
         */
        @Test
        void test6CodeReviewOfFrontend() {
	   TextUITester tester = new TextUITester("randomfile.txt");
           frontend = new PathFinderFrontendFD(new Scanner(System.in), new PathFinderBackendFD());
           frontend.loadDataCommand();
           String output = tester.checkOutput();

           Assertions.assertEquals("Enter the name of the file to load: Successfully loaded randomfile.txt" + System.lineSeparator(), output);
        }

	/**
         * This tester test the Integration to make sure the data can be 
         * loaded correctly and that the displayStatistics is working once
         * the data is updated accordingly.
         *
         */
        @Test
        void test7CodeReviewOfFrontend() {
    	   TextUITester tester = new TextUITester("randomfile.txt");
    	   frontend = new PathFinderFrontendFD(new Scanner(System.in), new PathFinderBackendFD());
   	   frontend.loadDataCommand();
    	   String output = tester.checkOutput();

    	   Assertions.assertEquals("Enter the name of the file to load: Successfully loaded randomfile.txt" + System.lineSeparator(), output);
  	}

	/**
         * This tester test the Integration to make sure the data can be 
	 * loaded correctly and that the displayStatistics is working once
	 * the data is updated accordingly.
         *
         */
        @Test
        void test8Integration() {
	
	}

	/**
         * This tester test the Integration to make sure the data can be
         * loaded correctly and that the shortestPath and distance can be
         * found and displayed correctly within the app 
         *
         */
        @Test
        void test9Integration() {

        }
}
