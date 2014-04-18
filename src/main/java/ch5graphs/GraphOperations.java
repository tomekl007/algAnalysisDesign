package ch5graphs;

import ch5graphs.operations.GraphProcessOperations;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Tomasz Lelek
 * @since 2014-04-16
 */
public class GraphOperations {
    enum COLOR {UNCOLORED, WHITE, BLACK};

    boolean processed[] = new boolean[Graph.MAX_VERTICES];
    boolean discovered[] = new boolean[Graph.MAX_VERTICES];
    COLOR color[] =  new COLOR[Graph.MAX_VERTICES];
    int parent[] = new int[Graph.MAX_VERTICES];
    int time = 0;
    int entryTime[] = new int[Graph.MAX_VERTICES];
    boolean bipartite;
    boolean finished = false;

    //each vertex is initialize as undiscovered
    private void initializeSearch(Graph graph){
       // Arrays.fill(color, COLOR.UNCOLORED);

        for (int i = 1; i < graph.nrOfVertices(); i++) {
            processed[i] = discovered[i] = false;
            parent[i] = -1;
        }
    }
    private final GraphProcessOperations graphProcessOperations;

    public GraphOperations(GraphProcessOperations graphProcessOperations) {
        this.graphProcessOperations = graphProcessOperations;
    }

    /**
     * A connected component of an undirected graph is a
     * maximal set of vertices such that there is a path between every pair of vertices
     * @param graph
     */
    public int connectedComponenets(Graph graph){
        int componentNumber = 0;
        initializeSearch(graph);

        for (int i = 0; i < graph.nrOfVertices(); i++) {
            if(!discovered[i]){
                componentNumber ++;
                System.out.print("Component : " + componentNumber);
                breadthFirstSearch(graph, i);
            }
        }
        return componentNumber;
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
            graphProcessOperations.processVertexEarly(currentVertex);
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
            graphProcessOperations.processVertexLate(currentVertex);
        }

    }


    public void depthFirstSearch(Graph g, int vertex){
        int successorVertex;

        if(finished) return;

        discovered[vertex] = true;
        time ++;
        entryTime[vertex] = time;

        graphProcessOperations.processVertexEarly(vertex);
        EdgeNode edgeNode = g.edges[vertex];

        while(edgeNode != null){
            successorVertex = edgeNode.adjencyInfo;
            if(!discovered[successorVertex]){
                parent[successorVertex] = vertex;
                finished = graphProcessOperations.processEdge(vertex, successorVertex, parent);
                depthFirstSearch(g, successorVertex);
            }else if( !processed[successorVertex] || g.directed){
                finished = graphProcessOperations.processEdge(vertex, successorVertex, parent);
            }

            if(finished) return;

            edgeNode = edgeNode.next;

        }
        graphProcessOperations.processVertexLate(vertex);
        time ++;
        entryTime[vertex] = time;

        processed[vertex] = true;

    }




    public void twoColor(Graph graph)
    {

        for (int i=1; i<=graph.nrOfVertices(); i++){
            color[i] = COLOR.UNCOLORED;
        }

        bipartite = true;
        initializeSearch(graph);

        for (int i=1; i<= graph.nrOfVertices(); i++)
            if (!discovered[i]) {
                color[i] = COLOR.WHITE;
                breadthFirstSearch(graph, i);
            }

    }

    public void processEdge(int x, int y)
    {
        if (color[x] == color[y]) {
            bipartite = false;
            System.out.printf("Warning: not bipartite due to (%d,%d)\n", x, y);
        }
        color[y] = complement(color[x]);
    }

    private COLOR complement(COLOR color) {
        if (color == COLOR.WHITE) return(COLOR.BLACK);
        if (color == COLOR.BLACK) return(COLOR.WHITE);
        return(COLOR.UNCOLORED);
    }
}
