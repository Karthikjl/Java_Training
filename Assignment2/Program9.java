package com.celcom.Assignment2;


class Vehicle{
	
	void drive() {
		System.out.println("not Declared");
	}
}

class Car extends Vehicle{
	void drive() {
		System.out.println("Repairing a car");
	}
}

public class Program9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle carVehicle = new Car();
		carVehicle.drive();
	}

}
