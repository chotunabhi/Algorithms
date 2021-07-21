package com.dsnalgomadeeasy.linkedList.problems;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;
import com.dsnalgomadeeasy.linkedList.common.SLLUtil;

public class InsertNodeInSortedSLL{

	public static void main(String[] args) {
		NodeSLL<Integer> head = null;
		InsertNodeInSortedSLL iniss = new InsertNodeInSortedSLL();
		
		head = iniss.insertNodeInSortedSLL(head,4);
		head = iniss.insertNodeInSortedSLL(head,8);
		head = iniss.insertNodeInSortedSLL(head,1);
		head = iniss.insertNodeInSortedSLL(head,6);
		SLLUtil.printList(head);
	}

	public<T extends Comparable<T>>  NodeSLL<T> insertNodeInSortedSLL(NodeSLL<T> head,T data){
		NodeSLL<T> newHead = head,previous = null;
		NodeSLL<T> node = new NodeSLL<T>(data);
		
		while(newHead != null && newHead.getData().compareTo(node.getData()) < 0) {
			previous = newHead;
			newHead = newHead.getNext();
		}
		
		node.setNext(newHead);
		
		if(previous != null)
			previous.setNext(node);
		else {
			head = node;
		}
		
		return head;
	}
}
