package com.miscellaneous;

import java.util.Arrays;

public class Mode {
	public static void main(String args[]) {
		int[] a = { 1, 1, 1, 3, 3, 3, 3, 5, 5, 5, 5, 6, 6, 8, 8 };
		Arrays.sort(a);

		System.out.println(findMode(a));

	}

	private static int findMode(int[] a) {
		int temp1, temp2;
		int count1 = 1, count2 = 1;

		if (a.length == 0)
			return -1;

		if (a.length == 1)
			return a[0];

		temp1 = temp2 = a[0];

		for (int i = 1; i < a.length; i++) {

			if (temp2 == a[i])
				count2++;
			else {
				if (count2 > count1) {
					temp1 = temp2;
					count1 = count2;
				}

				temp2 = a[i];
				count2 = 1;
			}
		}

		return temp1;
	}
}
