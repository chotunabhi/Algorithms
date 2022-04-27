package com.dsnalgomadeeasy.queue.common;

import java.lang.reflect.Array;

public class QueueUtil{
	public static <T extends Comparable<T>> CQueue<T> getQueueFromArray(T[] data){
		if(data == null)
			return null;
		
		CQueue<T> queue = new CQueue(data[0].getClass());
		
		for(T element:data) {
			queue.enQueue(element);
		}
		
		return queue;
	}
	
	public static <T extends Comparable<T>> CQueue<T> cloneQueue(CQueue<T> queue){
		CQueue<T> clonedQueue = null;
		
		if(queue != null) {
			clonedQueue = new CQueue<>(queue.getClazz());
			CQueue<T> tempQueue = new CQueue<>(queue.getClazz());
			
			while(!queue.isEmpty()) {
				T data = queue.deQueue();
				
				clonedQueue.enQueue(data);
				tempQueue.enQueue(data);
			}
			
			queue = tempQueue;
			
		}
		
		return clonedQueue;
	}
	public static <T extends Comparable<T>> T[] getArrayFromQueue(CQueue<T> queue){
		T[] data = null;
		
		if(queue != null) {
			data = (T[]) Array.newInstance(queue.getClazz()	, queue.size());
			CQueue<T> clonedQueue = cloneQueue(queue);
			int i = 0;
			
			while(!clonedQueue.isEmpty()) {
				data[i++] = clonedQueue.deQueue();
			}
		}
		
		return data;
	}
	
	public static void main(String args[]) {
		CQueue<Integer> queue = QueueUtil.getQueueFromArray(new Integer[] {1,2,3,4,5});
		
		System.out.println(queue);
	}
}
