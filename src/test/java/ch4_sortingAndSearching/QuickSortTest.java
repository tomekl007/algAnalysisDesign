package ch4_sortingAndSearching;

import ch1_introduction.SortAlgorithm;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Tomasz Lelek
 * @since 2014-04-13
 */
public class QuickSortTest {

    @Test
    public void shouldSortInput(){
        //given
        Integer[] a = new Integer[]{ 65, 72, 23, 36, 99, 20, 1, 44};
        Integer [] b = Arrays.copyOf(a, a.length);
        SortAlgorithm sortAlgorithm = new QuickSort();
        //when
        sortAlgorithm.sort(a, a.length);
        Arrays.sort(b);
        //then
        System.out.println(Arrays.toString(a));
        Assert.assertTrue(Arrays.equals(a, b));
    }

    @Test
    public void quickSortOnSortedInput(){
        //given
        Integer[] a = new Integer[]{ 1,2,3,4,5,6,7,8};
        Integer [] b = Arrays.copyOf(a, a.length);
        SortAlgorithm sortAlgorithm = new QuickSort();
        //when
        sortAlgorithm.sort(a, a.length);
        Arrays.sort(b);
        //then
        System.out.println(Arrays.toString(a));
        Assert.assertTrue(Arrays.equals(a, b));
    }

}
