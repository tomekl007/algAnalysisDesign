package ch7_combinatorialHeuristics;

import ch7_combinatorialHeuristics.sudoku.BoardType;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Tomasz Lelek
 * @since 2014-04-20
 */
public class BacktrackingTest {

    @Test
    public void sholdFindAllSubsets(){
        //given
        Backtracking backtracking = new Backtracking();
        //when
        backtracking.generate_subsets(3);
        //then
        Assert.assertEquals(8, backtracking.subsets.size());
    }

    @Test
    public void shouldGenerateAllPermutations(){
        //given
        Backtracking backtracking = new Backtracking();
        //when
        backtracking.generatePermutations(3);
        //then
        Assert.assertEquals(6, backtracking.nrOfPermutations);

    }

    @Test
    public void shouldSolveSudokuForGivenBoard(){
        //given
        Backtracking backtracking = new Backtracking();
        BoardType boardType = new BoardType();
        boardType.matrix[0][1] = 2;
        boardType.matrix[3][3] = 5;
        //when
        backtracking.solveSudoku(boardType);
        //then

    }
}
