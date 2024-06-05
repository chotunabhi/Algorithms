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

	}

	public T pop() throws EmptyStackException {
		T data = null;

		
		
		return data;
	}

	public boolean isEmpty() {
		return queue1.isEmpty() && queue2.isEmpty();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		CQueue<T> displayQueue = queue1.isEmpty() ? queue2 : queue1;
		
		if(!displayQueue.isEmpty()) {
			StringBuilder displayQueueString = new StringBuilder(displayQueue.toString());
			String queueString = displayQueueString.substring(1,displayQueueString.length()-1);
			
			for(String elem:queueString.toString().split(",")) {
				sb.insert(0, elem+",");
			}
			
			sb.deleteCharAt(sb.length()-1);
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
		
		stack.push(8);
		System.out.println(stack);
		
		stack.push(81);
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
