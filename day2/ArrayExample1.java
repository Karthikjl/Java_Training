package com.celcom.day2;

public class ArrayExample1 {

	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40, 50 };
		int sum = 0;
		System.out.println("The length of array is " + arr.length + "\n");

		for (int i = 0; i < arr.length; i++) {
			System.out.println("The " + i + " Index element is " + arr[i]);
			sum += arr[i];
		}
		System.out.println("\nThe sum of array is " + sum);

		System.out.println("\nPrinting array using foreach");
		for (int value : arr) {
			System.out.print(value + " ");
		}
	}

}
