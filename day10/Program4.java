package com.celcom.day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Program4 {

	public static void main(String[] args) {
		List<Integer> newList1 = new ArrayList<Integer>();
		List<Integer> newList2 = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);
		int numOfElements;

		System.out.print("Enter number of elements: ");
		numOfElements = scanner.nextInt();
		System.out.print("Enter numbers in 1st ArrayList: ");
		for (int i = 0; i < numOfElements; i++) {
			newList1.add(scanner.nextInt());
		}

		System.out.print("Enter numbers in 2nd ArrayList: ");
		for (int i = 0; i < numOfElements; i++) {
			newList2.add(scanner.nextInt());
		}
		Collections.sort(newList1);
		Collections.sort(newList2);
		boolean isEquals = true;
		for (int i = 0; i < numOfElements; i++) {
			if (newList1.get(i) != newList2.get(i)) {
				isEquals = false;
				break;
			}
		}

		if (isEquals) {
			System.out.println("The Array list contains same elements.");
		} else {
			System.out.println("The Array list contains different element.");
		}

		scanner.close();
	}

}
