package com.revature.homework;

public class EvenNumberChecker {

	public static void main(String[] args) {
		numberChecker(8);
	}
	
	public static void numberChecker( int x) {
		int y = x/2; 
		if(y*2== x){ 
			System.out.println("Even number"); 
		}else {System.out.println("Odd Number");}

	}
}
