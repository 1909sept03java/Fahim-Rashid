package com.revature.homework;

public class EvenNumberPrinter {
	
	public static void main(String[] args) {
		
		int[] arr = new int[100];
		for(int i = 0; i <100; i++) {
			arr[i]=i;
		}
		
		printEvenNums(arr);
		
		
	}
	
	public static void printEvenNums(int[] myArray) {
		for(int x : myArray) {
			if(x%2 == 0) {
				System.out.print(x+ " ");
			}
		}
	}

}
