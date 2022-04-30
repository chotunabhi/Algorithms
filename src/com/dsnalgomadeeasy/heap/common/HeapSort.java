package com.dsnalgomadeeasy.heap.common;

import com.dsnalgomadeeasy.heap.common.BinaryHeap.HeapType;

public class HeapSort {
	public Integer[] sort(Integer[] data) {
		if(data != null && data.length > 0) {
			BinaryHeap h = new BinaryHeap(data.length, HeapType.MAXIMUM);
			h.buildHeap(h, data);
			
			for(int i = data.length -1; i > 0; i--) {
				int temp = h.array[0];
				h.array[0] = h.array[h.getCount()-1];
				h.array[h.getCount()-1] = temp;
				
				h.setCount(h.getCount() - 1);
				h.heapify(0);
			}
			
			h.setCount(data.length);
			data = h.array;
		}
		
		return data;
	}
}
