package com.revature.homework;

public class ArrayList {


	public static void main(String[] args) {

		ArrEditor alm = new ArrEditor();

		int[] myArray = {1,2,3,4,5,6,7,8,9,10};
		alm.EvenNumberSumPrinter(myArray);
		alm.OddNumberSumPrinter(myArray);
	}

	public  class ArrEditor{



		public  void EvenNumberSumPrinter(int [] myArray) {
			for (int i : myArray) {
				int sum = 0;
				if (i%2 == 0) {
					sum += i;
					System.out.print("Even numbers: " + i);
				}
			}
		}

		public  void OddNumberSumPrinter(int [] myArray) {
			for (int i : myArray) {
				int sum = 0;
				if (i%2 == 1) {
					sum += i;
					System.out.println("Odd numbers sum: " + i);
				}
			}
		}

	}

}
