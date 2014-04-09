package ch1_introduction;

/**
 * @author Tomasz Lelek
 * @since 2014-04-09
 */
public abstract class SortAlgorithm {
    //in comment worst case
    public abstract void sort(int s[], int n);

    public static void swap(int[] s, int j) {
        int temp = s[j - 1];
        s[j - 1] = s[j];
        s[j] = temp;
    }
}
