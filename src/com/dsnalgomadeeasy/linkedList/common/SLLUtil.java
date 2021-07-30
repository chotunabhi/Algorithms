package com.dsnalgomadeeasy.linkedList.common;

import java.lang.reflect.Array;

public class SLLUtil {
	public static <T extends Comparable<T>> void printList(NodeSLL<T> head) {
		NodeSLL<T> node = head;

		StringBuffer list = new StringBuffer();
		list.append("[");

		if (node != null) {
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

	public static <T extends Comparable<T>> NodeSLL<T> createSLL(T[] elements){
		NodeSLL<T> head = null,prev = null;

		for (T data : elements) {
			NodeSLL<T> node = new NodeSLL<T>(data);

			if(head == null) 
				prev = head = node;
			else {
				prev.setNext(node);
				prev = prev.getNext();
			}
		}

		return head;
	}

	public static <T extends Comparable<T>> NodeSLL<T> cloneList(NodeSLL<T> head){
		NodeSLL<T> newPrevious = null,newHead = null;
		NodeSLL<T> current = head;

		while(current != null) {
			NodeSLL<T> node = new NodeSLL<T>(current.getData());

			if(newHead == null) 
				newPrevious = newHead = node;
			else {
				newPrevious.setNext(node);
				newPrevious = newPrevious.getNext();
			}

			current = current.getNext();
		}

		return newHead;
	}
	public static <T extends Comparable<T>> T[] getArrayFromList(NodeSLL<T> head) {
		T[] elements = null;
		NodeSLL<T> node = head;
		int length = 0;

		if(head == null)
			return elements;

		while(node != null) {
			node = node.getNext();
			length++;
		}

		node = head;


		elements = (T[])Array.newInstance(head.getData().getClass(), length);
		int i = 0;

		while(node != null) {
			elements[i++] = node.getData();
			node = node.getNext();
		}

		return elements;
	}
}
