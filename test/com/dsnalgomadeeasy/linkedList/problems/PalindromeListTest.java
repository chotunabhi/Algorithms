package com.dsnalgomadeeasy.linkedList.problems;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;
import com.dsnalgomadeeasy.linkedList.common.SLLUtil;

@RunWith(Parameterized.class)
public class PalindromeListTest {

	private PalindromeList pl;
	private NodeSLL<Integer> head;
	private boolean expectedResult;
	
	public PalindromeListTest(NodeSLL<Integer> head, boolean expectedResult) {
		this.head = head;
		this.expectedResult = expectedResult;
	}

	@Before
	public void init() {
		pl = new PalindromeList();
		
	}
	
	@Parameterized.Parameters
	public static Collection testData() {
		return Arrays.asList(new Object[][] {
			{null, true},
			{SLLUtil.createSLL(new Integer[] {1}), true},
			{SLLUtil.createSLL(new Integer[] {1,1}), true},
			{SLLUtil.createSLL(new Integer[] {1,2}), false},
			{SLLUtil.createSLL(new Integer[] {1,2,3}), false},
			{SLLUtil.createSLL(new Integer[] {1,2,1}), true},
			{SLLUtil.createSLL(new Integer[] {1,2,3,1,2}), false},
			{SLLUtil.createSLL(new Integer[] {1,2,3,2,1}), true},
			{SLLUtil.createSLL(new Integer[] {1,2,1,1}), false},
			{SLLUtil.createSLL(new Integer[] {1,2,3,4,4,3,2,1}), true}
		});
	}
	
	@Test
	public void testIsListPalindromeSplittingList() {
		assertEquals(expectedResult, pl.isListPalindromeSplittingList(head));
	}
	
	@Test
	public void testIsListPalindromeReversingList() {
		assertEquals(expectedResult, pl.isListPalindromeReversingList(head));
	}
	
	@Test
	public void testIsListPalindromeUsingStack() {
		assertEquals(expectedResult, pl.isListPalindromeUsingStack(head));
	}
}
