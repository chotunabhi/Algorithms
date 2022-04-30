package com.dsnalgomadeeasy.heap.problems;

import com.dsnalgomadeeasy.heap.common.BinaryHeap;

public class DeleteIElement {
	public Integer getIthIndexDeleted(BinaryHeap h,int i) {
		Integer result=null;
		
		if(h != null && h.array != null && h.array.length > 0 && i < h.getCount()) {
			result = h.array[i];
			
			h.array[i] = h.array[h.getCount()-1];
			h.setCount(h.getCount() - 1);
			
			h.heapify(i);
		}
		
		return result;
	}
}
