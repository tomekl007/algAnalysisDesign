package ch5graphs.helper;

import ch5graphs.Graph;

/**
 * @author Tomasz Lelek
 * @since 2014-04-16
 */
public class GraphTestHelper {
    public static Graph createUndirectedGraph() {
        Graph graph = new Graph(false);
        graph.insertEdge(0, 1, false, 0);
        graph.insertEdge(0, 2, false, 0);
        graph.insertEdge(0, 3, false, 0);
        graph.insertEdge(1, 2, false, 0);
        graph.insertEdge(3, 4, false, 0);
        return graph;
    }

    public static Graph createUndirectedGraphWithTwoComponents() {
        Graph graph = createUndirectedGraph();
        graph.insertEdge(5, 6, false, 0);
        graph.insertEdge(6, 7, false, 0);
        return graph;
    }

    public static Graph createBipartialeGraph() {
        Graph graph = new Graph(false);
        graph.insertEdge(1, 2, false, 0);
        graph.insertEdge(1, 3, false, 0);
        graph.insertEdge(3, 4, false, 0);
        graph.insertEdge(4, 5, false, 0);
        return graph;
    }

    public static Graph createNotBipartialeGraph() {
        Graph graph = createBipartialeGraph();
        graph.insertEdge(2, 3, false, 0);
        return graph;
    }

    public static Graph createGraphWithCycle() {
        Graph graph = createUndirectedGraph();
        graph.insertEdge(2,4, false, 0);
        return graph;
    }

    public static Graph createDirectGraph() {
        Graph graph = new Graph(true);
        graph.insertEdge(1,2, true, 0);
        graph.insertEdge(1,3, true, 0);
        graph.insertEdge(2,4, true, 0);
        graph.insertEdge(2,3, true, 0);
        graph.insertEdge(3,5, true, 0);
        graph.insertEdge(5,4, true, 0);
        graph.insertEdge(6,5, true, 0);
        graph.insertEdge(3,6, true, 0);
        graph.insertEdge(7,6, true, 0);
        graph.insertEdge(7,1, true, 0);
        return graph;

    }

    public static Graph createGraphWithThreeStronglyConnectedComponents() {
        Graph graph = new Graph(true);
        graph.insertEdge(1,2, true, 0);
        graph.insertEdge(2,3, true, 0);
        graph.insertEdge(3,1, true, 0);
        graph.insertEdge(2,4, true, 0);
        graph.insertEdge(4,1, true, 0);
        graph.insertEdge(4,6, true, 0);
        graph.insertEdge(4,8, true, 0);
        graph.insertEdge(8,6, true, 0);
        graph.insertEdge(2,5, true, 0);
        graph.insertEdge(5,6, true, 0);
        graph.insertEdge(6,7, true, 0);
        graph.insertEdge(7,5, true, 0);
        return graph;
    }

    public static Graph createWeightenedGraph() {
        Graph graph = new Graph(true);
        graph.insertEdge(1,2, true, 1);
        graph.insertEdge(1,4, true, 1);
        graph.insertEdge(2,3, true, 1);
        graph.insertEdge(1,3, true, 10);
        graph.insertEdge(3,4, true, 2);
        return graph;
    }
}
