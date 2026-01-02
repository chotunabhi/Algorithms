package com.dsnalgomadeeasy.queue.problems;

import com.dsnalgomadeeasy.queue.common.CQueue;
import com.dsnalgomadeeasy.stack.common.StackLL;

public class QueueReversal<T extends Comparable<T>> {
	public CQueue<T> reverseQueue(CQueue<T> queue){
		if(queue != null && !queue.isEmpty()) {
			T data = queue.deQueue();
			reverseQueue(queue);
			queue.enQueue(data);
		}
		return queue;
	}
	
	public CQueue<T> reverseQueueUsingStacks(CQueue<T> queue){
		if(queue != null && !queue.isEmpty()) {
			StackLL<T> stack = new StackLL<>();
			
			while(!queue.isEmpty())
				stack.push(queue.deQueue());
			
			while(!stack.isEmpty())
				queue.enQueue(stack.pop());
		}
		return queue;
	}
}
