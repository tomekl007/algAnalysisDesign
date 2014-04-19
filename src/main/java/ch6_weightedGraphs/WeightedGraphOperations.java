package ch6_weightedGraphs;

import ch5graphs.EdgeNode;
import ch5graphs.EdgePair;
import ch5graphs.Graph;
import ch5graphs.GraphOperations;

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
    void prim(Graph graph, int start) {


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
                if ((distance[nextVertexCandidate] > edgeWeight) && (!intree[nextVertexCandidate])) {
                    distance[nextVertexCandidate] = edgeWeight;
                    parent[nextVertexCandidate] = currentVertex;
                }
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
    public void invertWeights(Graph graph){
        for(EdgeNode edgeNode : graph.edges){
            edgeNode.weight = -edgeNode.weight;
        }
    }
}

