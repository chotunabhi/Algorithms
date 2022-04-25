package com.dsnalgomadeeasy.linkedList.problems;

import java.util.HashSet;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;

public class CycleInSLL {
	public <T extends Comparable<T>>  boolean usingHashTable(NodeSLL<T> head) {
		Boolean hasCycle = false;
		
		NodeSLL<T> node = head;
		HashSet<NodeSLL<T>> hs = new HashSet<>();
		
		while(node != null) {
			if(hs.contains(node)) {
				hasCycle = true;
				break;
			}
			
			hs.add(node);
			node = node.getNext();
		}
		
		return hasCycle;
	}
	
	public <T extends Comparable<T>>  boolean usingSinglePass(NodeSLL<T> head) {
		Boolean hasCycle = false;
		
		NodeSLL<T> slowPointer = head,fastPointer = head;
		
		while(fastPointer != null && fastPointer.getNext() != null) {
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();
			
			if(slowPointer == fastPointer) {
				hasCycle = true;
				break;
			}
		}
		
		return hasCycle;
	} 

}
