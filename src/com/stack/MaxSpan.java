package com.stack;

import java.util.Arrays;
import java.util.Stack;

public class MaxSpan {

	public static void main(String[] args) {
		int[] a = {1,3,-1,-3,5,3,6,7,2,8,0,0,9};
		int[] spans = new int[a.length];
		
		Stack<Integer> stack = new Stack<>();
		int p = 0;
		
		for(int i =0; i < a.length; i++) {
			
			while(!stack.isEmpty() && a[i] > a[stack.peek()])
				stack.pop();
			
			spans[i] = i - (stack.isEmpty()?-1:stack.peek());
			
			stack.push(i);
		}
		
		Arrays.stream(spans)
			.mapToObj(i -> Integer.toUnsignedString(i))
			.forEach(System.out::print);
			
	}

}
