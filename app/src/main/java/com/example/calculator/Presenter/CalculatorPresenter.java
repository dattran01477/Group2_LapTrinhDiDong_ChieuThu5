package com.example.calculator.Presenter;

import com.example.calculator.Algorithm.PolishNotation;
import com.example.calculator.Algorithm.PostFix;
import com.example.calculator.AppConstant.AppConstant;
import com.example.calculator.MathImpl.Operation;
import com.github.bgora.rpnlibrary.CalculatorInterface;
import com.github.bgora.rpnlibrary.advanced.AdvancedCalculatorFactory;
import com.github.bgora.rpnlibrary.exceptions.NoSuchFunctionFound;
import com.github.bgora.rpnlibrary.exceptions.WrongArgumentException;

import java.math.BigDecimal;
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

    public CalculatorPresenter() {

    }

    public CalculatorPresenter(String x) {
        //Nhan chuoi tu giao dien
        //Xoa het cac khoang trang
        this.expression = x.replaceAll("\\s+","");
        this.converter = new PostFix(this.expression);
    }

    //D
    public double compute() throws WrongArgumentException, NoSuchFunctionFound {
        //Tinh sin, cos, tan
        if (this.expression.contains(AppConstant.sin)
                || this.expression.contains(AppConstant.cos)
                || this.expression.contains(AppConstant.tan)
                || this.expression.contains(AppConstant.cotan)) {

            AdvancedCalculatorFactory advancedCalculatorFactory = new AdvancedCalculatorFactory();
            CalculatorInterface calc = advancedCalculatorFactory.createCalculator();
            BigDecimal result = calc.calculate(this.expression);
            return result.doubleValue();

        }

        //Tinh bieu thuc
        Stack<String> st = converter.parse();
        Stack<String> stack = new Stack<>();
        String tmp = "";

        while (!st.empty()) {
            tmp = st.pop();
            if (PolishNotation.getPriority(tmp) == 0) stack.push(tmp);
            else {
                double number1 = Double.parseDouble(stack.pop());
                double number2 = Double.parseDouble(stack.pop());
                stack.push(Calculate(number1, number2, tmp) + "");
            }
        }
        if(stack.size()!=1) throw new ArithmeticException("Biểu thức không hợp lệ");
        else return Double.parseDouble(stack.pop());
    }

    //Ham thuc hien mot phep tinh
    private double Calculate(double a, double b, String operator) {
        Operation operation = new Operation();
        switch (operator) {
            case AppConstant.add:
                return operation.addExpr(a, b);
            case AppConstant.sub:
                return operation.subExpr(b, a);
            case AppConstant.mul:
                return operation.multiExpr(a, b);
            case AppConstant.mod:
                return operation.modExpr(b, a);
            case AppConstant.div:
                return operation.divExpr(b, a);
            case AppConstant.exponen:
                return operation.exponenExpr(b,(int)a);
            default:
                throw new RuntimeException("Lỗi không xác định");
        }
    }

    private void detectExpression() {

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