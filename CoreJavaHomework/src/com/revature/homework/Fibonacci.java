package com.revature.homework;

public class Fibonacci {
	public static void main(String args[]){    

		int num1 = 0;
		int num2 = 1;
		int num3;
		int i = 0;
		while(i<2) {
			System.out.print(i + " ");
			i++;
		}while(i<25) {
			num3 = num1+num2;
			System.out.print(num3 + " ");
			num1 = num2;
			num2 = num3;
			i++;
		}

	}

}
