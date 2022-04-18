package com.dsnalgomadeeasy.stack.problems;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinMaxTest {

	@Test
	public void testGetMinMax() {
		MinMaxStack<Integer> mms = new MinMaxStack<>();
		mms.push(10);
		Integer min = 10,max = 10;
		
		assertEquals(min, mms.getMin());
		assertEquals(max, mms.getMax());
		
		mms.push(5);
		min = 5;
		assertEquals(min, mms.getMin());
		assertEquals(max, mms.getMax());
		
		mms.push(8);
		assertEquals(min, mms.getMin());
		assertEquals(max, mms.getMax());
		
		mms.push(5);
		min = 5;
		assertEquals(min, mms.getMin());
		assertEquals(max, mms.getMax());
		
		mms.push(15);
		max = 15;
		assertEquals(min, mms.getMin());
		assertEquals(max, mms.getMax());
		
		mms.push(3);
		min = 3;
		assertEquals(min, mms.getMin());
		assertEquals(max, mms.getMax());
		
		mms.pop();
		min = 5;
		assertEquals(min, mms.getMin());
		assertEquals(max, mms.getMax());
		
		mms.pop();
		max = 10;
		assertEquals(min, mms.getMin());
		assertEquals(max, mms.getMax());
	}

}
