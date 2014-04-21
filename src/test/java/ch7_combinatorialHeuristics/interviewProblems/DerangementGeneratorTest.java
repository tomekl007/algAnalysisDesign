package ch7_combinatorialHeuristics.interviewProblems;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Tomasz Lelek
 * @since 2014-04-21
 */
public class DerangementGeneratorTest {

    @Test
    public void shouldGenerateAllDerangements(){
        //given
        int n = 5;
        DerangementGenerator derangementGenerator = new DerangementGenerator();
        //when
        int result = derangementGenerator.generateDerangements(n);
        //then
        Assert.assertEquals(44, result);

    }

}
