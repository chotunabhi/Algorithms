package com.dsnalgomadeeasy.linkedList.problems;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;

public class PartitioningSLL {
	public NodeSLL<Integer> partition(NodeSLL<Integer> head, int k){
		NodeSLL<Integer> root = new NodeSLL<>(0);
		if(head != null) {
			NodeSLL<Integer> pivot = new NodeSLL<>(k);
			
			NodeSLL<Integer> pivotNext = pivot;
			NodeSLL<Integer> rootNext = root;
			NodeSLL<Integer> current = head;
			
			while(current != null) {
				NodeSLL<Integer> next = current.getNext();
				
				if(current.getData() >= k) {
					pivotNext.setNext(current);
					pivotNext = current;
					pivotNext.setNext(null);
				}else {
					rootNext.setNext(current);
					rootNext = current;
				}
				
				current = next;
			}
			
			rootNext.setNext(pivot.getNext());
			head = root.getNext();
		}
		
		return root.getNext();
	}
}
