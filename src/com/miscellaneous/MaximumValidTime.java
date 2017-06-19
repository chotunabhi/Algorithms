package com.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumValidTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(1, 2, 1, 2);
	}
	public static String solution(int A,int B,int C,int D){
		String time = "";
		int ar[] = {A,B,C,D};
		Arrays.sort(ar);
		
		List<Integer> nums = new ArrayList<>();
		nums.add(A);
		nums.add(B);
		nums.add(C);
		nums.add(D);
		
		if(nums.contains(2)){
			nums.remove(2);
			if(nums.contains(0) || nums.contains(1) || nums.contains(2) || nums.contains(3)){
				time += "2";
			}else{
				nums.add(2);
			}
				
		}else if(nums.contains(1)){
			
		}
		
		
		return time;
	}
}
