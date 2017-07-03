package com.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EvaluateExpression {
	private static Stack<Double> argumentStack = new Stack<>();
	private static Stack<Character> operatorStack = new Stack<>();
	private static final Character[] validChars = { '+', '-', '*', '/', '(', ')' };
	private static final List<Character> validOperators = Arrays.asList(validChars);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the expression to evaluate : ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String expression = reader.readLine();

		Double result = evaluateExpression(expression);
		System.out.println(result);
	}

	private static Double evaluateExpression(String expression) {
		Double result = 0.0;
		Pattern pattern = Pattern.compile("((\\d+)([-\\*\\/\\+\\(\\)]*))");
		Matcher matcher = pattern.matcher(expression);

		while (matcher.find()) {
			//			System.out.println(matcher.group() + "->" + matcher.group(2) + " expression " + matcher.group(3));
			Double argument = Double.parseDouble(matcher.group(2));
			String operators = matcher.group(3);

			if (!isValidOperatorContinuation(operators)) {
				System.err.println("Invalid Expression!" + operators);
				System.exit(0);
			}

			argumentStack.push(argument);

			for (int i = 0; i < operators.length(); i++) {

				char currentOperator = operators.charAt(i);

				if (currentOperator == ')') {
					while (operatorStack.peek() != '(')
						performOperation();

					operatorStack.pop();
				}else if(currentOperator == '(')
					operatorStack.push(currentOperator);
				else {
					while (!operatorStack.isEmpty()
							&& (operatorPriority(operatorStack.peek()) > operatorPriority(currentOperator)))
						performOperation();

					operatorStack.push(currentOperator);
				}
			}
		}

		while(!operatorStack.isEmpty())
			performOperation();
		return argumentStack.pop();
	}

	private static void performOperation() {
		Double result;
		double operand1 = argumentStack.pop();
		double operand2 = argumentStack.pop();
		char operator = operatorStack.pop();

		result = operation(operand2, operand1, operator);

		argumentStack.push(result);
		System.out.println(argumentStack);
		System.out.println(operatorStack);
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
