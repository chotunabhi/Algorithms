package com.arrays;

public class LongestSequence10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,1,0,0,0,1,1,1,1,1,0,0,1,1};
		
		indexOfLongest10s(a);
	}
	
	public static int indexOfLongest10s(int []a) {
		if(a.length == 1)
			return 0;
		
		int index = -1;
		
		int[] t = new int[a.length];
		
		for(int i = 0; i < a.length - 1; i++) {
			if(a[i] == a[i+1])
				t[i+1] = t[i]+1;
			else
				continue;
		}
		
		int ci = 0,cl = 0,pl = 0,maxLength = 0;
		
		while(ci < t.length - 1) {
			if(t[ci] == 0 && t[ci] > t[ci+1]) {
				
			}else {
				ci++;
			}
		}
		
		for(int i = 0;i < t.length; i++)
			System.out.print(t[i]+" ");
		
		return index;
	}

}
