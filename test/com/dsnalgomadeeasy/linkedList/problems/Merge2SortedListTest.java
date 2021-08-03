package com.dsnalgomadeeasy.linkedList.problems;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;
import com.dsnalgomadeeasy.linkedList.common.SLLUtil;

public class Merge2SortedListTest {
	Merge2SortedList merge2SortedList = new Merge2SortedList();
	
	@Test
	public void testNullLists() {
		testImplementation(null, null, null);
	}
	
	@Test
	public void testOneNullList() {
		testImplementation(SLLUtil.createSLL(new Integer[] {1,2,3}), null, new Integer[] {1,2,3});
	}
	
	@Test
	public void testOneNodeEach() {
		testImplementation(SLLUtil.createSLL(new Integer[] {1}), SLLUtil.createSLL(new Integer[] {2}), new Integer[] {1,2});
	}
	
	@Test
	public void testOneNodeEachFirstGreater() {
		testImplementation(SLLUtil.createSLL(new Integer[] {2}), SLLUtil.createSLL(new Integer[] {1}), new Integer[] {1,2});
	}
	
	@Test
	public void testOneNodeFirstListSecondGreater() {
		testImplementation(SLLUtil.createSLL(new Integer[] {1}), SLLUtil.createSLL(new Integer[] {2,3}), new Integer[] {1,2,3});
	}
	
	@Test
	public void testOneNodeFirsttListSecondSmaller() {
		testImplementation(SLLUtil.createSLL(new Integer[] {2}), SLLUtil.createSLL(new Integer[] {1,3}), new Integer[] {1,2,3});
	}
	
	@Test
	public void testOneNodeFirsttListSecondSmallest() {
		testImplementation(SLLUtil.createSLL(new Integer[] {3}), SLLUtil.createSLL(new Integer[] {1,2}), new Integer[] {1,2,3});
	}
	
	@Test
	public void testOneNodeSecondtListFirstSmallest() {
		testImplementation(SLLUtil.createSLL(new Integer[] {1,2}), SLLUtil.createSLL(new Integer[] {3}), new Integer[] {1,2,3});
	}
	
	@Test
	public void testOneNodeSecondtListFirstSmaller() {
		testImplementation(SLLUtil.createSLL(new Integer[] {1,3}), SLLUtil.createSLL(new Integer[] {2}), new Integer[] {1,2,3});
	}
	
	@Test
	public void testOneNodeSecondtListFirstGreater() {
		testImplementation(SLLUtil.createSLL(new Integer[] {2,3}), SLLUtil.createSLL(new Integer[] {1}), new Integer[] {1,2,3});
	}
	
	@Test
	public void testFirstListSmallest() {
		testImplementation(SLLUtil.createSLL(new Integer[] {1,2,3}), SLLUtil.createSLL(new Integer[] {4,5,6}), new Integer[] {1,2,3,4,5,6});
	}
	
	@Test
	public void testSecondListSmallest() {
		testImplementation(SLLUtil.createSLL(new Integer[] {4,5,6}), SLLUtil.createSLL(new Integer[] {1,2,3}), new Integer[] {1,2,3,4,5,6});
	}
	
	@Test
	public void testOneNodeBothListEqual() {
		testImplementation(SLLUtil.createSLL(new Integer[] {1}), SLLUtil.createSLL(new Integer[] {1}), new Integer[] {1,1});
	}
	
	@Test
	public void testBothListEqual() {
		testImplementation(SLLUtil.createSLL(new Integer[] {1,2,3}), SLLUtil.createSLL(new Integer[] {1,2,3}), new Integer[] {1,1,2,2,3,3});
	}
	
	@Test
	public void testSecondListFirstAndLastValueGreater() {
		testImplementation(SLLUtil.createSLL(new Integer[] {2,3,4}), SLLUtil.createSLL(new Integer[] {1,5}), new Integer[] {1,2,3,4,5});
	}
	
	@Test
	public void testFirstListFirstAndLastValueGreater() {
		testImplementation(SLLUtil.createSLL(new Integer[] {1,5}), SLLUtil.createSLL(new Integer[] {2,3,4}), new Integer[] {1,2,3,4,5});
	}
	
	@Test
	public void testSecondListFirstValueGreater() {
		testImplementation(SLLUtil.createSLL(new Integer[] {1,3,5}), SLLUtil.createSLL(new Integer[] {2,4}), new Integer[] {1,2,3,4,5});
	}
	
	@Test
	public void testFirstListFirstValueGreater() {
		testImplementation(SLLUtil.createSLL(new Integer[] {2,4}), SLLUtil.createSLL(new Integer[] {1,3,5}), new Integer[] {1,2,3,4,5});
	}
	
	@Test
	public void testSecondListFitsCompletelyInBetween() {
		testImplementation(SLLUtil.createSLL(new Integer[] {1,2,5}), SLLUtil.createSLL(new Integer[] {3,4}), new Integer[] {1,2,3,4,5});
	}
	
	@Test
	public void testFirstListFitsCompletelyInBetween() {
		testImplementation(SLLUtil.createSLL(new Integer[] {3,4}), SLLUtil.createSLL(new Integer[] {1,2,5}), new Integer[] {1,2,3,4,5});
	}
	/*
	 * @Test public void testOneNodeEachSameList() { NodeSLL<Integer> head1 =
	 * SLLUtil.createSLL(new Integer[] { 1 }); testImplementation(head1, head1, new
	 * Integer[] { 1, 1 }); }
	 */
	 
	
	private <T extends Comparable<T>> void testImplementation(NodeSLL<T> head1,NodeSLL<T> head2,T[] expectedResult) {
		assertArrayEquals(expectedResult, SLLUtil.getArrayFromList(merge2SortedList.mergedListRecursive(head1, head2)));
//		assertArrayEquals(expectedResult, SLLUtil.getArrayFromList(merge2SortedList.mergedList(head1, head2)));
	}

}
