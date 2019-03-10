package com.example.calculator.Algorithm;

/**
 * @author Dattr
 * @version 1.0
 * @created 05-Mar-2019 9:35:48 PM
 */
public class PolishNotation {

	protected String expression;

	public PolishNotation(){

	}

	public PolishNotation(String expression){

	}

	public void finalize(){

	}

	protected void formatExpression(){

	}

	protected int getPriority(String express){

		if (express == "*" || express == "/" || express == "%")
			return 2;
		if (express == "+" || express == "-")
			return 1;
		return 0;
	}

	protected boolean isOperator(String str){
		return false;
	}

	public String parse(){
		return "";
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

}