package com.dsnalgomadeeasy.stack.problems;

import java.util.Stack;

/*
 * Service Now Round 1
 */
public class MinMaxStack<T extends Comparable<T>> extends Stack<T>{
	Stack<T> minStack = new Stack<>();
	Stack<T> maxStack = new Stack<>();
	
	@Override
	public T push(T e) {
		super.push(e);
		
		return e;
	}
	
	@Override
	public T pop() {
		T e = super.pop();
		
		return e;
	}
	
	public T getMin() {
		return minStack.peek();
	}
	
	public T getMax() {
		return maxStack.peek();
	}
}
