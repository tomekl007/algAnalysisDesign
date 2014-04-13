package ch4_sortingAndSearching;


import org.junit.Assert;
import org.junit.Test;

/**
 * @author Tomasz Lelek
 * @since 2014-04-13
 */
public class BinarySearchTest {
    @Test
    public void shouldFindNumberForSortedInput() {
        //given
        int keyToFind = 88;
        Integer[] sortedInput = new Integer[]{1,2,3,4,66,77,keyToFind,99,100};
        //when
        int result = BinarySearch.find(sortedInput, keyToFind);
        //then
        Assert.assertEquals(6, result);
    }
}
