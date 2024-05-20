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
		
		return length;
	}
}
