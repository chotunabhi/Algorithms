package com.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpiralArray {
	/*
	 * Given a 2D array..
	 * Print it in spiral form 
	 * E.g.:
	 * 1 2 3 
	 * 4 5 6
	 * 7 8 9
	 * 
	 * Output:
	 * 1,2,3,6,9,8,7,4,5
	 * 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter dimension of 2 D Array ");
		String dimensions = bufferedReader.readLine();
		
		String input[] = dimensions.split(" ");
		
		int rows = Integer.parseInt(input[0]);
		int cols = Integer.parseInt(input[1]);
//		int[][] a = new int[3][3];
			
//		for(int i = 0;i < rows;i++) {
//			String rowData = bufferedReader.readLine();
//			
//			for(int j = 0 ; j < cols;j++) {
//				String rd[] = rowData.split(" ");
//				
//				a[i][j] = Integer.parseInt(rd[j]);
//			}
//		}
//		
		int a[][] = {
				 {1,2,3,10},
				 {4,5,6,11},
				 {7,8,9,12}
		 };
		
		int rowStart = 0;
		int rowEnd = a.length;
		int colStart = 0;
		int colEnd = a[0].length;
		
		while(rowStart <= rowEnd || colStart <= colEnd) {
			printArrayOneRound(rowStart, rowEnd, colStart, colEnd, a);
			rowStart++;
			rowEnd--;
			colStart++;
			colEnd--;
		}
	}

	private static void printArrayOneRound(int startRow,int endRow,int startCol,int endCol,int[][] a) {
		System.err.println("inside method");
		for(int i=startCol;i<endCol;i++)
			System.out.print(a[startRow][i]+" ");
			
		for(int i=(startRow+1);i<endRow;i++)
			System.out.print(a[i][endCol-1]+" ");
		
		for(int i=(endCol-2);i>=startCol;i--)
			System.out.print(a[endRow-1][i]+" ");
			
		for(int i=(endRow-2);i>=(startRow+1);i--)
			System.out.print(a[i][startCol]+" ");
	}
}
