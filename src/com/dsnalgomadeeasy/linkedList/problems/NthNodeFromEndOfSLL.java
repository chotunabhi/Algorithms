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


		return data;
	}

	public <T extends Comparable<T>> T usingStack(NodeSLL<T> sll, int n) {
		T data = null;

		
		
		return data;
	}

	public <T extends Comparable<T>> T usingHT(NodeSLL<T> sll, int n) {
		T data = null;

		return data;
	}

	public <T extends Comparable<T>> T usingLengthOfSLL(NodeSLL<T> sll, int n) {
		T data = null;

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
