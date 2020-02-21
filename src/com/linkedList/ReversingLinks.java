package com.linkedList;

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

	public void reverseKLinks(NodeSLL<T> head, int k) {

		/*
		 * int count = 0;
		 * 
		 * NodeSLL<T> prev = null; NodeSLL<T> temp = null; NodeSLL<T> tail = head;
		 * NodeSLL<T> prevTail = head;
		 * 
		 * while (head != null) { if (count == k) { if (!setHead) {
		 * this.sll.setHead(temp); setHead = true; }
		 * 
		 * tail.next = head; prevTail.next = temp; prevTail = tail; tail = head; prev =
		 * null; count = 0; } else { temp = head; head = head.next; temp.next = prev;
		 * prev = temp; count++; } }
		 * 
		 * prevTail.next = temp;
		 */

		NodeSLL<T> prev = null;
		NodeSLL<T> current = head;
		NodeSLL<T> newHead = null;
		NodeSLL<T> prevTail = null;
		int count = 1;

		while (current != null) {
			NodeSLL<T> temp = current.next;
			current.next = prev;
			prev = current;

			current = temp;

			if (count % k == 0 || current == null) {
				if (newHead == null) {
					newHead = prev;
					prevTail = head;
				}

				prevTail.next = prev;
				head.next = current;
				prev = null;

				prevTail = head;
				head = current;
			}
			count++;
		}
		
		this.sll.setHead(newHead);
	}

	public NodeSLL<T> reverseKLinksRecursive(NodeSLL<T> head, int k) {
		NodeSLL<T> current = head;
		NodeSLL<T> next = null;
		NodeSLL<T> prev = null;
		int count = 0;

		while (count++ < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		if (next != null) {
			head.next = reverseKLinksRecursive(next, k);
		}

		return prev;
	}
}
