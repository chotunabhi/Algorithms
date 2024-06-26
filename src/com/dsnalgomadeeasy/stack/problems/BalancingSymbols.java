package com.dsnalgomadeeasy.stack.problems;

import com.dsnalgomadeeasy.stack.common.StackLL;

public class BalancingSymbols {
	public boolean isBalancedSymbols(String symbols) {
		StackLL<Character> symbolStack = new StackLL();

		if(symbols != null) {
			for(int i = 0; i < symbols.length(); i++) {
				char symbol = symbols.charAt(i);

				if(isValidSymbol(symbol)) 
					if(symbolStack.isEmpty() || getBalancingSymbol(symbol) != symbolStack.peek()) 
						symbolStack.push(symbol);
					else if(getBalancingSymbol(symbol) == symbolStack.peek()) 
						symbolStack.pop();

			}
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
