package com.celcom.day3;


class Vehicle {

	int engineCount;
	String gOrNg;

	Vehicle(int engineCount, String gOrNg) {
		this.engineCount = engineCount;
		this.gOrNg = gOrNg;
	}

	void noOfEngine() {
		System.out.println("I have " + engineCount + " engine.");
	}

	void gearOrNonGear() {
		System.out.println(gOrNg);
	}

	void displayDetails() {
		gearOrNonGear();
		noOfEngine();
	}
}

class TwoWheelers extends Vehicle {
	TwoWheelers(int engineCount, String gOrNg) {
		super(engineCount, gOrNg);
	}

}

class bike extends TwoWheelers{
	bike(int engineCount, String gOrNg) {
		super(engineCount, gOrNg);
	}
}
public class InheritanceMultiLevel {
	public static void main(String args[]) {
		bike pulsar = new bike(1,"Pulsar");
		pulsar.displayDetails();
	}
}
