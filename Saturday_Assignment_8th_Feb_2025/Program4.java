package com.celcom.Saturday_Assignment_8th_Feb_2025;

import java.util.Scanner;

class Circle {

	float radius;
	float area;
	float circumference;

	public Circle(float radius) {
		this.area = (float) ((Math.PI) * (radius * radius));
		this.circumference = (float)(2*(Math.PI*radius));
		System.out.printf("The area of the circle is %.2f\n", area);
		System.out.printf("The Circumference of the cicle is %.2f", circumference);
	}
}

public class Program4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputScanner = new Scanner(System.in);
		float radius;
		System.out.println("Circle area and Circumference Program\n");
		System.out.print("Enter the radius: ");		
		radius = inputScanner.nextFloat();
		Circle circle = new Circle(radius);
		
		

		
	}

}
