package com.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayPuzzlesTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter number of elements :");
		int n = Integer.parseInt(reader.readLine());

		int[] array = new int[n];

		System.out.println("Enter numbers");

		for (int i = 0; i < n; i++)
			array[i] = Integer.parseInt(reader.readLine());
		
		printArray(array);
		
		ArrayManips1D.WaveSort(array);
		
		printArray(array);

	}
	
	private static void printArray(int []a){
		System.out.print("[");
		int i = 0;
		
		for(i = 0;i < a.length - 1; i++)
			System.out.print(a[i]+",");
		
		System.out.println(a[i]+"]");
	}

}
