package com.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class Set {
	public static List<String> getSubsets(String set) {
		List<String> subSets = new ArrayList<>();

		for (int i = 0; i < (1 << set.length()); i++) {
			StringBuffer subSet = new StringBuffer();

			for (int j = 0; j < set.length(); j++) {
				if ((i & (1 << j)) > 0)
					subSet.append(set.charAt(j));
			}

			if(subSet.length() > 0)
				subSets.add(subSet.toString());
		}

		return subSets;
	}

	private static int numberofSubsets(int setCount) {
		return (1 << setCount - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getSubsets("ABCA"));
	}

}
