package com.celcom.day2;

import java.util.Arrays;

public class ArraySortExample {

	public static void main(String[] args) {
		int arr[] = { 4, 432, 3422, 5657, 236, 8, 7667 };
		System.out.println("Before Sorting");
		for (int value : arr) {
			System.out.print(value + " ");
		}

		Arrays.sort(arr);
		System.out.println("\n\nAcending Sort");
		for (int value : arr) {
			System.out.print(value + " ");
		}

		System.out.println("\n\nMinimum Value: " + arr[0]);
		System.out.println("Second Minimum Value: " + arr[1]);

		System.out.println("\nMaximum Value: " + arr[arr.length - 1]);
		System.out.println("Second Maximum Value: " + arr[arr.length - 2]);

		System.out.println("\nDecending Sort");
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}

	}

}
