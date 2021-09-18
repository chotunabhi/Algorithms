package com.dsnalgomadeeasy.linkedList.problems;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.dsnalgomadeeasy.linkedList.common.SLLUtil;

@RunWith(Parameterized.class)
public class PartitioningSLLTest {
	private Integer[] head;
	private int k;
	private Integer[] result;
	PartitioningSLL partitioningSLL;
	
	@Before
	public void setUp() throws Exception {
		partitioningSLL = new PartitioningSLL();
	}

	public PartitioningSLLTest(Integer[] head, int k, Integer[] result) {
		this.head = head;
		this.k = k;
		this.result = result;
	}
	
	@Parameterized.Parameters
	public static Collection testData() {
		return Arrays.asList(new Object[][] { 
			{ null, 100, null},
			{ new Integer[]{1}, 0, new Integer[] { 1 } },
			{ new Integer[]{1}, 1,  new Integer[] { 1 } },
			{ new Integer[]{1,2}, 0,  new Integer[] { 1, 2 } },
			{ new Integer[]{1, 2, 3}, 1,  new Integer[] { 1, 2, 3 } },
			{ new Integer[]{3, 1, 2}, 1,  new Integer[] { 3, 1, 2 } },
			{ new Integer[]{1, 4, 3, 2, 5, 2, 3}, 3, new Integer[] {1, 2, 2, 4, 3, 5, 3}}
		});
	}

	@Test
	public void testPartition() {
		assertArrayEquals(result, SLLUtil.getArrayFromList(partitioningSLL.partition(SLLUtil.createSLL(head), k)));
	}

}
