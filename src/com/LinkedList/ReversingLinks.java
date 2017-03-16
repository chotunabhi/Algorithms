package com.LinkedList;

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

	public void reverseKLinks(NodeSLL<T> head,int k){
		int count = 0;

		NodeSLL<T> prev = null;
		NodeSLL<T> temp = null;
		NodeSLL<T> tail = head;
		NodeSLL<T> prevTail = head;

		while(head != null ){
			if(count == k){
				if(!setHead){
					this.sll.setHead(temp);
					setHead = true;
				}

				tail.next = head;
				prevTail.next = temp;
				prevTail = tail;
				tail = head;
				prev = null;
				count = 0;
			}else{
				temp = head;
				head = head.next;
				temp.next = prev;
				prev = temp;
				count++;
			}
		}
		
		prevTail.next = temp;
	}
	public NodeSLL<T> cloneList(){

		return null;
	}
}
