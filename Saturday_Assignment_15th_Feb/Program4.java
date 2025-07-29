package com.celcom.Saturday_Assignment_15th_Feb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ReverseArrayList {
	List<Integer> list = new ArrayList<>();

	ReverseArrayList(List<Integer> list) {
		this.list = list;
	}

	void reverseList() {
		List<Integer> revList = new ArrayList<>();
		System.out.print("Before Array list reversed: ");
		for (int val : list) {
			System.out.print(val + " ");
		}
		for (int i = list.size() - 1; i >= 0; i--) {
			revList.add(list.get(i));
		}
		System.out.print("\nAfter Array list reversed: ");
		for (int revVal : revList) {
			System.out.print(revVal + " ");
		}
	}

}

public class Program4 {

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

		ReverseArrayList revList = new ReverseArrayList(list);
		revList.reverseList();

		scanner.close();

	}

}
