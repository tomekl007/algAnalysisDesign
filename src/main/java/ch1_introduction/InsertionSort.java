package ch1_introduction;

/**
 * @author Tomasz Lelek
 * @since 2014-04-07
 */
public class InsertionSort extends SortAlgorithm {



    @Override
    public void sort(Integer[] s, int n) {
        int i, j;                /* counters */
        for (i = 1; i < n; i++) { // n
            j = i;
            while ((j > 0) && (s[j] < s[j - 1])) { // n in last iteration
                swap(s, j);
                j = j - 1;
            }
        }
        //n * n = n^2
    }
}