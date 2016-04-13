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
		System.out.println(integerSLL);

		ReversingLinks<Integer> rl = new ReversingLinks<>(integerSLL);
		rl.reverseKLinks(integerSLL.getHead(), 2);
		
		System.out.println(integerSLL);
	}

}
