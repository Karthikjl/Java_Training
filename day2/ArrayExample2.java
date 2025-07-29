package com.celcom.day2;

import java.util.Scanner;

public class ArrayExample2 {

	public static void main(String[] args) {
		int arr[] = new int[5];
		int sum = 0;
		int evenCount = 0, oddCount = 0;
		Scanner input = new Scanner(System.in);

		System.out.println("Initial value of array\n");

		for (int value : arr) {
			System.out.println("The element in array " + value);
		}

		System.out.println("\nEnter 5 values for array");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = input.nextInt();
			sum += arr[i];
			if (arr[i] % 2 == 0) {
				evenCount++;
			} else {
				oddCount++;
			}
		}

		System.out.println("The sum of array is " + sum);
		System.out.println("The number of even number present in an array: " + evenCount);
		System.out.println("The number of odd number present in an array: " + oddCount);
		input.close();
	}

}
