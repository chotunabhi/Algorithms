package com.sortings;

public class SelectionSort implements ISort {

	@Override
	public <T extends Comparable<T>> T[] sort(T[] a) {

		for(int i=0;i<a.length;i++)
			for(int j=i+1;j<a.length;j++){
				if(a[i].compareTo(a[j]) > 0){
					T temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		return a;
	}

}
