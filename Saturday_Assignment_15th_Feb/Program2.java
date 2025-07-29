package com.celcom.Saturday_Assignment_15th_Feb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class SortArrayList {
	List<Integer> list;

	public SortArrayList(List<Integer> list) {
		this.list = list;
	}

	void sortArray() {

		Collections.sort(list);
		System.out.print("The sorted array: " + list);
	}

}

public class Program2 {

	public static void main(String[] args) {
		int input;

		List<Integer> list = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of elements: ");
		input = scanner.nextInt();
		System.out.print("Enter element number: ");
		for (int i = 0; i < input; i++) {
			list.add(scanner.nextInt());
		}
		SortArrayList sortArray = new SortArrayList(list);
		sortArray.sortArray();
		scanner.close();
	}

}
