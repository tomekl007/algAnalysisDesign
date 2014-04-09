package ch1_introduction;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @author Tomasz Lelek
 * @since 2014-04-09
 */
public class InterviewProblemTest {
    @Test
    public void shouldDivideTwoInt(){
        //given
        int x = 10;
        int y = 5;
        //when
        int result = InterviewProblems.divide(x,y);
        //then
        Assert.assertEquals(2, result);
    }
    @Test
    public void shouldDivideTwoBigInt(){
        //given
        int x = 104;
        int y = 12;
        //when
        int result = InterviewProblems.divide(x,y);
        //then
        Assert.assertEquals(x/y, result);
    }
}
