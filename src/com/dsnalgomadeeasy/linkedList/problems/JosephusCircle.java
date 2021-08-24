package com.dsnalgomadeeasy.linkedList.problems;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;

public class JosephusCircle {
	public int alivePersonNumber(int numberOfPersons,int nthPerson) {
		int result = -1;
		
		if(numberOfPersons > 0 && nthPerson > 0) {
			NodeSLL<Integer> node = new NodeSLL<Integer>(1);
			NodeSLL<Integer> head = node;
			
			for(int i = 2; i <= numberOfPersons; i++) {
				node.setNext(new NodeSLL<Integer>(i));
				node = node.getNext();
			}
			
			node.setNext(head);
			node = node.getNext();
			
//			CLLUtil.printList(head);
			while(node.getNext() != node) {
				int i = 0;
				
				while(++i < nthPerson)
					node = node.getNext();
				
				node.setNext(node.getNext().getNext());
				node = node.getNext();
			}
			
			result = node != null ? node.getData():-1;
		}
		
		return result;
	}
}
