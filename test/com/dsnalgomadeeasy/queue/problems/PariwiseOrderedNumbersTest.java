package com.dsnalgomadeeasy.queue.problems;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PariwiseOrderedNumbersTest {
	private PariwiseOrderedNumbers pariwiseOrderedNumbers;
	private Integer[] data;
	private boolean expectedResult;
	
	public PariwiseOrderedNumbersTest(Integer[] data,boolean expectedResult) {
		super();
		this.data = data;
		this.expectedResult = expectedResult;
	}
	
	@Parameterized.Parameters
	public static Collection testData() {
		return Arrays.asList(new Object[][] {
			{ null, true },
			{new Integer[] {1},true},
			{new Integer[] {1,2},true},
			{new Integer[] {1,2,3,4,5,6},true},
			{new Integer[] {1,2,3,5,4,6},false},
			{new Integer[] {4,3,2,1},true},
			{new Integer[] {4,2,3,1},false}
		});
	}
	
	@Test
	public void testhasPaire() {
		assertEquals(expectedResult, new PariwiseOrderedNumbers(data).hasPair());
	}
}
