package com.dsnalgomadeeasy.stack.problems;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PostfixEvaluationTest {
	private PostfixEvaluation pe;
	private String postfixExpression;
	private String expectedResult;
	
	public PostfixEvaluationTest(String postfixExpression, String expectedResult) {
		super();
		this.postfixExpression = postfixExpression;
		this.expectedResult = expectedResult;
	}

	@Before
	public void setUp() throws Exception {
		pe = new PostfixEvaluation();
	}
	
	@Parameterized.Parameters
	public static Collection testData() {
		return Arrays.asList(new Object[][] {
			{null, null},
			{"", null},
			{"AB+CD+-","(A+B)-(C+D)"},
			{"ABD*-","A-B*D"},
			{"ABC-*","A*B-C"},
			{"AB*C/D+","A*B/C+D"}
		});
	}

	@Test
	public void testGetPostFix() {
		Assert.assertEquals(expectedResult, pe.getPostfixValue(postfixExpression));
	}
}
