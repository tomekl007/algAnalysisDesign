package ch2_alghoritmAnalysis;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @author Tomasz Lelek
 * @since 2014-04-09
 */
public class DivideAndConquerExampleTest {

    @Test
    public void shouldReturnPower(){
        Assert.assertEquals(256, DivideAndConquerExample.power(2, 8));
    }
}
