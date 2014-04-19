package ch5graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Tomasz Lelek
 * @since 2014-04-16
 */
public class Graph {
    public final static int MAX_VERTICES  = 100;

    Set<Integer> vertices = new HashSet<>();
    public EdgeNode[] edges ;
    int[] degree;

    int nrOfEdges;
    boolean directed;

    public Graph(boolean directed) {
        this.nrOfEdges = 0;
        this.directed = directed;
        this.edges = new EdgeNode[MAX_VERTICES];
        this.degree = new int[MAX_VERTICES];
    }

    public void insertEdge(int firstVertex, int secondVertex, boolean directed, int weight){
        vertices.add(firstVertex);
        vertices.add(secondVertex);

        EdgeNode edgeNode = new EdgeNode();
        edgeNode.weight = weight;
        edgeNode.adjencyInfo = secondVertex;
        edgeNode.next = this.edges[firstVertex];
        this.edges[firstVertex] = edgeNode;
        this.degree[firstVertex] ++;

        if(!directed){
            insertEdge(secondVertex,firstVertex, true, 0);
        }else{
            this.nrOfEdges ++;
        }

    }
    public void printGraph(){
        for (int i = 0; i < nrOfVertices(); i++) {
            System.out.print(i + ": ");
            EdgeNode edgeNode = this.edges[i];
            while(edgeNode != null){
                System.out.print(" " + edgeNode.adjencyInfo  + " ->");
                edgeNode = edgeNode.next;
            }
            System.out.println();
        }
    }

    public final int nrOfVertices() {
         return vertices.size();
    }

    @Override
    public String toString() {
        return "Graph{}";
    }


}
