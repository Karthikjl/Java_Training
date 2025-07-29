package com.celcom.day15.Ecommerce;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class LinkedHashMapEx1 {
	private static final int MAX_SIZE = 5;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean running = true;

		Map<String, String> viewedProducts = new LinkedHashMap<String, String>(MAX_SIZE, 0.75f,false) {
			public boolean removeEldestEntry(Map.Entry<String, String> eldest) {
				return size() > MAX_SIZE;
			}
		};

		while (running) {
			System.out.println("\nE-Commerce 5-Viewed Product.");
			System.out.println("1. Add Search");
			System.out.println("2. View Searched");
			System.out.println("3. Exit");
			System.out.print("Enter your choice--> ");

			int choice;
			try {
				choice = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				System.out.println("Enter a correct choice.");
				sc.nextLine();
				continue;
			}

			switch (choice) {
			case 1:

				System.out.print("Enter product name: ");
				String search = sc.nextLine();

				viewedProducts.remove(search);

				viewedProducts.put(search, search);

				System.out.println("Product added: " + search);
				break;

			case 2:

				if (viewedProducts.isEmpty()) {
					System.out.println("No recently viewed products.");
				} else {
					System.out.println("Recently viewed products (most recent first):");

					List<String> productList = new ArrayList<>(viewedProducts.keySet());
					Collections.reverse(productList);

					for (String product : productList) {
						System.out.println(product);

					}
				}
				break;

			case 3:
				running = false;
				System.out.println("Exiting... Thank you.");
				break;

			default:
				System.out.println("Invalid choice. Please enter 1, 2, or 3.");
			}
		}

		sc.close();
	}
}
