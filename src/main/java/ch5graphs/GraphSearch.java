package ch5graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Tomasz Lelek
 * @since 2014-04-16
 */
public class GraphSearch {
    boolean processed[] = new boolean[Graph.MAX_VERTICES];
    boolean discovered[] = new boolean[Graph.MAX_VERTICES];
    int parent[] = new int[Graph.MAX_VERTICES];

    //each vertex is initialize as undiscovered
    private void initializeSearch(Graph graph){
        for (int i = 1; i < graph.nrOfVertices(); i++) {
            processed[i] = discovered[i] = false;
            parent[i] = -1;
        }
    }
    public void breadthFirstSearch(Graph graph, int start){
        initializeSearch(graph);
        Queue<Integer> verticesToVisit = new LinkedList<>();
        int currentVertex;
        int successorVertex;

        verticesToVisit.offer(start);
        discovered[start] = true;
        EdgeNode edgeNode;

        while(!verticesToVisit.isEmpty()){
            currentVertex = verticesToVisit.poll();
            processVertexEarly(currentVertex);
            processed[currentVertex] = true;
            edgeNode = graph.edges[currentVertex];

            while(edgeNode != null){
                successorVertex = edgeNode.adjencyInfo;
                if((!processed[successorVertex]) || graph.directed){
                    processEdge(currentVertex, successorVertex);
                }
                if(!discovered[successorVertex]){
                    verticesToVisit.offer(successorVertex);
                    discovered[successorVertex] = true;
                    parent[successorVertex] = currentVertex;
                }
                edgeNode = edgeNode.next;
            }
            processVertexLate(currentVertex);
        }

    }

    private void processVertexLate(int currentVertex) {

    }

    private void processEdge(int currentVertex, int successorVertex) {
        System.out.println("processed edge : " + currentVertex + " -> " + successorVertex);
    }

    private void processVertexEarly(int currentVertex) {
        System.out.println("processed vertex : " + currentVertex);
    }
}
