package ch5graphs;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Tomasz Lelek
 * @since 2014-04-16
 */
public class GraphSearchTest {
    @Test
    public void shouldSearchGraphAsBFS(){
        //given
        Graph graph = GraphTestHelper.createUndirectedGraph();
        //when
        GraphSearch graphSearch =  new GraphSearch();
        graphSearch.breadthFirstSearch(graph, 0);
        //then
        Assert.assertEquals(true, graphSearch.processed[0]);

    }



}
