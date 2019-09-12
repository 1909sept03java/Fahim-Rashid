package com.revature.homework;

public class BubbleSort {
	
	public static void main(String[] args) {
		
		int[] myArray = {1,0,5,6,3,2,3,7,9,8,4};
		
		bubbleSort(myArray);
		
		for(int i : myArray) {
			System.out.print(i + " ");
		}
	}
	
    public static void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
         }
    }

}
