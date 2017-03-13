package com.miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class NumberOfPalindromes {
	String longestPalindrome = "";
	
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		
		new NumberOfPalindromes().palindromes(str);
	}
	
	public void palindromes(String str){
		Set<String> palindromes = new HashSet<>();

		for(int i = 0;i<str.length();i++){
			for(int j = str.length();j > i; j--){
				String substring = str.substring(i, j);
				
				if(substring.length() > 1 && isPalindrome(substring)){
					palindromes.add(substring);
				}
			}
		}

		System.out.println(palindromes);
		System.out.println("Total number of palindromes : "+ palindromes.size());
		System.out.println("longest Palindrome : "+longestPalindrome);
	}
	
	public boolean isPalindrome(String str){
		boolean palindrome = true;
		int i = 0;
		int j = str.length() - 1;
		
		while(i < j){
			if(str.charAt(i++) != str.charAt(j--)){
				palindrome = false;
				break;
			}
		}
	
		
		if(palindrome){
			longestPalindrome = longestPalindrome.length() < str.length()?str:longestPalindrome;
		}
		
		return palindrome;
	}
}
