package com.celcom.day13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@172.19.0.5:1521:XE"; // Change "XE" if needed
        String user = "training";
        String password = "Celcom123";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("Connected to Oracle database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
