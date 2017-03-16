package com.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter first string : ");
		String string1 = reader.readLine();
		System.out.print("Enter second string : ");
		String string2 = reader.readLine();
		
		char[] str1 = string1.toCharArray();
		Arrays.sort(str1);
		char[] str2 = string2.toCharArray();
		Arrays.sort(str2);

		if(Arrays.equals(str1, str2))
			System.out.println(string1+" and "+ string2+" are anagrams");
		else
			System.out.println(string1+" and "+ string2+" are not anagrams");
	}

}
