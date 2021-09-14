package com.dsnalgomadeeasy.linkedList.problems;

import java.util.HashSet;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;

public class RemoveDuplicatesInUnorderedSLL {
	public <T extends Comparable<T>> NodeSLL<T> getNonDuplicateListBruteForce(NodeSLL<T> head){
		if(head != null && head.getNext() != null) {
			NodeSLL<T> current = head;
			
			while(current != null) {
				NodeSLL<T> next = current.getNext();
				NodeSLL<T> prev = current;
				
				while(next != null) {
					if(next.getData().compareTo(current.getData()) == 0) {
						prev.setNext(next.getNext());
					}else
						prev = next;
					
					next = next.getNext();
				}
				
				current = current.getNext();
			}
		}
		
		return head;
	}
	
	public <T extends Comparable<T>> NodeSLL<T> getNonDuplicateListUsingHashSet(NodeSLL<T> head){
		if(head != null && head.getNext() != null) {
			HashSet<T> set = new HashSet<>();
			NodeSLL<T> current = head, next = head.getNext();
			
			set.add(head.getData());
			
			while(next != null) {
				if(set.contains(next.getData())) {
					current.setNext(next.getNext());
					
				}else {
					set.add(next.getData());
					current = next;
				}
				
				next = next.getNext();
			}
		}
		
		return head;
	}
}
