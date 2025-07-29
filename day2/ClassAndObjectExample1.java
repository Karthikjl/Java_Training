package com.celcom.day2;

class Employee {

	int employeeId;
	String employeeName;
	private float employeeSalary;

	Employee(int employeeId, String employeeName, float employeeSalary) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
//		this.displayEmployeeDetails();

	}

	void displayEmployeeDetails() {

		System.out.println("Employee Id: " + employeeId);
		System.out.println("Employee Name: " + employeeName);
		System.out.println("Employee Salary: " + employeeSalary);

	}
	
	void setSalary(int salary) {
		employeeSalary = salary;
	}
}

public class ClassAndObjectExample1 {

	public static void main(String[] args) {
		Employee Raju = new Employee(1, "Raju", 12000);
		Raju.displayEmployeeDetails();
		System.out.println();
		
		Employee Nila = new Employee(2, "Nila", 11000);
		Nila.displayEmployeeDetails();
		System.out.println();
		
//		Raju.setSalary(50000);
//		Raju.displayEmployeeDetails();
	}

}
