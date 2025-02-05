package com.celcom.day2;

public class TypesOfMethodsInJava {

	void m1() {
		System.out.println("Instance Method");
	}
	static void m2() {
		System.out.println("Static Method");
	}
	public static void main(String[] args) {
		//Instance Method
		TypesOfMethodsInJava m1 = new TypesOfMethodsInJava();
		m1.m1();
		
		System.out.println();
		
		//Static Method
		m2();

	}

}
