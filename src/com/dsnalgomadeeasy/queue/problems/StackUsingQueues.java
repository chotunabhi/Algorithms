package com.dsnalgomadeeasy.queue.problems;

import java.lang.reflect.Array;
import java.util.EmptyStackException;

import com.dsnalgomadeeasy.queue.common.CQueue;

public class StackUsingQueues<T extends Comparable<T>> {
	CQueue<T> queue1;
	CQueue<T> queue2;
	
	public StackUsingQueues(Class<T> clazz) {
		queue1 = new CQueue<T>(clazz);
		queue2 = new CQueue<T>(clazz);
	}
	
	public void push(T data) {
		if (queue1.isEmpty())
			queue2.enQueue(data);
		else
			queue1.enQueue(data);
	}

	public T pop() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException();
		
		T data = null;

		CQueue<T> popQueue = queue1.isEmpty() ? queue2 : queue1;
		CQueue<T> pushQueue = queue1.isEmpty() ? queue1 : queue2;

		for (int i = 0; i < popQueue.size(); i++) {
			pushQueue.enQueue(popQueue.deQueue());
		}

		data = popQueue.deQueue();

		return data;
	}

	public boolean isEmpty() {
		return queue1.isEmpty() && queue2.isEmpty();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		CQueue<T> displayQueue = queue1.isEmpty() ? queue2 : queue1;
		
		if(!displayQueue.isEmpty()) {
			StringBuilder qb = new StringBuilder(displayQueue.toString());
			
			sb = new StringBuilder(qb.reverse().substring(1,qb.length()-1));
		}
		
		return sb.toString();
	}
	public static void main(String[] args) {
		StackUsingQueues<Integer> stack = new StackUsingQueues<>(Integer.class);
		
		System.out.println(stack);
		
		stack.push(1);
		System.out.println(stack);
		
		stack.push(2);
		System.out.println(stack);

		stack.push(3);
		System.out.println(stack);
		
		System.out.println(stack.pop());
		System.out.println(stack);

		stack.push(4);
		System.out.println(stack);
		
		System.out.println(stack.pop());
		System.out.println(stack);
		
		stack.push(5);
		System.out.println(stack);
	}
}
