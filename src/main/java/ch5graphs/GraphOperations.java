package ch5graphs;

import ch5graphs.operations.FindCycleOperations;
import ch5graphs.operations.GraphProcessOperations;
import ch5graphs.operations.TriFunction;

import java.util.*;
import java.util.function.Consumer;

/**
 * @author Tomasz Lelek
 * @since 2014-04-16
 */
public class GraphOperations {
    enum COLOR {UNCOLORED, WHITE, BLACK}

    ;

    enum EDGE_TYPE {TREE, BACK, FORWARD, CROSS, UNCLASSIFIED}

    boolean processed[] = new boolean[Graph.MAX_VERTICES];
    boolean discovered[] = new boolean[Graph.MAX_VERTICES];
    COLOR color[] = new COLOR[Graph.MAX_VERTICES];
    int parent[] = new int[Graph.MAX_VERTICES];
    int time = 0;
    int entryTime[] = new int[Graph.MAX_VERTICES];
    boolean bipartite;
    boolean finished = false;

    //finding articulation
    int reachargableAncestor[] = new int[Graph.MAX_VERTICES]; /* earliest reachable ancestor of v */
    int treeOutDegree[] = new int[Graph.MAX_VERTICES];/* DFS tree outdegree of v */

    //each vertex is initialize as undiscovered
    private void initializeSearch(Graph graph) {
        // Arrays.fill(color, COLOR.UNCOLORED);

        for (int i = 1; i < graph.nrOfVertices(); i++) {
            processed[i] = discovered[i] = false;
            parent[i] = 0;
        }
    }

    private final GraphProcessOperations graphProcessOperations;

    public GraphOperations(GraphProcessOperations graphProcessOperations) {
        this.graphProcessOperations = graphProcessOperations;
    }

    /**
     * A connected component of an undirected graph is a
     * maximal set of vertices such that there is a path between every pair of vertices
     *
     * @param graph
     */
    public int connectedComponenets(Graph graph) {
        int componentNumber = 0;
        initializeSearch(graph);

        for (int i = 0; i < graph.nrOfVertices(); i++) {
            if (!discovered[i]) {
                componentNumber++;
                System.out.print("Component : " + componentNumber);
                breadthFirstSearch(graph, i);
            }
        }
        return componentNumber;
    }


    public void breadthFirstSearch(Graph graph, int start) {
        initializeSearch(graph);
        Queue<Integer> verticesToVisit = new LinkedList<>();
        int currentVertex;
        int successorVertex;

        verticesToVisit.offer(start);
        discovered[start] = true;
        EdgeNode edgeNode;

        while (!verticesToVisit.isEmpty()) {
            currentVertex = verticesToVisit.poll();
            graphProcessOperations.processVertexEarly(currentVertex);
            processed[currentVertex] = true;
            edgeNode = graph.edges[currentVertex];

            while (edgeNode != null) {
                successorVertex = edgeNode.adjencyInfo;
                if ((!processed[successorVertex]) || graph.directed) {
                    processEdge(currentVertex, successorVertex);
                }
                if (!discovered[successorVertex]) {
                    verticesToVisit.offer(successorVertex);
                    discovered[successorVertex] = true;
                    parent[successorVertex] = currentVertex;
                }
                edgeNode = edgeNode.next;
            }
            graphProcessOperations.processVertexLate(currentVertex);
        }

    }


    public void depthFirstSearch(Graph g, int vertex,
                                 Consumer<Integer> processVertexEarly,
                                 Consumer<Integer> processVertexLate,
                                 TriFunction<Integer, Integer, int[], Boolean> processEdgeF) {
        int successorVertex;

        if (finished) return;

        discovered[vertex] = true;
        time++;
        entryTime[vertex] = time;


        processVertexEarly.accept(vertex);

        EdgeNode edgeNode = g.edges[vertex];

        while (edgeNode != null) {
            successorVertex = edgeNode.adjencyInfo;


            if (!discovered[successorVertex]) {
                parent[successorVertex] = vertex;
                finished = processEdgeF.accept(vertex, successorVertex, parent);
                depthFirstSearch(g, successorVertex, processVertexEarly, processVertexLate, processEdgeF);
            } else if (!processed[successorVertex] || g.directed) {
                finished = processEdgeF.accept(vertex, successorVertex, parent);
            }

            printInfoAboutEdgeType(vertex, successorVertex);

            if (finished) return;

            edgeNode = edgeNode.next;

        }
        processVertexLate.accept(vertex);
        time++;
        entryTime[vertex] = time;

        processed[vertex] = true;

    }

    private void printInfoAboutEdgeType(int vertex, int successorVertex) {
        System.out.println(vertex + " -> " + successorVertex
                + " " + edgeClassification(vertex, successorVertex));
    }


    public void twoColor(Graph graph) {

        for (int i = 1; i <= graph.nrOfVertices(); i++) {
            color[i] = COLOR.UNCOLORED;
        }

        bipartite = true;
        initializeSearch(graph);

        for (int i = 1; i <= graph.nrOfVertices(); i++)
            if (!discovered[i]) {
                color[i] = COLOR.WHITE;
                breadthFirstSearch(graph, i);
            }

    }

    public void processEdge(int x, int y) {
        if (color[x] == color[y]) {
            bipartite = false;
            System.out.printf("Warning: not bipartite due to (%d,%d)\n", x, y);
        }
        color[y] = complement(color[x]);
    }

    private COLOR complement(COLOR color) {
        if (color == COLOR.WHITE) return (COLOR.BLACK);
        if (color == COLOR.BLACK) return (COLOR.WHITE);
        return (COLOR.UNCOLORED);
    }

