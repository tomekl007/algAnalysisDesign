package ch6_weightedGraphs;

import ch5graphs.Graph;
import ch5graphs.helper.GraphTestHelper;
import ch6_weightedGraphs.allpairs.shortestpath.AdjacencyMatrix;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Tomasz Lelek
 * @since 2014-04-19
 */
public class WeightedGraphOperationsTest {

    @Test
    public void shouldFindMinimumSpanningTreeUsingPrimAlg(){
        //given
        Graph graph = GraphTestHelper.createWeightenedGraph();
        WeightedGraphOperations weightedGraphOperations = new WeightedGraphOperations();
        //when
        weightedGraphOperations.prim(graph, 1);
        //then
        Assert.assertEquals(3, weightedGraphOperations.getMinimumSpanningTreeWeight());

    }
    @Test
    public void shouldFndShortestPathUsingDijkstraAlg(){
        //given
        Graph graph = GraphTestHelper.createWeightenedGraph();
        WeightedGraphOperations weightedGraphOperations = new WeightedGraphOperations();
        //when
        int distance = weightedGraphOperations.findShortestPathDijkstra(graph, 1, 3);
        //then
        Assert.assertEquals(2, distance);
    }

    @Test
    public void shouldFindAllPairsUsingFloydAlg(){
        //given
        AdjacencyMatrix adjacencyMatrix = GraphTestHelper.createAdjacencyMatrix();
        WeightedGraphOperations weightedGraphOperations = new WeightedGraphOperations();
        //when
        weightedGraphOperations.floyd(adjacencyMatrix);
        //then
        Assert.assertTrue(adjacencyMatrix.weights[3][1] != 10);

    }
}
