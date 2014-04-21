package ch7_combinatorialHeuristics;

import ch5graphs.operations.TriFunction;
import ch7_combinatorialHeuristics.sudoku.BoardType;
import ch7_combinatorialHeuristics.sudoku.SudokuBacktrackingFunctions;
import ch7_combinatorialHeuristics.sudoku.SudokuConst;

import java.util.*;

/**
 * @author Tomasz Lelek
 * @since 2014-04-20
 */
public class Backtracking {

    private static final int MAXCANDIDATES = 10;
    private boolean finished = false; /* found all solutions yet? */
    public Set<List<Integer>> subsets = new LinkedHashSet<>();
    public int nrOfPermutations = 0;

    private<T> void backtrack(int a[], int k, T input,
                           QuadFunction<int[], Integer, T, int[], Integer> constructCandidates,
                           TriFunction<int[], Integer, T, Boolean> processSolution,
                           TriFunction<int[], Integer, T, Boolean> isASolution,
                           TriConsumer<int[], Integer, T> makeMove,
                           TriConsumer<int[], Integer, T> unmakeMove) {
        int candidatesForNextPosition[] = new int[MAXCANDIDATES];
        int nextPositionCandidateCount;
        if (isASolution.accept(a, k, input))
            finished = processSolution.accept(a, k, input);
        else {
            k = k + 1;
            nextPositionCandidateCount = constructCandidates.accept(a, k, input, candidatesForNextPosition);
            for (int i = 0; i < nextPositionCandidateCount; i++) {
                a[k] = candidatesForNextPosition[i];

                makeMove.accept(a, k, input);

                backtrack(a, k, input,
                        constructCandidates,
                        processSolution,
                        isASolution,
                        makeMove,
                        unmakeMove);

                unmakeMove.accept(a, k, input);

                if (finished) return;
            }
        }
    }

    private<T> void unmakeMove(int[] a, int k, T input) {
        System.out.println("unmake move for : a: " + Arrays.toString(a) + " k : " + k + " input : " + input);
        System.out.println();
    }

    private<T> void makeMove(int[] a, int k, T input) {
        //System.out.println(" a: " + Arrays.toString(a) + " k : " + k + " input : " + input);
    }

    private boolean processSolutionSubset(int[] a, int k, int input) {

        System.out.printf("{");
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= k; i++) {

            if (a[i] == 1) {
                list.add(i);
                System.out.printf(" %d", i);
            }

        }
        subsets.add(list);
        System.out.println(" }\n");
        return false;
    }

    private int constructCandidatesSubset(int[] a, int k, int input, int[] candidatesForNextPosition) {
        candidatesForNextPosition[0] = 1;
        candidatesForNextPosition[1] = 0;
        return 2;
    }

    private boolean isASolutionSubset(int[] a, int k, int input) {
        return (k == input);
    }

    /**
     * enumerate all subsets for given n
     *
     * @param n
     * @return
     */
    public void generate_subsets(int n) {
        int a[] = new int[MAXCANDIDATES];
        backtrack(a, 0, n,
                this::constructCandidatesSubset,
                this::processSolutionSubset,
                this::isASolutionSubset,
                this::makeMove,
                this::unmakeMove);
    }


    private<T> int constructCandidatesPermutations(int a[], int k, T n, int c[]) {
        int n2 = (Integer) n;

        boolean inPermutation[] = new boolean[MAXCANDIDATES];/* who is in the permutation? */
        for (int i = 1; i < MAXCANDIDATES; i++) inPermutation[i] = false;
        for (int i = 0; i < k; i++) inPermutation[a[i]] = true;

        int ncandidates = 0;
        for (int i = 1; i <= n2; i++) {
            if (!inPermutation[i]) {
                c[ncandidates] = i;
                ncandidates++;
            }
        }
        return ncandidates;
    }

    private boolean processSolutionPermutation(int a[], int k, int ignore) {
        nrOfPermutations++;
        for (int i = 1; i <= k; i++) System.out.printf(" %d", a[i]);
        System.out.printf("\n");
        return false;
    }

    private boolean isASolutionPermuation(int a[], int k, int n) {
        return (k == n);
    }

    public void generatePermutations(int n) {
        int a[] = new int[MAXCANDIDATES];
        backtrack(a, 0, n,
                this::constructCandidatesPermutations,
                this::processSolutionPermutation,
                this::isASolutionPermuation,
                this::makeMove,
                this::unmakeMove);
    }

    public void solveSudoku(BoardType boardType){
        int a[] = new int[SudokuConst.CELLS_NUMBER];
        backtrack(a, 0, boardType ,
                SudokuBacktrackingFunctions::constructCandidates,
                SudokuBacktrackingFunctions::processSolution,
                SudokuBacktrackingFunctions::isASolution,
                SudokuBacktrackingFunctions::makeMove,
                SudokuBacktrackingFunctions::unmakeMove);


    }

}