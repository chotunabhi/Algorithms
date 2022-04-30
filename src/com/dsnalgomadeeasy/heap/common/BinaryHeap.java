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

		int max = array[0];

		if (this.heapType == HeapType.MINIMUM) {
			System.err.println("BinaryHeap.getMaximum() => This is MINIMUM heap, getting max will lead to O(N)");

			for (Integer e : array) {
				if (e > max)
					max = e;
			}
		}
		return max;
	}

	public int getMinimum() {
		if (count == 0)
			return -1;

		int min = array[0];

		if (this.heapType == HeapType.MAXIMUM) {
			System.err.println("BinaryHeap.getMaximum() => This is MAXIMUM heap, getting min will lead to O(N)");

			for (Integer e : array) {
				if (e < min)
					min = e;
			}
		}
		return min;
	}

	public void heapify(int i) {
		if (this.heapType == HeapType.MAXIMUM)
			heapifyMax(i);
		else if (this.heapType == HeapType.MINIMUM)
			heapifyMin(i);
	}

	private void heapifyMin(int i) {
		int leftIndex = -1, rightIndex = -1, minIndex = -1;

		leftIndex = getLeft(i);
		rightIndex = getRight(i);

		if (leftIndex != -1 && this.array[leftIndex] < this.array[i])
			minIndex = leftIndex;
		else
			minIndex = i;

		if (rightIndex != -1 && this.array[rightIndex] < this.array[minIndex])
			minIndex = rightIndex;

		if (minIndex != i) {
			int temp = this.array[minIndex];
			this.array[minIndex] = this.array[i];
			this.array[i] = temp;
			
			heapifyMin(minIndex);
		}

		
	}

	private void heapifyMax(int i) {
		int leftIndex = -1, rightIndex = -1, maxIndex = -1;

		leftIndex = getLeft(i);
		rightIndex = getRight(i);

		if (leftIndex != -1 && this.array[leftIndex] > this.array[i])
			maxIndex = leftIndex;
		else
			maxIndex = i;

		if (rightIndex != -1 && this.array[rightIndex] > this.array[maxIndex])
			maxIndex = rightIndex;

		if (maxIndex != i) {
			int temp = this.array[maxIndex];
			this.array[maxIndex] = this.array[i];
			this.array[i] = temp;
			
			heapifyMax(maxIndex);
		}
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
		if (this.count == this.capacity)
			resizeHeap();

		this.count++;

		int i = this.count - 1;

		while (i >= 0 && data >= array[(i - 1) / 2]) {
			this.array[i] = this.array[(i - 1) / 2];
			i = (i - 1) / 2;
		}

		this.array[i] = data;
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
		if (h == null || data == null)
			return null;

		if (data.length == 0)
			return new Integer[] {};

		while (data.length > this.capacity)
			resizeHeap();

		for (int i = 0; i < data.length; i++)
			this.array[i] = data[i];

		this.count = data.length;

		for (int i = (data.length - 1) / 2; i >= 0; i--)
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
