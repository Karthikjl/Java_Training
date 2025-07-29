package com.celcom.day3;

import java.util.Scanner;

class Shape {
	int length;
	int breadth;
	float height;
	int radius;
	float half = 0.5f;
	Shape(int radius){
		this.radius = radius;
		calculateArea();
	}
	
	Shape(int length,int breadth){
		this.length = length;
		this.breadth = breadth;
		calculateArea();
	}
	
	Shape(int length,float height){
		this.length = length;
		this.height = height;

		calculateArea();
		
	}
	void calculateArea() {

	}

}

class Circle extends Shape {
	Circle(int radius){
		super(radius);
	}
	void calculateArea() {
		System.out.println("The Area of Circle is : " + (3.14) * radius * radius);
	}
}

class Rectangle extends Shape{
	Rectangle(int length,int breadth){
		super(length,breadth);
	}
	
	void calculateArea() {
		System.out.println("The Area of Rectangle is : " + length * breadth);
	}
}

class Triangle extends Shape{
	Triangle(int length,float height){
		super(length,height);

	}
	
	void calculateArea() {
		System.out.println("The Area of Triangle is : " + (half) * length * height);
	}
}




public class AreaCalculator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Shape shape;
		int choice;
		System.out.println("Area Calculator");
		while(true) {
			
			System.out.print("\n1. Circle\n2. Rectangle\n3. Triangle\n4. Exit\nEnter the choice : ");
			choice = input.nextInt();
			if(choice == 1) {
				System.out.print("Enter the Radius of the circle: ");
				shape = new Circle(input.nextInt());
			}
			else if(choice == 2) {
				System.out.print("Enter the Length and Breadth: ");
				shape = new Rectangle(input.nextInt(),input.nextInt());
			}
			else if(choice == 3) {
				System.out.print("Enter the Base and Height : ");
				shape = new Triangle(input.nextInt(),input.nextFloat());
			}
			else if(choice == 4){
				System.out.println("Thank you....");
				break;
			}
			else {
				System.out.println("Invalid Choice.");
			}
		}
		
	}

}
