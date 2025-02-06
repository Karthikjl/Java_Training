package com.celcom.day3;

class Employee {

	private String name;
	private int eid;
	private int salary;

	public Employee() {
		System.out.println("The parameter is Empty!!!");
	}

	public Employee(String name, int eid, int salary) {
		super();
		this.name = name;
		this.eid = eid;
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public void displayDetails() {
		System.out.println("Employee Id : "+ eid);
		System.out.println("Employee name : "+ name);
		System.out.println("Employee Salary : "+ salary);
	}

}

public class EncapsulationExample {
	public static void main(String[] args) {
		Employee Raju = new Employee("Raju",1,20000);
		Raju.displayDetails();
	}

}
