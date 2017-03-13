package com.miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotateArray90 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int rows,columns = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		rows = Integer.parseInt(br.readLine());
		columns = Integer.parseInt(br.readLine());

		int matrix[][] = new int[rows][columns];
		
		for(int i = 0 ; i < rows; i++){
			String input = br.readLine().trim();
			matrix[i] = new int[input.split(" ").length];
			int j = 0;

			for(String element:input.split(" ")){
				matrix[i][j++] = Integer.parseInt(element);
			}

		}
		
		for(int i = 0; i < columns; i++){
			for(int j = rows - 1; j >= 0; j--){
				System.out.print(matrix[j][i]+ " ");
			}
			System.out.println();
		}
	}

}
