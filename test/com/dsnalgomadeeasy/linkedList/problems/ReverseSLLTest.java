package com.dsnalgomadeeasy.linkedList.problems;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;
import com.dsnalgomadeeasy.linkedList.common.SLLUtil;

public class ReverseSLLTest {

	@Test
	public void testReverseSLLIterativeForNullList() {
		NodeSLL<Integer> head = null;
		testImplementationMethods(head);
	}
	
	@Test
	public void testReverseSLLIterativeForOneNode() {
		NodeSLL<Integer> head = SLLUtil.createSLL(new Integer[] {1});
		testImplementationMethods(head);
	}
	
	@Test
	public void testReverseSLLIterativeForTwoNodes() {
		NodeSLL<Integer> head = SLLUtil.createSLL(new Integer[] {1,2});
		testImplementationMethods(head);
	}
	
	@Test
	public void testReverseSLLIterativeForNNodes() {
		NodeSLL<Integer> head = SLLUtil.createSLL(new Integer[] {1,2,3,4,5,6,7});
		testImplementationMethods(head);
	}
	
	private <T extends Comparable<T>> void testImplementationMethods(NodeSLL<T> head) {
		ReverseSLL reverseSLL = new ReverseSLL();
		
		NodeSLL<T> clonedHead = SLLUtil.cloneList(head);
		NodeSLL<T> reverseHead = reverseSLL.reverseSLLIterative(clonedHead);
		
		assertTrue(compareReversedLists(head, reverseHead));
		
		clonedHead = SLLUtil.cloneList(head);
		reverseHead = reverseSLL.reverseSLLRecursive(clonedHead);
		
		assertTrue(compareReversedLists(head, reverseHead));
	}
	
	private <T extends Comparable<T>> boolean compareReversedLists(NodeSLL<T> head,NodeSLL<T> reverseHead) {
		boolean result = true;
		NodeSLL<T> head1 = head,head2 = reverseHead;
		Stack<T> stack = new Stack<>();
		
		while(head2 != null) {
			stack.push(head2.getData());
			head2 = head2.getNext();
		}
		
		while(head1 != null && !stack.isEmpty()) {
			if(head1.getData().compareTo(stack.pop()) != 0) {
				result = false;
				break;
			}

			head1 = head1.getNext();
		}
		
		result = head1 ==null && stack.isEmpty();
		
		return result;
	}
}
