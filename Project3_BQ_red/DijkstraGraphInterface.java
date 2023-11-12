import java.util.List;
public interface DijkstraGraphInterface<NodeType, EdgeType extends Number> 
extends GraphADT<NodeType, EdgeType> {

public List<NodeType> visit3Nodes(NodeType start, NodeType middle, NodeType end);	
}
