package com.dsnalgomadeeasy.linkedList.problems;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;
import com.dsnalgomadeeasy.linkedList.common.SLLUtil;

public class InsertNodeInSortedSLLTest {
	InsertNodeInSortedSLL iniss = new InsertNodeInSortedSLL();
	
	@Test
	public void testInsertNodeInSortedSLLForEmptyList() {
		NodeSLL<Integer> head = null;
		head = iniss.insertNodeInSortedSLL(head, 1);
		
		assertNotNull(head);
	}

	@Test
	public void testInsertNodeInSortedSLLForDataInMiddle() {
		NodeSLL<Integer> head = SLLUtil.createSLL(new Integer[] {4,8,9});
		head = iniss.insertNodeInSortedSLL(head, 6);
		
		assertNotNull(head);
		assertArrayEquals(new Integer[] {4,6,8,9}, SLLUtil.getArrayFromList(head));
	}
	
	@Test
	public void testInsertNodeInSortedSLLForDataAtStart() {
		NodeSLL<Integer> head = SLLUtil.createSLL(new Integer[] {4,8,9});
		head = iniss.insertNodeInSortedSLL(head, 1);
		
		assertNotNull(head);
		assertArrayEquals(new Integer[] {1,4,8,9}, SLLUtil.getArrayFromList(head));
	}
	
	@Test
	public void testInsertNodeInSortedSLLForDataAtEnd() {
		NodeSLL<Integer> head = SLLUtil.createSLL(new Integer[] {4,8,9});
		head = iniss.insertNodeInSortedSLL(head, 10);
		
		assertNotNull(head);
		assertArrayEquals(new Integer[] {4,8,9,10}, SLLUtil.getArrayFromList(head));
	}
}
