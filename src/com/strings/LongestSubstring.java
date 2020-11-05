package com.strings;

import java.util.HashMap;

public class LongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(longestSubstring("abhilash") );
		System.out.println(longestSubstring("abihlash") );
	}
	
	public static String longestSubstring(String string) {
		String result = "";
		
		int start = 0,end = 0,startIndex = 0,endIndex = 0,maxLength = 0;
		
		HashMap<Character, Integer> charMap = new HashMap<>();
		
		while(start < string.length()) {
			while(end < string.length()) {
				char c = string.charAt(end);
				
				if(charMap.containsKey(c) && charMap.get(c) > start && charMap.get(c) != end) 
					break;
				
				charMap.put(c, end);
				end++;
			}
			
			if(maxLength < (end - start)) {
				maxLength = end - start;
				
				startIndex = start;
				endIndex = end - 1;
			}
			
			if(end >= string.length())
				break;
			
			start = charMap.get(string.charAt(end)) + 1;
			
			charMap.put(string.charAt(end), end);
		}
		System.out.println(startIndex+","+endIndex);
		return string.substring(startIndex,endIndex+1);
	}
}
