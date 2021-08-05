package com.dsnalgomadeeasy.linkedList.problems;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;
import com.dsnalgomadeeasy.linkedList.common.SLLUtil;

public class ReverseLinksInPairsTest {
	ReverseLinksInPairs rlip = new ReverseLinksInPairs();
	
	@Test
	public void testReversePairs() {
		testImplementation(SLLUtil.createSLL(new Integer[] {1,2,3,4,5}), new Integer[] {2,1,4,3,5});
	}
	
	@Test
	public void testReversePairsForEvenNodes() {
		testImplementation(SLLUtil.createSLL(new Integer[] {1,2,3,4,5,6}), new Integer[] {2,1,4,3,6,5});
	}
	
	@Test
	public void testReversePairsForNull() {
		testImplementation(null,null);
	}
	
	@Test
	public void testReversePairsForSingleNode() {
		testImplementation(SLLUtil.createSLL(new Integer[] {1}), new Integer[] {1});
	}
	
	@Test
	public void testReversePairsForTwoNode() {
		testImplementation(SLLUtil.createSLL(new Integer[] {1,2}), new Integer[] {2,1});
	}
	
	public <T extends Comparable<T>> void testImplementation(NodeSLL<T> head,T[] expectedResult) {
//		assertArrayEquals(expectedResult, SLLUtil.getArrayFromList(rlip.reversePairsRecursive(head)));
		
		NodeSLL<T> reversePairs = rlip.reversePairs(head);
		SLLUtil.printList(reversePairs);
		assertArrayEquals(expectedResult, SLLUtil.getArrayFromList(reversePairs));
	}

}
