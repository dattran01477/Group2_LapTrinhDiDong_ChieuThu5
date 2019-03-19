package com.example.calculator.Algorithm;

import java.util.Stack;

/**
 * @author Dattr
 * @version 1.0
 * @created 05-Mar-2019 9:35:49 PM
 */
public class PostFix extends PolishNotation {

	public PostFix(String str){
		super(str);
	}
	@Override
	public Stack<String> parse() {
		Stack<String> stack = new Stack<String>();
		Stack<String> output = new Stack<String>();
		String number = "";
		int n = this.expression.length();

		for (int i = 0; i < n; i++) {
			String s = "" + this.expression.charAt(i);
			if (prioritizeExpression(s) == 0)
				number += s;
			else if(s.equals("-"))
			{
				if(i==0) number+=s;
				else
				{
					String sp = "" + this.expression.charAt(i-1);
					if(sp.equals("(")||prioritizeExpression(sp) > 0) number+=s;
					else
					{
						output.push(number);
						number = "";
						while (!stack.empty() && getPriority(stack.peek()) >= getPriority(s)) {
							output.push(stack.pop());
						}
						stack.push(s);
					}
				}
			}
			else {
				if (number.length() > 0) {
					output.push(number);
					number = "";
				}
				if (prioritizeExpression(s) == 1) {
					if (s.equals("(")) {

						stack.push(s);
					} else if (s.equals(")")) {
						String pop = stack.pop();
						while (pop.equals("(")) {
							output.push(pop);
							pop = stack.pop();
						}
					}
				} else {
					while (!stack.empty() && getPriority(stack.peek()) >= getPriority(s)) {
						output.push(stack.pop());
					}
					stack.push(s);

				}
			}
		}
		if (number.length() > 0) {
			output.push(number);
			number = "";
		}
		while (!stack.empty()) {
			output.push(stack.pop());
		}
		while (!output.empty()) {
			stack.push(output.pop());
		}
		return stack;
	}




}