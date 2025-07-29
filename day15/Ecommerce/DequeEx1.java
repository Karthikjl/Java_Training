package com.celcom.day15.Ecommerce;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DequeEx1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean running = true;
		int n = 5;
		Deque<String> queue = new ArrayDeque<String>();

		while (running) {
			System.out.println("E-Commerce 5-Viewed Product.");
			System.out.println("1. Add Search");
			System.out.println("2. View Searched");
			System.out.println("3. Exit");
			System.out.print("Enter your choice--> ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				// search
				System.out.print("Enter product name: ");
				String search = sc.next();
				if (queue.size() == n) {
					queue.removeLast();
				}
				queue.addFirst(search);
				System.out.println("Product added\n");

				break;
			case 2:
				// view searched
				if (queue.isEmpty()) {
					System.out.println("You did not searched anything.");

				} else {
					for (String val : queue) {
						System.out.println(val);
					}
				}
				break;
			case 3:
				running = false;
				System.out.println("Exiting Thank you.");
				break;
			default:
				System.out.println("Invalid choice.");
			}
		}
		sc.close();

	}

}
