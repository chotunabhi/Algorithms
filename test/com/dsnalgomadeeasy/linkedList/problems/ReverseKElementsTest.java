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
public class ReverseKElementsTest {
	private NodeSLL<Integer> head;
	private int k;
	private Integer[] expected;
	private ReverseKElements rke;

	public ReverseKElementsTest(NodeSLL<Integer> head, Integer k, Integer[] expected) {
		this.head = head;
		this.k = k;
		this.expected = expected;
	}

	@Before
	public void init() {
		rke = new ReverseKElements();
	}

	@Parameterized.Parameters
	public static Collection testData() {
		return Arrays.asList(
				new Object[][] { 
					{ null, 10, null }, 
					{ SLLUtil.createSLL(new Integer[] { 1 }), 1, new Integer[] { 1 } },
					{ SLLUtil.createSLL(new Integer[] { 1 }), 2, new Integer[] { 1 } },
					{ SLLUtil.createSLL(new Integer[] { 1 }), 0, new Integer[] { 1 } },
					{ SLLUtil.createSLL(new Integer[] { 1, 2 }), 1, new Integer[] { 1, 2 } },
					{ SLLUtil.createSLL(new Integer[] { 1, 2 }), 2, new Integer[] { 2, 1 } },
					{ SLLUtil.createSLL(new Integer[] { 1, 2 }), 3, new Integer[] { 2, 1 } },
					{ SLLUtil.createSLL(new Integer[] { 1, 2, 3 }), 1, new Integer[] { 1, 2, 3 } },
					{ SLLUtil.createSLL(new Integer[] { 1, 2, 3 }), 2, new Integer[] { 2, 1, 3 } },
					{ SLLUtil.createSLL(new Integer[] { 1, 2, 3 }), 3, new Integer[] { 3, 2, 1 } },
					{ SLLUtil.createSLL(new Integer[] { 1, 2, 3 }), 4, new Integer[] { 3, 2, 1 } },
					{ SLLUtil.createSLL(new Integer[] { 1, 2, 3, 4 }), 0, new Integer[] { 1, 2, 3, 4 } },
					{ SLLUtil.createSLL(new Integer[] { 1, 2, 3, 4 }), 1, new Integer[] { 1, 2, 3, 4 } },
					{ SLLUtil.createSLL(new Integer[] { 1, 2, 3, 4 }), 2, new Integer[] { 2, 1, 4, 3 } },
					{ SLLUtil.createSLL(new Integer[] { 1, 2, 3, 4 }), 3, new Integer[] { 3, 2, 1, 4 } },
					{ SLLUtil.createSLL(new Integer[] { 1, 2, 3, 4, 5 }), 4, new Integer[] { 4, 3, 2, 1, 5 } },
					{ SLLUtil.createSLL(new Integer[] { 1, 2, 3, 4, 5 }), 2, new Integer[] { 2, 1, 4, 3, 5 } },
					{ SLLUtil.createSLL(new Integer[] { 1, 2, 3, 4, 5 }), 1, new Integer[] { 1, 2, 3, 4, 5 } }
				}
			);
	}

//	@Test
	public void testReverseKLinksTest() {
		assertArrayEquals(expected, SLLUtil.getArrayFromList(rke.reverseKLinks(head, k)));
	}

	@Test
	public void testReverseKLinksRecursiveTest() {
		assertArrayEquals(expected, SLLUtil.getArrayFromList(rke.reverseKLinksRecursive(head, k)));
	}
}
