package com.dsnalgomadeeasy.linkedList.problems;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;
import com.dsnalgomadeeasy.linkedList.common.SLLUtil;

@RunWith(Parameterized.class)
public class ExchangeAdjacentElementsTest {
	private NodeSLL<Integer> head;
	private Integer[] expectedResult;
	private ExchangeAdjacentElements eae;
	
	public ExchangeAdjacentElementsTest(NodeSLL<Integer> head, Integer[] expectedResult) {
		this.head = head;
		this.expectedResult = expectedResult;
	}

	@Before
	public void init() {
		eae = new ExchangeAdjacentElements();
	}

	@Parameterized.Parameters
	public static Collection testData() {
		return Arrays.asList(new Object[][] {
			{null, null},
			{SLLUtil.createSLL(new Integer[] {1}), new Integer[] {1}},
			{SLLUtil.createSLL(new Integer[] {1,2}), new Integer[] {2,1}},
			{SLLUtil.createSLL(new Integer[] {1,2,3}), new Integer[] {2,1,3}},
			{SLLUtil.createSLL(new Integer[] {1,2,3,4}), new Integer[] {2,1,4,3}},
			{SLLUtil.createSLL(new Integer[] {1,2,3,4,5}), new Integer[] {2,1,4,3,5}}
		});
	}
	
//	@Test
	public void testExchangeAdjacentElementsIterative() {
		assertArrayEquals(expectedResult, SLLUtil.getArrayFromList(eae.exchangeAdjacentElementsIterative(head)));
	}

	@Test
	public void testExchangeAdjacentElementsRecursive() {
		assertArrayEquals(expectedResult, SLLUtil.getArrayFromList(eae.exchangeAdjacentElementsRecursive(head)));
	}
}
