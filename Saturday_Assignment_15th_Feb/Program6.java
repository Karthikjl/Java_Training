package com.celcom.Saturday_Assignment_15th_Feb;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Program6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input;
		Scanner scanner = new Scanner(System.in);
		List<Integer> list = new LinkedList<>();
		System.out.print("Enter number of element: ");
		input = scanner.nextInt();
		System.out.print("Enter element number: ");
		for (int i = 0; i < input; i++) {
			list.add(scanner.nextInt());
		}

		System.out.print("Printing using iterator: ");

		for (Iterator<Integer> i = list.iterator(); i.hasNext();) {
			System.out.print(i.next() + " ");
		}
		scanner.close();

	}

}
