package com.celcom.day3;

class Mobile {

	String name;
	int price;
	int ram;
	int storage;

	Mobile(String name, int price, int ram, int storage) {
		this.name = name;
		this.price = price;
		this.ram = ram;
		this.storage = storage;
	}

	void displayDetails() {
		System.out.println("Name of the mobile: " + name);
		System.out.println("Price of the mobile (According to today's Market): " + price + "Rs");
		System.out.println("Ram of the mobile: " + ram + "Gb");
		System.out.println("Storage of the moblie: " + storage + "Gb");

	}

	void setPrice(int price) {
		this.price = price;
	}

}

public class RecapClassAndObject {

	public static void main(String[] args) {

		Mobile vivo = new Mobile("Vivo Y22", 14000, 6, 128);
		Mobile oppo = new Mobile("Oppo Reno", 15000, 6, 128);
		Mobile redmi = new Mobile("Redmi 11", 13000, 6, 128);

		System.out.println("Vivo");
		vivo.displayDetails();

		System.out.println();

		System.out.println("Oppo");
		oppo.displayDetails();

		System.out.println();

		System.out.println("Redmi");
		redmi.displayDetails();

		System.out.println();
		
		vivo.setPrice(14500);
		System.out.println("Vivo");
		vivo.displayDetails();


	}

}
