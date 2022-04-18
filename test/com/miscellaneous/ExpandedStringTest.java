package com.miscellaneous;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExpandedStringTest {

	@Test
	public void testGetExpandedString() {
		ExpandingString es = new ExpandingString();
		
		assertEquals("abcdcdabcdcdabcdcdefefefefefefefef", es.getExpandedString("[[ab]1[cd]2]3[[ef]1]8"));
		assertEquals("ab", es.getExpandedString("[ab]1"));
		assertEquals("abab", es.getExpandedString("[[ab]1]2"));
		assertEquals("abab", es.getExpandedString("[[ab]2]1"));
		assertEquals("abab", es.getExpandedString("[[[a]1[b]1]2]1"));
	}

}
