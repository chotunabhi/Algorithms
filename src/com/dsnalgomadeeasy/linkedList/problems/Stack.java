package com.dsnalgomadeeasy.linkedList.problems;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;

public class Stack<T extends Comparable<T>>  {
	NodeSLL<T> top;
	private static int size = 0;

	public static void main(String[] args) {
		Stack<Integer> stackSLL = new Stack<>();

		System.out.println(stackSLL.size());
		stackSLL.printStack();

		stackSLL.push(1);
		stackSLL.push(2);
		System.out.println(stackSLL.size());
		stackSLL.printStack();

		stackSLL.push(3);
		System.out.println(stackSLL.size());
		stackSLL.printStack();

		System.out.println(stackSLL.pop());
		System.out.println(stackSLL.size());
		stackSLL.printStack();

		System.out.println(stackSLL.peek());
		System.out.println(stackSLL.size());

		System.out.println(stackSLL.pop());
		System.out.println(stackSLL.pop());

		System.out.println(stackSLL.size());
		stackSLL.printStack();
		System.out.println(stackSLL.pop());

		System.out.println(stackSLL.size());
		stackSLL.printStack();
		
		System.out.println(stackSLL.pop());
	}

	public void push(T data) {
		NodeSLL<T> currentNode = new NodeSLL(data);
		
		currentNode.setNext(top);
		top = currentNode;
		
		size++;
	}

	public T pop() {
		T data = null;
		
		if(isEmpty()) {
			System.err.print("Stack Empty");
		}else {
			NodeSLL<T> currentNode = top;
			top = top.getNext();
			
			data = currentNode.getData();
			currentNode.setNext(null);
			
			size--;
		}
		
		return data;
	}

	public T peek() {
		T data = null;

		if(isEmpty()) {
			System.err.print("Stack Empty");
		}else {
			data = top.getData();
		}

		return data;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public int size() {
		return size;
	}

	public void printStack() {
		StringBuffer list = new StringBuffer();
		list.append("[");

		if (!isEmpty()) {
			NodeSLL<T> node = this.top;

			do {
				list.append(node.getData());
				list.append(",");

				node = node.getNext();
			} while (node != null);
		}

		if (list.length() > 1)
			list.deleteCharAt(list.length() - 1);

		list.append("]");

		System.out.println(list);
	}
}
