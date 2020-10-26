package com.stack;

import java.util.Stack;

public class LargestRectangle {
	public static int maxRectangleArea(int[] A) {
		Stack<Integer> s = new Stack<Integer>();
		int maxArea = 0;

		if (A != null & A.length != 0) {

			int i = 0;

			while (i < A.length) {
				if(s.isEmpty() || A[s.peek()] <= A[i])
					s.push(i++);
				else {
					int top = s.pop();
					maxArea = Math.max(maxArea, A[top]*(s.isEmpty()?i:(i - s.peek() - 1)));
				}
			}
			
			while(!s.isEmpty()) {
				int top = s.pop();
				maxArea = Math.max(maxArea, A[top]*(s.isEmpty()?i:(i - s.peek() - 1)));
			}
		}

		return maxArea;
	}

	public static void main(String args[]) {
		int[] A =
			{1,3,3}; 
//			{1,3,5,6,4,2};
//				{ 3, 2, 3, 4, 4};
		System.out.println(maxRectangleArea(A));
	}
}
