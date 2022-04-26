package com.dsnalgomadeeasy.stack.problems;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class InfixToPostFixTest {
	private InfixToPostFix itp;
	private String infixExpression;
	private String expectedResult;
	
	public InfixToPostFixTest(String infixExpression, String expectedResult) {
		super();
		this.infixExpression = infixExpression;
		this.expectedResult = expectedResult;
	}

	@Before
	public void setUp() throws Exception {
		itp = new InfixToPostFix();
	}
	
	@Parameterized.Parameters
	public static Collection testData() {
		return Arrays.asList(new Object[][] {
			{null, null},
			{"()", ""},
			{"(A+B)-(C+D)", "AB+CD+-"},
			{"A-B*D", "ABD*-"},
			{"(A*(B-C))", "ABC-*"},
			{"A*B/C+D", "AB*C/D+"}
		});
	}

	@Test
	public void testGetPostFix() {
		Assert.assertEquals(expectedResult, itp.getPostFix(infixExpression));
	}

}
