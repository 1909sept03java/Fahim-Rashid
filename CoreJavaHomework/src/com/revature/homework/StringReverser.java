package com.revature.homework;

public class StringReverser {
		
		public static void main(String[] args) {
			
			String name = "Fahim";
			System.out.println(reverseMe(name));
			System.out.println(reverseMe("Hello"));
			
		}
		
		 static String reverseMe(String s) {
			   if(s.length() == 0)
			     return "";
			   else {
			   return s.charAt(s.length() - 1) + reverseMe(s.substring(0,s.length()-1));
			 
		}
	}

}
