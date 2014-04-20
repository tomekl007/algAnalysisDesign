package ch6_weightedGraphs;

import ch5graphs.EdgeNode;
import ch5graphs.EdgePair;
import ch5graphs.Graph;
import ch5graphs.GraphOperations;
import ch6_weightedGraphs.allpairs.shortestpath.AdjacencyMatrix;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Tomasz Lelek
 * @since 2014-04-19
 */
public class WeightedGraphOperations {


    int parent[] = new int[Graph.MAX_VERTICES];
    int distance[] = new int[Graph.MAX_VERTICES];/* cost of adding to tree */

    public int getMinimumSpanningTreeWeight() {
        int sum = 0;

        for (int aDistance : distance) {
            sum += aDistance;
        }
        return sum;
    }

    /**
     * prim algorithm for finding minimum spanning tree
     *
     * @param start
     */
    public void prim(Graph graph, int start) {
        prim(graph, start, this::primAlgCondition);
    }

    private void prim(Graph graph, int start, QuadConsumer<Boolean, Integer, Integer, Integer> quadConsumer) {


        boolean intree[] = new boolean[Graph.MAX_VERTICES];/* is the vertex in the tree yet? */

        int currentVertex;
        int nextVertexCandidate;
        int edgeWeight;
        int bestCurrentDistanceFromStart;/* best current distance from start */

        for (int i = 1; i <= graph.nrOfVertices(); i++) {
            intree[i] = false;
            distance[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        distance[start] = 0;
        currentVertex = start;
        while (!intree[currentVertex]) {
            System.out.println("processing : " + currentVertex);
            intree[currentVertex] = true;
            EdgeNode edgeNode = graph.edges[currentVertex];
            while (edgeNode != null) {
                nextVertexCandidate = edgeNode.adjencyInfo;
                edgeWeight = edgeNode.weight;
                quadConsumer.accept(intree[nextVertexCandidate], currentVertex, nextVertexCandidate, edgeWeight);
                edgeNode = edgeNode.next;
            }
            currentVertex = 1;
            bestCurrentDistanceFromStart = Integer.MAX_VALUE;
            for (int i = 1; i <= graph.nrOfVertices(); i++) {
                if ((!intree[i]) && (bestCurrentDistanceFromStart > distance[i])) {
                    System.out.println("set curDisFromStart " + distance[i]);
                    bestCurrentDistanceFromStart = distance[i];
                    currentVertex = i;

                }
            }


        }
    }

    private void primAlgCondition(boolean intree, int currentVertex, int nextVertexCandidate, int edgeWeight) {
        if ((distance[nextVertexCandidate] > edgeWeight) && (!intree)) {
            distance[nextVertexCandidate] = edgeWeight;
            parent[nextVertexCandidate] = currentVertex;
        }
    }

    public int findShortestPathDijkstra(Graph g, int from, int to) {
        prim(g, from, this::dijkstraAlgCondition);
        return distance[to];
    }

    private void dijkstraAlgCondition(boolean ignore, int currentVertex, int nextVertexCandidate, int edgeWeight) {
        if (distance[nextVertexCandidate] > (distance[currentVertex] + edgeWeight)) {
            distance[nextVertexCandidate] = distance[currentVertex] + edgeWeight;
            parent[nextVertexCandidate] = currentVertex;
        }
    }

    /**
     * kruskal algorithm for finding minimum spanning tree
     */
    void kruskal(Graph g) {


        EdgePair e[];
        UnionFind unionFind = new UnionFind(g.nrOfVertices());


        e = GraphOperations.toEdgePairArray(g);
        Collections.sort(Arrays.asList(e), (o1, o2) -> Integer.compare(o1.weight, o2.weight));

        for (int i = 0; i < g.nrOfEdges; i++) {
            if (!unionFind.sameComponents(e[i].x, e[i].y)) {
                System.out.printf("edge (%d,%d) in MST\n", e[i].x, e[i].y);
                unionFind.unionsSets(e[i].x, e[i].y);
            }
        }
    }


    public void primMaximum(Graph graph, int i) {
        invertWeights(graph);
        prim(graph, i);
    }

    public void invertWeights(Graph graph) {
        for (EdgeNode edgeNode : graph.edges) {
            edgeNode.weight = -edgeNode.weight;
        }
    }

    /**
     * Floyd-Warshall all-pairs shortest path algorithm
     */
    public void floyd(AdjacencyMatrix a) {


        int distanceThroughVertexK;
        for (int k = 1; k <= a.numberOfVerticesInGraph; k++)
            for (int i = 1; i <= a.numberOfVerticesInGraph; i++)
                for (int j = 1; j <= a.numberOfVerticesInGraph; j++) {
                    distanceThroughVertexK = a.weights[i][k] + a.weights[k][j];
                    if (distanceThroughVertexK < a.weights[i][j])
                        a.weights[i][j] = distanceThroughVertexK;
                }
    }

}

