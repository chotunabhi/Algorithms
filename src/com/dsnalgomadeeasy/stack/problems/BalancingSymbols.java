package com.dsnalgomadeeasy.stack.problems;

import static org.hamcrest.CoreMatchers.startsWith;

import com.dsnalgomadeeasy.stack.common.StackLL;

public class BalancingSymbols {
	public boolean isBalancedSymbols(String symbols) {
		StackLL<Character> symbolStack = new StackLL<>();
		
		if(symbols != null)
			for (int i = 0; i < symbols.length(); i++) {
				char c = symbols.charAt(i);

				if (isValidSymbol(c)) {
					if (symbolStack.isEmpty() || symbolStack.peek() != getBalancingSymbol(c))
						symbolStack.push(c);
					else
						symbolStack.pop();
				}
			}

		return symbolStack.isEmpty();
	}

	private boolean isValidSymbol(char c) {
		return "(){}[]".contains(c + "");
	}

	private char getBalancingSymbol(Character c) {
		char balancingSymbol = c;

		switch (c) {
		case ')':
			balancingSymbol = '(';
			break;
		case '}':
			balancingSymbol = '{';
			break;
		case ']':
			balancingSymbol = '[';
			break;
		}

		return balancingSymbol;
	}
}
