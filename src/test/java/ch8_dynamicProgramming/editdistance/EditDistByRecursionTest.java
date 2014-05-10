package ch8_dynamicProgramming.editdistance;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Tomasz Lelek
 * @since 2014-04-30
 */
public class EditDistByRecursionTest {

    @Test( timeout = 10)
    @Ignore
    public void shouldFindEditDistance(){
        //given
        String s = "you should not";
        String t = "thou shalt not";
        //when
        EditDistByRecursion.stringCompare(s, t);
    }
}
