package com.celcom.MockAssesment;

import java.sql.Statement;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
	Connection con;
	Statement st;
	Scanner sc = new Scanner(System.in);

	Customer() throws SQLException {
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

	void addCustomer() {
		System.out.print("Enter First name : ");
		String firstName = sc.next();
		System.out.print("Enter Last name: ");
		String lastName = sc.next();
		System.out.print("Enter mobile number: ");
		String mobileNumber = sc.next();
		System.out.print("Enter email address: ");
		String email = sc.next();
		System.out.print("Enter address: ");
		String address = sc.next();
		String query = "insert into customer_karthikeyan(first_name,last_name,mobile_no,email,address) values(?,?,?,?,?)";
		try (PreparedStatement pst = con.prepareStatement(query)) {
			pst.setString(1, firstName);
			pst.setString(2, lastName);
			pst.setString(3, mobileNumber);
			pst.setString(4, email);
			pst.setString(5, address);

			pst.executeUpdate();
			String accountNumberquery = "select customer_id from customer_karthikeyan order by customer_id desc fetch first row only";
			try (Statement st = con.createStatement()) {
				ResultSet rs = st.executeQuery(accountNumberquery);
				if (rs.next()) {
					int accountNumber = rs.getInt(1);
					System.out.println("Your account number is: " + accountNumber + "\n");
				}
			}

		} catch (SQLException e) {
			System.out.println("Error while adding customer: " + e);
		}
	}

	void addFood() {
		System.out.print("Enter food name: ");
		String foodName = sc.next();
		System.out.print("Category\n1. Starter\n2. Main Course\n3. Dessert\nEnter Category: ");
		int categoryInt = sc.nextInt();
		String categoryString = null;
		switch (categoryInt) {
		case 1:
			categoryString = "Starter";
			break;
		case 2:
			categoryString = "Main Course";
			break;
		case 3:
			categoryString = "Dessert";
			break;
		default:
			System.out.println("Invalid option selected.");
			break;
		}
		System.out.print("Enter price: ");
		int price = sc.nextInt();
		String query = "insert into menu_karthikeyan(food_name,food_category,price) values(?,?,?)";
		try (PreparedStatement pst = con.prepareStatement(query)) {
			pst.setString(1, foodName);
			pst.setString(2, categoryString);
			pst.setInt(3, price);
			pst.executeUpdate();

			String foodIdquery = "select food_id from menu_karthikeyan order by food_id desc fetch first row only";
			try (Statement st = con.createStatement()) {
				ResultSet rs = st.executeQuery(foodIdquery);
				if (rs.next()) {
					int foodId = rs.getInt(1);
					System.out.println("Food id of " + foodName + " is: " + foodId + "\n");
				}
			}

		} catch (SQLException e) {
			System.out.println("Error while adding food: " + e);
		}
	}

	void orderFood() {
		System.out.print("Enter Account number: ");
		int accountNumber = sc.nextInt();
		String query = "select count(*) from customer_karthikeyan where customer_id = ?";
		try (PreparedStatement pst = con.prepareStatement(query)) {
			pst.setInt(1, accountNumber);
			ResultSet rs = pst.executeQuery();
			rs.next();
			if (rs.getInt(1) > 0) {
				displayMenu();

				System.out.print("Enter menu id: ");
				int menuId = sc.nextInt();

				System.out.print("Enter quantity: ");
				int quantity = sc.nextInt();

				String orderQuery = "insert into order_karthikeyan(account_number,menu_id,quantity,price,status) values(?,?,?,?,?)";

				try (PreparedStatement pstm = con.prepareStatement(orderQuery)) {
					pstm.setInt(1, accountNumber);
					pstm.setInt(2, menuId);
					pstm.setInt(3, quantity);
					pstm.setInt(4, 0);
					pstm.setString(5, "NEW");
					pstm.executeQuery();
					Statement st = con.createStatement();
					String queryOrderId = "select order_id from order_karthikeyan order by order_id desc fetch first row only";
					ResultSet res = st.executeQuery(queryOrderId);
					if (res.next()) {
						int orderId = res.getInt(1);
						System.out.println("Order is created. order id is " + orderId + ", Please wait");
					}
				}

			} else {
				System.out.println("User not found.");
			}

		} catch (SQLException e) {
			System.out.println("Error occured while ordering food: " + e);
		}

	}

	void displayMenu() {
		String query = "Select * from menu_karthikeyan";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			System.out.println("-----------------------------------");
			System.out.println("Id  |  " + "Name  |  " + "Category" + "  |  " + "Price");
			System.out.println("-----------------------------------");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "      " + rs.getString(2) + "     " + rs.getString(3) + "      "
						+ rs.getFloat(4));
			}
			System.out.println("-----------------------------------");
		} catch (SQLException e) {
			System.out.print("Error occured while fetching menu: " + e + "\n");
		}
	}

	void updateOrder() {
		String pendingOrdersQuery = "SELECT order_id, menu_id, quantity FROM order_karthikeyan WHERE status = 'NEW'";

		try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(pendingOrdersQuery)) {
			while (rs.next()) {
				int orderId = rs.getInt("order_id");
				int menuId = rs.getInt("menu_id");
				int quantity = rs.getInt("quantity");

				String priceQuery = "SELECT price FROM menu_karthikeyan WHERE food_id = ?";
				try (PreparedStatement pstPrice = con.prepareStatement(priceQuery)) {
					pstPrice.setInt(1, menuId);
					ResultSet resPrice = pstPrice.executeQuery();

					if (resPrice.next()) {
						int pricePerItem = resPrice.getInt("price");
						int totalPrice = quantity * pricePerItem;
						String status = "Completed";

						String updateQuery = "UPDATE order_karthikeyan SET price = ?, status = ? WHERE order_id = ?";
						try (PreparedStatement pstUpdate = con.prepareStatement(updateQuery)) {
							pstUpdate.setInt(1, totalPrice);
							pstUpdate.setString(2, status);
							pstUpdate.setInt(3, orderId);
							pstUpdate.executeUpdate();

							System.out.println("\nOrder ID " + orderId + " updated: Price = " + totalPrice
									+ ", Status = " + status);
						}
					}
				}
			}
		} catch (SQLException e) {
			System.out.print("Error occurred while updating orders: " + e);
		}
	}

}
