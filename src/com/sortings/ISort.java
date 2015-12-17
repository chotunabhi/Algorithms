package com.sortings;

public interface ISort {
	public <T extends Comparable<T>> T[] sort(T[] a);
}
