package com.miscellaneous;

public class SudokuSolver {
	private int[][] puzzle;

	private SudokuSolver(int[][] puzzle) {
		this.puzzle = puzzle;
	}
	public static void main(String[] args) {
		int[][] puzzle = {
				{0,1,3,4,2,0,0,8,6},
				{2,0,4,6,0,0,0,0,0},
				{0,8,7,0,1,0,3,0,0},
				{0,0,0,0,3,0,6,0,0},
				{0,6,2,5,0,0,0,0,3},
				{5,0,0,7,6,4,0,9,1},
				{7,0,0,0,4,0,8,1,0},
				{0,4,0,8,0,0,0,6,0},
				{0,0,1,2,5,6,0,3,7}
		};

		SudokuSolver sudokuSolver = new SudokuSolver(puzzle);
		int[][] solution = sudokuSolver.solvePuzzle();
		sudokuSolver.printPuzzle(solution);
		
	}
	
	protected void printPuzzle(int[][] puzzle) {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++)
				System.out.print(puzzle[i][j]+" ");
			
			System.out.println();
		}
	}

	public int[][] solvePuzzle() {

		return solvePuzzleRec(0,0);
	}

	private int[][] solvePuzzleRec(int r, int c){
		if(r > 8 && c > 8)
			return this.puzzle;
		
		if(c > 8)
			return solvePuzzleRec(r+1,0);
		

		if(this.puzzle[r][c] == 0) {
			for(int num = 1; num <= 9; num++) {
				if(isValidValuePlace(num, r, c)) {
					this.puzzle[r][c] = num;

					solvePuzzleRec(r+1, c);
					solvePuzzleRec(r, c+1);
				}
			}
		}

		return puzzle;
	}

	private boolean isValidValuePlace(int num,int r,int c) {
		return validValueInRow(num, r) && validValueInColumn(num, c) && isValidValueInBox(num, r, c);
	}

	private boolean isValidValueInBox(int num,int r,int c) {
		boolean isValid = true;

		int blockR = r/3;
		int blockC = c/3;

		for(int i = blockR*3; i < blockR*4; i++) {
			for(int j = blockC*3 ; j < blockC*4; j++) {
				if(r == i && c == j)
					continue;

				if(puzzle[i][j] == num) {
					isValid = false;
					break;
				}

			}

			if(!isValid)
				break;
		}

		return isValid;
	}

	private boolean validValueInRow(int num,int pos) {
		boolean isValid = true;

		for(int i = 0; i < 9; i++) {
			if(puzzle[pos][i] == num) {
				isValid = false;
				break;
			}
		}

		return isValid;
	}

	private boolean validValueInColumn(int num,int pos) {
		boolean isValid = true;

		for(int i = 0; i < 9; i++) {
			if(puzzle[i][pos] == num) {
				isValid = false;
				break;
			}
		}

		return isValid;
	}

}
