package com.LinkedList;

public class TestingSinglyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList<Integer> integerSLL = new SinglyLinkedList<Integer>();
		integerSLL.insertAtHead(1);
		integerSLL.insertAtEnd(3);
		integerSLL.insertAtEnd(5);
		
		System.out.println(integerSLL);
		
		integerSLL.insertAtHead(0);
		
		System.out.println(integerSLL);
		integerSLL.insertAtPosition(6, 4);
		System.out.println(integerSLL);

		ReversingLinks<Integer> rl = new ReversingLinks<>(integerSLL);
		rl.reverseLinks(integerSLL.getHead());
		
		System.out.println(integerSLL);
	}

}
