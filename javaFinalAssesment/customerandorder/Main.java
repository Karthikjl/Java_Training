package com.celcom.javaFinalAssesment.customerandorder;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {

		Scanner inputScanner = new Scanner(System.in);
		ScheduledExecutorService sExecutor = Executors.newScheduledThreadPool(1);
		sExecutor.scheduleAtFixedRate(() -> PlaceOrder.viewStatus(), 0, 60, TimeUnit.SECONDS);
		boolean running = true;

		while (running) {
			System.out.println("E-Commerce Order Processing System");
			System.out.println("1. Register Customer.");
			System.out.println("2. Add Product.");
			System.out.println("3. Update Quantity.");
			System.out.println("4. Place Order.");
			System.out.println("5. Exit.");
			System.out.print("Enter your Choice-> ");
			int choice = inputScanner.nextInt();

			switch (choice) {
			case 1:
				// register customer
				CustomerRegister.registerCustomer();
				break;
			case 2:
				// add product
				ProductRegister.addProduct();
				break;
			case 3:
				// update quantity
				ProductRegister.updateQuantity();
				break;
			case 4:
				// place order
				PlaceOrder.placeOrder();
				break;
			case 5:
				// exit
				System.out.println("Exiting, Thankyou for using E-Commerce Order Processing System");
				running = false;
				sExecutor.shutdown();
				break;
			default:
				System.out.println("Invalid Choice.");
			}
		}
		inputScanner.close();
	}

}
