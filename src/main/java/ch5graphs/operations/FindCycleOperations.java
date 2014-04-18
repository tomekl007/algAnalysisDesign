package ch5graphs.operations;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tomasz Lelek
 * @since 2014-04-18
 */
public class FindCycleOperations implements GraphProcessOperations {
    @Override
    public void processVertexLate(int currentVertex) {
        System.out.println("process vertex late : " + currentVertex);
    }

    private Map<Pair<Integer, Integer>, Boolean> twoVertex = new HashMap<>();

    @Override
    public boolean processEdge(int x, int y, int[] parent) {

        if (twoVertex.get(new Pair<>(x, y)) != null) {
            return false;
        } else if (twoVertex.get(new Pair<>(y, x)) != null) {
            return false;
        }
        twoVertex.put(new Pair<>(x, y), true);


        if (parent[y] != x) {   /* found back edge! */
            System.out.printf("Cycle from %d to %d:", y, x);
            GraphHelper.findPath(y, x, parent);
            System.out.println("\n");
            return true;
        }
        return false;
    }


    @Override
    public void processVertexEarly(int currentVertex) {
        System.out.println("processed vertex : " + currentVertex);
    }
}
