package com.celcom.day5;

import java.util.Scanner;

//Abstract class 
abstract class Vehicle {
	abstract int noOfEngine();

	abstract int noOfWheels();

	void tyreAir() {
		System.out.println("Support both air.");
	}
}

class Car extends Vehicle {
	int engine;
	int wheel;

	Car(int engine, int wheel) {
		this.engine = engine;
		this.wheel = wheel;

	}
//	Vehicle vehicle = new Vehicle() {
//		
//		@Override
//		int noOfWheels(int wheel) {
//			// TODO Auto-generated method stub
//			
//			return wheel;
//			
//		}
//		
//		@Override
//		int noOfEngine(int engine) {
//			// TODO Auto-generated method stub
//			return engine;
//			
//		}
//	};

	@Override
	int noOfEngine() {
		// TODO Auto-generated method stub
		return engine;
	}

	@Override
	int noOfWheels() {
		// TODO Auto-generated method stub
		return wheel;
	}

	void numberOfPeople() {
		System.out.println();
	}
}

abstract class Bike extends Vehicle {
	abstract void tyreAir();

	@Override
	int noOfEngine() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	int noOfWheels() {
		// TODO Auto-generated method stub
		return 0;
	}

}

abstract public class AbstractClassExample1 {
	abstract void a();


	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no of engine: ");
		int engine = sc.nextInt();
		System.out.print("Enter no of wheels: ");
		int wheel = sc.nextInt();
		Vehicle myCar = new Car(engine, wheel);

		System.out.println("No of engine: " + myCar.noOfEngine());
		System.out.println("No of tyre: " + myCar.noOfWheels());
		myCar.tyreAir();
		sc.close();

	}
}
