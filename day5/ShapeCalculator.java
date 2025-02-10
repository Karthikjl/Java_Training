package com.celcom.day5;

import java.util.Scanner;

interface Area1 {
	void calculateArea();
}

interface Perimeter {
	void perimenter();
}

abstract class Shape1 implements Area, Perimeter {
	int length;
	int breadth;
	float height;
	int a, b, c;
	int radius;
	float half = 0.5f;

	Shape1(int radius) {
		this.radius = radius;
		calculateArea();
		perimenter();
	}

	Shape1(int length, int breadth) {
		this.length = length;
		this.breadth = breadth;
		calculateArea();
		perimenter();
	}

	Shape1(int length, float height) {
		this.length = length;
		this.height = height;

		calculateArea();

	}

	Shape1(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;

		perimenter();

	}

}

class Circle1 extends Shape1 {
	Circle1(int radius) {
		super(radius);
	}

	public void calculateArea() {
		System.out.println("The Area of Circle is : " + (3.14) * radius * radius);
	}

	@Override
	public void perimenter() {
		// TODO Auto-generated method stub
		System.out.println("The Circumference of Circle is : " + 2 * (3.14) * radius);

	}
}

class Rectangle1 extends Shape1 {
	Rectangle1(int length, int breadth) {
		super(length, breadth);
	}

	public void calculateArea() {
		System.out.println("The Area of Rectangle is : " + length * breadth);
	}

	@Override
	public void perimenter() {
		// TODO Auto-generated method stub
		System.out.println("The perimeter of the rectangle is: " + 2 * (length + breadth));

	}
}

class Triangle1 extends Shape1 {
	Triangle1(int length, float height) {
		super(length, height);

	}

	Triangle1(int a, int b, int c) {
		super(a, b, c);
	}

	public void calculateArea() {
		System.out.println("The Area of Triangle is : " + (half) * length * height);
	}

	@Override
	public void perimenter() {
		System.out.println("The perimeter of Triangle is: " + (a + b + c));
	}
}

public class ShapeCalculator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Shape1 shape;
		int choice;
		System.out.println("Area Calculator");
		while (true) {

			System.out.print("\n1. Circle\n2. Rectangle\n3. Triangle\n4. Exit\nEnter the choice : ");
			choice = input.nextInt();
			if (choice == 1) {
				System.out.print("Enter the Radius of the circle: ");
				shape = new Circle1(input.nextInt());
			} else if (choice == 2) {
				System.out.print("Enter the Length and Breadth: ");
				shape = new Rectangle1(input.nextInt(), input.nextInt());
			} else if (choice == 3) {
				System.out.println("Options\n1. Area of triangle\n2. Perimeter of triangle\n");
				System.out.print("Enter choice: ");
				int c = input.nextInt();

				if (c == 1) {
					System.out.print("Enter the Base and Height : ");
					shape = new Triangle1(input.nextInt(), input.nextFloat());
				} else if (c == 2) {
					System.out.print("Enter the value to find perimeter of triangle : ");
					shape = new Triangle1(input.nextInt(), input.nextInt(), input.nextInt());
				} else {
					System.out.println("Invalid choice");
				}

			} else if (choice == 4) {
				System.out.println("Thank you....");
				break;
			} else {
				System.out.println("Invalid Choice.");
			}
		}

	}

}
