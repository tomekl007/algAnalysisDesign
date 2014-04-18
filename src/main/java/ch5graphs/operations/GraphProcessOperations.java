package ch5graphs.operations;

/**
 * @author Tomasz Lelek
 * @since 2014-04-18
 */
public interface GraphProcessOperations {
    void processVertexLate(int currentVertex);

    boolean processEdge(int x, int y, int[] parent);

    void processVertexEarly(int currentVertex);
}
