package com.employee.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class Employee1 {
	private Connection con;
	private Statement statement;

	Employee1() {
		String url = "jdbc:oracle:thin:@//172.19.0.5:1521/trainingsql.celcom.com";
		String username = "training";
		String password = "Celcom123";
		try {
			con = DriverManager.getConnection(url, username, password);
			statement = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void addEmployee1(int eId, String eName, int eAge, String eEmail, String eAddress, int eSalary) {
		String query = "INSERT INTO karthikeyan_j(eId, eName, eAge,eEmail,eAddress,salary) VALUES (?, ?, ?,?,?,?)";
		try (PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setInt(1, eId);
			pstmt.setString(2, eName);
			pstmt.setInt(3, eAge);
			pstmt.setString(4, eEmail);
			pstmt.setString(5, eAddress);
			pstmt.setInt(6, eSalary);
			pstmt.executeUpdate();

			System.out.println("Employee Created Successfully!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteEmployee1(int eId) {
		String query = "DELETE FROM karthikeyan_j WHERE eId = ?";
		try (PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setInt(1, eId);
			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				System.out.println("Employee deleted successfully!");
			} else {
				System.out.println("Employee not found.");
			}
		} catch (SQLException e) {
			System.out.println("Error deleting account: " + e.getMessage());
		}
	}

	public void updateSalary(int salary, int id) {
		String query = "update karthikeyan_j set salary = ? where eid = ?";

		try (PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setInt(1, salary);
			pstmt.setInt(2, id);
			int updated = pstmt.executeUpdate();
			if (updated > 0) {
				System.out.println("Salary updated.");
			} else {
				System.out.println("Employee not found.");
			}
		} catch (SQLException e) {
			System.out.println("Error occured while updating salary: " + e.getMessage());
		}
	}

	public void viewDetailsById(int eId) {
		String query = "Select * from karthikeyan_j where eId = ?";

		try (PreparedStatement pstmt = con.prepareStatement(query)) {

			pstmt.setInt(1, eId);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("Employee Id: " + rs.getInt("eId"));
				System.out.println("Employee Name: " + rs.getString("eName"));
				System.out.println("Employee Age: " + rs.getInt("eAge"));
				System.out.println("Employee Email: " + rs.getString("eEmail"));
				System.out.println("Employee Address: " + rs.getString("eAddress"));
				System.out.println("Employee Salary: " + rs.getInt("salary"));
			} else {
				System.out.println("Employee1 not found.");
			}

		} catch (SQLException e) {
			System.out.println("Error occured while viewing details: " + e.getMessage());
		}

	}

	public void viewDetailsByAge(int age) {
		String query = "Select * from karthikeyan_j where eAge = ?";

		try (PreparedStatement pstmt = con.prepareStatement(query)) {

			pstmt.setInt(1, age);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("Employee Id: " + rs.getInt("eId"));
				System.out.println("Employee Name: " + rs.getString("eName"));
				System.out.println("Employee Age: " + rs.getInt("eAge"));
				System.out.println("Employee Email: " + rs.getString("eEmail"));
				System.out.println("Employee Address: " + rs.getString("eAddress"));
				System.out.println("Employee Salary: " + rs.getInt("salary"));
				System.out.println("=============================================");
			}

		} catch (SQLException e) {
			System.out.println("Error occured while viewing details: " + e.getMessage());
		}

	}

	public void viewAllEmployee1() {
		String query = "SELECT * FROM Karthikeyan_J";
		try (ResultSet rs = statement.executeQuery(query)) {
			System.out.println("Employee Details:");
			System.out.println("Id\tName\tAge\tEmail\t	    Address\t Salary");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4)
						+ "      " + rs.getString(5) + "\t " + rs.getInt(6));
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving accounts: " + e.getMessage());
		}
	}
}

public class MainServer {

	public static void main(String[] args) {

		Scanner inputScanner = new Scanner(System.in);
		Employee1 Employee1 = new Employee1();
		boolean running = true;

		while (running) {
			System.out.println("\nEmployee System");
			System.out.println("1. Create Employee Account");
			System.out.println("2. Delete Employee Account");
			System.out.println("3. Update Salary (Using id)");
			System.out.println("4. View Employee Details (Id / Age)");
			System.out.println("5. List All Employee Account");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");
			int choice = inputScanner.nextInt();
			inputScanner.nextLine();

			switch (choice) {
			case 1:
				// create
				System.out.print("Enter Employee Id: ");
				int eId = inputScanner.nextInt();
				System.out.print("Enter Employee Name: ");
				String eName = inputScanner.next();
				inputScanner.nextLine();
				System.out.print("Enter Employee Age: ");
				int eAge = inputScanner.nextInt();
				System.out.print("Enter Employee Email: ");
				String eEmail = inputScanner.next();
				System.out.print("Enter Employee Address: ");
				String eAddress = inputScanner.next();
				System.out.print("Enter Employee Salary: ");
				int salary = inputScanner.nextInt();

				try {
					Employee1.addEmployee1(eId, eName, eAge, eEmail, eAddress, salary);
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
			case 2:
				// delete
				System.out.print("Enter id to delete Employee: ");
				int deleteId = inputScanner.nextInt();

				Employee1.deleteEmployee1(deleteId);
				break;
			case 3:
				// update
				System.out.print("Enter Employee id: ");
				int id = inputScanner.nextInt();
				System.out.print("Enter updated salary: ");
				int updateSalary = inputScanner.nextInt();
				Employee1.updateSalary(updateSalary, id);
				break;
			case 4:
				// view id Employee1 details
				System.out.print("\n1. By Id\n2. By Age\nEnter choice: ");
				int details_id = inputScanner.nextInt();
				if (details_id == 1) {
					System.out.print("Enter Employee id: ");
					int Employee1Id = inputScanner.nextInt();

					Employee1.viewDetailsById(Employee1Id);
				} else if (details_id == 2) {
					System.out.print("Enter Employee age: ");
					int Employee1Age = inputScanner.nextInt();

					Employee1.viewDetailsByAge(Employee1Age);
				} else {
					System.out.println("Invalid Choice.");
				}
				break;
			case 5:
				// all Employee1 details
				Employee1.viewAllEmployee1();
				break;
			case 6:
				// Exit program
				System.out.println("Thank you for using the Employee System.");
				running = false;
				break;
			default:
				System.out.println("Invalid Choice. Try again.");
			}
		}
		inputScanner.close();

	}

}
