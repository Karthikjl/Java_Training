package com.celcom.javaFinalAssesment.customerandorder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {
	public static Connection con;
	public static Statement st;

	static {
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
}
