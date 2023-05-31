package com.sortings;

public class BubbleSort implements ISort {

	@Override
	public <T extends Comparable<T>> T[] sort(T[] a) {
		for(int i = a.length; i > 0; i--) {
			boolean swapped = false;
			
			for(int j = 0 ; j < i - 1; j++) {
				if(a[j+1].compareTo(a[j]) < 0) {
					T temp = a[j+1];
					a[j+1] = a[j];
					a[j] = temp;
					
					swapped = true;
				}
			}
			
			if(!swapped)
				break;
		}
		
		return a;
	}
}
