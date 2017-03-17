package com.miscellaneous;

import java.util.HashSet;
import java.util.Set;

public class Permutations {
	static HashSet<String> permutations = new HashSet<>();
	
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
		
		permutations.clear();
		permutation("",s1);
		System.out.println(permutations);
		System.out.println(permutations.size());
		
		permutations.clear();
		permutation("",s2);
		System.out.println(permutations);
		System.out.println(permutations.size());

	}
}
