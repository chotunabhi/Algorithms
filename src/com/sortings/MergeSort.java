package com.sortings;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort implements ISort{

	@Override
	public <T extends Comparable<T>> T[] sort(T[] a) {
		mergeSort(a, 0, a.length - 1);
		return a;
	}
	
	private <T extends Comparable<T>> void mergeSort(T[] a,int lowerBound,int upperBound){
		if(lowerBound < upperBound){
			int mid = (lowerBound + upperBound)/2;
			mergeSort(a, lowerBound, mid);
			mergeSort(a, mid + 1, upperBound);
			merge(a,lowerBound,mid,upperBound);
		}
	}
	private <T extends Comparable<T>> void merge(T[] a,int lowerBound,int midPoint,int upperBound){
		int i = lowerBound;
		int j = midPoint + 1;
		T[] tempArray = a.clone();
		int k = lowerBound;
		
		while(i <= midPoint && j <= upperBound)
			if(a[i].compareTo(a[j]) < 0)
				tempArray[k++] = a[i++];
			else
				tempArray[k++] = a[j++];
		
		while(i <= midPoint)
			tempArray[k++] = a[i++];
		
		while(j <= upperBound)
			tempArray[k++] = a[j++];

		for(k = lowerBound;k <= upperBound;k++)
			a[k] = tempArray[k];
	}
	
}
