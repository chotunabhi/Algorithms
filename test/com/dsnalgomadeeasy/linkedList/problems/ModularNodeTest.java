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
public class ModularNodeTest {
	private NodeSLL<Integer> head;
	private Integer k;
	private Integer expectedResult;
	private ModularNode mn;

	@Before
	public void setUp() throws Exception {
		mn = new ModularNode();
	}

	public ModularNodeTest(NodeSLL<Integer> head, Integer k, Integer expectedResult) {
		super();
		this.head = head;
		this.k = k;
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters(name=" list {0} k {1} ")
	public static Collection testData() {
		/*return Arrays.asList(new Object[][] { { null, 10, null }, { SLLUtil.createSLL(new Integer[] { 1 }), 10, null },
				{ SLLUtil.createSLL(new Integer[] { 1 }), 1, 1 },
				{ SLLUtil.createSLL(new Integer[] { 1, 2, 3 }), -1, null },
				{ SLLUtil.createSLL(new Integer[] { 1, 2, 3, 4 }), 2, 4 },
				{ SLLUtil.createSLL(new Integer[] { 1, 2, 3, 4 }), 3, 3 },
				{ SLLUtil.createSLL(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 }), 3, 18 } });*/
		
		/*return Arrays.asList(new Object[][] {{ null, 10, null },
					{ SLLUtil.createSLL(new Integer[] { 1 }), 10, null },
					{ SLLUtil.createSLL(new Integer[] { 1 }), 1, null },
					{ SLLUtil.createSLL(new Integer[] { 1, 2, 3 }), -1, null },
					{ SLLUtil.createSLL(new Integer[] { 1, 2, 3, 4 }), 2, 3 },
					{ SLLUtil.createSLL(new Integer[] { 1, 2, 3, 4 }), 3, 1 },
					{ SLLUtil.createSLL(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 }), 3, 16 } });*/
		
		return Arrays.asList(new Object[][] {
			{ null, 10, null },
			{ SLLUtil.createSLL(new Integer[] { 1 }), 10, 1 },
			{ SLLUtil.createSLL(new Integer[] { 1 }), 1, 1 },
			{ SLLUtil.createSLL(new Integer[] { 1, 2, 3 }), -1, null },
			{ SLLUtil.createSLL(new Integer[] { 1, 2, 3, 4 }), 2, 2 },
			{ SLLUtil.createSLL(new Integer[] { 1, 2, 3, 4 }), 3, 2 },
			{ SLLUtil.createSLL(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 }), 3, 7 } 
		});
	}

//	@Test
	public void testGetModularNode() {
		assertEquals(expectedResult, mn.getModularNode(head, k));
	}

//	@Test
	public void testGetFirstElementOfModularNode() {
		assertEquals(expectedResult, mn.getFirstElementOfModularNode(head, k));
	}
	
	@Test
	public void testGetFractionalNodee() {
		assertEquals(expectedResult, mn.getFractionalNode(head, k));
	}
}
