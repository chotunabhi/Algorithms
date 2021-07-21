package com.dsnalgomadeeasy.linkedList.problems;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;
import com.dsnalgomadeeasy.linkedList.common.SLLUtil;

public class ReverseSLL {

	public static void main(String[] args) {
		Integer[] data = new Integer[] {1,2,3,4,5};
		NodeSLL<Integer> head = SLLUtil.createSLL(data);
		SLLUtil.printList(head);
	}

}
