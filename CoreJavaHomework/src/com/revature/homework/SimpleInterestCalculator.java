package com.revature.homework;

import java.util.Scanner;

public class SimpleInterestCalculator {
	
	static Scanner keyboardInput = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Enter your principal");
		double p = keyboardInput.nextDouble();
		System.out.println("Enter your rate");
		double r = keyboardInput.nextDouble();
		System.out.println("Enter amount of time");
		double t = keyboardInput.nextDouble();
		
		System.out.println("Your simple interest is " + simpleInterestCalc(p,r,t));
		
	}
	
	public static double simpleInterestCalc(double principal, double rate, double time) {
		double interest = principal * rate * time;
		return interest;
	}

}
