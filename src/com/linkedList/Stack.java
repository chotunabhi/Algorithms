package com.linkedList;

public class Stack<T> {
	NodeSLL<T> top = null;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		stack.push(1);
		stack.printStack();
		System.out.println();
		
		stack.push(2);
		stack.printStack();
		System.out.println();
		
		stack.push(3);
		stack.printStack();
		System.out.println();
		
		stack.push(4);
		stack.printStack();
		System.out.println(stack.peek());
		
		System.out.println(stack.pop());
		stack.printStack();
		
		
		
	}

	private T pop() {
		NodeSLL<T> topOfStack = top;
		
		if(top != null) 
			top = top.next;
			
		return topOfStack != null?topOfStack.data:null; 
	}
	
	private T peek(){
		return top != null?top.data:null;
	}
	
	private void push(T data) {
		NodeSLL<T> node = new NodeSLL<T>(data);
		node.data = data;
		
		if(top != null)
			node.next = top;
			
		top = node;
	}
	
	private boolean isEmpty() {
		return top == null;
	}
	
	private void printStack() {
		NodeSLL<T> head = top;
		
		while(head != null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
	}
}
