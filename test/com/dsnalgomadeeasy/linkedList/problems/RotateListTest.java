package com.dsnalgomadeeasy.linkedList.problems;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;
import com.dsnalgomadeeasy.linkedList.common.SLLUtil;

@RunWith(Parameterized.class)
public class RotateListTest {
	private NodeSLL<Integer> head;
	private int k;
	private Integer[] expected;
	private RotateList rl;
	
	public RotateListTest(NodeSLL<Integer> head, int k,Integer[] expected) {
		this.head = head;
		this.k = k;
		this.expected = expected;
	}

	@Before
	public void setUp() throws Exception {
		rl = new RotateList();
	}

	@Parameterized.Parameters
	public static Collection testData() {
		return Arrays.asList(new Object[][] {
			{ null, 10, null },
			{ null, -1, null },
			{ SLLUtil.createSLL(new Integer[] { 1 }), 10, new Integer[] {1} },
			{ SLLUtil.createSLL(new Integer[] { 1 }), -10, new Integer[] {1} },
			{ SLLUtil.createSLL(new Integer[] { 1 }), -1, new Integer[] {1} },
			{ SLLUtil.createSLL(new Integer[] { 1 }), 1, new Integer[] {1} },
			{ SLLUtil.createSLL(new Integer[] { 1, 2 }), 1, new Integer[] {2, 1} },
			{ SLLUtil.createSLL(new Integer[] { 1, 2 }), -1, new Integer[] {2, 1} },
			{ SLLUtil.createSLL(new Integer[] { 1, 2 }), 2, new Integer[] {1,2} },
			{ SLLUtil.createSLL(new Integer[] { 1, 2 }), -2, new Integer[] {1, 2} },
			{ SLLUtil.createSLL(new Integer[] { 1, 2 }), 0, new Integer[] {1, 2} },
			{ SLLUtil.createSLL(new Integer[] { 1, 2 }), 10, new Integer[] {1, 2} },
			{ SLLUtil.createSLL(new Integer[] { 1, 2 }), -10, new Integer[] {1, 2} },
			{ SLLUtil.createSLL(new Integer[] { 1, 2 }), 9, new Integer[] {2, 1} },
			{ SLLUtil.createSLL(new Integer[] { 1, 2 }), -9, new Integer[] {2, 1} },
			{ SLLUtil.createSLL(new Integer[] { 1, 2, 3, 4, 5 }), 2, new Integer[] {4, 5, 1, 2, 3} },
			{ SLLUtil.createSLL(new Integer[] { 1, 2, 3, 4, 5 }), -2, new Integer[] {3, 4, 5, 1, 2} },
			{ SLLUtil.createSLL(new Integer[] { 1, 2, 3, 4, 5 }), -7, new Integer[] {3, 4, 5, 1, 2} },
			{ SLLUtil.createSLL(new Integer[] { 1, 2, 3, 4, 5 }), 7, new Integer[] {4, 5, 1, 2, 3} },
		});
	}
	
	@Test
	public void testGetRotatedList() {
		assertArrayEquals(expected, SLLUtil.getArrayFromList(rl.getRotatedList(head, k)));
	}

}
