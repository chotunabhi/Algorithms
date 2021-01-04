package com.linkedList;

public class MiddleOfSLL {

	public static void main(String[] args) {
		NodeSLL<Integer> list = null;
		NodeSLL<Integer> node = new NodeSLL<>(5);
		list = node;
		
		node.next = new NodeSLL<>(9);
		node = node.next;
		
		node.next = new NodeSLL<>(6);
		node = node.next;
		
		node.next = new NodeSLL<>(8);
		node = node.next;
		
		node.next = new NodeSLL<>(1);
		node = node.next;
		
		node.next = new NodeSLL<>(2);
		node = node.next;
		
		node.next = new NodeSLL<>(7);
		node = node.next;
		
//		node.next = new NodeSLL<>(4);
//		node = node.next;
		
		System.out.println(new MiddleOfSLL().middleOfLLBF(list));
		System.out.println(new MiddleOfSLL().middleOfLL(list));
	}
	
	private <T> T middleOfLLBF(NodeSLL<T> head) {
		T data = null;
		NodeSLL<T> c = head;
		int l = 0;
		
		while(c != null) {
			l++;
			c = c.next;
		}
		
		c = head;
		
		for(int i = 1; i <= l/2; i++)
			c = c.next;
		
		data = c.data;
		
		return data;
	}

	private <T> T middleOfLL(NodeSLL<T> head) {
		T data = null;
		NodeSLL<T> slowPtr = head, fastPtr = head;
		
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		
		data = slowPtr.data;
		
		return data;
	}
}
