package com.dynamicProgramming;

public class LongestCommonSubsequnce {
	private StringBuffer subSequence;
	
	public static void main(String[] args) {
		LongestCommonSubsequnce longestCommonSubsequnce = new LongestCommonSubsequnce();
		int lcs = longestCommonSubsequnce.lcs("abdcef", "adefe");
		System.out.println("Subsequence " + longestCommonSubsequnce.subSequence +" with length "+ lcs);
	}

	private int lcs(String string,String subSeqString) {
		int length = 0;
		int t[][] = new int[subSeqString.length() + 1][string.length() + 1];
		subSequence = new StringBuffer();
		
		for(int i = 1; i <= subSeqString.length(); i++ ) {
			for(int j = 1; j <= string.length(); j++) {
				if(string.charAt(j-1) == subSeqString.charAt(i-1)) {
					t[i][j] = t[i-1][j-1] + 1;
				}
				else
					t[i][j] = Math.max(t[i][j-1],Math.max(t[i-1][j-1], t[i-1][j]));
					
			}
		}
		
		for(int i = t.length - 1,j = t[0].length - 1; i > 0 && j > 0 ; ) {
			if(t[i][j] == t[i][j-1])
				j--;
			else if(t[i][j] == t[i-1][j])
				i--;
			else if(t[i][j] == t[i-1][j-1] + 1) {
				i--;
				j--;
				
				subSequence.append(string.charAt(j));
			}
		}
		subSequence.reverse();
		
		length = t[t.length - 1 ][t[0].length - 1];
		
		return length;
	}
}
