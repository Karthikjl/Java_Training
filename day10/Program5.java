package com.celcom.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//3 1 4 5 6

public class Program5 {
	public static List<Integer> sortArray(List<Integer> list, int num) {
		for (int i = 0; i < num; i++) {
			for (int j = i + 1; j < num; j++) {
				if (list.get(i) > list.get(j)) {
					int temp = list.get(j);
					list.set(j, list.get(i));
					list.set(i, temp);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		int num;
		Scanner scanner = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();

		System.out.print("Enter number of element: ");
		num = scanner.nextInt();
		System.out.print("Enter array elements: ");
		for (int i = 0; i < num; i++) {
			list.add(scanner.nextInt());
		}
		System.out.println("Sorted array: " + sortArray(list, num));
		scanner.close();

	}

}
