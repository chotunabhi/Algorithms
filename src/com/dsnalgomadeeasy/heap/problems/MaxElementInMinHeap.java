package com.dsnalgomadeeasy.heap.problems;

import com.dsnalgomadeeasy.heap.common.BinaryHeap;

public class MaxElementInMinHeap {
	public Integer getMaxInMinHeap(BinaryHeap minHeap) {
		Integer max = null;
		
		if(minHeap != null && minHeap.getCount() > 0) {
			for(int i = (minHeap.getCount() - 1)/2; i < minHeap.getCount(); i++)
				if(max == null || max < minHeap.array[i])
					max = minHeap.array[i];
				
		}
		return max;
	}
}
