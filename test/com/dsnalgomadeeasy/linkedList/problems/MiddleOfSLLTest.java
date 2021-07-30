package com.dsnalgomadeeasy.linkedList.problems;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;
import com.dsnalgomadeeasy.linkedList.common.SLLUtil;

public class MiddleOfSLLTest {
	MiddleOfSLL middleOfSLL = new MiddleOfSLL();
	
	@Test
	public void testMiddleOfSLLNullList() {
		testImplementationMethods(null, null);
	}
	
	@Test
	public void testMiddleOfSLLSingleNode() {
		NodeSLL<Integer> head = new NodeSLL<Integer>(1);
		
		testImplementationMethods(head, head);
	}
	
	@Test
	public void testMiddleOfSLLTwoNodes() {
		NodeSLL<Integer> head = SLLUtil.createSLL(new Integer[] {1,2});
		
		testImplementationMethods(head, head);
	}
	
	@Test
	public void testMiddleOfSLLOddNodes() {
		NodeSLL<Integer> head = SLLUtil.createSLL(new Integer[] {1,2,3,4,5});
		
		testImplementationMethods(head, head.getNext().getNext());
	}
	
	@Test
	public void testMiddleOfSLLEvenNodes() {
		NodeSLL<Integer> head = SLLUtil.createSLL(new Integer[] {1,2,3,4});
		
		testImplementationMethods(head, head.getNext());
	}
	
	private <T extends Comparable<T>> void testImplementationMethods(NodeSLL<T> head,NodeSLL<T> expectedResult) {
		assertEquals(expectedResult, middleOfSLL.middleOfSLLBruteForce(head));
		assertEquals(expectedResult, middleOfSLL.middleOfSLLByFindingLength(head));
		assertEquals(expectedResult, middleOfSLL.middleOfSLLUsingHashTable(head));
		assertEquals(expectedResult, middleOfSLL.middleOfSLLON(head));
	}

}
