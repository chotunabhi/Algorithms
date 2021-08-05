package com.dsnalgomadeeasy.linkedList.common;

import java.lang.reflect.Array;
import java.util.LinkedList;

public class CLLUtil {
	public static <T extends Comparable<T>> NodeSLL<T> getCLLFromArray(T[] elements){
		NodeSLL<T> head = null,node = null,current = null;
		
		for (T element : elements) {
			node = new NodeSLL<T>(element);
			
			if(head == null) {
				head = node;
				current = node;
			}
			
			current.setNext(node);
			current = node;
		}
		
		if(node != null)
			node.setNext(head);
		
		return head;
	}
	
	public static <T extends Comparable<T>> T[] getArrayFromCLL(NodeSLL<T> head) {
		T[] elements = null;
		
		if(head != null) {
			NodeSLL<T> node = head;
			int length = 0;
			
			do {
				length++;
				node = node.getNext();
			}while(node != head);
			
			node = head;
			
			elements = (T[])Array.newInstance(head.getData().getClass(), length);
			
			for(int i = 0;i < length; i++) {
				elements[i] = node.getData();
				node = node.getNext();
			}
		}
		
		return elements;
	}
	
	public static <T extends Comparable<T>> void printList(NodeSLL<T> head) {
		java.util.LinkedList<T> list = new LinkedList<>();
		
		if(head != null) {
			NodeSLL<T> node = head;
			
			do {
				list.add(node.getData());
				node = node.getNext();
			}while(node != head);
		}
		
		System.out.println(list);
	}
}
