package com.revature.homework;

public class MethodsClass implements IMethods {

	@Override
	public double add(double num1, double num2) {
		double ans = num1 + num2;
		return ans;
	}

	@Override
	public double subtract(double num1, double num2) {
		double ans = num1 - num2;
		return ans;
	}

	@Override
	public double multiply(double num1, double num2) {
		double ans = num1 * num2;
		return ans;
	}

	@Override
	public double divide(double num1, double num2) {
		double ans = num1/num2;
		return ans;
	}

	

}
