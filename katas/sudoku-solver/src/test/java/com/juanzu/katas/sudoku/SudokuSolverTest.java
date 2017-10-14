package com.juanzu.katas.sudoku;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the sudoku solver function.
 * 
 * @author jzuriaga
 *
 */
public class SudokuSolverTest {

	public static final int[][] puzzle_demo = new int[][] {
        {5,3,0,0,7,0,0,0,0},
        {6,0,0,1,9,5,0,0,0},
        {0,9,8,0,0,0,0,6,0},
        {8,0,0,0,6,0,0,0,3},
        {4,0,0,8,0,3,0,0,1},
        {7,0,0,0,2,0,0,0,6},
        {0,6,0,0,0,0,2,8,0},
        {0,0,0,4,1,9,0,0,5},
        {0,0,0,0,8,0,0,7,9}
    };
        
    public static final int[][] puzzle_solution = new int[][] {
    	{5,3,4,6,7,8,9,1,2},
    	{6,7,2,1,9,5,3,4,8},
    	{1,9,8,3,4,2,5,6,7},
    	{8,5,9,7,6,1,4,2,3},
    	{4,2,6,8,5,3,7,9,1},
    	{7,1,3,9,2,4,8,5,6},
    	{9,6,1,5,3,7,2,8,4},
    	{2,8,7,4,1,9,6,3,5},
    	{3,4,5,2,8,6,1,7,9}
    };
    
    private SudokuSolver solver;
	
	@Before
	public void setUp () {
		solver = new SudokuSolver(puzzle_demo);
	}
	
	@Test
	public void should_create_a_solver_with_a_puzzle() {
		assertNotNull(solver);
	}

	@Test
	public void should_solve_puzzle () throws Exception {
		int[][] solution = solver.solve();
		assertNotNull(solution);
	}
	
	@Test
	public void should_check_if_solved() throws Exception {
		assertFalse(solver.isSolved(puzzle_demo));
		solver = new SudokuSolver(puzzle_solution);
		assertTrue(solver.isSolved(puzzle_solution));
	}
	
	@Test
	public void should_solve () throws Exception {
		int[][] solution = solver.solve();
		
		for (int i = 0; i < solution.length; i++) {
			assertTrue(Arrays.equals(solution[i], puzzle_solution[i]));
		}
	}
	
}
