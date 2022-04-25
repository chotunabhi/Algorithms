package com.dsnalgomadeeasy.linkedList.problems;

import java.util.Hashtable;
import java.util.Stack;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;

public class NthNodeFromEndOfSLL {
	private static int position = 0;

	public NthNodeFromEndOfSLL() {
		position = 0;
	}

	public static void main(String[] args) {
		NodeSLL<Integer> node = new NodeSLL<>(1);
		NodeSLL<Integer> next = node;

		next.setNext(new NodeSLL<>(2));
		next = next.getNext();

		next.setNext(new NodeSLL<>(3));
		next = next.getNext();

		next.setNext(new NodeSLL<>(4));
		next = next.getNext();

		next.setNext(new NodeSLL<>(5));
		next = next.getNext();

		System.out.println(new NthNodeFromEndOfSLL().bruteForce(node, 0));
		// System.out.println(new NthNodeFromEndOfSLL().usingStack(node, -1));
		// System.out.println(new NthNodeFromEndOfSLL().usingHT(node, 10));
		// System.out.println(new NthNodeFromEndOfSLL().usingLengthOfSLL(node, -2));
		// System.out.println(new NthNodeFromEndOfSLL().usingStack(node, 10));
		// System.out.println(new NthNodeFromEndOfSLL().usingRecursion(node, 5));
	}

	public <T extends Comparable<T>> T bruteForce(NodeSLL<T> sll, int n) {
		T data = null;

		if(sll != null && n > 0) {
			NodeSLL<T> current = sll;
			NodeSLL<T> next = null;

			while(n-- > 0) {
				if(current == next)
					break;

				while(current.getNext() != next)
					current = current.getNext();

				next = current;
				current = sll;
			}

			if(n == -1)
				data = next.getData();
		}

		return data;
	}

	public <T extends Comparable<T>> T usingStack(NodeSLL<T> sll, int n) {
		T data = null;

		if(sll != null && n > 0) {
			NodeSLL<T> current = sll;
			Stack<T> nodeStack = new Stack<>();

			while(current != null) {
				nodeStack.push(current.getData());
				current = current.getNext();
			}

			while(n-- > 0 && !nodeStack.isEmpty()) {
				data = nodeStack.pop();
			}

			if(n != -1)
				data = null;
		}
		return data;
	}

	public <T extends Comparable<T>> T usingHT(NodeSLL<T> sll, int n) {
		T data = null;

		if(sll != null && n > 0) {
			Hashtable<Integer, T> listTable = new Hashtable<>();
			NodeSLL<T> current = sll;
			int i = 1;

			while(current != null) {
				listTable.put(i++, current.getData());
				current = current.getNext();
			}

			data = listTable.getOrDefault(listTable.size() - n + 1, null);
		}

		return data;
	}

	public <T extends Comparable<T>> T usingLengthOfSLL(NodeSLL<T> sll, int n) {
		T data = null;

		if(sll != null && n > 0) {
			int length = 0;
			NodeSLL<T> current = sll;

			while(current != null) {
				current = current.getNext();
				length++;
			}

			if(length >= n) {
				current = sll;

				for(int i = 0; i < (length - n) && current != null; i++) {
					current = current.getNext();
				}

				if(current != null && length >= n)
					data = current.getData();
			}
		}

		return data;
	}

	public <T extends Comparable<T>> T usingOnePass(NodeSLL<T> sll, int n) {
		T data = null;

		if(sll != null && n > 0) {
			NodeSLL<T> next = sll;
			NodeSLL<T> prev = sll;
			
			while(--n > 0 && next != null)
				next = next.getNext();
			
			while(next!= null && next.getNext() != null) {
				prev = prev.getNext();
				next = next.getNext();
			}
			
			if(next != null)
				data = prev.getData();
		}

		return data;
	}

	public <T extends Comparable<T>> T usingRecursion(NodeSLL<T> sll, int n) {
		T data = null;

		if(sll != null) {
			data = usingRecursion(sll.getNext(), n);
			
			if(++position == n)
				return sll.getData();
		}
		return data;
	}
}
