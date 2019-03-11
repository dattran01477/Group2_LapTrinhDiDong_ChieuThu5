package com.example.calculator.Presenter;

import com.example.calculator.Algorithm.PostFix;
import com.example.calculator.MathImpl.Operation;

import java.util.Stack;

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
	//D
	public double compute(Stack<String> st){
	    Stack<String> stack = new Stack<>();
	    String tmp = "";
	    while (!st.empty())
        {
            tmp = st.pop();
            if(isOperator(tmp)==0) stack.push(tmp);
            else {
                double number1 = Double.parseDouble(stack.pop());
                double number2 = Double.parseDouble(stack.pop());
                stack.push(caculartor(number1,number2,tmp)+"");
            }
        }
		return Double.parseDouble(stack.pop());
	}

	private int isOperator(String s)
    {
        if(s.equals("+")) return 1;
        else if(s.equals("-")) return 1;
        else if(s.equals("*")) return 1;
        else if(s.equals("/")) return 1;
        else return  0;
    }

	private double caculartor(double a, double b, String operator)
	{
	    Operation operation = new Operation();
	    switch (operator){
            case "+":return operation.addExpr(a,b);
            case  "-" : return operation.subExpr(a,b);
            case  "*": return  operation.multiExpr(a,b);
            case "/" : return  operation.divExpr(a,b);
            default: throw new RuntimeException("Lỗi không xác định");
        }
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