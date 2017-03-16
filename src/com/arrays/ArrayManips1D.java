package com.arrays;

public class ArrayManips1D {
	public static int[] WaveSort(int a[]) {
		int length = a.length;

		if (length == 1 || length == 2)
			return a;

		for (int i = 1; i < a.length; i++) {
			if (i % 2 != 0 && a[i - 1] > a[i]) {
				// swap
				int t = a[i];
				a[i] = a[i - 1];
				a[i - 1] = t;
			}else if(i % 2 == 0 && a[i - 1] < a[i]){
				int t = a[i];
				a[i] = a[i - 1];
				a[i - 1] = t;
			}
		}

		return a;
	}

}
