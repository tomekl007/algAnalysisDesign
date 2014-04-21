package ch7_combinatorialHeuristics.sudoku;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Tomasz Lelek
 * @since 2014-04-21
 */
public class SudokuBacktrackingFunctions {

    public static int constructCandidates(int a[], int k, BoardType board, int candidatesForNextPosition[]) {
        int x, y;                    /* position of next move */

        Point nextSquareToFill = nextSquare( board);   /* which square should we fill next? */
        x = nextSquareToFill.x;
        y = nextSquareToFill.y;
        board.move[k].x = x;       /* store our choice of next position */
        board.move[k].y = y;
        int ncandidates = 0;
        if ((x < 0) && (y < 0)) throw new RuntimeException("/* error condition, no moves possible */");//todo maybe return 0 ?

        boolean possible[] = possibleValues(x, y, board);  /* what is possible for the square */
        for (int i = 0; i <= SudokuConst.DIMENSION; i++)
            if (possible[i]) {
                candidatesForNextPosition[ncandidates] = i;
                ncandidates++;
            }
        return ncandidates;
    }


    /**
     * Local Count – Our backtrack search works correctly if the
     * routine generating candidates for board position (i, j)
     * (possible values) does the obvious thing and allows all
     * numbers 1 to 9 that have not appeared in the given row, column, or sector.
     * @param x
     * @param y
     * @param board
     * @return
     */
    private static boolean[] possibleValues(int x, int y, BoardType board) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> column = new HashSet<>();

        for (int i = 0; i < SudokuConst.DIMENSION; i++) {
            for (int j = 0; j < SudokuConst.DIMENSION; j++) {
                if(x == i){
                    row.add(board.matrix[i][j]);
                }
                if( y == j){
                    column.add(board.matrix[i][j]);
                }
            }
        }
        return new boolean[1];
    }

    /**
     * Pick the first open square we encounter,
     * possibly picking the first, the last, or a
     * random open square. All are equivalent in
     * that there seems to be no reason to believe
     * that one heuristic will perform any better than the other.
     * @param board
     * @return
     */
    private static Point nextSquare(BoardType board) {
        for (int i = 0; i < SudokuConst.DIMENSION; i++) {
            for (int j = 0; j < SudokuConst.DIMENSION; j++) {
                if (isOpen(board.matrix[i][j])){
                       return new Point(i,j);
                }
            }
        }
      return new Point(-1,-1);//denote that there is no possible move
    }

    private static boolean isOpen(int i) {
        return i == 0;
    }

    public static void makeMove(int a[], int k, BoardType board) {
        fillSqaure(board.move[k].x, board.move[k].y, a[k], board);
    }

    private static void fillSqaure(int x, int y, int i, BoardType board) {

    }

    public static void unmakeMove(int a[], int k, BoardType board) {
        freeSquare(board.move[k].x, board.move[k].y, board);
    }

    private static void freeSquare(int x, int y, BoardType board) {

    }

    public static boolean isASolution(int a[], int k, BoardType board) {
        return board.freecount == 0;
    }

    public static boolean processSolution(int a[], int k, BoardType board)
    {
        System.out.println(board);
        return true;
    }
}

