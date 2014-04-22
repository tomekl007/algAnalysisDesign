package ch8_dynamicProgramming;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Tomasz Lelek
 * @since 2014-04-22
 */
public class FibonacciCachingTest {

    @Test
    public void shouldCountFibUsingCache(){
        //given
        int n = 6;
        //when
        long result = new FibonacciCaching().fibonacci(n);
        //then
        Assert.assertEquals(8, result);
    }
    @Test
    public void shouldCountFibonacciUltimate(){
        //given
        int n = 6;
        //when
        long result = new FibonacciUltimate().fibonacci(n);
        //then
        Assert.assertEquals(8, result);
    }
}
