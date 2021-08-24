package com.dsnalgomadeeasy.linkedList.problems;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class JosephusCircleTest {
	private int numberOfPersons;
	private int nthPerson;
	private int expected;
	private JosephusCircle jc;
	
	public JosephusCircleTest(int numberOfPersons, int nthPerson, int expected) {
		this.numberOfPersons = numberOfPersons;
		this.nthPerson = nthPerson;
		this.expected = expected;
	}

	@Before
	public void init() {
		jc = new JosephusCircle();
	}

	@Parameterized.Parameters
	public static Collection testData() {
		return Arrays.asList(
				new Object[][] { 
					{ 1, 10, 1 }, 
					{ 1, 0 , -1 },
					{ 1, -1, -1 },
					{ 1, 1, 1 },
					{ 2, 1, 1 },
					{ 2, 2, 2 },
					{ 3, 1, 3 },
					{ 3, 2, 2 },
					{ 3, 3, 2 },
					{ 100, 1, 73 }
				}
			);
	}
	
	@Test
	public void testAlivePersonNumber() {
		assertEquals(expected ,jc.alivePersonNumber(numberOfPersons, nthPerson));
	}

}
