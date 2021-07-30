package com.dsnalgomadeeasy.linkedList.problems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;
import com.dsnalgomadeeasy.linkedList.common.SLLUtil;

public class CycleInSLLTest {
	CycleInSLL cis = new CycleInSLL();

	@Test
	public void testCycleInSLLForNullList() {
		NodeSLL<Integer> head = null;
		
		testMethods(head, false);
	}
	
	@Test
	public void testCycleInSLLForSingleNonCyclicNodeList() {
		testMethods(SLLUtil.createSLL(new Integer[] {1}), false);
	}
	
	@Test
	public void testCycleInSLLForSingleCyclicNodeList() {
		NodeSLL<Integer> head = new NodeSLL<Integer>(1);
		head.setNext(head);
		
		testMethods(head,true);
	}
	
	@Test
	public void testCycleInSLLForTwoNonCyclicNodeList() {
		testMethods(SLLUtil.createSLL(new Integer[] {1,2}), false);
	}
	
	@Test
	public void testCycleInSLLForTwoCyclicNodeList() {
		NodeSLL<Integer> head = new NodeSLL<Integer>(1);
		NodeSLL<Integer> node = new NodeSLL<Integer>(2);
		head.setNext(node);
		node.setNext(head);
		
		testMethods(head,true);
	}
	
	@Test
	public void testCycleInSLLForMoreThanTwoNonCyclicNodeList() {
		NodeSLL<Integer> head = SLLUtil.createSLL(new Integer[] {1,2,3,4,5});
		
		testMethods(head,false);
	}
	
	@Test
	public void testCycleInSLLForMoreThanTwoCyclicNodeCycleFirstToLastList() {
		NodeSLL<Integer> head = SLLUtil.createSLL(new Integer[] {1,2,3,4,5});
		NodeSLL<Integer> node = head;
		
		while(node.getNext() != null)
			node = node.getNext();
		
		node.setNext(head);
		
		testMethods(head,true);
	}
	
	@Test
	public void testCycleInSLLForMoreThanTwoCyclicNodeCycleInMiddleList() {
		NodeSLL<Integer> head = SLLUtil.createSLL(new Integer[] {1,2,3,4,5});
		NodeSLL<Integer> tail = head,node = null;
		
		while(tail.getNext() != null) {
			if(tail.getData() == 3)
				node = tail;
			
			tail = tail.getNext();
		}
		
		tail.setNext(node);
		
		testMethods(head,true);
	}
	
	private void testMethods(NodeSLL<Integer> head, Boolean result) {
		assertEquals(cis.usingHashTable(head), result);
		assertEquals(cis.usingSinglePass(head), result);
	}
}
