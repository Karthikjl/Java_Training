package com.celcom.javaFinalAssesment.orderProcessing;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.celcom.javaFinalAssesment.customerandorder.DataBaseConnection;
public class Payment {

	public static void entryPayment(int orderid, int totalPrice, int accountNumber) {
		String insertPaymentQuery = "insert into ecommercepaymentkarthikeyan(orderid,orderprice,orderstatus) values(?,?,?)";

		String checkQuery = "Select paymentstatus from ecommercecustomerkarthikeyan where customerid = ?";

		try (PreparedStatement pst = DataBaseConnection.con.prepareStatement(checkQuery)) {
			pst.setInt(1, accountNumber);
			ResultSet rs = pst.executeQuery();
			rs.next();
			String paymentStatus = rs.getString(1);
			if (paymentStatus.equals("Active")) {
				try (PreparedStatement paymentPst = DataBaseConnection.con.prepareStatement(insertPaymentQuery)) {
					paymentPst.setInt(1, orderid);
					paymentPst.setInt(2, totalPrice);
					paymentPst.setString(3, "Success");
					paymentPst.executeUpdate();
					String statusOfOrder = "update ecommerceorderkarthikeyan set status = ? where orderid = ?";
					try (PreparedStatement updateCustomer = DataBaseConnection.con.prepareStatement(statusOfOrder)) {
						updateCustomer.setString(1, "Order Success");
						updateCustomer.setInt(2, orderid);
						updateCustomer.executeUpdate();
					}
				}
			}
			else {
				try (PreparedStatement paymentPst = DataBaseConnection.con.prepareStatement(insertPaymentQuery)) {
					paymentPst.setInt(1, orderid);
					paymentPst.setInt(2, totalPrice);
					paymentPst.setString(3, "Failed");
					paymentPst.executeUpdate();
					String statusOfOrder = "update ecommerceorderkarthikeyan set status = ? where orderid = ?";
					try (PreparedStatement updateCustomer = DataBaseConnection.con.prepareStatement(statusOfOrder)) {
						updateCustomer.setString(1, "Order Failed");
						updateCustomer.setInt(2, orderid);
						updateCustomer.executeUpdate();
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("Error occured while updating payment: " + e);
		}
	}

}
