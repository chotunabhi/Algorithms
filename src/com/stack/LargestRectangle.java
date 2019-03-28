package com.stack;

import java.util.Stack;

public class LargestRectangle {
	public static int maxRectangleArea(int[] A){
		Stack<Integer> s =  new Stack<Integer>();
		int maxArea = 0;
		
		if(A == null || A.length == 0)
			return maxArea;
		
		int i = 0;
		while(i < A.length){
			
			if(s.isEmpty() || A[i] >= A[s.peek()])//if coming is with greater height or equal
				s.push(i++);
			else{
				int top = s.pop();
				maxArea = Math.max(maxArea, A[top] * (s.isEmpty() ? i : i - s.peek() - 1));
			}
			System.out.println("A["+(i-1)+"] = "+ A[i - 1]+" -> "+s +" : "+maxArea);
		}
		
		while(!s.isEmpty()){
			System.out.println(i+" -> "+maxArea);
			int top = s.pop();
			maxArea = Math.max(maxArea, A[top] * (s.isEmpty() ? i : i - s.peek() - 1));
		}
		return maxArea;
	}
	public static void main(String args[]){
		int[] A = 
//			{2,1,2,3,1}; 
//			{1,3,5,6,4,2};
		{4,3,2,4,2};
		System.out.println(maxRectangleArea(A));
	}
}
