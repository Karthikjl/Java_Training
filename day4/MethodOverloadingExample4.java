package com.celcom.day4;

//Constructor Overloading
public class MethodOverloadingExample4 {
	MethodOverloadingExample4(int num1, int num2) {
		System.out.println("Concatination of two int: " + num1 + " " + num2);
	}

	MethodOverloadingExample4(String str1, String str2) {
		this(1,3);
		System.out.println("Concaination of two String: " + str1 + " " + str2);
	}

	MethodOverloadingExample4(float num1, float num2) {
		this("A", "B");
		System.out.println("Concadination of two Float: " + num1 + " " + num2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodOverloadingExample4 concate;
		concate = new MethodOverloadingExample4(4.0f, 5.0f);
//		new MethodOverloadingExample4(5, 5);
//		new MethodOverloadingExample4("f", "f");

	}

}
