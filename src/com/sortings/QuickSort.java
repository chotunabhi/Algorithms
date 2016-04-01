package com.sortings;

public class QuickSort implements ISort {

	@Override
	public <T extends Comparable<T>> T[] sort(T[] a) {
		quickSort(a, 0, a.length - 1);
		
		return a;
	}
	private <T extends Comparable<T>> void quickSort(T[] a,int lowerBound,int upperBound){
		if(lowerBound <= upperBound){
			int pivot = getPivotPosition(a, lowerBound, upperBound);
			quickSort(a, lowerBound, pivot - 1);
			quickSort(a, pivot + 1, upperBound);
		}
		
	}

	private <T extends Comparable<T>> int getPivotPosition(T[] a,int lowerBound,int upperBound){
		int position = -1;
		int i = lowerBound;
		int j = upperBound;
		T pivot = a[lowerBound];
		
		while(i < j){
			while(pivot.compareTo(a[i]) >= 0 && i<upperBound)
				i++;
			
			while(pivot.compareTo(a[j]) < 0)
				j--;
			
			if(i<j){
				T temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		
		a[lowerBound] = a[j];
		a[j] = pivot;
		position = j;
		
		return position;
		
	}
}
