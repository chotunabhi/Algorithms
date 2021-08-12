package com.dsnalgomadeeasy.linkedList.problems;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;
import com.dsnalgomadeeasy.linkedList.common.SLLUtil;

@RunWith(Parameterized.class)
public  class MiddleOfSLLTest{
	private MiddleOfSLL middleOfSLL;
	private NodeSLL<Integer> expectedResult;
	private NodeSLL<Integer> head;
	
	public MiddleOfSLLTest(NodeSLL<Integer> expectedResult, NodeSLL<Integer> head) {
		this.expectedResult = expectedResult;
		this.head = head;
	}
	
	@Before
	public void init() {
		middleOfSLL = new MiddleOfSLL();
	}
	
	@Parameterized.Parameters
	public static Collection listData() {
		NodeSLL<Integer> singleNode = new NodeSLL<Integer>(1);
		NodeSLL<Integer> twoNode = SLLUtil.createSLL(new Integer[] {1,2});
		NodeSLL<Integer> oddNode = SLLUtil.createSLL(new Integer[] {1,2,3,4,5});
		NodeSLL<Integer> evenNode = SLLUtil.createSLL(new Integer[] {1,2,3,4});
		
		return Arrays.asList(new Object[][] {
			{null,null},
			{twoNode,twoNode},
			{oddNode.getNext().getNext(),oddNode},
			{evenNode.getNext(),evenNode}
		});
	}
	
	@Test
	public void testMiddleOfSLLBruteForce() {
		assertEquals(expectedResult, middleOfSLL.middleOfSLLBruteForce(head));
	}
	
	@Test
	public void testMiddleOfSLLByFindingLength() {
		assertEquals(expectedResult, middleOfSLL.middleOfSLLByFindingLength(head));
	}

	@Test
	public void testMiddleOfSLLUsingHashTable() {
		assertEquals(expectedResult, middleOfSLL.middleOfSLLUsingHashTable(head));
	}
	
	@Test
	public void testMiddleOfSLLON() {
		assertEquals(expectedResult, middleOfSLL.middleOfSLLON(head));
	}
}
