package com.dsnalgomadeeasy.heap.common;

import com.dsnalgomadeeasy.heap.common.BinaryHeap.HeapType;

public class HeapSort {
	public Integer[] sort(Integer[] data) {
		if(data != null && data.length > 0) {
			BinaryHeap binaryHeap = new BinaryHeap(data.length, HeapType.MAXIMUM);
			binaryHeap.buildHeap(binaryHeap, data);
			
			for(int i = data.length - 1;i > 0;i--) {
				int temp = binaryHeap.array[0];
				binaryHeap.array[0] = binaryHeap.array[i];
				binaryHeap.array[i] = temp;
				
				binaryHeap.setCount(binaryHeap.getCount() - 1);
				
				binaryHeap.heapify(0);
			}
			
			binaryHeap.setCount(data.length);
			
			data = binaryHeap.array;
		}
		
		return data;
	}
}
