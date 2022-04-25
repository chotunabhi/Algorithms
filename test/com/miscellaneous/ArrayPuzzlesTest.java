package com.miscellaneous;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class ArrayPuzzlesTest {

	@Test
	public void testGetLeaders() {
		ArrayPuzzles ap = new ArrayPuzzles();
		assertArrayEquals(new Integer[] {8,6,5}, ap.getLeaders(new int[] {1,2,8,6,3,5}));
		assertArrayEquals(new Integer[] {5}, ap.getLeaders(new int[] {1,2,3,4,5}));
		assertArrayEquals(new Integer[] {5,4,3,2,1}, ap.getLeaders(new int[] {5,4,3,2,1}));
		
	}

}
