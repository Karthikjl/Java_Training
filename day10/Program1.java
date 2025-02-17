package com.celcom.day10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
<<<<<<< HEAD
//
=======

>>>>>>> cdebdd70e7246b64b5e9d997db24474c36e47f44
public class Program1 {
	public static void display(List<Integer> list) {
		for (int val : list) {
			System.out.print(val + " ");
		}
		System.out.println("\n" + list.getClass());
	}

	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<Integer>();
		List<Integer> linkedList = new LinkedList<Integer>();

		int input;
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of element: ");
		input = scanner.nextInt();
		System.out.print("Enter element number: ");
		for (int i = 0; i < input; i++) {
			arrayList.add(scanner.nextInt());
		}
		System.out.print("Array list: ");
		display(arrayList);

		for (int val : arrayList) {
			linkedList.add(val);
		}
		System.out.print("Linked List: ");
		display(linkedList);
		scanner.close();
	}

}
