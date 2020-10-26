package com.miscellaneous;

import java.util.Arrays;

public class MinNumAfterKDeletions {
public static void main(String args[]) {
		
		System.out.println(leastPossibleTrucatedNum("1412219",3));
		System.out.println(leastPossibleTrucatedNum("9765432",3));
		System.out.println(leastPossibleTrucatedNum("123456",3));
		System.out.println(leastPossibleTrucatedNum("1231456",3));
		System.out.println(leastPossibleTrucatedNum("127954",3));//124
		System.out.println(leastPossibleTrucatedNum("12",2));//124
	}

	public static String leastPossibleTrucatedNum(String num,int k) {
		StringBuffer truncatedString = new StringBuffer(num);
		
		if((k > num.length()) || (num.length() == 1 && num.length() == k))
			return "";
		
		for(int i = 0 ; i < k; i++) {
			int j = 0;
			
			while(j < truncatedString.length() -1 && truncatedString.charAt(j) <= truncatedString.charAt(j+1)) {
				j++;
			}
			
			if(j != truncatedString.length()) {
				truncatedString.delete(j, j+1);
			}
		}
		
		return truncatedString.toString();
	}
}
