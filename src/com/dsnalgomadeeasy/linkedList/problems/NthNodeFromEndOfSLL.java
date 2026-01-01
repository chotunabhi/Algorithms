package com.dsnalgomadeeasy.linkedList.problems;

import java.util.Hashtable;
import java.util.Stack;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;
import com.stack.StackSLL;

public class NthNodeFromEndOfSLL {
	private static int position = 0;

	public NthNodeFromEndOfSLL() {
		position = 0;
	}

	public static void main(String[] args) {
		NodeSLL<Integer> node = new NodeSLL<>(1);
		/*
		 * NodeSLL<Integer> next = node;
		 * 
		 * next.setNext(new NodeSLL<>(2)); next = next.getNext();
		 * 
		 * next.setNext(new NodeSLL<>(3)); next = next.getNext();
		 * 
		 * next.setNext(new NodeSLL<>(4)); next = next.getNext();
		 * 
		 * next.setNext(new NodeSLL<>(5)); next = next.getNext();
		 */

		System.out.println(new NthNodeFromEndOfSLL().bruteForce(node, 5));
		// System.out.println(new NthNodeFromEndOfSLL().usingStack(node, -1));
		// System.out.println(new NthNodeFromEndOfSLL().usingHT(node, 10));
		// System.out.println(new NthNodeFromEndOfSLL().usingLengthOfSLL(node, -2));
		// System.out.println(new NthNodeFromEndOfSLL().usingStack(node, 10));
		// System.out.println(new NthNodeFromEndOfSLL().usingRecursion(node, 5));
	}

	public <T extends Comparable<T>> T bruteForce(NodeSLL<T> sll, int n) {
		T data = null;

		if(sll != null) {
			NodeSLL<T> next = null;

			while(n > 0 && next != sll) {
				NodeSLL<T> current = sll;

				while(current.getNext() != next) {
					current = current.getNext();
				}

				next = current;
				n--;
			}
			
			if(n == 0 && next != null)
				data = next.getData();
		}

		return data;
	}

	public <T extends Comparable<T>> T usingHT(NodeSLL<T> sll, int n) {
		T data = null;

		if(sll != null) {
			Hashtable<Integer, T> nodeTable = new Hashtable<Integer, T>();
			NodeSLL<T> current = sll;
			int i = 1;
			
			while(current != null) {
				nodeTable.put(i++, current.getData());
				current = current.getNext();
			}
			
			if(i > 1 && n > 0) {
				data = nodeTable.get(i - n);
			}
		}
		
		return data;
	}

	public <T extends Comparable<T>> T usingLengthOfSLL(NodeSLL<T> sll, int n) {
		T data = null;
		
		if(sll != null & n > 0) {
			NodeSLL<T> current = sll;
			int size = 0;
			
			while(current != null) {
				current = current.getNext();
				size++;
			}
			
			if(size >= n) {
				int i = 0;
				current = sll;
				
				while(i++ < (size - n)) {
					current = current.getNext();
				}
				
				if(current != null) {
					data = current.getData();
				}
			}
		}

		return data;
	}

	public <T extends Comparable<T>> T usingStack(NodeSLL<T> sll, int n) {
		T data = null;
		
		if(sll != null) {
			Stack<T> nodeStack = new Stack<>();
			NodeSLL<T> current = sll;
			
			while(current != null) {
				nodeStack.push(current.getData());
				current = current.getNext();
			}
			
			if(nodeStack.size() >= n) {
				while(n > 0 && !nodeStack.isEmpty()) {
					data = nodeStack.pop();
					n--;
				}
				
				if(n != 0)
					data = null;
			}
			
		}


		return data;
	}

	public <T extends Comparable<T>> T usingOnePass(NodeSLL<T> sll, int n) {
		T data = null;

		return data;
	}

	public <T extends Comparable<T>> T usingRecursion(NodeSLL<T> sll, int n) {
		T data = null;

		return data;
	}
}
