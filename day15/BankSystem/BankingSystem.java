package com.celcom.day15.BankSystem;

import java.sql.Timestamp;
import java.util.*;
import java.util.random.RandomGenerator;

public class BankingSystem {

	private static TreeSet<Transaction> deposits;
	private static TreeSet<Transaction> withdrawals;
	private static Scanner scanner = new Scanner(System.in);
	static RandomGenerator rg = RandomGenerator.getDefault();

	public static void main(String[] args) {

		Comparator<Transaction> transactionComparator = Comparator
				.comparing(Transaction::getAmount, Comparator.reverseOrder()).thenComparing(Transaction::getTimestamp);

		deposits = new TreeSet<>(transactionComparator);
		withdrawals = new TreeSet<>(transactionComparator);

		while (true) {
			System.out.println("\n===== Banking System Menu =====");
			System.out.println("1. Deposit Money");
			System.out.println("2. Withdraw Money");
			System.out.println("3. View Sorted Deposits");
			System.out.println("4. View Sorted Withdrawals");
			System.out.println("5. Exit");
			System.out.print("Choose an option: ");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				deposit();
				break;
			case 2:
				withdraw();
				break;
			case 3:
				viewTransactions(deposits, "Deposits");
				break;
			case 4:
				viewTransactions(withdrawals, "Withdrawals");
				break;
			case 5:
				System.out.println("Exiting... Thank you!");
				return;
			default:
				System.out.println("Invalid option. Try again.");
			}
		}

	}

	private static void deposit() {
		System.out.print("Enter deposit amount: ");
		double amount = scanner.nextDouble();
		Transaction transaction = new Transaction(rg.nextInt(100, 999), amount,
				new Timestamp(System.currentTimeMillis()), "Deposit");
		deposits.add(transaction);
		System.out.println("Deposit successful!");
	}

	private static void withdraw() {
		System.out.print("Enter withdrawal amount: ");
		double amount = scanner.nextDouble();
		Transaction transaction = new Transaction(rg.nextInt(1000, 2000), amount,
				new Timestamp(System.currentTimeMillis()), "Withdraw");
		withdrawals.add(transaction);
		System.out.println("Withdrawal successful!");
	}

	private static void viewTransactions(TreeSet<Transaction> transactions, String type) {
		if (transactions.isEmpty()) {
			System.out.println("No " + type.toLowerCase() + " transactions available.");
			return;
		}
		System.out.println("\n===== Sorted " + type + " =====");
		for (Transaction t : transactions) {
			System.out.println(t);
		}
	}
}
