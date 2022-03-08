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
		if (count == 0)
			return -1;

		return array[0];
	}

	public void heapify(int i) {
		if (this.heapType == HeapType.MAXIMUM)
			heapifyMax(i);
		else if (this.heapType == HeapType.MINIMUM)
			heapifyMin(i);
	}

	private void heapifyMin(int i) {
		int leftIndex, rightIndex, minIndex=-1;

		leftIndex = getLeft(i);
		rightIndex = getRight(i);

		if(leftIndex != -1)
			if (i != -1 && array[leftIndex] < array[i])
				minIndex = leftIndex;
			else
				minIndex = i;

		if(rightIndex != -1)
			if (getRight(i) != -1 && array[rightIndex] < array[minIndex])
				minIndex = rightIndex;

		if (minIndex != -1 && minIndex != i) {
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;

			heapifyMin(minIndex);
		}
	}

	private void heapifyMax(int i) {
		int leftIndex, rightIndex, maxIndex=-1;

		leftIndex = getLeft(i);
		rightIndex = getRight(i);
		
		if(leftIndex != -1)
			if (i != -1 && array[leftIndex] > array[i])
				maxIndex = leftIndex;
			else
				maxIndex = i;

		if(rightIndex != -1)
			if (rightIndex != -1 && array[rightIndex] > array[maxIndex])
				maxIndex = rightIndex;

		if (maxIndex != -1 && maxIndex != i) {
			int temp = array[i];
			array[i] = array[maxIndex];
			array[maxIndex] = temp;
			
			heapifyMax(maxIndex);
		}
	}

	public int deleteMaxOrMin() {
		if (count == 0)
			return -1;

		int element = array[0];
		array[0] = array[count - 1];
		count--;

		heapify(0);

		return element;
	}

	public void insert(int data) {
		if (count == capacity)
			resizeHeap();

		int current = count;
		count++;

		while (current >= 0 && data > array[(current - 1) / 2]) {
			array[current] = array[(current - 1) / 2];
			current = (current - 1) / 2;
		}

		array[current] = data;
	}

	private void resizeHeap() {
		int oldArray[] = new int[this.capacity];
		System.arraycopy(array, 0, oldArray, 0, capacity);

		array = new Integer[capacity * 2];

		System.arraycopy(oldArray, 0, array, 0, capacity);

		capacity *= 2;
	}
	
	public void destroyHeap() {
		this.count = 0;
		this.array = null;
	}
	
	public Integer[] buildHeap(BinaryHeap h,Integer[] data) {
		if(h == null || data == null)
			return null;
		
		if(data.length == 0)
			return new Integer[] {};
		
		for(int i = 0; i < data.length ; i++)
			h.array[i] = data[i];
		
		this.count = data.length;
		
		for(int i = (data.length-1)/2; i>=0 ; i--)
			h.heapify(i);
		
		return h.array;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
