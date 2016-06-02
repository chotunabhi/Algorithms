package com.stack;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangle {
	public static int maxRectangleArea(int[] A){
		Stack<Integer> s =  new Stack<Integer>();
		int maxArea = 0;
		
		if(A == null || A.length == 0)
			return maxArea;
		
		int i = 0;
		while(i < A.length){
			System.out.println("A["+i+"] = "+ A[i]+" -> "+s +" : "+maxArea);
			if(s.isEmpty() || A[i] >= A[s.peek()])
				s.push(i++);
			else{
				int top = s.pop();
				maxArea = Math.max(maxArea, A[top] * (s.isEmpty() ? i : i - s.peek() - 1));
			}
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
			{1,3,5,1,4,2};
		String s = "abcdabaaab";
		char[] ch = s.toCharArray();
		Arrays.sort(ch);
System.out.println(new String(ch));
//		System.out.println(maxRectangleArea(A));
	}
}
