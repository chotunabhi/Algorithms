package com.dsnalgomadeeasy.stack.problems;

import com.dsnalgomadeeasy.stack.common.StackLL;

public class InfixToPostFix {

	public String getPostFix(String infix) {
		if (infix == null)
			return null;

		StringBuffer postFix = new StringBuffer();
		StackLL<Character> operatorStack = new StackLL<>();

		for (int i = 0; i < infix.length(); i++) {
			char op = infix.charAt(i);

			if (!isOperator(op)) {
				postFix.append(op);
			}else if(op == '(')
				operatorStack.push(op);
			else if(op == ')') {
				while (!operatorStack.isEmpty()
						&& operatorStack.peek() != '(') 
					postFix.append(operatorStack.pop());
				
				if(!operatorStack.isEmpty() && operatorStack.peek() == '(')
					operatorStack.pop();
			}else {
				while (!operatorStack.isEmpty()
						&& getOperatorPriority(op) <= getOperatorPriority(operatorStack.peek())
						&& operatorStack.peek() != '(') 
					postFix.append(operatorStack.pop());
				
				operatorStack.push(op);
			}
		}

		while(!operatorStack.isEmpty()) 
			postFix.append(operatorStack.pop());

		return postFix.toString();
	}

	private boolean isOperator(char symbol) {
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
