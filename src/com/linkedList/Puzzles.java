package com.linkedList;

public class Puzzles {

	public static void main(String[] args) {
		NodeSLL<Integer> list = null;
		Puzzles p = new Puzzles();
		NodeSLL<Integer> node = new NodeSLL<>(5);
		/*	list = node;
		
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
		
		
		p.printListFromEnd(list);
		System.out.println();
		System.out.println(p.evenOrOddListON(list)?"ODD":"EVEN");
		System.out.println(p.evenOrOddListONBy2(list)?"ODD":"EVEN");
		*/
		NodeSLL<Integer> list1 = null,list2 = null;
		node = new NodeSLL<>(1);
		list1 = node;
		
		node.next = new NodeSLL<>(3);
		node = node.next;
		
		node.next = new NodeSLL<>(8);
		node = node.next;
		
		node.next = new NodeSLL<>(10);
		node = node.next;
		
		node = new NodeSLL<>(2);
		list2 = node;
		
		node.next = new NodeSLL<>(6);
		node = node.next;
		
		node.next = new NodeSLL<>(7);
		node = node.next;
		
		node.next = new NodeSLL<>(9);
		node = node.next;
		
//		node.next = new NodeSLL<>(11);
//		node = node.next;
//		
//		node.next = new NodeSLL<>(12);
//		node = node.next;
		
		p.printList(p.mergedList(list1, list2));
//		p.printList(p.mergedListRec(list1, list2));
		
	}

	private <T> void printList(NodeSLL<T> head) {
		NodeSLL<T> current = head;
		
		while(current != null) {
			System.out.print(current.data+" ");
			current = current.next;
		}
		
		System.out.println();
	}
	private <T> void printListFromEnd(NodeSLL<T> head) {
		if(head == null)
			return;
		
		printListFromEnd(head.next);
		System.out.print(head.data+" ");
	}
	
	private <T> boolean evenOrOddListON(NodeSLL<T> head) {
		boolean isOdd = Boolean.FALSE;
		NodeSLL<T> c = head;
		int l = 0;
		
		while(c != null) {
			l++;
			c = c.next;
		}
		
		isOdd = (l%2 != 0);
		
		return isOdd;
	}
	
	private <T> boolean evenOrOddListONBy2(NodeSLL<T> head) {
		boolean isOdd = Boolean.FALSE;
		NodeSLL<T> c = head;
		int l = 0;
		
		while(c != null && c.next != null) {
			c = c.next.next;
		}
		
		isOdd = (c != null);
		
		return isOdd;
	}
	
	public <T extends Comparable<T>> NodeSLL<T> mergedList(NodeSLL<T> l1,NodeSLL<T> l2){
		NodeSLL<T> h1 = l1,h2 = l2;
		NodeSLL<T> p1 = null;
		
		while(h1 != null && h2 != null) {
			if(h1.data.compareTo(h2.data) < 0) {
				p1 = h1;
				h1 = h1.next;
			}
			
			if(h1 != null && h1.data.compareTo(h2.data) > 0 && p1.data.compareTo(h2.data) < 0) {
				p1.next = h2;
				
				while(h2 != null && h2.data.compareTo(h1.data) < 0) {
					p1 = h2;
					h2 = h2.next;
				}
				
				p1.next = h1;
			}
		}
		
		if(h1 == null) {
			p1.next = h2;
		}
		
			
		return l1;
	}
	
	public <T extends Comparable<T>> NodeSLL<T> mergedListRec(NodeSLL<T> l1,NodeSLL<T> l2){
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		
		NodeSLL<T> head;
		
		if(l1.data.compareTo(l2.data) < 0) {
			head = l1;
			head.next = mergedListRec(l1.next, l2);
		}else {
			head = l2;
			head.next = mergedListRec(l1, l2.next);
		}
		
		return head;
	}
}
