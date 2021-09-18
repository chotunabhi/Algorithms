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
public class InsertionSortTest {
	private Integer[] data;
	private Integer[] expectedResult;
	private InsertionSort iSort;
	
	public InsertionSortTest(Integer[] data, Integer[] expectedResult) {
		this.data = data;
		this.expectedResult = expectedResult;
	}

	@Before
	public void setUp() throws Exception {
		iSort = new InsertionSort();
	}
	
	@Parameterized.Parameters
	public static Collection testData() {
		return Arrays.asList(new Object[][] { 
			{ null, null},
			{ new Integer[]{1}, new Integer[] { 1 } },
			{ new Integer[]{1,2}, new Integer[] { 1, 2 } },
			{ new Integer[]{2, 1}, new Integer[] { 1, 2 } },
			{ new Integer[]{1, 3, 2}, new Integer[] { 1, 2, 3 } },
			{ new Integer[]{3, 1, 2}, new Integer[] { 1, 2, 3 } },
			{ new Integer[]{5, 4, 3, 2, 1}, new Integer[] { 1, 2, 3, 4, 5 } },
			{ new Integer[]{5, 5, 5, 5}, new Integer[] { 5, 5, 5, 5 } },
			{ new Integer[]{1, 4, 3, 2, 5, 2, 3}, new Integer[] {1, 2, 2, 3, 3, 4, 5}}
		});
	}

	@Test
	public void test() {
		assertArrayEquals(expectedResult, SLLUtil.getArrayFromList(iSort.sort(SLLUtil.createSLL(data))));
	}

}
