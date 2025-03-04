package com.celcom.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of users: ");
		int userCount = scanner.nextInt();
		scanner.nextLine();

		List<UserData> users = new ArrayList<>();
		for (int i = 1; i <= userCount; i++) {
			System.out.println("\nUser " + i + ":");
			System.out.print("Enter phone number: ");
			String phoneNumber = scanner.nextLine();
			System.out.print("Enter email address: ");
			String emailAddress = scanner.nextLine();
			users.add(new UserData(phoneNumber, emailAddress));
		}

		ExecutorService executor = Executors.newCachedThreadPool();

		for (UserData user : users) {
			executor.submit(new SmsTask(user.getPhoneNumber()));
			executor.submit(new EmailTask(user.getEmailAddress()));
		}

		executor.shutdown();

		scanner.close();
	}
}
