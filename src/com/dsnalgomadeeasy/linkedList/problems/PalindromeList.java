package com.dsnalgomadeeasy.linkedList.problems;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;

public class PalindromeList {
	public <T extends Comparable<T>> boolean isListPalindromeSplittingList(NodeSLL<T> head) {
		boolean result = true;

		if (head != null) {
			// Find middle node
			NodeSLL<T> slowPointer = head, fastPointer = null, secondList = null;

			if (head != null)
				fastPointer = head.getNext();

			while (fastPointer != null && fastPointer.getNext() != null) {
				slowPointer = slowPointer.getNext();
				fastPointer = fastPointer.getNext().getNext();
			}

			secondList = slowPointer.getNext();
			slowPointer.setNext(null);

			ReverseSLL rSLL = new ReverseSLL();
			secondList = rSLL.reverseSLLIterative(secondList);

			while (head != null && secondList != null) {
				if (head.getData().compareTo(secondList.getData()) != 0) {
					result = false;
					break;
				}
				
				head = head.getNext();
				secondList = secondList.getNext();
			}
		}

		return result;
	}
}