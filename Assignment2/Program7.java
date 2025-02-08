package com.celcom.Assignment2;

import java.util.ArrayList;
import java.util.Scanner;

class Account {
	private String name;
	private String accountNumber;
	private double balance;

	public Account(String name, String accountNumber, double balance) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("Deposited: " + amount);
		} else {
			System.out.println("Deposit amount must be positive.");
		}
	}

	public void withdraw(double amount) {
		if (amount > 0) {
			if (balance >= amount) {
				balance -= amount;
				System.out.println("Withdrew: " + amount);
			} else {
				System.out.println("Insufficient balance.");
			}
		} else {
			System.out.println("Withdrawal amount must be positive.");
		}
	}

	public String getAccountInfo() {
		return "Name: " + name + ", Account Number: " + accountNumber + ", Balance: " + balance;
	}
}

class Bank {
	private ArrayList<Account> accounts = new ArrayList<>();

	public void addAccount(Account account) {
		accounts.add(account);
	}

	public void removeAccount(String accountNumber) {
		accounts.removeIf(account -> account.getAccountNumber().equals(accountNumber));
	}

	public Account getAccount(String accountNumber) {
		for (Account account : accounts) {
			if (account.getAccountNumber().equals(accountNumber)) {
				return account;
			}
		}
		return null;
	}

	public void listAccounts() {
		if (accounts.isEmpty()) {
			System.out.println("No accounts available.");
		} else {
			for (Account account : accounts) {
				System.out.println(account.getAccountInfo());
			}
		}
	}
}

public class Program7 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Bank bank = new Bank();
		boolean running = true;

		while (running) {
			System.out.println("\nBank System Menu:");
			System.out.println("1. Create Account");
			System.out.println("2. Delete Account");
			System.out.println("3. Deposit Money");
			System.out.println("4. Withdraw Money");
			System.out.println("5. View Account Details");
			System.out.println("6. List All Accounts");
			System.out.println("7. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.print("Enter account holder's name: ");
				String name = scanner.nextLine();
				System.out.print("Enter account number: ");
				String accountNumber = scanner.nextLine();
				System.out.print("Enter initial deposit amount: ");
				double initialDeposit = scanner.nextDouble();
				Account newAccount = new Account(name, accountNumber, initialDeposit);
				bank.addAccount(newAccount);
				System.out.println("Account created successfully.");
				break;

			case 2:
				System.out.print("Enter account number to delete: ");
				String deleteAccountNumber = scanner.nextLine();
				bank.removeAccount(deleteAccountNumber);
				System.out.println("Account deleted successfully.");
				break;

			case 3:
				System.out.print("Enter account number: ");
				String depositAccountNumber = scanner.nextLine();
				Account depositAccount = bank.getAccount(depositAccountNumber);
				if (depositAccount != null) {
					System.out.print("Enter amount to deposit: ");
					double depositAmount = scanner.nextDouble();
					depositAccount.deposit(depositAmount);
				} else {
					System.out.println("Account not found.");
				}
				break;

			case 4:

				System.out.print("Enter account number: ");
				String withdrawAccountNumber = scanner.nextLine();
				Account withdrawAccount = bank.getAccount(withdrawAccountNumber);
				if (withdrawAccount != null) {
					System.out.print("Enter amount to withdraw: ");
					double withdrawAmount = scanner.nextDouble();
					withdrawAccount.withdraw(withdrawAmount);
				} else {
					System.out.println("Account not found.");
				}
				break;

			case 5:
				System.out.print("Enter account number: ");
				String viewAccountNumber = scanner.nextLine();
				Account viewAccount = bank.getAccount(viewAccountNumber);
				if (viewAccount != null) {
					System.out.println(viewAccount.getAccountInfo());
				} else {
					System.out.println("Account not found.");
				}
				break;

			case 6:
				bank.listAccounts();
				break;

			case 7:
				running = false;
				System.out.println("Exiting the system.");
				break;

			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}

	}
}
