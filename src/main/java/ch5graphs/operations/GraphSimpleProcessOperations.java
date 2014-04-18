package ch5graphs.operations;

/**
 * @author Tomasz Lelek
 * @since 2014-04-18
 */
public class GraphSimpleProcessOperations implements GraphProcessOperations{

    @Override
    public void processVertexLate(int currentVertex) {
        System.out.println("process vertex late : " + currentVertex);

    }

    @Override
    public boolean processEdge(int currentVertex, int successorVertex, int[] array) {
        System.out.println("processed edge : " + currentVertex + " -> " + successorVertex);
        return false;
    }

    @Override
    public void processVertexEarly(int currentVertex) {
        System.out.println("processed vertex : " + currentVertex);
    }
}
