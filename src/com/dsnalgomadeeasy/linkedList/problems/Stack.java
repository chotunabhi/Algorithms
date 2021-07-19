package com.dsnalgomadeeasy.linkedList.problems;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;

public class Stack<T> {
	NodeSLL<T> node;
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
		NodeSLL<T> newNode = new NodeSLL<T>(data);

		newNode.setNext(this.node);
		this.node = newNode;

		size++;
	}

	public T pop() {
		T data = null;

		if (isEmpty()) {
			System.err.println("Stack is empty");
		} else {
			data = node.getData();
			node = node.getNext();
			
			size--;
		}

		return data;
	}

	public T peek() {
		T data = null;

		if (isEmpty()) {
			System.err.println("Stack is empty");
		} else {
			data = node.getData();
		}

		return data;
	}

	public boolean isEmpty() {
		return node == null;
	}

	public int size() {
		return size;
	}

	public void printStack() {
		StringBuffer list = new StringBuffer();
		list.append("[");

		if (!isEmpty()) {
			NodeSLL<T> node = this.node;

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
