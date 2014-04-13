package ch4_sortingAndSearching;

import ch1_introduction.SortAlgorithm;

import java.util.*;

/**
 * @author Tomasz Lelek
 * @since 2014-04-13
 */
public class MergeSort extends SortAlgorithm {
    @Override
    public void sort(Integer[] s, int n) {
        mergesort(s, 0, n - 1);

    }

    private void mergesort(Integer s[], int low, int high) {
        int middle;             /* index of middle element */
        if (low < high) {
            middle = (low + high) / 2;
            mergesort(s, low, middle); //recursion goes lg n levels deep
            mergesort(s, middle + 1, high);
            merge(s, low, middle, high);
        }
    }    //n * log n

    private void merge(Integer[] s, int low, int middle, int high) {   //linear work per level (n), to merge two sorted lists
        int i;                  /* counter */
        Queue<Integer> buffer1, buffer2; /* buffers to hold elements for merging */
        buffer1 = new ArrayDeque<Integer>();
        buffer2 = new ArrayDeque<Integer>();

        for (i = low; i <= middle; i++) {
            buffer1.offer(s[i]);
        }
        for (i = middle + 1; i <= high; i++) {
            buffer2.offer(s[i]);
        }
        i = low;

        while (!(buffer1.isEmpty() || buffer2.isEmpty())) {
            if (buffer1.peek() <= buffer2.peek()) {
                s[i++] = buffer1.poll();
            } else {
                s[i++] = buffer2.poll();
            }
        }
            while (!buffer1.isEmpty())s[i++] = buffer1.poll();
            while (!buffer2.isEmpty())s[i++] = buffer2.poll();
        }


    }

