package ch4_sortingAndSearching;

import ch1_introduction.SortAlgorithm;
import com.google.common.collect.MinMaxPriorityQueue;

import java.util.Arrays;

/**
 * @author Tomasz Lelek
 * @since 2014-04-10
 */
public class HeapSort extends SortAlgorithm {


    private MinMaxPriorityQueue<Integer> makeHeap(Integer[] s) {
        MinMaxPriorityQueue<Integer> heap = MinMaxPriorityQueue.create();
        heap.addAll(Arrays.asList(s));//initialization of heap is n
        return heap;
    }

    @Override
    public void sort(Integer[] s, int n) {
        MinMaxPriorityQueue<Integer> heap = makeHeap(s);//n

        for (int i = 0; i < s.length; i++) {
            s[i] = heap.removeFirst(); //log n
        }
    }
}


