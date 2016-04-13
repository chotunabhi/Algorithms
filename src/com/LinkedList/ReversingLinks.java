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

	public NodeSLL<T> reverseKLinks(NodeSLL<T> head,int k){
		NodeSLL<T> current = head;
		NodeSLL<T> next = null;
		NodeSLL<T> prev = null;

		int count = 0;

		/* Reverse first k nodes of linked list */
		while (count < k && current != null) 
		{
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		/* next is now a pointer to (k+1)th node 
	          Recursively call for the list starting from current.
	          And make rest of the list as next of first node */
		if (next != null) 
			head.next = reverseKLinks(next, k);

		// prev is now head of input list
		return prev;
	}
}
