package com.celcom.Saturday_Assignment_8th_Feb_2025;

class Person {

	String name;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	void displayDetails() {
		System.out.println("Name of the person: " + name);
		System.out.println("Age of the person: " + age);
	}
}

public class Program1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person raju = new Person("Raju", 20);
		raju.displayDetails();
		
		System.out.println();
		Person nila = new Person("Nila", 20);
		nila.displayDetails();
	}

}
