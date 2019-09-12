package com.revature.homework;

public class SubString {
	
	public static void main(String[] args) {
		
		
		substring("Elephant",3);
		
	}
	
	public static void substring(String str, int ind) {
		int i = 0;
		
		char[] myArray = new char[ind];

		while(i<ind) {
			myArray[i]  =str.charAt(i);
			
			for(int x=0;x<myArray.length;x++) {
				System.out.print(myArray[x]);
				
			}i++;
			
			
		}
	}

}
