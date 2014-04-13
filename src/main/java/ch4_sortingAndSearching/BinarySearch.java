package ch4_sortingAndSearching;

/**
 * @author Tomasz Lelek
 * @since 2014-04-13
 */
public class BinarySearch {

    public static int find(Integer[] input, Integer key){
        return binarySearch(input, key, 0, input.length);
    }

    private static int binarySearch(Integer[] s, Integer key, int low, int high) {
        int middle;                   /* index of middle element */
        if (low > high) return (-1);  /* key not found */
        middle = (low + high) / 2;
        if (s[middle].equals(key)) return (middle);
        if (s[middle] > key)
            return (binarySearch(s, key, low, middle - 1));
        else
            return (binarySearch(s, key, middle + 1, high));
    }



}
