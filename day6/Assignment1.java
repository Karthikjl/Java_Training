package com.celcom.day6;

import java.util.Scanner;

class AssignmentEx extends Exception {

	public String toString() {
		return "Duplicate element found";
	}
}

public class Assignment1 {

	public static void main(String[] args) {

		int num;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter total number to enter: ");
		num = input.nextInt();
		int arr[] = new int[num];
		try {
			for (int i = 0; i < num; i++) {
				arr[i] = input.nextInt();
				for (int j = 0; j < i + 1; j++) {
					if (i != j && arr[i] == arr[j]) {
						throw new AssignmentEx();
					}
				}
			}
		} catch (AssignmentEx e) {
			System.out.println(e);
		}

	}
}
