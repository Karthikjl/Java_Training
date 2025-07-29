package com.celcom.day3;

// Hirachey Inhertance

class Vehicles {

	int engineCount;
	String gOrNg;

	Vehicles(int engineCount, String gOrNg) {
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

class TwoWheeler extends Vehicles {
	TwoWheeler(int engineCount, String gOrNg) {
		super(engineCount, gOrNg);
	}

}

class FourWheeler extends Vehicles {
	FourWheeler(int engineCount, String gOrNg) {
		super(engineCount, gOrNg);
	}

	void maxSpeed() {
		System.out.println();
	}
}

public class InheritanceHierarchy {
	public static void main(String[] args) {
		TwoWheeler pulsar = new TwoWheeler(2, "Pulsar");
		pulsar.displayDetails();

		System.out.println();

		FourWheeler Sedan = new FourWheeler(1, "Sedan");
		Sedan.displayDetails();
	}
}
