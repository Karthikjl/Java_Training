package com.celcom.Saturday_Assignment_8th_Feb_2025;

import java.util.HashMap;
import java.util.Scanner;

class Account {
	private String userName;
	private double balance;
	private int accountNumber;
	private int pin;

	Account(String userName, double amount, int accountNumber, int pin) {
		this.userName = userName;
		this.balance = amount;
		this.accountNumber = accountNumber;
		this.pin = pin;
	}

	public String getUserName() {
		return userName;
	}

	public double getBalance() {
		return balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("Deposited: " + amount);
			System.out.println("Total: " + balance);
		} else {
			System.out.println("Amount must be in positive");
		}
	}

	public void withdraw(double amount, int userPin) {
		if (this.pin == userPin) {
			if (amount > 0) {
				if (balance >= amount) {
					balance -= amount;
					System.out.println("Withdrew: " + amount);
					System.out.println("Balance: " + balance);
				} else {
					System.out.println("Insufficient Balance");
				}
			} else {
				System.out.println("Withdrawl amount should be in positive");
			}
		} else {
			System.out.println("Entered a wrong pin");
		}
	}

	public String displayDetails() {
		return "Name: " + userName + "\n" + "Balance: " + balance + "\n" + "Account number: " + accountNumber + "\n";
	}
}

class Bank {

	private HashMap<Integer, Account> accounts = new HashMap<>();

	public void addAccount(Account account) {
		accounts.put(account.getAccountNumber(), account);
	}

	public void removeAccount(int accountNumber) {
		if (accounts.containsKey(accountNumber)) {
			accounts.remove(accountNumber);
			System.out.println("Account deleted successfully.");
		} else {
			System.out.println("Account not found.");
		}
	}

	public Account getAccount(int accountNumber) {
		return accounts.get(accountNumber);
	}

	public void listAccount() {
		if (accounts.isEmpty()) {
			System.out.println("No accounts available.");
		} else {
			for (Account account : accounts.values()) {
				System.out.println(account.displayDetails());
			}
		}
	}

}

class Program7 {
	public static void main(String args[]) {
		Scanner inputScanner = new Scanner(System.in);
		Bank bank = new Bank();
		boolean running = true;

		while (running) {
			System.out.println("Bank System\n");
			System.out.println("1. Create Account");
			System.out.println("2. Delete Account");
			System.out.println("3. Deposit Money");
			System.out.println("4. Withdraw Money");
			System.out.println("5. View Account Details");
			System.out.println("6. List All Accounts");
			System.out.println("7. Exit\n");
			System.out.print("Enter your choice: ");
			int choice = inputScanner.nextInt();
			inputScanner.nextLine();

			switch (choice) {
			case 1:
				System.out.print("Enter account holder's name: ");
				String name = inputScanner.nextLine();
				System.out.print("Enter account number: ");
				int accountNumber = inputScanner.nextInt();
				System.out.print("Enter Initial amount: ");
				double initialAmount = inputScanner.nextDouble();
				inputScanner.nextLine();
				System.out.print("Enter pin: ");
				int pin = inputScanner.nextInt();

				Account newAccount = new Account(name, initialAmount, accountNumber, pin);
				bank.addAccount(newAccount);
				System.out.println("Account Created Sucessfully.");
				break;
			case 2:
				System.out.print("Enter account number to delete: ");
				int deleteAccountNumber = inputScanner.nextInt();
				bank.removeAccount(deleteAccountNumber);
				break;
			case 3:
				System.out.print("Enter Account Number: ");
				int depositAccountNumber = inputScanner.nextInt();
				Account depositAccount = bank.getAccount(depositAccountNumber);
				if (depositAccount != null) {
					System.out.print("Enter amount to deposit: ");
					double depositAmount = inputScanner.nextDouble();
					depositAccount.deposit(depositAmount);
				} else {
					System.out.println("Account not found.");
				}
				break;
			case 4:
				System.out.print("Enter Account Number: ");
				int withdrawAccountNumber = inputScanner.nextInt();

				Account withdrawAccount = bank.getAccount(withdrawAccountNumber);

				if (withdrawAccount != null) {
					System.out.print("Enter Pin Number: ");
					int pinNumber = inputScanner.nextInt();
					System.out.print("Enter amount to withdraw: ");
					double withdrawAmount = inputScanner.nextDouble();
					withdrawAccount.withdraw(withdrawAmount, pinNumber);
				} else {
					System.out.println("Account not found.");
				}
				break;
			case 5:
				System.out.print("Enter account number: ");
				int accountNum = inputScanner.nextInt();

				Account viewAccount = bank.getAccount(accountNum);

				if (viewAccount != null) {
					System.out.println(viewAccount.displayDetails());
				} else {
					System.out.println("Account not found.");
				}
				break;

			case 6:
				bank.listAccount();
				break;
			case 7:
				System.out.println("Exiting Bank Application");
				inputScanner.close();
				running = false;
				break;

			default:
				System.out.println("Invalid Choice. Please try again.");
			}
		}

	}
}