package com.dsnalgomadeeasy.linkedList.problems;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;

public class ReverseLinksInPairs {
	public<T extends Comparable<T>> NodeSLL<T> reversePairsRecursive(NodeSLL<T> head){
		if(head == null || head.getNext() == null)
			return head;
		
		NodeSLL<T> next = head.getNext();
		head.setNext(reversePairsRecursive(next.getNext()));
		next.setNext(head);
		
		return next;
	}
	
	public<T extends Comparable<T>> NodeSLL<T> reversePairs(NodeSLL<T> head){
		NodeSLL<T> newHead = head,pTail = null;
		//1,2,3,4
		
		while(head != null && head.getNext() != null) {
			if(newHead == head)
				newHead = head.getNext();
			
			if(pTail != null)
				pTail.setNext(head.getNext());
			
			NodeSLL<T> next = head.getNext().getNext();
			head.getNext().setNext(head);
			head.setNext(next);
			
			pTail = head;
			head = next;
			
		}
		
		return newHead;
	}
}
