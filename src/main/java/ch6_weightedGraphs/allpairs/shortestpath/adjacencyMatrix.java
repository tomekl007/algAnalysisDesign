package ch6_weightedGraphs.allpairs.shortestpath;

import ch5graphs.Graph;

/**
 * @author Tomasz Lelek
 * @since 2014-04-20
 */
public class AdjacencyMatrix {
    public int weights[][] = new int[Graph.MAX_VERTICES + 1][Graph.MAX_VERTICES + 1];
    public int numberOfVerticesInGraph;
}
