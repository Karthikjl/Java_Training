package com.celcom.day5;

interface AnimalPlan {
	void move();

	void eat();
}

abstract class Animal implements AnimalPlan {

	public abstract void move();

	public abstract void eat();

}

class Horse extends Animal {

	public void move() {
		System.out.println("Horse can move fastly.");
	}

	public void eat() {
		System.out.println("Horse eat grass");
	}
}

class Tiger extends Animal {

	public void move() {
		System.out.println("Tiger move fastly.");
	}

	public void eat() {
		System.out.println("Tiger eat meat.");
	}
}

class Lion extends Animal {

	public void move() {
		System.out.println("Lion move fastly.");
	}

	public void eat() {
		System.out.println("Lion eat meat.");
	}
}

class MethodOverRidingExample2 {
	public static void main(String args[]) {
		Animal animal;

		animal = new Horse();
		animal.eat();
		animal.move();
		System.out.println();
		animal = new Lion();
		animal.eat();
		animal.move();
		System.out.println();
		animal = new Tiger();
		animal.eat();
		animal.move();
		
		System.out.println();

		System.out.println(new Object().toString());
	}
}