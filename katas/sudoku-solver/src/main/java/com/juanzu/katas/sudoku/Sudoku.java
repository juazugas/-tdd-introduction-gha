package com.juanzu.katas.sudoku;

import java.time.Instant;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Solves a sudoku.
 * 
 * @author jzuriaga
 */
public class Sudoku {
	
	public static final int[][] puzzle_demo = new int[][] {
	              {5,3,0,0,7,0,0,0,0},
	              {6,0,0,1,9,5,0,0,0},
	              {0,9,8,0,0,0,0,6,0},
	              {8,0,0,0,6,0,0,0,3},
	              {4,0,0,8,0,3,0,0,1},
	              {7,0,0,0,2,0,0,0,6},
	              {0,6,0,0,0,0,2,8,0},
	              {0,0,0,4,1,9,0,0,5},
	              {0,0,0,0,8,0,0,7,9}};
	
	public static int[][] parsePuzzle (String puzzleArg) {
		return new int[9][9];
	}
	              
	public static void main(String... args) {
		int[][] puzzle = (args.length > 0) ? parsePuzzle(args[0]) : puzzle_demo;
		SudokuSolver solver = new SudokuSolver(puzzle);
		
		Instant start = Instant.now();
		int[][] solution = solver.solve();
		System.out.println("Inicio:");
		Sudoku.printPuzzle(puzzle_demo);
		System.out.println("Solution:");
		Sudoku.printPuzzle(solution);
		System.out.println("Time elapsed : " + (Instant.now().toEpochMilli() - start.toEpochMilli()) + "ms");
	}

	public static void printPuzzle(int[][] solution) {
		Arrays.stream(solution)
			.map(Arrays::toString)
			.forEach(System.out::println);
	}

	public static int[][] clonePuzzle(int[][] puzzleDemo) {
		return Arrays.stream(puzzleDemo)
				.map(Sudoku::arrayClone)
				.toArray(int[][]::new);
	}
	
	public static int[] arrayClone (int[] origin) {
		return Arrays.copyOf(origin, origin.length);
	}

}
