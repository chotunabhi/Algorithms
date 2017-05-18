package com.techgig.hard;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class CandidateCode {
	static boolean hasValue[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner in = new Scanner(System.in);

		int output = 0;
		int ip1_rows = 0;
		int ip1_cols = 0;
		ip1_rows = Integer.parseInt(in.nextLine().trim());
		ip1_cols = Integer.parseInt(in.nextLine().trim());

		int[][] ip1 = new int[ip1_rows][ip1_cols];

		for (int ip1_i = 0; ip1_i < ip1_rows; ip1_i++) {
			for (int ip1_j = 0; ip1_j < ip1_cols; ip1_j++) {
				ip1[ip1_i][ip1_j] = in.nextInt();
			}
		}

		int n = (int)Math.sqrt(ip1_cols);

		 output = SolveMagicSquare(ip1);
		 System.out.println(String.valueOf(output));

	}

	private static int SolveMagicSquare(int[][] input1) {
		int n = (int) Math.sqrt(input1.length);
		hasValue = new boolean[input1.length];

		if(!solveSudoku(input1,n))
			return 0;
		
		print2DArray(input1);
		if (!isValidSudoku(n, input1))
			return 0;

		// check after each swap horizontally
		for (int row = 0; row < input1.length; row += n) {
			for (int column = 0; (column + n) < input1.length; column += n) {
				swapGrids(input1, row, column, row, column + n, n);

				if (!isValidSudoku(n, input1)) {
					return 0;
				}

				swapGrids(input1, row, column, row, column + n, n);
			}
		}

		// check after each swap vertically
		for (int column = 0; column < input1.length; column += n) {
			for (int row = 0; (row + n) < input1.length; row += n) {
				swapGrids(input1, row, column, row + n, column, n);

				if (!isValidSudoku(n, input1)) {
					return 0;
				}

				swapGrids(input1, row, column, row + n, column, n);
			}
		}

		return 1;
	}

	private static boolean solveSudoku(int[][] grid,int n) {
		int row = 0, column = 0;
		boolean hasUnassigned = false;

		for (row = 0;!hasUnassigned && row < grid.length; row++)
			for (column = 0; column < grid.length; column++)
				if (grid[row][column] == 0) {
					hasUnassigned = true;
					break;
				}

		if (!hasUnassigned)
			return true;

		for (int num = 1; num <= grid.length; num++) {
			if (isSafe(grid, row - 1, column, num,n)) {
				grid[row - 1][column] = num;

				if (solveSudoku(grid,n))
					return true;

				grid[row - 1][column] = 0;
			}
		}

		return false;
	}


	/*
	 * Returns a boolean which indicates whether any assigned entry in the
	 * specified row matches the given number.
	 */
	static boolean UsedInRow(int grid[][], int row, int num) {
		for (int col = 0; col < grid.length; col++)
			if (grid[row][col] == num)
				return true;
		return false;
	}

	/*
	 * Returns a boolean which indicates whether any assigned entry in the
	 * specified column matches the given number.
	 */
	static boolean UsedInCol(int grid[][], int col, int num) {
		for (int row = 0; row < grid.length; row++)
			if (grid[row][col] == num)
				return true;
		return false;
	}

	/*
	 * Returns a boolean which indicates whether any assigned entry within the
	 * specified 3x3 box matches the given number.
	 */
	static boolean UsedInBox(int grid[][], int boxStartRow, int boxStartCol, int num,int n) {
		for (int row = 0; row < n; row++)
			for (int col = 0; col < n; col++)
				if (grid[row + boxStartRow][col + boxStartCol] == num)
					return true;
		return false;
	}

	/*
	 * Returns a boolean which indicates whether it will be legal to assign num
	 * to the given row,col location.
	 */
	static boolean isSafe(int grid[][], int row, int col, int num,int n) {
		/*
		 * Check if 'num' is not already placed in current row, current column
		 * and current 3x3 box
		 */
		return !UsedInRow(grid, row, num) && !UsedInCol(grid, col, num)
				&& !UsedInBox(grid, row - row % n, col - col % n, num,n);
	}

	private static void print2DArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++)
				System.out.print(array[i][j] + " ");
			System.out.println();
		}
	}

	private static void swapGrids(int[][] sudokuGrid, int firstGridRow, int firstGridColumn, int secondGridRow,
			int secondGridColumn, int n) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int temp = sudokuGrid[firstGridRow + i][firstGridColumn + j];
				sudokuGrid[firstGridRow + i][firstGridColumn + j] = sudokuGrid[secondGridRow + i][secondGridColumn + j];
				sudokuGrid[secondGridRow + i][secondGridColumn + j] = temp;
			}
		}
	}

	private static boolean isValidSudoku(int n, int[][] sudokuGrid) {
		if (!isAllValidHorzontalLine(sudokuGrid))
			return false;

		if (!isAllValidVerticalLine(sudokuGrid))
			return false;

		boolean allValidGrids = true;
		// check all grids are Valid or not
		for (int row = 0; row < sudokuGrid.length; row += n) {
			for (int column = 0; column < sudokuGrid.length; column += n) {
				if (!isValidGrid(row, column, n, sudokuGrid)) {
					allValidGrids = false;
					break;
				}
				resetBooleanArray(sudokuGrid.length);
			}
		}

		if (!allValidGrids)
			return allValidGrids;

		return true;
	}

	private static boolean isAllValidHorzontalLine(int[][] sudokuGrid) {
		boolean isValid = true;

		for (int row = 0; row < hasValue.length; row++) {
			for (int column = 0; column < hasValue.length; column++) {
				int value = sudokuGrid[row][column] - 1;

				if (value < 0 || value >= hasValue.length || hasValue[value]) {
					isValid = false;
					break;
				}
				hasValue[value] = true;
			}

			resetBooleanArray(sudokuGrid.length);
		}

		return isValid;
	}

	private static boolean isAllValidVerticalLine(int[][] sudokuGrid) {
		boolean isValid = true;

		for (int column = 0; column < hasValue.length; column++) {
			for (int row = 0; row < hasValue.length; row++) {
				int value = sudokuGrid[row][column] - 1;

				if (value < 0 || value >= hasValue.length || hasValue[value]) {
					isValid = false;
					break;
				}
				hasValue[value] = true;
			}

			resetBooleanArray(sudokuGrid.length);
		}

		return isValid;
	}

	private static boolean isValidGrid(int startRow, int startColumn, int n, int[][] sudokuGrid) {
		boolean isValid = true;

		for (int row = startRow; row < (startRow + n); row++) {
			for (int column = startColumn; column < (startColumn + n); column++) {
				int value = sudokuGrid[row][column] - 1;

				if (value < 0 || value >= hasValue.length || hasValue[value]) {
					isValid = false;
					break;
				}
				hasValue[value] = true;
			}
		}

		return isValid;
	}

	private static void resetBooleanArray(int N) {
		hasValue = new boolean[N];
	}
}
