package com.celcom.oracle.employee;

import java.sql.*;

public class Employee {
	public static void main(String[] args) {
		// JDBC URL for Oracle XE
//		String url = "jdbc:oracle:thin:@localhost:1521/XE";
//		String username = "system";
//		String password = "12345678";
		String url = "jdbc:oracle:thin:@//172.19.0.5:1521/trainingsql.celcom.com";
        String username = "training";
        String password = "Celcom123";

//		String query = "insert into employee values(5,'Vishal')";
		try (Connection conn = DriverManager.getConnection(url, username, password);
				Statement stmt = conn.createStatement();
//				ResultSet ds = stmt.executeQuery(query);
				ResultSet rs = stmt.executeQuery("SELECT * FROM employee")) {

			while (rs.next()) {
				System.out.println("Employee ID: " + rs.getInt("Eid") + ", Name: " + rs.getString("Ename"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
                                                                       