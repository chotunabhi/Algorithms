package com.dsnalgomadeeasy.linkedList.problems;

import java.util.HashSet;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;

public class CycleInSLL {
	public <T extends Comparable<T>>  boolean usingHashTable(NodeSLL<T> head) {
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
	
	public <T extends Comparable<T>>  boolean usingSinglePass(NodeSLL<T> head) {
		Boolean hasCycle = false;
		
		NodeSLL<T> slowPointer = head,fastPointer = head;
		
		while(fastPointer != null && fastPointer.getNext() != null) {
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();
			
			if((hasCycle = slowPointer == fastPointer))
				break;
		}
		
		return hasCycle;
	} 

}
