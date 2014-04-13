package ch4_sortingAndSearching;

import ch1_introduction.SortAlgorithm;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Tomasz Lelek
 * @since 2014-04-13
 */
public class QuickSort extends SortAlgorithm {
    @Override
    public void sort(Integer[] s, int n) {
        Collections.shuffle(Arrays.asList(s));//permutation can be constructed in O(n) time
        quicksort(s, 0, n - 1);
    }

    public void quicksort(Integer[] s, int l, int h) {

        int p;                  /* index of partition */
        if ((h - l) > 0) {    //log n levels, with high probability
            p = partition(s, l, h);
            quicksort(s, l, p - 1);
            quicksort(s, p + 1, h);
        }
    }// n * log n for random input

    private int partition(Integer[] s, int l, int h) {  //n
        for (int i = l; i < h; i++){
            if (s[i] < s[h]) {
                swap(s, i, l);
                l++;
            }
        }
        swap(s, h, l);
        return (l);
    }
}
