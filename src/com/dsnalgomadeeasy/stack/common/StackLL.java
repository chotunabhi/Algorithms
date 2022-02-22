package com.dsnalgomadeeasy.stack.common;

import java.util.EmptyStackException;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;

public class StackLL<T extends Comparable<T>> {
	private NodeSLL<T> top;
	private int length;

	public StackLL() {
		length = 0;
		top = null;
	}

	public void push(T data) {
		NodeSLL<T> node = new NodeSLL<>(data);

		node.setNext(top);
		top = node; 
		
		length++;
	}
	
	public T pop() throws EmptyStackException{
		if(isEmpty())
			throw new EmptyStackException();
		
		T result = top.getData();
		top = top.getNext();
		length--;
		
		return result;
	}
	
	public T peek() throws EmptyStackException{
		if(isEmpty())
			throw new EmptyStackException();
		
		return top.getData();
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int size() {
		return length;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		NodeSLL<T> current = top;
		
		while(current != null) {
			if(sb.length() == 0)
				sb.append("[");
			
			sb.append(current.getData())
				.append(",");
			
			current = current.getNext();
		}
		
		if(sb.length() > 1)
			sb.deleteCharAt(sb.length()-1).append("]");
		
		return sb.toString();
	}
	
	public static void main(String args[]) {
		StackLL<Integer> s = new StackLL<>();
		
		System.out.println("Empty stack"+s);
		
		s.push(1);
		System.out.println("stack"+s);
		
		s.push(2);
		System.out.println("stack"+s);
		System.out.println("Peek()"+s.peek());
		System.out.println("pop()"+s.pop());
		System.out.println("Stack after one pop"+s);
		System.out.println("pop()"+s.pop());
		System.out.println("pop()"+s.pop());
	}
}
