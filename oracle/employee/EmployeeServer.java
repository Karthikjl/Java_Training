package com.oracle.employee;

import java.sql.*;

public class EmployeeServer {
    public static void main(String[] args) {
        // JDBC URL updated to match the provided sqlplus connection string
        String url = "jdbc:oracle:thin:@//172.19.0.5:1521/trainingsql.celcom.com";
        String username = "training";
        String password = "Celcom123";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM employee")) {

            while (rs.next()) {
                System.out.println("Employee ID: " + rs.getInt(1) +
                                   ", Name: " + rs.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
