package com.arrays;

public class Sort012 {

	public static void main(String[] args) {
		int[] a = {1,1,1,1,1,0,2,1,2,1};
		int start=0,end=a.length-1,i=0;
		
		while(i <= end && start < end) {
			if(a[i] == 0) {
				a[i] = a[start];
				a[start] = 0;
				start++;
				i++;
			}else if(a[i] == 2) {
				a[i] = a[end];
				a[end] = 2;
				end--;
			}else
				i++;
		}
		
		for (int k : a) {
			System.out.print(k+" ");
		}
	}

}
