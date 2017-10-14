package com.juanzu.katas.sudoku;

import java.util.stream.IntStream;

/**
 * Solves a sudokyu puzzle. 
 * 
 * @author jzuriaga
 */
public class SudokuSolver {
	
	private int[][] puzzle;
	
	private long iteration;
	
	public SudokuSolver(int[][] puzzle) {
		this.puzzle = Sudoku.clonePuzzle(puzzle);
	}
	
	public int[][] solve() {
		int[][] solution = Sudoku.clonePuzzle(this.puzzle);
		while(!isSolved(this.puzzle)) {
			for (int value = 0; value < solution.length; value++) {
				computePossibles(solution, value+1);
			}
			resetImpossibles(solution);
			this.puzzle = consolidate(solution); 
			iteration++;
			if  (iteration>5000) {
				System.err.println("No encuentro solucion ... ");
				Sudoku.printPuzzle(this.puzzle);
				break;
			}
		}
		return solution;
	}

	private int[][] consolidate(int[][] solution) {
		for (int row = 0; row < solution.length; row++) {
			for (int col = 0; col < solution[row].length; col++) {
				if (solution[row][col]<0) {
					solution[row][col] = -solution[row][col];
				}
			}
		}
		return Sudoku.clonePuzzle(solution);
	}

	private void resetImpossibles(int[][] solution) {
		for (int row = 0; row < solution.length; row++) {
			for (int col = 0; col < solution[row].length; col++) {
				if (solution[row][col]<-solution.length) {
					// System.out.println("reset: "+row+","+col+" : "+solution[row][col]);
					solution[row][col]=0;
				}
			}
		}
	}

	private void computePossibles(int[][] solution, int value) {
		for (int row = 0; row < solution.length; row++) {
			for (int col = 0; col < solution[row].length; col++) {
				if (solution[row][col]<=0 && solution[row][col]>-(solution.length+1)) {
					if (fitValue(this.puzzle, row, col, value)) {
						synchronized(solution) {
							solution[row][col]=(solution[row][col]*10)-value;
						// System.out.println("computed: " + row+"," + col + " : " + value + " to " + solution[row][col]);
						}
					}
				}
			}
		}
	}

	private boolean fitValue(final int[][] solution, final int row, final int column, final int value) {
		return fitRow(solution, row, column, value) && fitColumn(solution, row, column, value) && fitQuadrant(solution, row, column, value);
	}

	private boolean fitQuadrant(int[][] solution, int row, int column, int value) {
		int qi = quadrantStart(row, solution.length);
		int qj = quadrantStart(column, solution[row].length);
		for (int i = qi; i < qi + 3; i++) {
			for (int j = qj; j < qj + 3; j++) {
				if (!(i==row && j==column) && isEqualTo(solution[i][j], value)) {
					return false;
				}
			}
		}
		return true;
	}

	private int quadrantStart(int element, int length) {
		int q = Double.valueOf(Math.floor(Math.sqrt(length))).intValue();
		return ((element / q) * q) ;
	}

	private boolean fitColumn(int[][] solution, int row,  int column, int value) {
		for (int i = 0; i < solution.length; i++) {
			if (i!=row && isEqualTo(solution[i][column], value)) {
				return false;
			}
		}
		return true;
	}

	private boolean fitRow(int[][] solution, int row, int column, int value) {
		for (int j = 0; j < solution.length; j++) {
			if (j!=column && isEqualTo(solution[row][j], value)) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isEqualTo(int cell, int value) {
		return Math.abs(cell) == value;
	}

	public boolean isSolved(int[][] solution) {
		for (int row = 0; row < solution.length; row++) {
			for (int column = 0; column < solution[row].length; column++) {
				if (0==solution[row][column] || !fitValue(solution, row, column, solution[row][column])) {
					return false;
				}
			}
		}
		return true;
	}

}
