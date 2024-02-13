package com.dsnalgomadeeasy.stack.problems;

import com.dsnalgomadeeasy.stack.common.StackLL;

public class PostfixEvaluation {
	public String getPostfixValue(String postfixExpression) {
		String value = null;
		
		if(postfixExpression != null) {
			
			StackLL<String> stack = new StackLL<>();
			
			for(int i = 0; i < postfixExpression.length(); i++) {
				char op = postfixExpression.charAt(i);
				
				if(!InfixToPostFix.isOperator(op)) {
					stack.push(op+"");
				}else {
					String op1 = stack.pop();
					String op2 = stack.pop();
					
					if(op1.length() > 1 && op2.length() > 1) {
						op1 = "("+op1+")";
						op2 = "("+op2+")";
					}
					
					StringBuffer sb = new StringBuffer();
					sb.append(op2).append(op).append(op1);
					
					stack.push(sb.toString());
				}
			}
			
			while(!stack.isEmpty())
				value = stack.pop();
		}
		
		return value;
	}
}
