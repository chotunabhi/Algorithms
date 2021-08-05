package com.dsnalgomadeeasy.linkedList.problems;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;

public class SplitCLL {
	public <T extends Comparable<T>> NodeSLL<T>[] splitCLLInto2CLL(NodeSLL<T> head){
		NodeSLL<T>[] lists = new NodeSLL[] {null,null};
		
		if(head != null) {
			NodeSLL<T> slowPointer = head, fastPointer = head.getNext();
			NodeSLL<T> temp = fastPointer.getNext();
			
			while(fastPointer != head && fastPointer.getNext() != head) {
				slowPointer = slowPointer.getNext();
				temp = fastPointer.getNext();
				fastPointer = fastPointer.getNext().getNext();
			}
			
			lists[0] = head;
			
			if(head.getNext() != head)
				lists[1] = slowPointer.getNext();
			
			//Even List
			if(fastPointer.getNext() == head) {
				fastPointer.setNext(slowPointer.getNext());
			}else {
				//odd list
				temp.setNext(slowPointer.getNext());
			}
			
			slowPointer.setNext(head);
		}
		
		return lists;
	}
}
