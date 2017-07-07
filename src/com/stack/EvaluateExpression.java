package com.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EvaluateExpression {
	private static final Character[] validChars = { '+', '-', '*', '/', '(', ')' };
	private static final List<Character> validOperators = Arrays.asList(validChars);
	private static LinkedList<Character> operators = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the expression to evaluate : ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String expression = reader.readLine();

		Double result = evaluateExpression(expression);
		System.out.println(result);
	}

	private static Double evaluateExpression(String expression) {
		Double result = 0.0;
		Pattern pattern = Pattern.compile("(\\(*)((\\d+)([-\\*\\/\\+\\(\\)]*))");
		Matcher matcher = pattern.matcher(expression);

		while (matcher.find()) {
			String startParanthesis = matcher.group(1);
			System.out.println(matcher.group() + "->" + startParanthesis+" argument " + matcher.group(3) + " expression " + matcher.group(4));

			Double argument = Double.parseDouble(matcher.group(3));
			String operators = matcher.group(4);

			if (!isValidOperatorContinuation(operators)) {
				System.err.println("Invalid Expression!" + operators);
				System.exit(0);
			}

			for (int i = 0; i < operators.length(); i++) {
				char currentOperator = operators.charAt(i);

			}
		}

		
		return null;
	}

	private static Double operation(double operand1, double operand2, char operator) {
		double result = 0;

		switch (operator) {
		case '+':
			result = operand1 + operand2;
			break;
		case '-':
			result = operand1 - operand2;
			break;
		case '*':
			result = operand1 * operand2;
			break;
		case '/':
			result = operand1 / operand2;
			break;
		}

		return result;
	}

	private static Boolean isValidOperatorContinuation(String operators) {
		Boolean isValidOperatorContiunation = false;
		Pattern pattern = Pattern.compile("(^[\\+\\-\\*\\/]?\\(*$)|(^\\)*[\\+\\-\\*\\/]?)");
		Matcher matcher = pattern.matcher(operators);

		if (matcher.find() && matcher.group().length() == operators.length())
			isValidOperatorContiunation = true;

		return isValidOperatorContiunation;
	}

	private static byte operatorPriority(char ch) {
		byte priority = -1;

		switch (ch) {

		case '*':
		case '/':
			priority = 3;
			break;
		case '+':
			priority = 1;
			break;
		case '-':
			priority = 2;
			break;
		}

		return priority;

	}
}
