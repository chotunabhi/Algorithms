package com.dsnalgomadeeasy.linkedList.problems;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;
import com.dsnalgomadeeasy.linkedList.common.SLLUtil;

public class ReverseSLL {
	public <T extends Comparable<T>> NodeSLL<T> reverseSLLIterative(NodeSLL<T> head){
		NodeSLL<T> previous = null,current = head,next = head;
		
		while(current != null) {
			next = current.getNext();
			current.setNext(previous);
			previous = current;
			
			current = next;
		}
		
		return previous;
	}
	
	public <T extends Comparable<T>> NodeSLL<T> reverseSLLRecursive(NodeSLL<T> head){
		if(head == null || head.getNext() == null)
			return head;
		
		NodeSLL<T> newHead = reverseSLLRecursive(head.getNext());
		
		head.getNext().setNext(head);
		head.setNext(null);
		
		return newHead;
	}
}
