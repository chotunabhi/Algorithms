package com.sortings;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer intArray[] = {35,34,98,90,56,23,76,90};

		ISort sort = new BubbleSort();
		sort = new MergeSort();
		intArray = sort.sort(intArray);
		printArray(intArray);
		
	}

	public static <T> void printArray(T[] a){
		for(T elem:a)
			System.out.print(elem+" ");
		System.out.println();
	}
}
