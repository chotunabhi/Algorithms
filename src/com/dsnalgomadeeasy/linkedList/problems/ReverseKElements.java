package com.dsnalgomadeeasy.linkedList.problems;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;

public class ReverseKElements {
	public <T extends Comparable<T>> NodeSLL<T> reverseKLinks(NodeSLL<T> head,int k){
		NodeSLL<T> newHead = k > 0 ? null : head;
		
		return newHead;
	}
	
	public <T extends Comparable<T>> NodeSLL<T> reverseKLinksRecursive(NodeSLL<T> head,int k){
		NodeSLL<T> current = head,previous = k > 0 ? null : head;
		
		return previous;
	}
}
