package com.LinkedList;

public class ReversingLinks<T> {
	SinglyLinkedList<T> sll;
	
	public ReversingLinks(SinglyLinkedList<T> sll) {
		super();
		this.sll = sll;
	}

	public void reverseLinksRecursive(NodeSLL<T> head){
		if(head == null || head.next == null){
			//base condition
			this.sll.setHead(head);
			return;
		}
		reverseLinksRecursive(head.next);
		head.next.next = head;
		head.next = null;
		toString();
		return;
	}

	public void reverseLinks(NodeSLL<T> head) {
		NodeSLL<T> temp = null;
		NodeSLL<T> prev = null;
		
		while(head != null){
			temp = head;
			head = head.next;
			temp.next = prev;
			prev = temp;
		}
		
		this.sll.setHead(temp);
	}
}