    EDGE_TYPE edgeClassification(int x, int y) {
        if (parent[y] == x) return (EDGE_TYPE.TREE);
        if (discovered[y] && !processed[y]) return (EDGE_TYPE.BACK);
        if (processed[y] && (entryTime[y] > entryTime[x])) return (EDGE_TYPE.FORWARD);
        if (processed[y] && (entryTime[y] < entryTime[x])) return (EDGE_TYPE.CROSS);
        System.out.printf("Warning: unclassified edge (%d,%d)\n", x, y);
        return EDGE_TYPE.UNCLASSIFIED;
    }


    void processEdgeArticulation(int x, int y) {
        EDGE_TYPE edge_type;              /* edge class */
        edge_type = edgeClassification(x, y);
        if (edge_type.equals(EDGE_TYPE.TREE))
            treeOutDegree[x] = treeOutDegree[x] + 1;
        if ((edge_type.equals(EDGE_TYPE.BACK)) && (parent[x] != y)) {
            if (entryTime[y] < entryTime[reachargableAncestor[x]])
                reachargableAncestor[x] = y;
        }
    }


    public void processLateVertexArticulation(int v) {
        boolean isRootOfTree;/* is the vertex the root of the DFS tree? */
        int time_v;/* earliest reachable time for v */
        int time_parent;/* earliest reachable time for parent[v] */

        if (parent[v] < 1) {    /* test if v is the root */
            if (treeOutDegree[v] > 1)
                System.out.printf("root articulation vertex: %d \n", v);
            return;
        }
        isRootOfTree = (parent[parent[v]] < 1);      /* is parent[v] the root? */
        if ((reachargableAncestor[v] == parent[v]) && (!isRootOfTree))
            System.out.printf("parent articulation vertex: %d \n", parent[v]);
        if (reachargableAncestor[v] == v) {
            System.out.printf("bridge articulation vertex: %d \n", parent[v]);
            if (treeOutDegree[v] > 0)  /* test if v is not a leaf */
                System.out.printf("bridge articulation vertex: %d \n", v);
        }
        time_v = entryTime[reachargableAncestor[v]];
        time_parent = entryTime[reachargableAncestor[parent[v]]];
        if (time_v < time_parent)
            reachargableAncestor[parent[v]] = reachargableAncestor[v];
    }

    private Stack<Integer> sorted = new Stack<>();

    public Collection<Integer> topologicalSort(Graph g) {
        int i;

        for (i = 1; i <= g.nrOfVertices(); i++)
            if (!discovered[i])
                depthFirstSearch(g, i,
                        graphProcessOperations::processVertexEarly,
                        this::processVertexLateTopSort,
                        this::processEdgeTopSort);

        Collections.reverse(sorted);
        return sorted;

    }

    void processVertexLateTopSort(int v) {
        sorted.push(v);
    }

    boolean processEdgeTopSort(int x, int y, int[] ignored) {
        EDGE_TYPE edge_type = edgeClassification(x, y);
        if (edge_type.equals(EDGE_TYPE.BACK)) {
            System.out.printf("Warning: directed cycle found, not a DAG\n");
            return true;
        }
        return false;
    }


    //finding strong connected components
    int oldestVertex[] = new int[Graph.MAX_VERTICES];
    int strongComponentNumber[] = new int[Graph.MAX_VERTICES];
    Stack<Integer> active = new Stack<>();
    int componentsFound;

    public void strongComponenets(Graph g) {

        for (int i = 1; i <= g.nrOfVertices(); i++) {
            oldestVertex[i] = i;
            strongComponentNumber[i] = -1;
        }
        componentsFound = 0;

        initializeSearch(g);

        for (int i = 1; i <= g.nrOfVertices(); i++)
            if (!discovered[i]) {
                depthFirstSearch(g, i,
                        this::processVertexEarlyStrongComponent,
                        this::processVertexLateStrongComponent,
                        this::procesEdgeStrongComponent);
            }
    }

    boolean procesEdgeStrongComponent(int x, int y, int[] ignored) {

        EDGE_TYPE edge_type = edgeClassification(x, y);
        if (edge_type.equals(EDGE_TYPE.BACK)) {
            if (entryTime[y] < entryTime[oldestVertex[x]])
                oldestVertex[x] = y;
        }
        if (edge_type.equals(EDGE_TYPE.CROSS)) {
            if (strongComponentNumber[y] == -1)  /* component not yet assigned */
                if (entryTime[y] < entryTime[oldestVertex[x]])
                    oldestVertex[x] = y;
        }
        return false;
    }

    void processVertexEarlyStrongComponent(int v) {
        active.push(v);
    }

    void processVertexLateStrongComponent(int v) {
        if (oldestVertex[v] == v) {     /* edge (parent[v],v) cuts off scc */
            popComponent(v);
        }
        if (entryTime[oldestVertex[v]] < entryTime[oldestVertex[parent[v]]])
            oldestVertex[parent[v]] = oldestVertex[v];
    }

    void popComponent(int v) {
        int t;                /* vertex placeholder */
        componentsFound++;
        strongComponentNumber[v] = componentsFound;
        while ((t = active.pop()) != v) {
            strongComponentNumber[t] = componentsFound;
        }
    }

    /**
     * should return array with all edges from given graph
     * @param g
     * @return
     */
    public static EdgePair[] toEdgePairArray(Graph g) {
        FindCycleOperations findCycleOperations = new FindCycleOperations();
        GraphOperations graphOperations = new GraphOperations(findCycleOperations);
        graphOperations.depthFirstSearch(g, 0, findCycleOperations::processVertexEarly,
                findCycleOperations::processVertexEarly, findCycleOperations::processEdge);
        //findCycleOperations.twoVertex
        return new EdgePair[findCycleOperations.twoVertex.size()];

    }

}
