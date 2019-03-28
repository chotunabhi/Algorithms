package com.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class NextGreaterElement {
	/*
	 * Given an array, print the Next Greater Element (NGE) for every element. 
	 * The Next greater Element for an element x is the first greater element on the right side of x in array. 
	 * Elements for which no greater element exist, consider next greater element as -1.
	 * 
	 * Examples: 
	 * 		a) For any array, rightmost element always has next greater element as -1.
	 * 		b) For an array which is sorted in decreasing order, all elements have next greater element as -1.
	 * 		c) For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.
	 * 
	 * 		Element       NGE
	 *    	 4      -->   5
	 *       5      -->   25
	 *       2      -->   25
	 *       25     -->   -1
	 *       
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		int numberOfElements = Integer.parseInt(bufferedReader.readLine());
		Integer[] elements = new Integer[numberOfElements];
		
		for(int i=0;i<numberOfElements;i++) {
			elements[i] = new Integer(bufferedReader.readLine());
		}
		
		Stack<Integer> elementStack = new Stack<>();
		elementStack.push(elements[0]);
		
		
		for(int i = 1;i < numberOfElements; i++) {
			if(elementStack.peek() > elements[i]) {
				elementStack.push(elements[i]);
			}else {
				while(!elementStack.isEmpty() && elementStack.peek() < elements[i]) {
					System.out.println(elementStack.pop() +"-->"+elements[i]);
				}
				elementStack.push(elements[i]);
				
			}
		}
		
		while(!elementStack.isEmpty()) {
			System.out.println(elementStack.pop() +"-->"+(-1));
		}
			
	}

}
