package com.miscellaneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import com.sortings.ISort;
import com.sortings.MergeSort;
import com.sortings.QuickSort;

public class ArrayPuzzles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long a[] = { 1, 8, 26, 16, 4, 2 };
		// 1,2,4,8,16,26,100
		// 1+2+4+8+10+74
		System.out.println(new ArrayPuzzles().doubleSize(a, 2));
		System.out.println(new ArrayPuzzles().minDiff(a));
	}

	public long doubleSize(long a[], long num) {
		long res = num;

		Long[] data = new Long[a.length];

		for (int i = 0; i < a.length; i++)
			data[i] = new Long(a[i]);

		ISort sorter = new QuickSort();
		data = sorter.sort(data);

		for (long v : data) {
			if (res == v)
				res *= 2;
		}

		return res;
	}

	public int minDiff(long[] a) {
		int res = 0;

		Long[] data = new Long[a.length];

		for (int i = 0; i < a.length; i++)
			data[i] = new Long(a[i]);

		ISort sorter = new MergeSort();
		data = sorter.sort(data);

		for (int i = 0; i < data.length - 1; i++) {
			res += (data[i + 1] - data[i]);
		}

		return res;
	}

	public Integer[] getLeaders(int[] a) {
		ArrayList<Integer> result = new ArrayList<>();
		int max = Integer.MIN_VALUE;
		
		if(a.length > 0) {
			max = a[a.length - 1];
			result.add(max);
		}

		for (int i = a.length - 2; i >= 0; i--) {
			if(max < a[i] ) {
				max = a[i];
				result.add(max);
			}
		}
		Collections.reverse(result);
		
		return result.stream().toArray(Integer[] ::new);
	}
}
