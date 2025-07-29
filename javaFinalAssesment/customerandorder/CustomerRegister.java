package com.celcom.javaFinalAssesment.customerandorder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CustomerRegister {
	static Scanner inputScanner = new Scanner(System.in);

	static void registerCustomer() {
		System.out.print("Enter First name: ");
		String firstName = inputScanner.next();
		System.out.print("Enter Last name: ");
		String lastName = inputScanner.next();
		System.out.print("Enter Mobile number: ");
		String mobileNumber = inputScanner.next();
		System.out.print("Enter Email id: ");
		String emailId = inputScanner.next();
		System.out.print("Enter Address: ");
		String address = inputScanner.next();
		String paymentMethodString = null;
		String paymentDetails = null;
		while (paymentMethodString == null && paymentDetails == null) {
			System.out.print("1. Credit Card\n2. Debit Card\n3. UPI\nEnter Payment Method--> ");
			int paymentMethod = inputScanner.nextInt();
			switch (paymentMethod) {
			case 1:
				paymentMethodString = "Credit Card";
				System.out.print("Enter Credit Card number: ");
				paymentDetails = inputScanner.next();
				break;
			case 2:
				paymentMethodString = "Debit Card";
				System.out.print("Enter Debit Card number: ");
				paymentDetails = inputScanner.next();
				break;
			case 3:
				paymentMethodString = "UPI";
				System.out.print("Enter UPI Id: ");
				paymentDetails = inputScanner.next();
				break;
			default:
				System.out.println("Invalid choice.");
			}
		}
		String registerCustomerQuery = "insert into ecommercecustomerkarthikeyan(firstName,lastName,mobileNumber,emailId,address,paymentMethod,paymentDetails,paymentStatus) values(?,?,?,?,?,?,?,?)";
		try (PreparedStatement pst = DataBaseConnection.con.prepareStatement(registerCustomerQuery)) {
			pst.setString(1, firstName);
			pst.setString(2, lastName);
			pst.setString(3, mobileNumber);
			pst.setString(4, emailId);
			pst.setString(5, address);
			pst.setString(6, paymentMethodString);
			pst.setString(7, paymentDetails);
			pst.setString(8, "Active");
			pst.executeUpdate();

			String customerNumberquery = "select customerid from ecommercecustomerkarthikeyan order by customerid desc fetch first row only";
			try (Statement st = DataBaseConnection.con.createStatement()) {
				ResultSet rs = st.executeQuery(customerNumberquery);
				if (rs.next()) {
					int accountNumber = rs.getInt(1);
					System.out.println("Your Customer number is: ECOP" + accountNumber + "\n");
				}
			}
		} catch (SQLException e) {
			System.out.println("Error while registering customer " + e);
		}

	}

}
