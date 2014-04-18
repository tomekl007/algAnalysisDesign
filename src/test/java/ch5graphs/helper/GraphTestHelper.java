package ch5graphs.helper;

import ch5graphs.Graph;

/**
 * @author Tomasz Lelek
 * @since 2014-04-16
 */
public class GraphTestHelper {
    public static Graph createUndirectedGraph() {
        Graph graph = new Graph(false);
        graph.insertEdge(0, 1, false);
        graph.insertEdge(0, 2, false);
        graph.insertEdge(0, 3, false);
        graph.insertEdge(1, 2, false);
        graph.insertEdge(3, 4, false);
        return graph;
    }

    public static Graph createUndirectedGraphWithTwoComponents() {
        Graph graph = createUndirectedGraph();
        graph.insertEdge(5, 6, false);
        graph.insertEdge(6, 7, false);
        return graph;
    }

    public static Graph createBipartialeGraph() {
        Graph graph = new Graph(false);
        graph.insertEdge(1, 2, false);
        graph.insertEdge(1, 3, false);
        graph.insertEdge(3, 4, false);
        graph.insertEdge(4, 5, false);
        return graph;
    }

    public static Graph createNotBipartialeGraph() {
        Graph graph = createBipartialeGraph();
        graph.insertEdge(2, 3, false);
        return graph;
    }

    public static Graph createGraphWithCycle() {
        Graph graph = createUndirectedGraph();
        graph.insertEdge(2,4, false);
        return graph;
    }
}
