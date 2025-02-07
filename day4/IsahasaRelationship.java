package com.celcom.day4;

class Vechicle {
	void engine() {
		System.out.println("Default engine");
	}

	void wheels() {
		System.out.println("Default number of Wheels");
	}
}

class Wheels {
	void wheelsModel() {
		System.out.println("Model of Mrf");
	}

	void noOfWheels(int wheelCount) {
		if (wheelCount == 4) {
			System.out.println("I am normal car");
		} else if (wheelCount == 8) {
			System.out.println("I am Load Van");

		} else if (wheelCount > 4) {
			System.out.println("I am super car...🏎️");
		} else {
			System.out.println("I am bike or auto or even a single tyre...");
		}
	}
}

class Engine {
	void engineModel(String model) {
		System.out.println("Model of " + model);
	}

}

class Car extends Vechicle {// Is a
	Wheels wheels = new Wheels();// Has a
	Engine engine = new Engine();// Has a

	void wheels() {
		wheels.wheelsModel();
		wheels.noOfWheels(5);
	}

	void engine() {
		engine.engineModel("V8 Motor");
	}
}

public class IsahasaRelationship {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car();
		car.engine();
		car.wheels();

	}

}
