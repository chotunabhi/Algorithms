package com.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseEachWord {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the String");
		String string = br.readLine();

		String reversedString = reverseEachWord(string);

		System.out.println(reversedString);
	}

	private static String reverseEachWord(String string) {
		string += " ";
		StringBuffer temp = new StringBuffer();
		StringBuffer reversedString = new StringBuffer();

		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
//			if (c == ' ' || i == string.length() - 1) {
			if(c == ' '){
//				if(i == string.length() - 1)
//					temp.append(c);
								
				reversedString.append(reverseString(temp.toString()));
				
//				if(i != string.length() - 1)
					reversedString.append(c);
				
				temp = new StringBuffer();
			} else {
				temp.append(c);
			}
		}

		return reversedString.toString().trim();
	}
	
	private static String reverseString(String string){
		StringBuffer result = new StringBuffer();
		
		for (int j = string.length() - 1; j >= 0; j--)
			result.append(string.charAt(j));
		
		return result.toString();
		
	}

}
