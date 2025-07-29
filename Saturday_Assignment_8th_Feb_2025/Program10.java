package com.celcom.Saturday_Assignment_8th_Feb_2025;

import java.util.Scanner;

class Shape {
	void getArea() {
		System.out.println("Not declared");
	}
}

class Rectangles extends Shape {
	float width;
	float height;
	float area;

	Rectangles(float width, float height) {
		this.height = height;
		this.width = width;
	}

	void getArea() {
		area = height * width;
		System.out.printf("The area of Rectangle: %.2f\n", area);
	}
}

public class Program10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputScanner = new Scanner(System.in);
		float width;
		float height;
		System.out.println("Rectangle area Program\n");
		System.out.print("Enter the width & height: ");
		width = inputScanner.nextFloat();
		height = inputScanner.nextFloat();
		
		Shape recShape = new Rectangles(width, height);
		recShape.getArea();
		
		System.out.println("\nThankYou");

	}

}
