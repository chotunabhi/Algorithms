package com.dsnalgomadeeasy.linkedList.problems;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;

public class SumOfTwoNumbers {
	public NodeSLL<Integer> sum(NodeSLL<Integer> n1, NodeSLL<Integer> n2) {
		NodeSLL<Integer> result = null;

		if (n1 == null)
			result = n2;
		else if (n2 == null)
			result = n1;
		else {
			Integer carry = 0;
			NodeSLL<Integer> digitNode = null;
			NodeSLL<Integer> node = null;
			Integer sum = 0;

			while (n1 != null && n2 != null) {
				sum = n1.getData() + n2.getData() + carry;

				carry = sum / 10;

				node = new NodeSLL(sum % 10);

				if (result == null) {
					result = node;
					digitNode = node;
				} else {
					digitNode.setNext(node);
					digitNode = digitNode.getNext();
				}

				n1 = n1.getNext();
				n2 = n2.getNext();
			}
			
			NodeSLL<Integer> leftNodes = null;
			
			if(n1 != null)
				leftNodes = n1;
			else if(n2 != null)
				leftNodes = n2;
			
			while (leftNodes != null) {
				sum = leftNodes.getData() + carry;

				carry = sum / 10;

				node = new NodeSLL(sum % 10);

				digitNode.setNext(node);
				digitNode = digitNode.getNext();
				
				leftNodes = leftNodes.getNext();
			}
			
			if(carry > 0) {
				digitNode.setNext(new NodeSLL(carry));
			}
		}

		return result;
	}
}
