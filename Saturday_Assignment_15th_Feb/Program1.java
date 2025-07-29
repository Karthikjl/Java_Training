package com.celcom.Saturday_Assignment_15th_Feb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//
class ContainsElement {
	List<Integer> list;

	public ContainsElement(List<Integer> list) {
		this.list = list;
	}

	public void containsElement(int input) {

		if (list.contains(input)) {
			System.out.println("The list contains number " + input + " in the index " + list.indexOf(input));
		} else {
			System.out.println("The list does not contains number " + input);
		}
	}
}

public class Program1 {

	public static void main(String[] args) {
		int input;
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		System.out.print("Enter number of element: ");
		input = sc.nextInt();
		System.out.print("Enter element number: ");
		for (int i = 0; i < input; i++) {
			list.add(sc.nextInt());
		}

		ContainsElement containsElement = new ContainsElement(list);
		System.out.print("Enter the number to search in a Arraylist: ");
		input = sc.nextInt();
		containsElement.containsElement(input);
		sc.close();

	}

}
