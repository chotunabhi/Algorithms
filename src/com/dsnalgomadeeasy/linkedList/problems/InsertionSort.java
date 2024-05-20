package com.dsnalgomadeeasy.linkedList.problems;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;

public class InsertionSort {
	public <T extends Comparable<T>> NodeSLL<T> sort(NodeSLL<T> head){
		if(head == null || head.getNext() == null)
			return head;

		NodeSLL<T> newHead = new NodeSLL<T>(head.getData());

		return newHead;
	}
}