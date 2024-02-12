package com.dsnalgomadeeasy.heap.common;

public class BinaryHeap {
	public Integer[] array;
	private int count;
	private int capacity;
	private HeapType heapType;

	public enum HeapType {
		MAXIMUM, MINIMUM
	};

	public BinaryHeap(int capacity, HeapType heapType) {
		this.capacity = capacity;
		this.count = 0;
		this.heapType = heapType;

		array = new Integer[capacity];
	}

	public int getParent(int i) {
		if (i <= 0 || i > capacity)
			return -1;

		return (i - 1) / 2;
	}

	public int getLeft(int i) {
		int left = 2 * i + 1;

		if (left >= count)
			return -1;

		return left;
	}

	public int getRight(int i) {
		int right = 2 * i + 2;

		if (right >= count)
			return -1;

		return right;
	}

	public int getMaximum() {
		int max = -1;
		
		return max;
	}

	public int getMinimum() {
		int min  = -1;
		
		return min;
	}

	private void heapifyMin(int i) {
		if(this.count == -1)
			return;
		
		int l,r,min,temp;
		l = this.getLeft(i);
		r = this.getRight(i);
		min = i;
		
		if(l != -1 && this.array[l] < this.array[i])
			min = l;
		
		if(r != -1 && this.array[r] < this.array[i])
			min = r;
		
		if(min != i) {
			temp = this.array[i];
			this.array[i] = this.array[min];
			this.array[min] = temp; 
		}
		
		heapifyMin(min);
		
	}

	private void heapifyMax(int i) {
		if(this.count == -1)
			return;
		
		int l,r,max,temp;
		l = this.getLeft(i);
		r = this.getRight(i);
		max = i;
		
		if(l != -1 && this.array[l] > this.array[i])
			max = l;
		
		if(r != -1 && this.array[r] > this.array[i])
			max = r;
		
		if(max != i) {
			temp = this.array[i];
			this.array[i] = this.array[max];
			this.array[max] = temp; 
		}
		
		heapifyMin(max);
		
	}

	public void heapify(int i) {
		if (this.heapType == HeapType.MAXIMUM)
			heapifyMax(i);
		else if (this.heapType == HeapType.MINIMUM)
			heapifyMin(i);
	}

	public int deleteMaxOrMin() {
		if (count == 0)
			return -1;

		int element = array[0];
		array[0] = array[count - 1];
		this.count--;
		
		heapify(0);
		
		return element;
	}

	public void insert(int data) {
		
	}

	private void resizeHeap() {
		int[] old_data = new int[this.array.length];

		System.arraycopy(this.array, 0, old_data, 0, this.count - 1);
		this.array = new Integer[this.capacity * 2];

		System.arraycopy(old_data, 0, array, 0, count - 1);
	}

	public void destroyHeap() {
		this.count = 0;
		this.array = null;
	}

	public Integer[] buildHeap(BinaryHeap h, Integer[] data) {
		

		return h.array;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
