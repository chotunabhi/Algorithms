package com.dsnalgomadeeasy.queue.common;

import java.util.EmptyStackException;

import com.dsnalgomadeeasy.stack.common.StackLL;

public class QueueUsingStacks<T extends Comparable<T>> {
	StackLL<T> pushStack = new StackLL<>();
	StackLL<T> popStack = new StackLL<>();

	public void enQueue(T data) {
		pushStack.push(data);
	}

	public T deQueue() throws IllegalStateException {
		if(isEmpty())
			throw new EmptyStackException();
		
		T data = null;
		
		while(!pushStack.isEmpty())
			popStack.push(pushStack.pop());
		
		data = popStack.pop();

		return data;
	}

	public boolean isEmpty() {
		return pushStack.isEmpty() && popStack.isEmpty();
	}

	public String toString() {
		StackLL<T> tempStack = new StackLL<>();

		while(!popStack.isEmpty())
			tempStack.push(popStack.pop());

		while(!pushStack.isEmpty())
			popStack.push(pushStack.pop());

		while(!tempStack.isEmpty())
			popStack.push(tempStack.pop());

		return popStack.isEmpty()? "[]":popStack.toString();
	}

	public static void main(String[] args) {
		QueueUsingStacks<Integer> queue = new QueueUsingStacks<>();

		System.out.println(queue);
		queue.enQueue(1);
		System.out.println(queue);
		queue.enQueue(2);
		System.out.println(queue);

		for (int i = 3; i <= 50; i++) {
			queue.enQueue(i);
		}
		System.out.println(queue);
		for (int i = 1; i <= 50; i++)
			queue.deQueue();

		System.out.println(queue);

		for (int i = 1; i <= 40; i++) {
			queue.enQueue(i);
		}
		for (int i = 51; i <= 100; i++) {
			queue.enQueue(i);
		}
		System.out.println(queue);
	}
}
