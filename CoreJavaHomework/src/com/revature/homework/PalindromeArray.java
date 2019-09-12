package com.revature.homework;

public class PalindromeArray {

	public static void main(String[] args) {
		String[] originalArray = {"karan","madam","tom","civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did"};



		StringBuilder[] palindromeArray = palindromeSorter(originalArray);
		for(StringBuilder s : palindromeArray) {
			System.out.println(s);
		}


	}

	public static StringBuilder[] palindromeSorter(String[] arr) {
		StringBuilder[] newArray = new StringBuilder[arr.length];
		for(String x : arr) {
			StringBuilder sb = new StringBuilder(x);
			if(sb == sb.reverse()) {

				for(int i = 0; i <newArray.length; i++) {
					newArray[i] = sb;				
				}
			}
		}
		return newArray;
	}
}


