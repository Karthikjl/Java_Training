package com.celcom.javaFinalAssesment.customerandorder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class ProductRegister {

	static Scanner inputScanner = new Scanner(System.in);

	static void addProduct() {
		System.out.print("Enter Product name: ");
		String productName = inputScanner.nextLine();
		int categoryNum = 0;
		String category = null;
		while (category == null) {
			System.out.print("1. Electronics\n2. Clothing\nEnter Category: ");
			categoryNum = inputScanner.nextInt();

			if (categoryNum == 1) {
				category = "Electronics";

			} else if (categoryNum == 2) {
				category = "Clothing";

			} else {
				System.out.println("Invalid Category try again.");
			}
		}
		System.out.print("Enter price per quantity: ");
		int price = inputScanner.nextInt();

		System.out.print("Enter Product Quantity: ");
		int quantity = inputScanner.nextInt();
		inputScanner.nextLine();
		String addProduct = "insert into ecommerceproductkarthikeyan(productName,category,price,quantity) values(?,?,?,?)";

		try (PreparedStatement pst = DataBaseConnection.con.prepareStatement(addProduct)) {
			pst.setString(1, productName);
			pst.setString(2, category);
			pst.setInt(3, price);
			pst.setInt(4, quantity);
			pst.executeUpdate();
			String customerNumberquery = "select productid from ecommerceproductkarthikeyan order by productid desc fetch first row only";
			try (Statement st = DataBaseConnection.con.createStatement()) {
				ResultSet rs = st.executeQuery(customerNumberquery);
				if (rs.next()) {
					int productId = rs.getInt(1);
					System.out.println("Product Id: ECOP" + productId + "\n");
				}
			}

		} catch (SQLException e) {
			System.out.print("Error Occured while Adding product: " + e);

		}
	}

	static void updateQuantity() {
		displayProduct();
		System.out.print("Enter id of product: ");
		int id = inputScanner.nextInt();
		System.out.print("Enter quantity: ");
		int quantity = inputScanner.nextInt();
		String query = "update ecommerceproductkarthikeyan set quantity= ? where productid = ?";
		try (PreparedStatement pst = DataBaseConnection.con.prepareStatement(query)) {
			pst.setInt(1, quantity);
			pst.setInt(2, id);
			pst.executeUpdate();
			System.out.println("Updated Quantity");
			displayProduct();
		} catch (SQLException e) {
			System.out.print("Error occured while updating quantity: " + e);
		}
	}

	static void displayProduct() {
		String displayQuery = "select * from ecommerceproductkarthikeyan";
		try (Statement st = DataBaseConnection.con.createStatement(); ResultSet res = st.executeQuery(displayQuery)) {
			System.out.println("---------------------------------------------");
			System.out.println("Id  |  Name  |  \tPrice  |  Quantity");
			System.out.println("---------------------------------------------");
			while (res.next()) {
				System.out.println(res.getInt("Productid") + "\t" + res.getString("productName") + "    "
						+ res.getInt("price") + "    " + res.getInt("quantity"));

			}
			System.out.println("---------------------------------------------");
		} catch (SQLException e) {
			System.out.println("Error oocured while displaying category: " + e);
		}
	}

}
