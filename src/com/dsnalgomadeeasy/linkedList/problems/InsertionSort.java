package com.dsnalgomadeeasy.linkedList.problems;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;

public class InsertionSort {
	public <T extends Comparable<T>> NodeSLL<T> sort(NodeSLL<T> head){
		if(head == null || head.getNext() == null)
			return head;

		NodeSLL<T> newHead = new NodeSLL<T>(head.getData());
		NodeSLL<T> pointer = head.getNext();

		while(pointer != null) {
			NodeSLL<T> next = pointer.getNext();
			NodeSLL<T> innerPointer = newHead;
			
			//pointer < nh
			if(pointer.getData().compareTo(newHead.getData()) <= 0) {
				NodeSLL<T> oldHead = newHead;
				newHead = pointer;
				pointer.setNext(oldHead);
			}else {
				while(innerPointer.getNext() != null) {
					// ip < p <= ip.next
					if(innerPointer.getData().compareTo(pointer.getData()) < 0 && innerPointer.getNext().getData().compareTo(pointer.getData()) >= 0) {
						NodeSLL<T> oldNext = innerPointer.getNext();
						innerPointer.setNext(pointer);
						pointer.setNext(oldNext);
					}

					innerPointer = innerPointer.getNext();
				}

				if(innerPointer.getNext() == null && pointer.getData().compareTo(innerPointer.getData()) >  0) {
					innerPointer.setNext(pointer);
					pointer.setNext(null);
				}
			}
			pointer = next;
		}

		return newHead;
	}
}