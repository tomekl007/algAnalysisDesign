package ch5graphs;

import ch5graphs.helper.GraphTestHelper;
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
        Assert.assertTrue(4 < graph.nrOfVertices());
        Assert.assertTrue(4 < graph.nrOfEdges);
        graph.printGraph();

    }


}
