package com.dsnalgomadeeasy.queue.common;

import java.lang.reflect.Array;

public class CQueue<T extends Comparable<T>> implements Cloneable{
	private T[] queueData;
	private int front, rear, size;
	public static int CAPACITY = 16;
	private static final int MIN_CAPACITY = 8;
	private Class<T> clazz;

	public CQueue(Class<T> clazz) {
		this.clazz = clazz;
		queueData = (T[]) Array.newInstance(clazz, CAPACITY);
		front = rear = size = 0;
	}

	public CQueue(Class<T> clazz, int capacity) {
		this.clazz = clazz;
		queueData = (T[]) Array.newInstance(getClass(), capacity);
		front = rear = size = 0;
	}

	public Class<T> getClazz() {
		return clazz;
	}

	public void enQueue(T data) {
		if (CAPACITY == size)
			expand();

		rear = size==0?0:(rear+1) % queueData.length;
		queueData[rear] = data;
		
		size++;
	}

	public T deQueue() throws IllegalStateException {
		if (size == 0)
			throw new IllegalStateException("Queue is empty");

		T data = queueData[front];
		queueData[front] = null;
		size--;
		front = size == 0 ? 0:(front + 1) % CAPACITY;

		if (size < CAPACITY / 2)
			shrink();

		return data;
	}

	private void shrink() {
		T[] newQueue = (T[]) Array.newInstance(clazz, CAPACITY >> 1);

		if (size <= MIN_CAPACITY)
			return;
		
		for (int i = front; i < queueData.length || (i%CAPACITY) <= rear; i++) {
			newQueue[i-front] = queueData[i%CAPACITY];
			
			if(i == rear)
				break;
		}
		
		front = 0;
		rear = size - 1;
		CAPACITY >>= 1;
		queueData = newQueue;
	}

	private void expand() {
		T[] newQueue = (T[]) Array.newInstance(clazz, CAPACITY << 1);

		for (int i = front; i < queueData.length || (i%CAPACITY) <= rear; i++) {
			newQueue[i - front] = queueData[i%queueData.length];
			
			if(i == rear)
				break;
		}

		queueData = newQueue;
		front = 0;
		rear = size - 1;
		CAPACITY <<= 1;
	}

	public int size() {
		return size;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");

		for (int i = front; i < queueData.length || (i%CAPACITY) <= rear; i++) {
			sb.append(queueData[(front + i) % CAPACITY]);

			if (i < queueData.length - 1 && i != rear)
				sb.append(",");
			
			if(i == rear)
				break;
		}

		sb.append("]");

		return sb.toString();
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public static void main(String[] args) {
		CQueue<Integer> queue = new CQueue<>(Integer.class);

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
