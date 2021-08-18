package com.dsnalgomadeeasy.linkedList.problems;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;

public class ExchangeAdjacentElements{
	public <T extends Comparable<T>> NodeSLL<T> exchangeAdjacentElementsIterative(NodeSLL<T> head){
		NodeSLL<T> newHead = null;
		NodeSLL<T> previous = null,current = head;
		
		while(current != null && current.getNext() != null) {
			NodeSLL<T> temp = current.getNext().getNext();
			
			if(newHead == null)
				newHead = current.getNext();
			
			if(previous != null)
				previous.setNext(current.getNext());
			
			current.getNext().setNext(current);
			current.setNext(temp);
			
			previous = current;
			current = temp;
		}
		
		if(newHead == null)
			newHead = current;
		
		return newHead;
	}
	
	public <T extends Comparable<T>> NodeSLL<T> exchangeAdjacentElementsRecursive(NodeSLL<T> head){
		if(head != null && head.getNext() != null) {
			NodeSLL<T> tailHead = exchangeAdjacentElementsRecursive(head.getNext().getNext());
			NodeSLL<T> temp = head.getNext();
			temp.setNext(head);
			head.setNext(tailHead);
			
			head = temp;
		}
		
		return head;
	}
}
