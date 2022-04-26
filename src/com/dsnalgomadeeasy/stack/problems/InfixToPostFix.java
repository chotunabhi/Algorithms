package com.dsnalgomadeeasy.stack.problems;

import com.dsnalgomadeeasy.stack.common.StackLL;

public class InfixToPostFix {
	
	public String getPostFix(String infix) {
		if(infix == null)
			return infix;
		
		StringBuffer postFix = new StringBuffer();
		StringBuffer infixBuffer = new StringBuffer(infix.length()+2);
		StackLL<Character> dataStack = new StackLL<>();
		
		infixBuffer.append(infix)
		.append(")");
		
		dataStack.push('(');
		
		for(int i = 0; i < infixBuffer.length(); i++) {
			char symbol = infixBuffer.charAt(i);
			
			if(isOperator(symbol)) {
				if(symbol == '(') {
					dataStack.push(symbol);
				}else if(symbol == ')') {
					while(!dataStack.isEmpty() && !dataStack.peek().equals('('))
						postFix.append(dataStack.pop());
					if(!dataStack.isEmpty() && dataStack.peek().equals('('))
						dataStack.pop();
				}else {
					while(!dataStack.isEmpty() 
							&& getOperatorPriority(symbol) <= getOperatorPriority(dataStack.peek())
							&& dataStack.peek() != '(') {
						postFix.append(dataStack.pop());
					}
					
					dataStack.push(symbol);
				}
			}else {
				postFix.append(symbol);
			}
			
		}
		
		return postFix.toString();
	}
	
	private boolean isOperator(char symbol) {
		return "+-()*%/".contains(symbol+"");
	}
	private byte getOperatorPriority(char operator) {
		byte priority = -1;
		
		switch(operator) {
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
