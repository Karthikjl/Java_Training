package com.celcom.day13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//Customer details

class CustomerDetails {
	Connection con;
	Statement st;

	public CustomerDetails() {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userName = "system";
		String password = "12345678";

		try {
			con = DriverManager.getConnection(url, userName, password);
			st = con.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// add customer
	void addCustomer(String name, String dob, String address, String fatherName, long aadharNumber, long phoneNumber) {
		String query = "Insert into customer(name, dob, address, fathername, aadharno, phonenumber) VALUES (?, TO_DATE(?, 'DD-MM-YYYY'), ?, ?, ?, ?)";
		try (PreparedStatement pst = con.prepareStatement(query)) {
			pst.setString(1, name);
			pst.setString(2, dob);
			pst.setString(3, address);
			pst.setString(4, fatherName);
			pst.setLong(5, aadharNumber);
			pst.setLong(6, phoneNumber);
			pst.executeUpdate();

			System.out.println("Added Customer.\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// delete customer
	void deleteCustomer(long aadharNumber) {
		String query = "delete from customer where AADHARNO = ?";
		try (PreparedStatement pst = con.prepareStatement(query)) {
			pst.setLong(1, aadharNumber);
			pst.executeUpdate();
			System.out.println("Customer deleted.\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void updateAddress(Long aadharnum, String address) {
		String query = "update customer set address = ? where AADHARNO = ?";

		try (PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setString(1, address);
			pstmt.setLong(2, aadharnum);
			int updated = pstmt.executeUpdate();
			if (updated > 0) {
				System.out.println("Address updated.");
			} else {
				System.out.println("Customer not found.");
			}
		} catch (SQLException e) {
			System.out.println("Error occured while updating Address: " + e.getMessage());
		}
	}

	// veiw Customer details
	void viewCustomerDetail(Long aadharNumber) {
		String query = "SELECT * FROM customer WHERE aadharno =?";

		try (PreparedStatement pstmt = con.prepareStatement(query)) {

			pstmt.setLong(1, aadharNumber);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("============================================");
			if (rs.next()) {
				System.out.println("Cusomer Name: " + rs.getString("NAME"));
				System.out.println("Customer Dob: " + rs.getDate("DOB"));
				System.out.println("Customer Address: " + rs.getString("ADDRESS"));
				System.out.println("Customer Father Name: " + rs.getString("FATHERNAME"));
				System.out.println("Customer Aadhar: " + rs.getLong("AADHARNO"));
				System.out.println("Customer Phone number: " + rs.getLong("PHONENUMBER"));
			} else {
				System.out.println("Customer not found.");
			}

			System.out.println("============================================");
		} catch (SQLException e) {
			System.out.println("Error occured while viewing details: " + e.getMessage());
		}
	}

	// view all
	void viewAllCustomer() {
		String query = "SELECT * FROM customer";
		try (ResultSet rs = st.executeQuery(query)) {

			while (rs.next()) {
				System.out.println("=====================================");
				System.out.println("Cusomer Name: " + rs.getString(1));
				System.out.println("Customer Dob: " + rs.getDate(2));
				System.out.println("Customer Address: " + rs.getString(3));
				System.out.println("Customer Father Name: " + rs.getString(4));
				System.out.println("Customer Aadhar: " + rs.getLong(5));
				System.out.println("Customer Phone number: " + rs.getLong(6));
				System.out.println("=====================================");
			}
			System.out.println();
		} catch (SQLException e) {
			System.out.println("Error retrieving Customer: " + e.getMessage());
		}
	}

}

public class DatabaseEx4 {
	public static void main(String args[]) {

		Scanner inputScanner = new Scanner(System.in);
		CustomerDetails coustDetails = new CustomerDetails();
		boolean running = true;

		while (running) {
			System.out.println("Customer Details.");
			System.out.println("1. Create Customer");
			System.out.println("2. Delete Customer");
			System.out.println("3. Update Customer (by Aadhar)");
			System.out.println("4. View Customer Details (by Aadhar)");
			System.out.println("5. List All Customer");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");
			int choice = inputScanner.nextInt();

			switch (choice) {
			case 1:
				// add
				System.out.print("Enter Customer name: ");
				String name = inputScanner.next();
				System.out.print("Enter Customer dob(DD-MM-YYY): ");
				String dob = inputScanner.next();
				System.out.print("Enter Customer address: ");
				String address = inputScanner.next();
				System.out.print("Enter Customer Father name: ");
				String fatherName = inputScanner.next();
				System.out.print("Enter Customer Aadhar number: ");
				Long aadharNumber = inputScanner.nextLong();
				System.out.print("Enter Customer Phone Number: ");
				Long phoneNumber = inputScanner.nextLong();

				try {
					coustDetails.addCustomer(name, dob, address, fatherName, aadharNumber, phoneNumber);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:
				// delete
				System.out.print("Enter Aadhar Number to delete customer: ");
				Long aadharnumber = inputScanner.nextLong();
				coustDetails.deleteCustomer(aadharnumber);
				break;
			case 3:
				// update
				System.out.print("Enter Aadhar number: ");
				Long aadharnum = inputScanner.nextLong();

				System.out.print("Enter aadhar number to update address: ");
				String updatedAddress = inputScanner.next();

				coustDetails.updateAddress(aadharnum, updatedAddress);
				break;
			case 4:
				// view customer details
				System.out.print("Enter aadhar number: ");
				Long aadharDetails = inputScanner.nextLong();
				coustDetails.viewCustomerDetail(aadharDetails);
				break;
			case 5:
				// view all
				coustDetails.viewAllCustomer();
				break;
			case 6:
				System.out.println("Exiting..");
				running = false;
				break;
			default:
				System.out.println("Invalid choice");
			}

		}

		inputScanner.close();

	}

}
