package com.dsnalgomadeeasy.linkedList.problems;

import java.util.HashSet;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;

public class CycleInSLL {

	public static void main(String[] args) {
		NodeSLL<Integer> head = new NodeSLL<>(1);
		NodeSLL<Integer> next = head;
		NodeSLL<Integer> loop = null;
		
//		next.setNext(new NodeSLL<>(2));
//		next = next.getNext();
//		
//		next.setNext(new NodeSLL<>(3));
//		next = next.getNext();
		loop = next;
//		
//		next.setNext(new NodeSLL<>(4));
//		next = next.getNext();
//		
//		next.setNext(new NodeSLL<>(5));
//		next = next.getNext();
//		
//		next.setNext(new NodeSLL<>(6));
//		next = next.getNext();
//		
//		next.setNext(new NodeSLL<>(7));
//		next = next.getNext();
		
//		next.setNext(loop);
		
		System.out.println(new CycleInSLL().usingHashTable(head));
		System.out.println(new CycleInSLL().usingHashTable(head));
	}
	
	private <T> boolean usingHashTable(NodeSLL<T> head) {
		Boolean hasCycle = false;
		
		NodeSLL<T> node = head;
		HashSet<NodeSLL<T>> hs = new HashSet<>();
		
		while(!hs.contains(node) && node != null) {
			hs.add(node);
			node = node.getNext();
		}
		
		hasCycle = hs.contains(node);
		
		return hasCycle;
	}
	
	private <T> boolean usingSinglePass(NodeSLL<T> head) {
		Boolean hasCycle = false;
		
		NodeSLL<T> slowPointer = head,fastPointer = head.getNext();
		
		while(slowPointer != null && fastPointer != null && fastPointer.getNext() != null && slowPointer != fastPointer) {
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();
		}
		
		hasCycle = slowPointer == fastPointer;
		
		return hasCycle;
	} 

}
