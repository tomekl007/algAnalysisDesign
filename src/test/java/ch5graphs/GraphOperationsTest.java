package ch5graphs;

import ch5graphs.helper.GraphTestHelper;
import ch5graphs.operations.FindCycleOperations;
import ch5graphs.operations.GraphProcessOperations;
import ch5graphs.operations.GraphSimpleProcessOperations;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

/**
 * @author Tomasz Lelek
 * @since 2014-04-16
 */
public class GraphOperationsTest {
    @Test
    public void shouldSearchGraphAsBFS(){
        //given
        Graph graph = GraphTestHelper.createUndirectedGraph();
        //when
        GraphOperations graphOperations =  new GraphOperations(new GraphSimpleProcessOperations());
        graphOperations.breadthFirstSearch(graph, 0);
        //then
        Assert.assertEquals(true, graphOperations.processed[0]);
    }
    @Test
    public void shouldFindNumberOfConnectedComponents(){
        //given
        Graph graph = GraphTestHelper.createUndirectedGraphWithTwoComponents();
        //when
        GraphOperations graphOperations = new GraphOperations(new GraphSimpleProcessOperations());
        int numberOfConnectedComponenets = graphOperations.connectedComponenets(graph);
        //then
        Assert.assertEquals(2, numberOfConnectedComponenets);
    }


    @Test
    public void shouldColorGraphWithTwoColors(){
       //given
        Graph graph = GraphTestHelper.createBipartialeGraph();
        //when
        GraphOperations graphOperations = new GraphOperations(new GraphSimpleProcessOperations());
        graphOperations.twoColor(graph);
        //then
        Assert.assertTrue(graphOperations.bipartite);

    }


    @Test
    public void shouldFindThatGraphIsNotBipartiale(){
        //given
        Graph graph = GraphTestHelper.createNotBipartialeGraph();
        //when
        GraphOperations graphOperations = new GraphOperations(new GraphSimpleProcessOperations());
        graphOperations.twoColor(graph);
        //then
        Assert.assertFalse(graphOperations.bipartite);

    }

    @Test
    public void shouldSearchGraphAsDFS(){
        //given
        Graph graph = GraphTestHelper.createUndirectedGraph();
        //when
        GraphSimpleProcessOperations graphSimpleProcessOperations = new GraphSimpleProcessOperations();
        GraphOperations graphOperations = new GraphOperations(graphSimpleProcessOperations);

        graphOperations.depthFirstSearch(graph, 0,
                graphSimpleProcessOperations::processVertexEarly
                ,graphSimpleProcessOperations::processVertexLate
                ,graphSimpleProcessOperations::processEdge);
        //then
        Assert.assertTrue(graphOperations.time > 9);

    }


    @Test
    public void shouldFindCycleInGraph(){
        //given
        Graph graph = GraphTestHelper.createGraphWithCycle();
        //when
        GraphProcessOperations graphProcessOperations = new FindCycleOperations();
        GraphOperations graphOperations = new GraphOperations(graphProcessOperations);
        graphOperations.depthFirstSearch(graph, 0,
                graphProcessOperations::processVertexEarly
                ,graphProcessOperations::processVertexLate
                ,graphProcessOperations::processEdge);
        //then
        Assert.assertTrue(graphOperations.finished);
    }

    @Test
    public void shouldSortDirectGraph(){
        //given
        Graph graph = GraphTestHelper.createDirectGraph();
        GraphOperations graphOperations = new GraphOperations(new GraphSimpleProcessOperations());
        //when
        Collection<Integer> result = graphOperations.topologicalSort(graph);
        //then
        Collection<Integer> expected = new LinkedList<>();
        expected.add(7);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(6);
        expected.add(5);
        expected.add(4);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void sholdFindStrongConnectedComponent(){
        //given
        Graph graph = GraphTestHelper.createGraphWithThreeStronglyConnectedComponents();
        GraphOperations graphOperations = new GraphOperations(new GraphSimpleProcessOperations());
        //when
        graphOperations.strongComponenets(graph);
        //then
        Assert.assertEquals(3, graphOperations.componentsFound);
    }

    @Test
    public void shouldReturnEdgaPairArray(){
        //given
        Graph graph = GraphTestHelper.createUndirectedGraph();
        //when
        EdgePair edgePair[] = GraphOperations.toEdgePairArray(graph);
        //then
        System.out.println(Arrays.toString(edgePair));
    }




}
