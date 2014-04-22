package ch8_dynamicProgramming;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @author Tomasz Lelek
 * @since 2014-04-22
 */
public class BinomialCoefficientTest {
    @Test
    public void shouldCountBinomialCoefficient(){
        //given
        int n = 5;
        int m = 4;
        //when
        double result = new BinomialCoefficient().countBinomialCoefficient(n, m);
        //then
        Assert.assertEquals(5d, result);



    }
}
