package com.celcom.Saturday_Assignment_8th_Feb_2025;

class Employee {

	String name;
	private float salary;
	String jobTitle;

	Employee(String name, String jobTitle, float salary) {
		this.name = name;
		this.jobTitle = jobTitle;
		this.salary = salary;
	}

	void display() {
		System.out.println("The name of the employee: " + name);
		System.out.println("The jobtitle of the employee: " + jobTitle);
		System.out.println("The salary of the employee: " + salary);
	}

	void setSalary(float salary) {
		this.salary = salary;
	}
}

public class Program6 {

	public static void main(String[] args) {
		Employee raju = new Employee("Raju", "Trinee", 15000);
		Employee nivetha = new Employee("Nivetha", "Hr", 35000);

		raju.display();
		raju.setSalary(20000);
		System.out.println();
		raju.display();
		System.out.println();

		nivetha.display();
		nivetha.setSalary(45000);
		System.out.println();
		nivetha.display();
		System.out.println();
	}

}
