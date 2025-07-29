package com.celcom.javaFinalAssesment.customerandorder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PlaceOrder {

	static Scanner inputScanner = new Scanner(System.in);

	static void placeOrder() {
		System.out.print("Enter Customer Id Last number: ");
		int customerId = inputScanner.nextInt();
		String query = "select count(*) from ecommercecustomerkarthikeyan where customerid = ?";
		try (PreparedStatement pst = DataBaseConnection.con.prepareStatement(query)) {
			pst.setInt(1, customerId);
			ResultSet rs = pst.executeQuery();
			rs.next();
			if (rs.getInt(1) > 0) {

				String category = null;
				while (category == null) {
					System.out.print("1. Electronics\n2. Clothing\nSelect Category Eg(1 or 2)--> ");
					int categoryChoice = inputScanner.nextInt();
					if (categoryChoice == 1) {
						category = "Electronics";

					} else if (categoryChoice == 2) {
						category = "Clothing";

					} else {
						System.out.println("Invalid Category try again.");
					}
				}
				displayCategory(category);
				System.out.print("Enter product id: ");
				int productId = inputScanner.nextInt();

				String productIdContainsQuery = "select count(*) from ecommerceproductkarthikeyan where productid = ?";

				try (PreparedStatement pstProduct = DataBaseConnection.con.prepareStatement(productIdContainsQuery)) {
					pstProduct.setInt(1, productId);
					ResultSet rsproduct = pstProduct.executeQuery();
					rsproduct.next();
					if (rsproduct.getInt(1) > 0) {
						System.out.print("Enter product quantity: ");
						int productQuantity = inputScanner.nextInt();
						String orderQuery = "insert into ecommerceorderkarthikeyan(accountnumber,productid,quantity,price,status) values(?,?,?,?,?)";
						try (PreparedStatement pstOrder = DataBaseConnection.con.prepareStatement(orderQuery)) {
							pstOrder.setInt(1, customerId);
							pstOrder.setInt(2, productId);
							pstOrder.setInt(3, productQuantity);
							pstOrder.setInt(4, 0);
							pstOrder.setString(5, "New");
							pstOrder.executeUpdate();
							System.out.println("New Order Created.");
						}
					} else {
						System.out.println("Product Id not found try again\n");
					}
				}
			} else {
				System.out.println("User not found try to register first\n");
			}

		} catch (SQLException e) {
			System.out.println("Error occured while ordering food: " + e);
		}
	}

	static void displayCategory(String category) {
		String displayQuery = "select * from ecommerceproductkarthikeyan where category = ?";
		try (PreparedStatement pstm = DataBaseConnection.con.prepareStatement(displayQuery)) {
			pstm.setString(1, category);

			ResultSet res = pstm.executeQuery();
			System.out.println("-----------------------------------");
			System.out.println("Id  |  Name  |  \tPrice");
			System.out.println("-----------------------------------");
			while (res.next()) {
				System.out.println(
						res.getInt("Productid") + "\t" + res.getString("productName") + "    " + res.getInt("price"));
			}
			System.out.println("-----------------------------------");
		} catch (SQLException e) {

			System.out.println("Error oocured while displaying category: " + e);
		}
	}

	static void viewStatus() {
		String query = "Select Status,orderid from ecommerceorderkarthikeyan";
		try {
			Statement st = DataBaseConnection.con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				int orderid = rs.getInt("orderid");
				String status = rs.getString("status");
				System.out.println("\nOrder Id: " + orderid + " Status: " + status);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
