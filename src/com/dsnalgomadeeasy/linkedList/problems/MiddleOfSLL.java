package com.dsnalgomadeeasy.linkedList.problems;

import java.util.HashMap;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;

public class MiddleOfSLL {
	public <T extends Comparable<T>> NodeSLL<T> middleOfSLLBruteForce(NodeSLL<T> head) {
		NodeSLL<T> middleNode = null;
		int length = 0;
		NodeSLL<T> node = head;

		while (node != null) {
			length++;
			node = node.getNext();
		}

		node = head;

		while (node != null) {
			NodeSLL<T> currentListNode = node;
			int currentLength = 0;

			while (currentListNode != null) {
				currentLength++;
				currentListNode = currentListNode.getNext();
			}

			if (currentLength == (length / 2 + 1)) {
				middleNode = node;
				break;
			}

			node = node.getNext();
		}

		return middleNode;
	}

	public <T extends Comparable<T>> NodeSLL<T> middleOfSLLByFindingLength(NodeSLL<T> head) {
		int length = 0, currentLength = 0;
		NodeSLL<T> node = head;

		while (node != null) {
			length++;
			node = node.getNext();
		}

		node = head;
		currentLength = length % 2 == 0 ? 1 : 0;

		while (node != null) {
			if (currentLength++ == (length / 2))
				break;

			node = node.getNext();
		}

		return node;
	}

	public <T extends Comparable<T>> NodeSLL<T> middleOfSLLUsingHashTable(NodeSLL<T> head) {
		int length = 0;
		NodeSLL<T> node = head;
		HashMap<Integer, NodeSLL<T>> nodeMap = new HashMap<>();

		while (node != null) {
			nodeMap.put(++length, node);

			node = node.getNext();
		}

		node = nodeMap.isEmpty() ? null : nodeMap.get(length % 2 == 0 ? (length / 2) : (length / 2+1));

		return node;
	}
	
	public <T extends Comparable<T>> NodeSLL<T> middleOfSLLON(NodeSLL<T> head) {
		NodeSLL<T> slowPointer = head,fastPointer = null;
		
		if(head != null)
			fastPointer = head.getNext();

		while(fastPointer != null && fastPointer.getNext() != null) {
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();
		}

		return slowPointer;
	}
}
