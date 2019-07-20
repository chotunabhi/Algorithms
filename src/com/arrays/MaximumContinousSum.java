package com.arrays;

public class MaximumContinousSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {-2,11,-4,13,-5,2};
		
		System.out.println("O(n3) ==> "+maxContiguousSumBruteForce(A));
		System.out.println("O(n2) ==> "+maxContiguousSum(A));
		System.out.println("O(n) ==> "+maxContigousSumDP(A));
		
		int B[] = {1,-3,4,-2,-1,6};
		
		System.out.println("O(n3) ==> "+maxContiguousSumBruteForce(B));
		System.out.println("O(n2) ==> "+maxContiguousSum(B));
		System.out.println("O(n) ==> "+maxContigousSumDP(B));
	}
	
	public static int maxContigousSumDP(int[] A) {
		int maxSum = A[0],sum = 0;
		
		for(int i = 0; i < A.length; i++) {
			sum = Math.max(sum + A[i], A[i]);
			maxSum = Math.max(maxSum, sum);
		}
		
		return maxSum;
	}
	
	// O(n2)
	public static int maxContiguousSum(int[] A) {
		int maxSum = 0;
		
		for(int i = 0; i < A.length; i++) {
			int currentSum = 0;
			
			for(int j = i; j < A.length; j++) {
					currentSum += A[j];
				
				if(currentSum > maxSum)
					maxSum = currentSum;
			}
		}
		
		return maxSum;
	}
	
	// O(n3)
	public static int maxContiguousSumBruteForce(int[] A) {
		int maxSum = 0;
		
		for(int i = 0; i < A.length; i++) {
			for(int j = i; j < A.length; j++) {
				int currentSum = 0;
				
				for(int k = i; k <= j; k++)
					currentSum += A[k];
				
				if(currentSum > maxSum)
					maxSum = currentSum;
			}
		}
		
		return maxSum;
	}
}
