package com.dsnalgomadeeasy.linkedList.problems;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;

public class ReverseKElements {
	public <T extends Comparable<T>> NodeSLL<T> reverseKLinks(NodeSLL<T> head,int k){
		NodeSLL<T> newHead = k > 0 ? null : head;
		NodeSLL<T> current = head,prevTail = null;
		
		while(current != null && k > 0) {
			int i = 0;
			
			NodeSLL<T> tail = current;
			NodeSLL<T> previous = null;
			
			while(i++ != k && current != null) {
				NodeSLL<T> next = current.getNext();
				
				current.setNext(previous);
				previous = current;
				current = next;
			}
			
			if(prevTail != null)
				prevTail.setNext(previous);
			
			tail.setNext(current);
			prevTail = tail;
			
			if(newHead == null)
				newHead = previous;
			
		}
		
		return newHead;
	}
	
	public <T extends Comparable<T>> NodeSLL<T> reverseKLinksRecursive(NodeSLL<T> head,int k){
		NodeSLL<T> current = head,previous = k > 0 ? null : head;
		
		if(head != null && k > 0) {
			int i = 0;
			
			while(i++ != k && current != null) {
				NodeSLL<T> next = current.getNext();
				
				current.setNext(previous);
				previous = current;
				current = next;
			}
			
			head.setNext(reverseKLinksRecursive(current, k));
		}
		
		return previous;
	}
}
