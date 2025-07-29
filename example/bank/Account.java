package com.celcom.example.bank;

import java.sql.*;
import java.util.Scanner;

class Bank {
	private Connection con;
	private Statement statement;

	// Constructor to establish database connection
	public Bank() {
		String url = "jdbc:mysql://localhost:3306/bankapplication";
		String userName = "root";
		String passWord = "12345678";

		try {
			con = DriverManager.getConnection(url, userName, passWord);
			statement = con.createStatement();
		} catch (SQLException e) {
			System.out.println("Database connection failed: " + e.getMessage());
		}
	}

	// Create account
	public void createAccount(String name, double initialAmount, int pin) {
		String query = "INSERT INTO account(name, balance, pin) VALUES (?, ?, ?)";
		try (PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			pstmt.setString(1, name);
			pstmt.setDouble(2, initialAmount);
			pstmt.setInt(3, pin);
			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int accountNumber = rs.getInt(1);
				System.out.println("Account Created Successfully! Account Number: " + accountNumber);
			}
		} catch (SQLException e) {
			System.out.println("Error creating account: " + e.getMessage());
		}
	}

	// Delete account
	public void removeAccount(int accountNumber) {
		String query = "DELETE FROM account WHERE accountnumber = ?";
		try (PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setInt(1, accountNumber);
			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				System.out.println("Account deleted successfully!");
			} else {
				System.out.println("Account not found.");
			}
		} catch (SQLException e) {
			System.out.println("Error deleting account: " + e.getMessage());
		}
	}

	// Deposit money
	public void deposit(int accountNumber, double amount) {
		String query = "UPDATE account SET balance = balance + ? WHERE accountnumber = ?";
		try (PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setDouble(1, amount);
			pstmt.setInt(2, accountNumber);
			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				System.out.println("Deposit successful!");
			} else {
				System.out.println("Account not found.");
			}
		} catch (SQLException e) {
			System.out.println("Error during deposit: " + e.getMessage());
		}
	}

	// Withdraw money
	public void withdraw(int accountNumber, double amount, int pin) {
		String checkQuery = "SELECT balance, pin FROM account WHERE accountnumber = ?";
		String updateQuery = "UPDATE account SET balance = balance - ? WHERE accountnumber = ?";

		try (PreparedStatement checkStmt = con.prepareStatement(checkQuery);
				PreparedStatement updateStmt = con.prepareStatement(updateQuery)) {

			checkStmt.setInt(1, accountNumber);
			ResultSet rs = checkStmt.executeQuery();

			if (rs.next()) {
				double balance = rs.getDouble("balance");
				int correctPin = rs.getInt("pin");

				if (pin == correctPin) {
					if (balance >= amount) {
						updateStmt.setDouble(1, amount);
						updateStmt.setInt(2, accountNumber);
						updateStmt.executeUpdate();
						System.out.println("Withdrawal successful!");
					} else {
						System.out.println("Insufficient balance.");
					}
				} else {
					System.out.println("Incorrect PIN.");
				}
			} else {
				System.out.println("Account not found.");
			}
		} catch (SQLException e) {
			System.out.println("Error during withdrawal: " + e.getMessage());
		}
	}

	// View account details
	public void viewAccount(int accountNumber) {
		String query = "SELECT * FROM account WHERE accountnumber = ?";
		try (PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setInt(1, accountNumber);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("Account Number: " + rs.getInt("accountnumber"));
				System.out.println("Name: " + rs.getString("name"));
				System.out.println("Balance: ₹" + rs.getDouble("balance"));
				System.out.println("Pin: " + rs.getInt("pin"));
			} else {
				System.out.println("Account not found.");
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving account details: " + e.getMessage());
		}
	}

	// List all accounts
	public void listAccounts() {
		String query = "SELECT * FROM account";
		try (ResultSet rs = statement.executeQuery(query)) {
			System.out.println("Account Details:");
			while (rs.next()) {
				System.out.println("Account Number: " + rs.getInt("accountnumber") + ", Name: " + rs.getString("name")
						+ ", Balance: ₹" + rs.getDouble("balance"));
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving accounts: " + e.getMessage());
		}
	}
}


public class Account {
	public static void main(String args[]) {
		Scanner inputScanner = new Scanner(System.in);
		Bank bank = new Bank();
		boolean running = true;

		while (running) {
			System.out.println("\nBank System");
			System.out.println("1. Create Account");
			System.out.println("2. Delete Account");
			System.out.println("3. Deposit Money");
			System.out.println("4. Withdraw Money");
			System.out.println("5. View Account Details");
			System.out.println("6. List All Accounts");
			System.out.println("7. Exit");
			System.out.print("Enter your choice: ");
			int choice = inputScanner.nextInt();
			inputScanner.nextLine();

			switch (choice) {
			case 1:
				System.out.print("Enter account holder's name: ");
				String name = inputScanner.nextLine();
				System.out.print("Enter Initial amount: ");
				double initialAmount = inputScanner.nextDouble();
				System.out.print("Enter pin: ");
				int pin = inputScanner.nextInt();
				bank.createAccount(name, initialAmount, pin);
				break;
			case 2:
				System.out.print("Enter account number to delete: ");
				int deleteAccountNumber = inputScanner.nextInt();
				bank.removeAccount(deleteAccountNumber);
				break;
			case 3:
				System.out.print("Enter Account Number: ");
				int depositAccountNumber = inputScanner.nextInt();
				System.out.print("Enter amount to deposit: ");
				double depositAmount = inputScanner.nextDouble();
				bank.deposit(depositAccountNumber, depositAmount);
				break;
			case 4:
				System.out.print("Enter Account Number: ");
				int withdrawAccountNumber = inputScanner.nextInt();
				System.out.print("Enter Pin: ");
				int pinNumber = inputScanner.nextInt();
				System.out.print("Enter amount to withdraw: ");
				double withdrawAmount = inputScanner.nextDouble();
				bank.withdraw(withdrawAccountNumber, withdrawAmount, pinNumber);
				break;
			case 5:
				System.out.print("Enter account number: ");
				int accountNum = inputScanner.nextInt();
				bank.viewAccount(accountNum);
				break;
			case 6:
				bank.listAccounts();
				break;
			case 7:
				System.out.println("Thank you for using the Bank System.");
				running = false;
				break;
			default:
				System.out.println("Invalid Choice. Try again.");
			}
		}
		inputScanner.close();
	}
}
