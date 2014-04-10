package ch3_dataStructures;


import junit.framework.Assert;
import org.junit.Test;

/**
 * @author Tomasz Lelek
 * @since 2014-04-10
 */
public class InterviewProblemsTest {
    @Test
    public void shouldClassifyStringAsCorrect(){
        //given
        String input = "((())())()";
        //when
        int result = InterviewProblems.isBalancedParenthesis(input);
        //then
        Assert.assertEquals(0, result);
    }

    @Test
    public void shouldClassifyStringAsNotCorrectOneCloseMore(){
        //given
        String input = "((())())())";
        //when
        int result = InterviewProblems.isBalancedParenthesis(input);
        //then
        Assert.assertEquals(10, result);

    }

    @Test
    public void shouldClassifyStringAsNotCorrectOneOpenMore(){
        //given
        String input = "((())())()(";
        //when
        int result = InterviewProblems.isBalancedParenthesis(input);
        //then
        Assert.assertEquals(10, result);

    }

    @Test
    public void shouldClassifyStringAsNotCorrectTooMuchClosing(){
        //given
        String input = "())(";
        //when
        int result = InterviewProblems.isBalancedParenthesis(input);
        //then
        Assert.assertEquals(2, result);

    }
}
