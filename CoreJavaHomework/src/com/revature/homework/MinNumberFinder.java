package com.revature.homework;

public class MinNumberFinder {

	
	public static void main(String[] args) {
		
		System.out.println(minNumber(9,3));
		
	}
	
	public static int minNumber(int firstNum, int secNum) {
		
		return (firstNum<secNum? firstNum : secNum);
	}
	
}
