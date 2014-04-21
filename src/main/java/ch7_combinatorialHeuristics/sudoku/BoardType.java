package ch7_combinatorialHeuristics.sudoku;

/**
 * @author Tomasz Lelek
 * @since 2014-04-21
 */
public class BoardType {

    public int matrix[][] = new int[SudokuConst.DIMENSION+1][SudokuConst.DIMENSION+1]; /* matrix of board contents */
    public int freecount; /* how many open squares remain? */
    public Point move [] = new Point[SudokuConst.CELLS_NUMBER+1]; /* how did we fill the squares? */
}
