package com.sortings;

public class BubbleSort implements ISort {

	@Override
	public <T extends Comparable<T>> T[] sort(T[] a) {
		// TODO Auto-generated method stub
		for(int i=0;i<a.length;i++){
			for(int j=i;j<a.length - 1;j++){
				if(a[j].compareTo(a[j+1])> 0 )
				{
					T temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
				
			}
		}
		
		return a;
	}
}
