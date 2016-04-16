package com.LinkedList;

import javax.swing.text.StyledEditorKit.BoldAction;

public class ReversingLinks<T> {
	SinglyLinkedList<T> sll;
	private boolean setHead = Boolean.FALSE;

	public ReversingLinks(SinglyLinkedList<T> sll) {
		super();
		this.sll = sll;
	}

	public void reverseLinksRecursive(NodeSLL<T> head) {
		if (head == null || head.next == null) {
			// base condition
			this.sll.setHead(head);
			return;
		}
		reverseLinksRecursive(head.next);
		head.next.next = head;
		head.next = null;
		return;
	}

	public void reverseLinks(NodeSLL<T> head) {
		NodeSLL<T> temp = null;
		NodeSLL<T> prev = null;

		while (head != null) {
			temp = head;
			head = head.next;
			temp.next = prev;
			prev = temp;
		}

		this.sll.setHead(temp);
	}

	public NodeSLL<T> reverseKLinksRecursive(NodeSLL<T> head, int k) {
		NodeSLL<T> current = head;
		NodeSLL<T> next = null;
		NodeSLL<T> prev = null;
		int count = k;

		/* Reverse first k nodes of linked list */
		while (current != null && count > 0) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count--;
		}

		/*
		 * next is now a pointer to (k+1)th node Recursively call for the list
		 * starting from current. And make rest of the list as next of first
		 * node
		 */
		if (next != null)
			head.next = reverseKLinksRecursive(next, k);

		// prev is now head of input list
		return prev;
	}

	public void reverseKLinks(NodeSLL<T> head, int k) {
		NodeSLL<T> current = head;
		NodeSLL<T> prevHead = head;
		NodeSLL<T> prev = null;
		NodeSLL<T> next = null;

		boolean setHead = Boolean.FALSE;

		while (current != null) {
			int count = k;
			prev = null;
			//reverse k links
			while (current != null && count > 0) {
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
				count--;
			}
			
			if(!setHead){
				this.sll.setHead(prev);
				setHead = Boolean.TRUE;
			}else{
				prevHead.next = prev;
				prevHead = head;
			}
			
			head.next = current;
			head = current;
			
		}
	}
	
	public NodeSLL<T> cloneList(){
		
		return null;
	}
}
