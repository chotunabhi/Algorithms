package com.linkedList;

public class CircularListNode<T> {
	public NodeSLL<T> head = null;
	private int size = 0;

	public int getSize() {
		return size;
	}

	public void insertAtHead(T value) {
		NodeSLL<T> node = getNode(value);

		insert(node);

		head = node;
		size++;
	}

	public void insertAtTail(T value) {
		NodeSLL<T> node = getNode(value);

		insert(node);

		if (head == null)
			head = node;

		size++;
	}

	private void insert(NodeSLL<T> node) {
		if (head != null) {
			NodeSLL<T> temp = head;

			while (temp.next != head)
				temp = temp.next;

			temp.next = node;
			node.next = head;
		}
	}

	public NodeSLL<T> deleteAtHead() {
		NodeSLL<T> node = null;

		if (head == null)
			node = null;
		else if (head.next == head) {
			node = head;
			head = null;
		} else {
			NodeSLL<T> tail = head;

			while (tail.next != head)
				tail = tail.next;

			node = tail.next;
			head = head.next;
			tail.next = head;
		}

		size = size > 0 ? size - 1 : 0;

		return node;
	}

	public NodeSLL<T> deleteAtTail() {
		NodeSLL<T> node = null;

		if (head == null)
			node = null;
		else if (head.next == head) {
			node = head;
			head = null;
		} else {
			NodeSLL<T> tail = head;

			while (tail.next.next != head)
				tail = tail.next;

			node = tail.next;
			tail.next = head;
		}

		size = size > 0 ? size - 1 : 0;

		return node;
	}

	public NodeSLL<T> delete(T data) {
		NodeSLL<T> node = null;

		if (head == null)
			node = null;
		else if (head.next == head) {
			if (head.data == data) {
				node = head;
				head = null;
			} else {
				node = null;
			}
		} else {
			NodeSLL<T> tail = head;
			int count = 0;

			while (tail.next.data != data && count++ < size)
				tail = tail.next;
			
			if(tail.next == head){
				head = head.next;
			}
			
			node = tail.next;
			tail.next = tail.next.next;
			node.next = node;
		}
		
		size = node == null?size:size - 1;
		
		return node;
	}

	private NodeSLL<T> getNode(T value) {
		NodeSLL<T> node = new NodeSLL<>();
		node.data = value;
		node.next = node;

		return node;
	}

	@Override
	public String toString() {
		NodeSLL<T> node = head;
		String pointer = " -> ";
		StringBuffer result = new StringBuffer();

		if (node == null)
			result.append("");
		else if (node.next == head) {
			result.append(node.data);
			result.append(pointer);
		} else {
			do {
				result.append(node.data);
				result.append(pointer);

				node = node.next;
			} while (node != head);
		}

		return result.toString();
	}
}
