package com.celcom.Saturday_Assignment_15th_Feb;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Program8 {

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
		ListIterator<Integer> iteratorList = list.listIterator(input);
		System.out.println(list.size());
		System.out.print("Printing in reverse order: ");

		while (iteratorList.hasPrevious()) {
			System.out.print(iteratorList.previous() + " ");

		}

		System.out.println("\n" + list);
		scanner.close();

	}

}
