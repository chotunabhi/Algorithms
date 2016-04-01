package com.sortings;

public class InsertionSort implements ISort {

	@Override
	public <T extends Comparable<T>> T[] sort(T[] a) {

		for(int i = 1;i < a.length;i++){
			int j = i-1;
			T temp = a[i];
			while(j >= 0 && temp.compareTo(a[j]) < 0){
				a[j+1] = a[j];
				j--;
				
			}
			a[j+1] = temp;
		}
		
		return a;
	}

}
