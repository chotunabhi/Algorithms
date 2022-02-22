package com.stack;

import java.util.Stack;

public class LargestRectangle {
	public static int maxRectangleArea(int[] A) {
		Stack<Integer> s = new Stack<Integer>();
		int maxArea = 0;

		if (A != null & A.length != 0) {

			int i = 0;

			while (i < A.length) {
				if (s.isEmpty() || A[s.peek()] <= A[i])
					s.push(i++);
				else {
					int top = s.pop();
					maxArea = Math.max(maxArea, A[top] * (s.isEmpty() ? i : (i - s.peek() - 1)));
				}
			}

			while (!s.isEmpty()) {
				int top = s.pop();
				maxArea = Math.max(maxArea, A[top] * (s.isEmpty() ? i : (i - s.peek() - 1)));
			}
		}

		return maxArea;
	}

	public static int calculate1(char[] str) {
		int T[][] = new int[str.length][str.length];

		for (int g = 0; g < str.length; g++) {
			for (int i = 0, j = g; j < str.length; i++, j++) {
				if (g == 0)
					T[i][j] = 1;
				else if (g == 1)
					T[i][j] = str[i] == str[j] ? 2 : 1;
				else
					T[i][j] = str[i] == str[j] ? T[i+1][j-1] + 2 : Math.max(T[i][j - 1], T[i + 1][j]);

			}
		}
		
		print2DArray(T,str);
		return T[0][str.length - 1];
	}
	
	public static void print2DArray(int[][] arr,char[] str) {
		System.out.print("\t");
		for(int i = 0 ; i < str.length; i++)
			System.out.print(str[i]+"\t");
		System.out.println();
		for(int i = 0;i < arr.length;i++) {
			System.out.print(str[i]+"\t");
			for(int j = 0;j < arr.length;j++) {
				System.out.print(arr[i][j]+"\t");
			}
			
			System.out.println();
		}
	}

	public static void main(String args[]) {
		System.out.println(calculate1(new String("aaddaag").toCharArray()));

		int[] A = { 1, 3, 3 };
		// {1,3,5,6,4,2};
		// { 3, 2, 3, 4, 4};
		// System.out.println(maxRectangleArea(A));
	}
}
