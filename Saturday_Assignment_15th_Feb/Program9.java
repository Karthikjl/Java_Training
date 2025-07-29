package com.celcom.Saturday_Assignment_15th_Feb;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Program9 {

	public static void main(String[] args) {
		int input;
		Scanner scanner = new Scanner(System.in);
		List<Integer> list = new LinkedList<>();
		System.out.print("Enter number of element: ");
		input = scanner.nextInt();
		System.out.print("Enter element number: ");
		for (int i = 0; i < input; i++) {
			list.add(scanner.nextInt());
		}
//		int i = 0;
		for (int val : list) {
			System.out.println(val + " in index " + list.indexOf(val));//i++
		}
		scanner.close();

	}

}
