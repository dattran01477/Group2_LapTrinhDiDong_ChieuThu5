package com.example.calculator.MathImpl;

import com.example.calculator.Math.IOperand;
import com.example.calculator.Math.IOperator;
import com.example.calculator.Math.ITrigonometric;

/**
 * @author Dattr
 * @version 1.0
 * @created 05-Mar-2019 9:35:45 PM
 */
public class Operation implements IOperand, IOperator, ITrigonometric {

	public Operation(){

	}

	@Override
	public double exponenExpr(double x, int y) {
		double kq=1;
		for(double i = 0; i<y ; i++)
		{
			kq *= x;
		}
		return kq;
	}

	@Override
	public double sqrtExpr(double x) {
		double rs = Math.sqrt(x);
		return rs;
	}

	@Override
	public double addExpr(double x, double y) {
		return x+y;
	}

	@Override
	public double divExpr(double x, double y) {
		if (y == 0) throw new IllegalArgumentException("Không thể chia cho 0");
		else return x / y;
	}

	@Override
	public double modExpr(double x, double y) {
		if (y == 0) throw new IllegalArgumentException("Không thể chia cho 0");
		else return x % y;
	}

	@Override
	public double multiExpr(double x, double y) {
		return x * y;
	}

	@Override
	public double subExpr(double x, double y) {
		return x-y;
	}

	@Override
	public double cosExpr(double x) {
		return Math.cos(x);
	}

	@Override
	public double cotanExpr(double x) {
		if(Math.tan(x)==0) {
			throw new IllegalArgumentException("phép toán không hợp lệ");
		}
		else {
			return 1 / Math.tan(x);
		}
	}

	@Override
	public double sinExpr(double x) {
		return Math.sin(x);
	}

	@Override
	public double tanExpr(double x) {
		return Math.tan(x);
	}
}