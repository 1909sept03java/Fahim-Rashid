package com.revature.homework;

public class NFactorial {

	public static void main(String[] args) {

		System.out.println(nFactorial(5));
	}
	public static int nFactorial(int n) {
		if(n <1) {
			return 1;
		}else {
			return n = n *nFactorial(n-1);

		}
	}
}