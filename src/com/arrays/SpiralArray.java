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
		int a[][] = {
				 {1,2,3,10},
				 {4,5,6,11},
				 {7,8,9,12}
//				 ,{13,14,15,16}
//				 ,{17,18,19,20}
		 };
		
		int rowStart = 0;
		int rowEnd = a.length - 1 ;
		int colStart = 0;
		int colEnd = a[0].length - 1;
		
		while(rowStart <= rowEnd || colStart <= colEnd) {
			for(int i=colStart;i<=colEnd;i++)
				System.out.print(a[rowStart][i]+" ");
			
			rowStart++;
			for(int i = rowStart;i <= rowEnd;i++)
				System.out.print(a[i][colEnd]+" ");
			
			colEnd--;
			for(int i = colEnd ;i >= colStart && rowStart<=rowEnd ;i--)
				System.out.print(a[rowEnd][i]+" ");
			
			rowEnd--;
			for(int i = rowEnd ;i >= rowStart && colStart<=colEnd;i--)
				System.out.print(a[i][colStart]+" ");
			
			colStart++;
		}
	}

	private static void printArrayOneRound(int startRow,int endRow,int startCol,int endCol,int[][] a) {
//		System.out.println("inside method");
		
//		System.out.println("Loop 1 :"+startCol+" , "+endCol);
		for(int i=startCol;i<endCol;i++)
			System.out.print(a[startRow][i]+" ");
	
//		System.out.println("\nLoop 2 :"+startRow+" , "+endRow);	
		for(int i=(startRow+1);i<endRow;i++)
			System.out.print(a[i][endCol-1]+" ");
//		System.out.println("\nLoop 3 :"+startCol+" , "+endCol);
		for(int i=(endCol-2);i>=startCol;i--)
			System.out.print(a[endRow-1][i]+" ");
//		System.out.println("\nLoop 4 :"+startRow+" , "+endRow);
		for(int i=(endRow-2);i>=(startRow+1);i--)
			System.out.print(a[i][startCol]+" ");
	}
}
