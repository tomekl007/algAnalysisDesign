package ch5graphs;

import ch5graphs.helper.GraphTestHelper;
import ch5graphs.operations.FindCycleOperations;
import ch5graphs.operations.GraphSimpleProcessOperations;
import org.junit.Assert;
import org.junit.Test;

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
        GraphOperations graphOperations = new GraphOperations(new GraphSimpleProcessOperations());
        graphOperations.depthFirstSearch(graph, 0);
        //then
        Assert.assertTrue(graphOperations.time > 9);

    }


    @Test
    public void shouldFindCycleInGraph(){
        //given
        Graph graph = GraphTestHelper.createGraphWithCycle();
        //when
        GraphOperations graphOperations = new GraphOperations(new FindCycleOperations());
        graphOperations.depthFirstSearch(graph, 0);
        //then
        Assert.assertTrue(graphOperations.finished);
    }




}
