package com.celcom.javaFinalAssesment.orderProcessing;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.celcom.javaFinalAssesment.customerandorder.DataBaseConnection;

public class ProcessOrder {

	static void processOrder() {
		String pendingOrdersQuery = "SELECT orderid, productid, quantity,accountnumber FROM ecommerceorderkarthikeyan WHERE status = 'New'";

		try (Statement st = DataBaseConnection.con.createStatement();
				ResultSet rs = st.executeQuery(pendingOrdersQuery)) {
			while (rs.next()) {
				int orderId = rs.getInt("orderid");
				int productId = rs.getInt("productid");
				int quantity = rs.getInt("quantity");
				int accountnumber = rs.getInt("accountnumber");
				int totalPrice = 0;
				String queryInprogress = "Update ecommerceorderkarthikeyan set status= ? where orderid = ?";
				try (PreparedStatement inprogress = DataBaseConnection.con.prepareStatement(queryInprogress)) {
					inprogress.setString(1, "InProgress");
					inprogress.setInt(2, orderId);
					inprogress.executeUpdate();

					String quantityCheck = "select quantity from ecommerceproductkarthikeyan where productid = "
							+ productId;
					Statement quantityst = DataBaseConnection.con.createStatement();
					ResultSet quantityCheckResult = quantityst.executeQuery(quantityCheck);
					quantityCheckResult.next();
					int productQuantity = quantityCheckResult.getInt("quantity");

					if (productQuantity >= quantity) {
						productQuantity -= quantity;
						String updateQuantity = "update ecommerceproductkarthikeyan set quantity = ? where productid = ?";
						try (PreparedStatement updateQuantitypst = DataBaseConnection.con
								.prepareStatement(updateQuantity)) {
							updateQuantitypst.setInt(1, productQuantity);
							updateQuantitypst.setInt(2, productId);
							updateQuantitypst.executeUpdate();
							String priceQuery = "Select price from ecommerceproductkarthikeyan where productid = ?";
							try (PreparedStatement pricepst = DataBaseConnection.con.prepareStatement(priceQuery)) {
								pricepst.setInt(1, productId);
								ResultSet resPrice = pricepst.executeQuery();
								if (resPrice.next()) {
									int pricePerItem = resPrice.getInt("price");
									totalPrice = quantity * pricePerItem;
									String updateTable = "update ecommerceorderkarthikeyan set price = ?,status = ? where orderid = ?";
									try (PreparedStatement pstUpdate = DataBaseConnection.con
											.prepareStatement(updateTable)) {
										pstUpdate.setInt(1, totalPrice);
										pstUpdate.setString(2, "Pending Payment");
										pstUpdate.setInt(3, orderId);
										pstUpdate.executeUpdate();
										Payment.entryPayment(orderId, totalPrice, accountnumber);

									}
								}
							}
						}

					} else {
						String insertPaymentQuery = "insert into ecommercepaymentkarthikeyan(orderid,orderprice,orderstatus) values(?,?,?)";
						try (PreparedStatement paymentPst = DataBaseConnection.con
								.prepareStatement(insertPaymentQuery)) {
							paymentPst.setInt(1, orderId);
							paymentPst.setInt(2, totalPrice);
							paymentPst.setString(3, "Failed");
							paymentPst.executeUpdate();
							String statusOfOrder = "update ecommerceorderkarthikeyan set status = ? where orderid = ?";
							try (PreparedStatement updateCustomer = DataBaseConnection.con
									.prepareStatement(statusOfOrder)) {
								updateCustomer.setString(1, "Order Failed");
								updateCustomer.setInt(2, orderId);
								updateCustomer.executeUpdate();
							}
						}
					}
				}

			}

		} catch (SQLException e) {
			System.out.println("Error occured while updating order:  " + e);
		}
	}

}