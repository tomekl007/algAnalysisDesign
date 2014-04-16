package ch4_sortingAndSearching;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Tomasz Lelek
 * @since 2014-04-16
 */
public class InterviewProblemsTest {

    @Test
    public void shouldSortListOfPairs(){
        //given
        List<Pair> pairs = new LinkedList<Pair>();
        Pair blue1 = new Pair("blue", 1);
        Pair red1 = new Pair("red", 3);
        Pair blue2 = new Pair("blue", 4);
        Pair yellow = new Pair("yellow", 6);
        Pair red2 = new Pair("red", 9);

        pairs.add(blue1);
        pairs.add(red1);
        pairs.add(blue2);
        pairs.add(yellow);
        pairs.add(red2);

        List<Pair> expectedSortedPairs = new LinkedList<>();
        expectedSortedPairs.add(blue1);
        expectedSortedPairs.add(blue2);
        expectedSortedPairs.add(red1);
        expectedSortedPairs.add(red2);
        expectedSortedPairs.add(yellow);

        //when
        List<Pair> sortedPairs = InterviewProblems.sortBucket(pairs);
        //then
        Assert.assertEquals(expectedSortedPairs, sortedPairs);
    }
}
