package ch1_introduction;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Tomasz Lelek
 * @since 2014-04-07
 */
public class SortAlghoritmTest {

    @Test
    public void shouldSortArray(){
        //given
        Integer[] a = new Integer[]{ 2,1,9,3,1};
        Integer [] b = Arrays.copyOf(a, a.length );
        SortAlgorithm sortAlgorithm = new InsertionSort();
        //when
        sortAlgorithm.sort(a, a.length);
        Arrays.sort(b);
        //then
        System.out.println(Arrays.toString(a));
        Assert.assertTrue(Arrays.equals(a, b));
    }

}
