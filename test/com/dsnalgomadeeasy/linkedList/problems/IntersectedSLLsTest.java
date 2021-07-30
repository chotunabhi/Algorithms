package com.dsnalgomadeeasy.linkedList.problems;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;
import com.dsnalgomadeeasy.linkedList.common.SLLUtil;

public class IntersectedSLLsTest {

	@Test
	public void testAreListIntersectedBothNullList() {
		NodeSLL<Integer> head1 = null,head2 = null;
		testImplementation(head1, head2, null);
	}

	@Test
	public void testAreListIntersectedOneNullList() {
		NodeSLL<Integer> head1 = null,head2 = SLLUtil.createSLL(new Integer[] {1,2,3});
		testImplementation(head1, head2, null);
	}
	
	@Test
	public void testAreListIntersectedSameList() {
		NodeSLL<Integer> head1 = null,head2 = SLLUtil.createSLL(new Integer[] {1,2,3});
		head1 = head2;
		
		testImplementation(head1, head2, head1);
	}
	
	@Test
	public void testAreListIntersectedDifferentListsWithSameData() {
		NodeSLL<Integer> head1 = SLLUtil.createSLL(new Integer[] {1,2,3}),head2 = SLLUtil.createSLL(new Integer[] {1,2,3});
		
		testImplementation(head1, head2, null);
	}
	
	@Test
	public void testAreListIntersectedDifferentListsWithDifferentData() {
		NodeSLL<Integer> head1 = SLLUtil.createSLL(new Integer[] {1,2,3}),head2 = SLLUtil.createSLL(new Integer[] {4,5,6});
		
		testImplementation(head1, head2, null);
	}
	
	@Test
	public void testAreListIntersectedDifferentListsWithSameDataOfDifferentLength() {
		NodeSLL<Integer> head1 = SLLUtil.createSLL(new Integer[] {1,2,3,4}),head2 = SLLUtil.createSLL(new Integer[] {1,2,3});
		
		testImplementation(head1, head2, null);
	}
	
	@Test
	public void testAreListIntersectedDifferentListsWithDifferentDataOfDifferentLength() {
		NodeSLL<Integer> head1 = SLLUtil.createSLL(new Integer[] {1,2,3,4}),head2 = SLLUtil.createSLL(new Integer[] {5,6,7});
		
		testImplementation(head1, head2, null);
	}
	
	@Test
	public void testIntersectedListOfSameLength() {
		NodeSLL<Integer> head1 = SLLUtil.createSLL(new Integer[] {1,2,3,4}),head2 = SLLUtil.createSLL(new Integer[] {1,2});
		NodeSLL<Integer> node = head2,intersectingNode = head1;
		
		while(node.getNext() != null) {
			node = node.getNext();
			intersectingNode = intersectingNode.getNext();
		}
		
		node.setNext(intersectingNode.getNext());
		
		testImplementation(head1, head2, intersectingNode.getNext());
	}

	@Test
	public void testIntersectedListOfDifferentLength() {
		NodeSLL<Integer> head1 = SLLUtil.createSLL(new Integer[] {1,2,3,4}),head2 = SLLUtil.createSLL(new Integer[] {1,2,5});
		NodeSLL<Integer> node = head2,intersectingNode = head1;
		int linkingNodeCount = 2;
		
		while(node.getNext() != null) {
			node = node.getNext();
			
			if(linkingNodeCount-- > 0)
				intersectingNode = intersectingNode.getNext();
		}
		
		node.setNext(intersectingNode);
		
		testImplementation(head1, head2, intersectingNode);
	}
	
	@Test
	public void testIntersectedListOfLinkAtEndOfList() {
		NodeSLL<Integer> head1 = SLLUtil.createSLL(new Integer[] {1,2,3,4}),head2 = SLLUtil.createSLL(new Integer[] {1,2,5});
		NodeSLL<Integer> node = head2,intersectingNode = head1;
		
		while(node.getNext() != null) {
			node = node.getNext();
			intersectingNode = intersectingNode.getNext();
		}
		
		node.setNext(intersectingNode.getNext());
		
		testImplementation(head1, head2, intersectingNode.getNext());
	}
	
	private <T extends Comparable<T>> void testImplementation(NodeSLL<T> head1,NodeSLL<T> head2,NodeSLL<T> expectedResult) {
		IntersectionOfSLLs intersectionOfSLLs = new IntersectionOfSLLs();
		assertEquals(intersectionOfSLLs.getNodeIntersectedBruteForce(head1, head2),expectedResult);
		assertEquals(intersectionOfSLLs.getNodeIntersectedUsingHashTable(head1, head2),expectedResult);
		assertEquals(intersectionOfSLLs.getNodeIntersectedUsingStack(head1, head2),expectedResult);
		assertEquals(intersectionOfSLLs.getNodeIntersectedUsingArray(head1, head2),expectedResult);
		assertEquals(intersectionOfSLLs.getNodeIntersectedWithON(head1, head2),expectedResult);
	}
}
