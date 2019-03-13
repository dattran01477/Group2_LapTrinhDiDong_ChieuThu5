package com.example.calculator.Algorithm;

import com.example.calculator.AppConstant.AppConstant;

import java.util.Stack;

/**
 * @author Dattr
 * @version 1.0
 * @created 05-Mar-2019 9:35:48 PM
 */
public abstract class PolishNotation {

	protected String expression;

	public PolishNotation(){

	}

	public PolishNotation(String expression){
		this.expression=expression;
	}


	protected int prioritizeExpression(String express){
		if (getPriority(express) == 0) {
			if (!express.equals("(") && !express.equals(")"))
				return 0;
			else
				return 1;
		}
		return 2;
	}

	public static int getPriority(String express){

		if (express.equals(AppConstant.mul) || express.equals(AppConstant.div) || express.equals(AppConstant.mod))
			return 2;
		if (express.equals(AppConstant.add) || express.equals(AppConstant.sub))
			return 1;
		return 0;
	}

	protected StringBuilder normalization(String str)
	{
		StringBuilder stb=new StringBuilder();
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)!=' ') stb.append(str.charAt(i));
			}
		return stb;
	}

	protected boolean isOperator(String str){
		return false;
	}

	public abstract Stack<String> parse();

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

}