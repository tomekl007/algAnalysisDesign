package ch7_combinatorialHeuristics.interviewProblems;

import java.util.LinkedList;
import java.util.List;

public class DerangementGenerator {
    private void derangements(int[] a) {
        d(a, new LinkedList<>());
    }
    private int nrOfResults;

    public DerangementGenerator() {
        this.nrOfResults = 0;
    }

    private void d(int[] a, LinkedList<Integer> curr) {
        if (curr.size() == a.length)
            print(curr);
        else {
            for (int i = 0; i < a.length; i++) {
                if (!curr.contains(a[i]) && i != curr.size()) {
                    curr.addLast(a[i]); // O(1)
                    d(a, curr);
                    curr.removeLast(); // O(1)
                }
            }
        }
    }


    private void print(List<Integer> l) {
        nrOfResults++;
        for (int i = 0; i < l.size() - 1; i++) {
            System.out.print(l.get(i) + ", ");
        }
        System.out.println(l.get(l.size() - 1));
    }

    public int generateDerangements(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }

        derangements(a);
        return nrOfResults;
    }
}