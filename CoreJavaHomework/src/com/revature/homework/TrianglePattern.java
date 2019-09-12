package com.revature.homework;

public class TrianglePattern {
	public static void main(String[] args) {

		printStars();
	}

	public static void printStars() 
	{ 
		int i, j; 
		for(i=0; i<5; i++) 
		{ 

			for(j=0; j<=i; j++) 
			{ 
				System.out.print(j); 
			} 
			System.out.println(); 
		} 

	}
}