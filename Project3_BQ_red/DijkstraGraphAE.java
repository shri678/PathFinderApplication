
import java.util.PriorityQueue;
import java.util.Hashtable;
import java.util.List;
import java.util.LinkedList;
import java.util.NoSuchElementException;
/**
 * This class extends the BaseGraph data structure with additional methods for
 * computing the total cost and list of node data along the shortest path
 * connecting a provided starting to ending nodes.  This class makes use of
 * Dijkstra's shortest path algorithm.
 */
public class DijkstraGraphAE<NodeType, EdgeType extends Number> 
	extends BaseGraph<NodeType,EdgeType> 
	implements DijkstraGraphInterface<NodeType, EdgeType>{
	/**
     * While searching for the shortest path between two nodes, a SearchNode
     * contains data about one specific path between the start node and another
     * node in the graph.  The final node in this path is stored in it's node
     * field.  The total cost of this path is stored in its cost field.  And the
     * predecessor SearchNode within this path is referened by the predecessor
     * field (this field is null within the SearchNode containing the starting
     * node in it's node field).
     *
     * SearchNodes are Comparable and are sorted by cost so that the lowest cost
     * SearchNode has the highest priority within a java.util.PriorityQueue.
     */
	protected class SearchNode implements Comparable<SearchNode> {
        public Node node;
        public double cost;
        public SearchNode predecessor;
        public SearchNode(Node node, double cost, SearchNode predecessor) {
            this.node = node;
            this.cost = cost;
            this.predecessor = predecessor;
        }
        public int compareTo(SearchNode other) {
            if( cost > other.cost ) return +1;
            if( cost < other.cost ) return -1;
            return 0;
        }
	}
	/**
     * This helper method creates a network of SearchNodes while computing the
     * shortest path between the provided start and end locations.  The
     * SearchNode that is returned by this method is represents the end of the
     * shortest path that is found: it's cost is the cost of that shortest path,
     * and the nodes linked together through predecessor references represent
     * all of the nodes along that shortest path (ordered from end to start).
     *
     * @param start the data item in the starting node for the path
     * @param end the data item in the destination node for the path
     * @return SearchNode for the final end node within the shortest path
     * @throws NoSuchElementException when no path from start to end is found
     *         or when either start or end data do not correspond to a graph node
     */
        protected SearchNode computeShortestPath(NodeType start, NodeType end) {   
        // Checks to make sure nodes exist within our graph
        if(!this.containsNode(start) || !this.containsNode(end)) {
                throw new NoSuchElementException("Start or End do not exist");
        }

        // If start equals end cost for both is 0 and return end.
        if(start.equals(end)) {
                Node ender = super.nodes.get(end);
                Node starter = super.nodes.get(start);
                SearchNode starting = new SearchNode(starter, 0, null);
                return starting;
        }

        SearchNode path = null; // Keep track of shortest path. 
        PriorityQueue<SearchNode> priority = new PriorityQueue<SearchNode>();
        Hashtable<Node, SearchNode> hash = new Hashtable<Node, SearchNode>();
        SearchNode starting = new SearchNode(super.nodes.get(start), 0, null);
        priority.add(starting);
     // Go through whole graph 
        while(!hash.containsKey(nodes.get(end).data) && !priority.isEmpty()) {
                SearchNode pNode = priority.poll(); // get top element of priority
                List<Edge> leaving = pNode.node.edgesLeaving; // Gets list of edges 

                if(pNode != null) {
                        hash.put(pNode.node, pNode);
                        // for each leaving edge from the pNode
                        for(Edge edge : leaving) {
                                SearchNode check = new SearchNode(edge.successor,
                                                edge.data.doubleValue() + pNode.cost, pNode);

                                if(!hash.containsKey(check.node)) {
                                        priority.add(check);
                                        // Checks to see if we found shorter path.
                                        if(check.node.equals(nodes.get(end))) {
                                                if(path == null) {
                                                        path = check; //Update path if we found a shorter
                                                } else if(check.cost < path.cost) {
                                                        path = check;
                                                }
                                        }
                                }
                        }
                }
        }
        // If path is still null when going through whole graph path 
        // doesn't exist. 
        if(path == null) {
                throw new NoSuchElementException("path doesn't exist");
        }

        return path; //End node, with path as predecessor
    }
        
        /**
         * Returns the list of data values from nodes along the shortest path
         * from the node with the provided start value through the node with the
         * provided end value.  This list of data values starts with the start
         * value, ends with the end value, and contains intermediary values in the
         * order they are encountered while traversing this shorteset path.  This
         * method uses Dijkstra's shortest path algorithm to find this solution.
         *
         * @param start the data item in the starting node for the path
         * @param end the data item in the destination node for the path
         * @return list of data item from node along this shortest path
         */
        public List<NodeType> shortestPathData(NodeType start, NodeType end) {
            SearchNode ending = computeShortestPath(start, end);
            List<NodeType> shortest = new LinkedList<NodeType>();
            shortest.add(ending.node.data); // Adding end node to list 

            // Goes through shortest path  
            while(ending.predecessor != null) {
                    // Adding each element to beginning of list. 
                    shortest.add(0, ending.predecessor.node.data);
                    ending = ending.predecessor; // Updating ending to its predecessor
            }
            return shortest;
        }

        /**
         * Returns the cost of the path (sum over edge weights) of the shortest
         * path from the node containing the start data to the node containing the
         * end data.  This method uses Dijkstra's shortest path algorithm to find
         * this solution.
         *
         * @param start the data item in the starting node for the path
         * @param end the data item in the destination node for the path
         * @return the cost of the shortest path between these nodes
         */
        public double shortestPathCost(NodeType start, NodeType end) {
            SearchNode ending = computeShortestPath(start, end);
            return ending.cost;
        }
        
        /**
         * This method makes sure we visit at least 3 nodes within the required data
         * it focuses on getting the shortest path while having to us the middle node. 
         *
         * @param start the data item in the starting node for the path
         * @param middle the data item required to be visited
         * @param end the data item in the destination node for the path
         * @return the cost of the shortest path between these nodes
         */
        public List<NodeType> visit3Nodes(NodeType start, NodeType middle, NodeType end){
        	List<NodeType> halfOne = shortestPathData(start, middle);
        	List<NodeType> halfTwo = shortestPathData(middle, end);
        	for(NodeType value : halfTwo) {
        		if(!halfOne.contains(value)) {
        			halfOne.add(value);
        		}
        	}
        	return halfOne;       
	}
}
