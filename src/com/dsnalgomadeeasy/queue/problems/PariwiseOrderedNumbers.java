package com.dsnalgomadeeasy.queue.problems;

import com.dsnalgomadeeasy.queue.common.CQueue;
import com.dsnalgomadeeasy.stack.common.StackLL;

public class PariwiseOrderedNumbers {
	StackLL<Integer> pairStack = new StackLL<>(); 
	
	public PariwiseOrderedNumbers(Integer[] data) {
		if(data != null)
			for (Integer i : data) 
				pairStack.push(i);
	}
	
	public boolean hasPair() {
		boolean pairOrderExist = true;
		CQueue<Integer> queue = new CQueue<>(Integer.class);
		
		while(!pairStack.isEmpty())
			queue.enQueue(pairStack.pop());
		
		while(!queue.isEmpty())
			pairStack.push(queue.deQueue());
		
		
		while(!pairStack.isEmpty()) {
			int m = pairStack.pop();
			queue.enQueue(m);
			
			if(!pairStack.isEmpty()) {
				int n = pairStack.pop();
				queue.enQueue(n);
				
				if(Math.abs(m-n) > 1)
					pairOrderExist = false;
			}
		}
		
		while(!queue.isEmpty())
			pairStack.push(queue.deQueue());
		
		return pairOrderExist;
	}
}
