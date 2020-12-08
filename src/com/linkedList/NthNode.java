package com.linkedList;

public class NthNode {

	public static void main(String[] args) {
		NodeSLL<Integer> head = null;
		NodeSLL<Integer> node = new NodeSLL<>(5);
		head = node;
		
		node.next = new NodeSLL<>(9);
		node = node.next;
		
		node.next = new NodeSLL<>(0);
		node = node.next;
		
		node.next = new NodeSLL<>(6);
		node = node.next;
		
		node.next = new NodeSLL<>(8);
		node = node.next;
		
		node.next = new NodeSLL<>(1);
		node = node.next;
		
		int n = -1;
		System.out.println(new NthNode().nthNodeFromEnd(head, n));
		System.out.println(new NthNode().nthNodeFromEndRec(head, n));
		System.out.println(new NthNode().nthNodeFromEndBF(head, n));
	}

	private <T> T nthNodeFromEnd(NodeSLL<T> head,int n) {
		T nthNode = null;
		int c = n;
		NodeSLL<T> prev = head,current = null;
		
		while(c-- > 1 && prev != null) 
			prev = prev.next;
		
		if(c == 0) {
			while(prev != null) {
				current = (current == null)?head:current.next;
				
				prev = prev.next;
			}
		}
		
		if(current !=null)
			nthNode = current.data;
		
		return nthNode;
	}
	
	private static int counter = 0;
	private <T> T nthNodeFromEndRec(NodeSLL<T> head,int n) {
		T nthNode = null;
		
		if(head != null) {
			nthNode = (T) nthNodeFromEndRec(head.next, n);
			
			counter++;
			
			if(counter == n)
				nthNode = head.data;
		}
		
		return nthNode;
	}
	
	private <T> T nthNodeFromEndBF(NodeSLL<T> head,int n) {
		T nthNode = null;
		NodeSLL<T> current = head,prev = null,tail = null;
		
		while(n >= 1) {
			current = head;
			prev = null;

			if(current == tail)
				break;
			
			while(current != tail) {
				prev = current;
				current = current.next;
			}
			
			tail = prev;
			n--;
		}
		
		if(n == 0 && prev != null)
			nthNode = prev.data;
		
		return nthNode;
	}
}
