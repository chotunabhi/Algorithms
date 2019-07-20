package com.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.miscellaneous.Permutations;
import com.miscellaneous.Set;

public class LongestSubSequenceString {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter 2 Strings :");
		String string1 = reader.readLine();
		String string2 = reader.readLine();
		
//		System.out.println("Longest common subsequence : "+longestCommonSubsequenceString(string1,string2));
		System.out.println("Longest common subsequence : "+longestCommonSubsequenceStringBruteForce(string1,string2));
	}

	private static String longestCommonSubsequenceStringBruteForce(String string1, String string2) {
		List<String> string1Sets = Set.getSubsets(string1);
		List<String> string2Sets = Set.getSubsets(string2);
		String lcss = null;
		int maxLengthSubset = 0;

		for(String subSet1 : string1Sets) {
			for(String subSet2 : string2Sets) {
				if(subSet1.equals(subSet2) && maxLengthSubset < subSet1.length()) {
					maxLengthSubset = subSet1.length();
					lcss = subSet2;
				}
			}
		}
		
		return lcss;
	}
	private static String longestCommonSubsequenceString(String string1, String string2) {
		StringBuffer subSequenceString = new StringBuffer();
		int x = string1.length() + 1;
		int y = string2.length() + 1;
		int[][] matchMatrix = new int[x][y];
		
		// Creating Match matrix for finding LCSS
		for(int i = 1; i <x; i++) {
			for(int j = 1; j < y;j++ ) {
				if(string1.charAt(i-1) == string2.charAt(j-1)) {
					matchMatrix[i][j] = matchMatrix[i-1][j-1] + 1;
				}else {
					matchMatrix[i][j] = Math.max(matchMatrix[i][j-1], matchMatrix[i-1][j]);
				}
			}
		}
		
		//Decrementing both axis as we now deal with only lengths;
		x--;
		y--;
		
		
		while(x != 0 && y != 0) {
			//Move up
			if(matchMatrix[x][y] == matchMatrix[x-1][y]) 
				x--;
			// Move left
			else if(matchMatrix[x][y] == matchMatrix[x][y-1])
				y--;
			else {
				//get diagonal which is match
				subSequenceString.append(string1.charAt(x-1));
				x--;
				y--;
			}
		}
		
		return subSequenceString.reverse().toString();
	}

}
