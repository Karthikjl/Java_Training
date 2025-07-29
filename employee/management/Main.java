package com.celcom.employee.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class Employee {
	private Connection con;
	private Statement statement;

	Employee() {
		String url = "jdbc:mysql://localhost:3306/employeeapplication";
		String userName = "root";
		String passWord = "12345678";
		try {
			con = DriverManager.getConnection(url, userName, passWord);
			statement = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void addEmployee(int eId, String eName, int eAge, String eEmail, String eAddress, double eSalary) {
		String query = "INSERT INTO employee(eId, eName, eAge,eEmail,eAddress,salary) VALUES (?, ?, ?,?,?,?)";
		try (PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			pstmt.setInt(1, eId);
			pstmt.setString(2, eName);
			pstmt.setInt(3, eAge);
			pstmt.setString(4, eEmail);
			pstmt.setString(5, eAddress);
			pstmt.setDouble(6, eSalary);
			pstmt.executeUpdate();

			System.out.println("Employee Created Successfully!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteEmployee(int eId) {
		String query = "DELETE FROM employee WHERE eId = ?";
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

	public void updateSalary(double salary, int id) {
		String query = "update employee set salary = ? where eid = ?";

		try (PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setDouble(1, salary);
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
		String query = "Select * from employee where eId = ?";

		try (PreparedStatement pstmt = con.prepareStatement(query)) {

			pstmt.setInt(1, eId);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("Employee Id: " + rs.getInt("eId"));
				System.out.println("Employee Name: " + rs.getString("eName"));
				System.out.println("Employee Age: " + rs.getInt("eAge"));
				System.out.println("Employee Email: " + rs.getString("eEmail"));
				System.out.println("Employee Address: " + rs.getString("eAddress"));
				System.out.println("Employee Salary: " + rs.getDouble("salary"));
			} else {
				System.out.println("Employee not found.");
			}

		} catch (SQLException e) {
			System.out.println("Error occured while viewing details: " + e.getMessage());
		}

	}

	public void viewDetailsByAge(int age) {
		String query = "Select * from employee where eAge = ?";

		try (PreparedStatement pstmt = con.prepareStatement(query)) {

			pstmt.setInt(1, age);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("Employee Id: " + rs.getInt("eId"));
				System.out.println("Employee Name: " + rs.getString("eName"));
				System.out.println("Employee Age: " + rs.getInt("eAge"));
				System.out.println("Employee Email: " + rs.getString("eEmail"));
				System.out.println("Employee Address: " + rs.getString("eAddress"));
				System.out.println("Employee Salary: " + rs.getDouble("salary"));
				System.out.println("=============================================");
			}

		} catch (SQLException e) {
			System.out.println("Error occured while viewing details: " + e.getMessage());
		}

	}

	public void viewAllEmployee() {
		String query = "SELECT * FROM employee";
		try (ResultSet rs = statement.executeQuery(query)) {
			System.out.println("Employee Details:");
			System.out.println("Id\tName\tAge\tEmail\t	    Address\t Salary");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4)
						+ "      " + rs.getString(5) + "\t " + rs.getDouble(6));
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving accounts: " + e.getMessage());
		}
	}
}

public class Main {

	public static void main(String[] args) {

		Scanner inputScanner = new Scanner(System.in);
		Employee employee = new Employee();
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
				double salary = inputScanner.nextDouble();

				try {
					employee.addEmployee(eId, eName, eAge, eEmail, eAddress, salary);
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
			case 2:
				// delete
				System.out.print("Enter id to delete employee: ");
				int deleteId = inputScanner.nextInt();

				employee.deleteEmployee(deleteId);
				break;
			case 3:
				// update
				System.out.print("Enter employee id: ");
				int id = inputScanner.nextInt();
				System.out.print("Enter updated salary: ");
				double updateSalary = inputScanner.nextDouble();
				employee.updateSalary(updateSalary, id);
				break;
			case 4:
				// view id employee details
				System.out.print("\n1. By Id\n2. By Age\nEnter choice: ");
				int details_id = inputScanner.nextInt();
				if (details_id == 1) {
					System.out.print("Enter employee id: ");
					int employeeId = inputScanner.nextInt();

					employee.viewDetailsById(employeeId);
				} else if (details_id == 2) {
					System.out.print("Enter employee age: ");
					int employeeAge = inputScanner.nextInt();

					employee.viewDetailsByAge(employeeAge);
				} else {
					System.out.println("Invalid Choice.");
				}
				break;
			case 5:
				// all employee details
				employee.viewAllEmployee();
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
