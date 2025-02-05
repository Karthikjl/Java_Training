package com.celcom.day2;

class Fruits {
	String color;
	public int price;
	String name;

	Fruits(String color, int price, String name) {
		this.color = color;
		this.price = price;
		this.name = name;
	}

	void displayDetails() {
		System.out.println("Fruit name : " + name);
		System.out.println("Fruit color : " + color);
		System.out.println("Fruit price for 1kg : " + price);
	}
}

public class ClassAndObjectExample2 {

	public static void main(String[] args) {

		Fruits banana = new Fruits("Yellow", 100, "Banana");
		banana.displayDetails();
		System.out.println();

		Fruits apple = new Fruits("Red", 120, "Apple");
		apple.displayDetails();
		
		
//		apple.price = 220;
//		System.out.println();
//		apple.displayDetails();

	}

}
