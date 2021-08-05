package com.dsnalgomadeeasy.linkedList.problems;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dsnalgomadeeasy.linkedList.common.CLLUtil;
import com.dsnalgomadeeasy.linkedList.common.NodeSLL;

public class SplitCLLTest {
	SplitCLL sc = new SplitCLL();

	@Test
	public void testNullCLL() {
		testImplementation(null, null, null);
	}

	@Test
	public void testSingleNodeCLL() {
		testImplementation(CLLUtil.getCLLFromArray(new Integer[] { 1 }), new Integer[] { 1 }, null);
	}

	@Test
	public void test2NodeCLL() {
		testImplementation(CLLUtil.getCLLFromArray(new Integer[] { 1, 2 }), new Integer[] { 1 }, new Integer[] { 2 });
	}

	@Test
	public void test3NodeCLL() {
		testImplementation(CLLUtil.getCLLFromArray(new Integer[] { 1, 2, 3 }), new Integer[] { 1, 2 },
				new Integer[] { 3 });
	}

	@Test
	public void test4NodeCLL() {
		testImplementation(CLLUtil.getCLLFromArray(new Integer[] { 1, 2, 3, 4 }), new Integer[] { 1, 2 },
				new Integer[] { 3, 4 });
	}

	@Test
	public void testevenNodeCLL() {
		testImplementation(CLLUtil.getCLLFromArray(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 }),
				new Integer[] { 1, 2, 3, 4 }, new Integer[] { 5, 6, 7, 8 });
	}

	@Test
	public void testOddNodeCLL() {
		testImplementation(CLLUtil.getCLLFromArray(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }),
				new Integer[] { 1, 2, 3, 4, 5 }, new Integer[] { 6, 7, 8, 9 });
	}

	private <T extends Comparable<T>> void testImplementation(NodeSLL<T> head, T[] expectedResult1,
			T[] expectedResult2) {
		NodeSLL<T>[] lists = sc.splitCLLInto2CLL(head);

		assertArrayEquals(expectedResult1, CLLUtil.getArrayFromCLL(lists[0]));
		assertArrayEquals(expectedResult2, CLLUtil.getArrayFromCLL(lists[1]));
	}
}
