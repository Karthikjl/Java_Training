package com.celcom.day14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

interface Process {
	void deposit(int id, int amount);

	void withdraw(int id, int amount);
}

class Customer implements Process {
	Connection con;
	Statement st;

	Customer() {
		String url = "jdbc:oracle:thin:@//172.19.0.5:1521/trainingsql.celcom.com";
		String username = "training";
		String password = "Celcom123";
		try {
			con = DriverManager.getConnection(url, username, password);
			st = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void addCustomer(int customerId, String name, int accountNumber, int balance) {
		String query = "insert into karthikeyan_customer_task1 values(?,?,?,?)";
		try (PreparedStatement pst = con.prepareStatement(query)) {
			pst.setInt(1, customerId);
			pst.setString(2, name);
			pst.setInt(3, accountNumber);
			pst.setInt(4, balance);
			pst.executeUpdate();
			System.out.println("Account added sucessfully.\n");
		} catch (SQLException e) {
			System.out.println("Error occured while adding customer");
			e.printStackTrace();
		}

	}

	void getAllCustomerDetails() {
		String query = "Select * from karthikeyan_customer_task1";

		try (ResultSet rs = st.executeQuery(query)) {

			while (rs.next()) {
				System.out.println("===========================");
				System.out.println("Customer id: " + rs.getInt(1));
				System.out.println("Customer name: " + rs.getString(2));
				System.out.println("Customer account number: " + rs.getInt(3));
				System.out.println("Customer balance: " + rs.getInt(4));
				System.out.println("===========================");
			}
		} catch (SQLException e) {
			System.out.println("Error occured while getting customer details.");
			e.printStackTrace();
		}
	}

	void getCustomerWithBalance(int amount) {
		String query = "Select * from karthikeyan_customer_task1 where balance > ?";
		try (PreparedStatement pst = con.prepareStatement(query)) {
			pst.setInt(1, amount);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println("===========================");
				System.out.println("Customer id: " + rs.getInt(1));
				System.out.println("Customer name: " + rs.getString(2));
				System.out.println("Customer account number: " + rs.getInt(3));
				System.out.println("Customer balance: " + rs.getInt(4));
				System.out.println("===========================");
			}
		} catch (SQLException e) {
			System.out.println("Error occured while featching...");
			e.printStackTrace();
		}
	}

	void updateBalance(int amount, int id) {
		String query = "update karthikeyan_customer_task1 set balance = ? where customer_id = ?";
		try (PreparedStatement pst = con.prepareStatement(query)) {
			pst.setInt(1, amount);
			pst.setInt(2, id);
			int updateStatus = pst.executeUpdate();
			if (updateStatus > 0) {
				System.out.println("Updated balance.");
			} else {
				System.out.println("Account not found.");

			}
		} catch (SQLException e) {
			System.out.println("Error occoured while updating balance.");
			e.printStackTrace();
		}

	}

	void deleteById(int id) {
		String query = "delete from karthikeyan_customer_task1 where customer_id = ?";

		try (PreparedStatement pst = con.prepareStatement(query)) {
			pst.setInt(1, id);
			int operation = pst.executeUpdate();

			if (operation > 0) {
				System.out.println("Customer deleted sucessfully");
			} else {
				System.out.println("Customer not found.");
			}
		} catch (SQLException e) {
			System.out.println("Error occured while deleting: " + e);
		}
	}

	public void deposit(int id, int amount) {
		String query = "UPDATE karthikeyan_customer_task1 SET balance = balance + ? WHERE customer_id = ?";
		try (PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setInt(1, amount);
			pstmt.setInt(2, id);
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

	public void withdraw(int id, int amount) {
		String query = "UPDATE karthikeyan_customer_task1 SET balance = balance - ? WHERE customer_id = ? and balance >0";
		try (PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setInt(1, amount);
			pstmt.setInt(2, id);
			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				System.out.println("withdrawed successful!");
			} else {
				System.out.println("Account not found.");
			}
		} catch (SQLException e) {
			System.out.println("Error during deposit: " + e.getMessage());
		}
	}

}

public class Task1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Customer customer = new Customer();
		boolean running = true;

		while (running) {
			System.out.println("\nCustomer Account Operation.\n");
			System.out.println("1. Add Customer.");
			System.out.println("2. Get all Customer details.");
			System.out.println("3. Get by balance.");
			System.out.println("4. Update balance.");
			System.out.println("5. Delete Customer.");
			System.out.println("6. Deposit.");
			System.out.println("7. Withdraw.");
			System.out.println("8. Exit.");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				// add
				System.out.print("Enter Customer Id: ");
				int customerId = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter Customer Name: ");
				String name = scanner.nextLine();
				System.out.print("Enter Customer Account Number: ");
				int accountNumber = scanner.nextInt();
				System.out.print("Enter Initial Amount: ");
				int amount = scanner.nextInt();
				customer.addCustomer(customerId, name, accountNumber, amount);
				break;

			case 2:
				// get all customer details
				customer.getAllCustomerDetails();
				break;

			case 3:
				// get by balance
				System.out.print("Enter amount to check: ");
				int amountCheck = scanner.nextInt();
				customer.getCustomerWithBalance(amountCheck);
				break;

			case 4:
				// update balance
				System.out.print("Enter Customer Id: ");
				int id = scanner.nextInt();
				System.out.print("Enter updated balance: ");
				int updatedBalance = scanner.nextInt();
				customer.updateBalance(updatedBalance, id);
				break;

			case 5:
				// delete customer
				System.out.print("Enter id to delete customer: ");
				int cId = scanner.nextInt();
				customer.deleteById(cId);
				break;

			case 6:
				// deposit money
				System.out.print("Enter customer id: ");
				int dId = scanner.nextInt();
				System.out.print("Enter Amount to deposit: ");
				int dAmount = scanner.nextInt();
				customer.deposit(dId, dAmount);
				break;

			case 7:
				// withdraw money
				System.out.print("Enter customer id: ");
				int wId = scanner.nextInt();
				System.out.print("Enter amount to withdraw: ");
				int wAmount = scanner.nextInt();
				customer.withdraw(wId, wAmount);
				break;

			case 8:
				System.out.println("Exiting, Thank you for using ;)");
				running = false;
				break;

			default:
				System.out.println("Invalid Choice.");

			}
		}

		scanner.close();

	}

}
