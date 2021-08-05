package com.dsnalgomadeeasy.linkedList.problems;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;
import com.dsnalgomadeeasy.linkedList.common.SLLUtil;

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
	
	public <T extends Comparable<T>> boolean isListPalindromeReversingList(NodeSLL<T> head) {
		boolean result = true;

		if (head != null) {
			NodeSLL<T> reversedList = SLLUtil.cloneList(head);
			
			ReverseSLL rSLL = new ReverseSLL();
			reversedList = rSLL.reverseSLLRecursive(reversedList);
			
			while(head != null && reversedList != null) {
				if(head.getData().compareTo(reversedList.getData()) != 0) {
					result = false;
					break;
				}
				
				head = head.getNext();
				reversedList = reversedList.getNext();
			}
			
			
		}

		return result;
	}
	
	public <T extends Comparable<T>> boolean isListPalindromeUsingStack(NodeSLL<T> head) {
		boolean result = true;

		if (head != null) {
			Stack<T> listStack = new Stack<>();
			NodeSLL<T> slowPointer = head,fastPointer = head.getNext();
			
			while(fastPointer != null && fastPointer.getNext() != null) {
				slowPointer = slowPointer.getNext();
				fastPointer = fastPointer.getNext().getNext();
			}
			
			Boolean isOddList = fastPointer == null;
			fastPointer = head;
			
			while(fastPointer != slowPointer.getNext()) {
				listStack.push(fastPointer.getData());
				
				fastPointer = fastPointer.getNext();
			}
			
			if(isOddList)
				listStack.pop();
			
			fastPointer = slowPointer.getNext();
			
			while(!listStack.isEmpty() && fastPointer != null) {
				if(listStack.pop().compareTo(fastPointer.getData()) != 0) {
					result = false;
					break;
				}
				
				fastPointer = fastPointer.getNext();
			}
		}

		return result;
	}
}