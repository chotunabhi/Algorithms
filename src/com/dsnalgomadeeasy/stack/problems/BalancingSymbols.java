package com.dsnalgomadeeasy.stack.problems;

import com.dsnalgomadeeasy.stack.common.StackLL;

public class BalancingSymbols {
	public boolean isBalancedSymbols(String symbols) {
		StackLL<Character> symbolStack = new StackLL<>();

		for(int i = 0;symbols != null && i < symbols.length(); i++) {
			char symbol = symbols.charAt(i);
			
			if(isValidSymbol(symbol)) 
				if(!symbolStack.isEmpty() && symbolStack.peek().equals(getBalancingSymbol(symbol)))
					symbolStack.pop();
				else
					symbolStack.push(symbol);
		}

		return symbolStack.isEmpty();
	}

	private boolean isValidSymbol(char symbol) {
		// TODO Auto-generated method stub
		return "()[]{}".contains(symbol+"");
	}

	private char getBalancingSymbol(char symbol) {
		char balancingSymbol=symbol;

		switch(symbol) {
		case '}':
			balancingSymbol = '{';
			break;
		case ']':
			balancingSymbol = '[';
			break;
		case ')':
			balancingSymbol = '(';
			break;
		}

		return balancingSymbol;
	}
}
