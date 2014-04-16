package ch5graphs;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Tomasz Lelek
 * @since 2014-04-16
 */
public class GraphTest {

    @Test
    public void shouldCreateGraph(){

        //when
        Graph graph = GraphTestHelper.createUndirectedGraph();
        //then
        Assert.assertEquals(4, graph.nrOfVertices());
        Assert.assertEquals(4, graph.nrOfEdges);
        graph.printGraph();

    }


}
