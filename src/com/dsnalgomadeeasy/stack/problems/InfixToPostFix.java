package com.dsnalgomadeeasy.stack.problems;

import com.dsnalgomadeeasy.stack.common.StackLL;

public class InfixToPostFix {

	public String getPostFix(String infix) {
		if (infix == null)
			return null;

		StringBuffer postFix = new StringBuffer();
		
		
		return postFix.toString();
	}

	public static boolean isOperator(char symbol) {
		return "+-()*%/".contains(symbol + "");
	}

	private byte getOperatorPriority(char operator) {
		byte priority = -1;

		switch (operator) {
		case '+':
		case '-':
			priority = 1;
			break;
		case '*':
		case '/':
			priority = 2;
			break;
		case '(':
		case ')':
			priority = 3;
			break;
		}

		return priority;
	}
}
