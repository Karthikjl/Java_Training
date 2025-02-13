package com.celcom.day7;

interface Calculator {
	int calc(int a, int b);
}

public class LambdaExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator c = (a, b) -> a + b;
		System.out.println("Addition: " + c.calc(5, 6)); // 11

		c = (a, b) -> a - b;
		System.out.println("Subraction: " + c.calc(5, 4)); // 1

		c = (a, b) -> a * b;
		System.out.println("Multiplication: " + c.calc(5, 4)); // 20

		c = (a, b) -> a / b;
		System.out.println("Division: " + c.calc(5, 5)); // 1
	}

}
