package ch1_introduction;

/**
 * @author Tomasz Lelek
 * @since 2014-04-09
 */
public class SelectionSort extends SortAlgorithm {

    @Override
    public void sort(int s[], int n) {
        int i, j;
        int min;
        for (i = 0; i < n; i++) {   //n
            min = i;
        /* counters */
        /* index of minimum */

            for (j = i + 1; j < n; j++) {   // n - i - 1
                if (s[j] < s[min]) {
                    min = j;
                }
                swap( s, i, min);
            }
        }     //n * (n - i - 1 ) => n * n = n^2 //
    }

    private void swap(int[] s, int i, int min) {
        int temp = s[min];
        s[min] = s[i];
        s[i] = temp;
    }
}
