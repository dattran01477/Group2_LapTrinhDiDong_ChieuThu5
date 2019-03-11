package com.example.calculator.Presenter;

import com.example.calculator.Algorithm.PostFix;
import com.example.calculator.MathImpl.Operation;

/**
 * @author Dattr
 * @version 1.0
 * @created 05-Mar-2019 9:35:42 PM
 */
public class CalculatorPresenter {

	private PostFix converter;
	private String expression;


	private Operation operation;

	public CalculatorPresenter(){

	}
	public CalculatorPresenter(String x){

	}

	public double compute(String x){
		return 0;
	}

	private void detectExpression(){

	}

	public PostFix getConverter() {
		return converter;
	}

	public void setConverter(PostFix converter) {
		this.converter = converter;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}


}