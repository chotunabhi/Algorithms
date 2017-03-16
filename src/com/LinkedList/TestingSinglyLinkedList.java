package com.LinkedList;

public class TestingSinglyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList<Integer> integerSLL = new SinglyLinkedList<Integer>();
		integerSLL.insertAtHead(1);
		integerSLL.insertAtEnd(3);
		integerSLL.insertAtEnd(5);
		integerSLL.insertAtHead(0);
		integerSLL.insertAtPosition(6, 4);
		integerSLL.insertAtEnd(7);
		integerSLL.insertAtEnd(8);
		integerSLL.insertAtEnd(9);
		System.out.println(integerSLL);

		ReversingLinks<Integer> rl = new ReversingLinks<>(integerSLL);
//		ReversingLinks<Integer> rlCopy = rl.
		rl.reverseKLinks(integerSLL.getHead(), 3);
		System.out.println(integerSLL);
		integerSLL.setHead(rl.reverseKLinksRecursive(integerSLL.getHead(), 3));
		
		System.out.println(integerSLL);
	}

}
