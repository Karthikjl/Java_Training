package com.celcom.day1;

import java.util.Scanner;

class UserInput {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Employee Id, Employee Name, Employee Salary: ");
		int EmployeeId = input.nextInt();
		String EmployeeName = input.next();
		double EmployeeSalary = input.nextDouble();
		System.out.println("Employee Id: " + EmployeeId);
		System.out.println("Employee Name: " + EmployeeName);
		System.out.println("Employee Salary: " + EmployeeSalary);

	}

}