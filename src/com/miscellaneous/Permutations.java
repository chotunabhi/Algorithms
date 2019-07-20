package com.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	static List<String> permutations = null;
	
	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) permutations.add(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	
	public static void main(String[] args) {
		String s1 = "ABC";
		String s2 = "ABCD";
		
		permutations = new ArrayList<>(fact(s1.length()));
		permutation("",s1);
		System.out.println(permutations);
		System.out.println(permutations.size());
		
		permutations = new ArrayList<>(fact(s2.length()));
		permutation("",s2);
		System.out.println(permutations);
		System.out.println(permutations.size());

	}

	private static int fact(int length) {
		return (length ==0)? 1 : (length * fact(length -1));
	}
}
