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
public class SumOfTwoNumbersTest {
	private NodeSLL<Integer> n1;
	private NodeSLL<Integer> n2;
	private Integer[] result;
	private SumOfTwoNumbers sumOfTwoNumbers;

	public SumOfTwoNumbersTest(NodeSLL<Integer> n1, NodeSLL<Integer> n2, Integer[] result) {
		this.n1 = n1;
		this.n2 = n2;
		this.result = result;
	}

	@Before
	public void setUp() throws Exception {
		sumOfTwoNumbers = new SumOfTwoNumbers();
	}

	@Parameterized.Parameters
	public static Collection testData() {
		return Arrays.asList(new Object[][] { 
			{ null, null, null },
			{ null, SLLUtil.createSLL(new Integer[] { 1 }), new Integer[] { 1 } },
			{ SLLUtil.createSLL(new Integer[] { 1 }), null, new Integer[] { 1 } },
			{ SLLUtil.createSLL(new Integer[] { 1 }), SLLUtil.createSLL(new Integer[] {1}), new Integer[] { 2 } },
			{ SLLUtil.createSLL(new Integer[] { 1 }), SLLUtil.createSLL(new Integer[] {9}), new Integer[] { 0 , 1 } },
			{ SLLUtil.createSLL(new Integer[] { 0 }), SLLUtil.createSLL(new Integer[] {9}), new Integer[] { 9 } },
			{ SLLUtil.createSLL(new Integer[] { 9 }), SLLUtil.createSLL(new Integer[] {9}), new Integer[] { 8 , 1 } } ,
			{ SLLUtil.createSLL(new Integer[] { 1 ,2 }), SLLUtil.createSLL(new Integer[] {9}), new Integer[] { 0 , 3 } },
			{ SLLUtil.createSLL(new Integer[] { 9 }), SLLUtil.createSLL(new Integer[] {9, 1}), new Integer[] { 8 , 2 } },
			{ SLLUtil.createSLL(new Integer[] { 1 }), SLLUtil.createSLL(new Integer[] {9, 9, 9, 9}), new Integer[] { 0 , 0, 0, 0, 1 } },
			{ SLLUtil.createSLL(new Integer[] { 9,9,9 }), SLLUtil.createSLL(new Integer[] {9,9,9}), new Integer[] { 8, 9, 9, 1} }
		});
	}

	@Test
	public void testSum() {
		assertArrayEquals(SLLUtil.getArrayFromList(sumOfTwoNumbers.sum(n1, n2)), result);
	}

}
