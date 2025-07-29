package com.celcom.Saturday_Assignment_15th_Feb;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Program10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input;
		Scanner scanner = new Scanner(System.in);
		List<Integer> list = new LinkedList<>();
		List<Integer> copyList = new LinkedList<>();
		System.out.print("Enter number of element: ");
		input = scanner.nextInt();
		System.out.print("Enter element number: ");
		for (int i = 0; i < input; i++) {
			list.add(scanner.nextInt());
		}
		System.out.print("Printing original LinkedList: ");
		Iterator<Integer> iterator = list.iterator();

		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");

		}

		for (int val : list) {
			copyList.add(val);
		}
		System.out.println();
		System.out.print("Printing Copy LinkedList: ");
		iterator = copyList.iterator();

		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		scanner.close();

	}

}
