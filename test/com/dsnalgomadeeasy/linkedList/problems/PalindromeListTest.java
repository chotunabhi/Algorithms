package com.dsnalgomadeeasy.linkedList.problems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;
import com.dsnalgomadeeasy.linkedList.common.SLLUtil;

public class PalindromeListTest {

	PalindromeList pl = new PalindromeList();
	
	@Test
	public void testPalindromeListWithNull() {
		testImplementation(null, true);
	}
	
	@Test
	public void testPalindromeListWithSingleNode() {
		testImplementation(SLLUtil.createSLL(new Integer[] {1}), true);
	}

	@Test
	public void testPalindromeListWithTwoNode() {
		testImplementation(SLLUtil.createSLL(new Integer[] {1,1}), true);
	}
	
	@Test
	public void testPalindromeListWithTwoNodeNotPalindrome() {
		testImplementation(SLLUtil.createSLL(new Integer[] {1,2}), false);
	}
	
	@Test
	public void testPalindromeListWithThreeNodeNotPalindrome() {
		testImplementation(SLLUtil.createSLL(new Integer[] {1,2,3}), false);
	}
	
	@Test
	public void testPalindromeListWithThreeNode() {
		testImplementation(SLLUtil.createSLL(new Integer[] {1,2,1}), true);
	}
	
	@Test
	public void testPalindromeListWithOddNodeNotPalindrome() {
		testImplementation(SLLUtil.createSLL(new Integer[] {1,2,3,1,2}), false);
	}
	
	@Test
	public void testPalindromeListWithOddNode() {
		testImplementation(SLLUtil.createSLL(new Integer[] {1,2,3,2,1}), true);
	}
	
	@Test
	public void testPalindromeListWithEvenNodeNotPalindrome() {
		testImplementation(SLLUtil.createSLL(new Integer[] {1,2,1,1}), false);
	}
	
	@Test
	public void testPalindromeListWithEvenNode() {
		testImplementation(SLLUtil.createSLL(new Integer[] {1,2,3,4,4,3,2,1}), true);
	}
	
	private <T extends Comparable<T>> void testImplementation(NodeSLL<T> head,boolean expectedResult) {
		assertEquals(expectedResult, pl.isListPalindromeSplittingList(head));
	}
}
