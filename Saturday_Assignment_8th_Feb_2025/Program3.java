package com.celcom.Saturday_Assignment_8th_Feb_2025;

import java.util.Scanner;

class Rectangle {

	int height;
	int width;

	public Rectangle(int height, int width) {

		this.height = height;
		this.width = width;
		System.out.println("The area of the rectangle is " + (width * height));
		System.out.println("The Perimeter of the rectangle is " + (width + height) * 2);
	}
}

public class Program3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputScanner = new Scanner(System.in);
		int width;
		int height;

		System.out.println("Rectangle Area and Perimeter Program\n");
		System.out.print("Enter the width and height : ");
		width = inputScanner.nextInt();
		height = inputScanner.nextInt();

		Rectangle rectangle =new Rectangle(height, width);
	}

}
