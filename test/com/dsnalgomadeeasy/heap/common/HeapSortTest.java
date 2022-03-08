package com.dsnalgomadeeasy.heap.common;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class HeapSortTest {
	private Integer[] data;
	private Integer[] expectedResult;
	private HeapSort hSort;
	
	@Before
	public void setup() {
		hSort = new HeapSort();
	}

	public HeapSortTest(Integer[] data, Integer[] expectedResult) {
		super();
		this.data = data;
		this.expectedResult = expectedResult;
	}
	
	@Parameterized.Parameters
	public static Collection testData() {
		return Arrays.asList(new Object[][] { 
				{null,null},
				{new Integer[] {},new Integer[] {}},
				{new Integer[] {1},new Integer[] {1}},
				{new Integer[] {1,4,2,3},new Integer[] {1,2,3,4}},
				{new Integer[] {1,2,3,4},new Integer[] {1,2,3,4}},
				{new Integer[] {4,3,2,1},new Integer[] {1,2,3,4}},
				{new Integer[] {10,9,8,7,6,5,4,3,2,1},new Integer[] {1,2,3,4,5,6,7,8,9,10}}
			}
		);
	}
	
	@Test
	public void heapSortTest() {
		Assert.assertArrayEquals(expectedResult, hSort.sort(data));
	}
}
