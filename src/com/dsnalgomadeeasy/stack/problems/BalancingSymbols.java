package com.dsnalgomadeeasy.stack.problems;

import com.dsnalgomadeeasy.stack.common.StackLL;

public class BalancingSymbols {
	public boolean isBalancedSymbols(String symbols) {
		StackLL<Character> symbolStack = new StackLL();

		
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
