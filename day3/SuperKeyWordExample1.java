package com.celcom.day3;

class Vechicle1 {
	String name = "Vechicle";

	Vechicle1() {
		System.out.println("Super Class Constructor");
	}

	void method1() {
		System.out.println("Method 1 from SuperClass");
	}
}

class TwoWheeler1 extends Vechicle1 {

	

	public TwoWheeler1() {
		super();
	}

	void superClassMethod() {
		super.method1();

		System.out.println("I am from Superclass Method in Subclass");
		System.out.println(super.name);
	}

}

public class SuperKeyWordExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TwoWheeler1 bike = new TwoWheeler1();
		bike.superClassMethod();
	}

}
