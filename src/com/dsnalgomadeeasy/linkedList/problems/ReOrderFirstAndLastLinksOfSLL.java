package com.dsnalgomadeeasy.linkedList.problems;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;

public class ReOrderFirstAndLastLinksOfSLL {
	public <T extends Comparable<T>> NodeSLL<T> reOrderListUsingStack(NodeSLL<T> head){
		if(head == null)
			return head;
		
		NodeSLL<T> slowPointer = head,fastPointer = head,middleHead = head;
		
		while(fastPointer != null && fastPointer.getNext() != null) {
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();
		}
		
		middleHead = slowPointer.getNext();
		slowPointer.setNext(null);
		slowPointer = middleHead;
		
		java.util.Stack<NodeSLL<T>> nodeStack = new java.util.Stack<NodeSLL<T>>();
		
		while(slowPointer != null) {
			nodeStack.push(slowPointer);
			slowPointer = slowPointer.getNext();
		}
		
		slowPointer = head;
		
		while(!nodeStack.isEmpty() && slowPointer != null) {
			NodeSLL<T> next = slowPointer.getNext();
			
			slowPointer.setNext(nodeStack.pop());
			slowPointer.getNext().setNext(next);
			
			slowPointer = next;
		}
		
		return head;
	}
}
