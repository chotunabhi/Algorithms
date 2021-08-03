package com.dsnalgomadeeasy.linkedList.problems;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;

public class Merge2SortedList {
	public <T extends Comparable<T>> NodeSLL<T> mergedListRecursive(NodeSLL<T> head1,NodeSLL<T> head2){
		NodeSLL<T> mergedListHead = null;
		
		if(head1 == null)
			mergedListHead = head2;
		else if(head2 == null)
			mergedListHead = head1;
		else {
			if(head1.getData().compareTo(head2.getData()) < 0) {
				mergedListHead = head1;
				mergedListHead.setNext(mergedListRecursive(head1.getNext(), head2));
			}else {
				mergedListHead = head2;
				mergedListHead.setNext(mergedListRecursive(head1, head2.getNext()));
			}
		}
		
		return mergedListHead;
	}
	
	public <T extends Comparable<T>> NodeSLL<T> mergedList(NodeSLL<T> head1,NodeSLL<T> head2){
		NodeSLL<T> head = new NodeSLL<T>(null);
		NodeSLL<T> current = head;
		
		while(head1 != null && head2 != null) {
			if(head1.getData().compareTo(head2.getData()) < 0) {
				current.setNext(head1);
				head1 = head1.getNext();
			}else {
				current.setNext(head2);
				head2 = head2.getNext();
			}
			
			current = current.getNext();
		}
		
		if(head1 != null)
			current.setNext(head1);
		else if(head2 != null)
			current.setNext(head2);
		
		return head.getNext();
	}
}
