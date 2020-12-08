package com.linkedList;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class CycleInSLL {

	public static void main(String[] args) {
		NodeSLL<Integer> head = null;
		NodeSLL<Integer> node = new NodeSLL<>(5);
		head = node;
		
		node.next = new NodeSLL<>(9);
		node = node.next;
		
		NodeSLL<Integer> cycleNode = new NodeSLL<>(0);
		node.next = cycleNode;
		node = node.next;
		
		node.next = new NodeSLL<>(6);
		node = node.next;
		
		node.next = new NodeSLL<>(8);
		node = node.next;
		
		node.next = new NodeSLL<>(1);
		node = node.next;
		
//		node.next = cycleNode;
		
		System.out.println(new CycleInSLL().isCycleExistHS(head));
		System.out.println(new CycleInSLL().isCycleExist(head));
	}
	
	private <T> boolean isCycleExistHS(NodeSLL<T> head) {
		boolean cycleExist = Boolean.FALSE;
		NodeSLL<T> current = head;
		
		HashSet<NodeSLL<T>> nodesSet = new LinkedHashSet<>();
		
		while(current != null) {
			if(nodesSet.contains(current)) {
				cycleExist = true;
				break;
			}
			nodesSet.add(current);
			
			current = current.next;
		}
		
		return cycleExist;
	}
	
	private <T> boolean isCycleExist(NodeSLL<T> head) {
		boolean cycleExist = Boolean.FALSE;
		NodeSLL<T> slowPtr = head,fastptr = head;
		
		while(fastptr != null && fastptr.next != null) {
			fastptr = fastptr.next.next;
			slowPtr = slowPtr.next;
			
			if(slowPtr == fastptr) {
				cycleExist = Boolean.TRUE;
				break;
			}
		}
		
		return cycleExist;
	}

}
