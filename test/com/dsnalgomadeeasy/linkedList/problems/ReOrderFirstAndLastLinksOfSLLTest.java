package com.dsnalgomadeeasy.linkedList.problems;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;
import com.dsnalgomadeeasy.linkedList.common.SLLUtil;

@RunWith(Parameterized.class)
public class ReOrderFirstAndLastLinksOfSLLTest {
	private NodeSLL<Integer> head;
	private Integer[] expectedResult;
	private ReOrderFirstAndLastLinksOfSLL reOrderFirstAndLastLinksOfSLL;
	
	public ReOrderFirstAndLastLinksOfSLLTest(NodeSLL<Integer> head, Integer[] expectedResult) {
		this.head = head;
		this.expectedResult = expectedResult;
	}

	@Before
	public void setUp() throws Exception {
		reOrderFirstAndLastLinksOfSLL = new ReOrderFirstAndLastLinksOfSLL();
	}

	@Parameterized.Parameters
	public static Collection testData() {
		return Arrays.asList(
				new Object[][] { 
					{ null, null }, 
					{ SLLUtil.createSLL(new Integer[] { 1 }), new Integer[] { 1 } },
					{ SLLUtil.createSLL(new Integer[] { 1, 2 }), new Integer[] { 1, 2 } },
					{ SLLUtil.createSLL(new Integer[] { 1, 2, 3 }), new Integer[] { 1, 3, 2 } },
					{ SLLUtil.createSLL(new Integer[] { 1, 2, 3, 4 }), new Integer[] { 1, 4, 2, 3 } },
					{ SLLUtil.createSLL(new Integer[] { 1, 2, 3, 4, 5 }), new Integer[] { 1,5,2,4,3 } }
				}
			);
	}
	
//	@Test
	public void testReOrderListUsingStack() {
		assertArrayEquals(expectedResult, SLLUtil.getArrayFromList(reOrderFirstAndLastLinksOfSLL.reOrderListUsingStack(head)));
	}

	@Test
	public void testReOrderListUsingReverseSLL() {
		assertArrayEquals(expectedResult, SLLUtil.getArrayFromList(reOrderFirstAndLastLinksOfSLL.reOrderListUsingReverseSLL(head)));
	}
}
