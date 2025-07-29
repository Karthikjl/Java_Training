package com.celcom.Saturday_Assignment_15th_Feb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program5 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int input;
		System.out.print("Enter number of elements: ");
		input = scanner.nextInt();
		System.out.print("Enter number: ");
		for (int i = 0; i < input; i++) {
			list.add(scanner.nextInt());
		}
		System.out.println("The element printed by position.");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		scanner.close();
	}

}
