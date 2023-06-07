package com.dsnalgomadeeasy.stack.problems;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.dsnalgomadeeasy.linkedList.common.SLLUtil;

@RunWith(Parameterized.class)
public class BalancingSymbolsTest {
	private BalancingSymbols bs;
	private boolean expectedResult;
	private String expression;
	
	public BalancingSymbolsTest(String expression, boolean expectedResult) {
		this.expression = expression;
		this.expectedResult = expectedResult;
	}

	@Before
	public void setUp() throws Exception {
		bs = new BalancingSymbols();
	}
	
	@Parameterized.Parameters
	public static Collection testData() {
		return Arrays.asList(new Object[][] {
			{null, true},
			{"()", true},
			{"(A+B)-(C+D)", true},
			{"(A*B-D", false},
			{"{(}()[])}", false},
			{"{[()]}", true},
			{"}{][)(",false}
		});
	}

	@Test
	public void testIsBalancedSymbols() {
		assertEquals(this.expectedResult, bs.isBalancedSymbols(expression));
	}

}
