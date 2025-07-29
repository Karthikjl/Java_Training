package com.celcom.MockAssesment;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		Customer customer = new Customer();
		boolean running = true;

		ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
		ses.scheduleAtFixedRate(() -> customer.updateOrder(), 0, 30, TimeUnit.SECONDS);

		while (running) {
			System.out.println("Restaurant Food Order Application");
			System.out.println("1. Register Customer.");
			System.out.println("2. Add Items to menu.");
			System.out.println("3. Place a order.");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			int choice;
			choice = sc.nextInt();
//			sc.nextLine();
			switch (choice) {
			case 1:
				// register customer
				customer.addCustomer();
				break;
			case 2:
				// add menu
				customer.addFood();
				break;
			case 3:
				// place a order
				customer.orderFood();
				break;
			case 4:
				// exit
				System.out.println("Exiting thank you...");
				ses.shutdown();
				running = false;
				break;
			default:
				System.out.println("Invalid choice.");
				break;
			}
		}
		sc.close();
	}

}
