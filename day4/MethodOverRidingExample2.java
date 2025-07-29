package com.celcom.day4;

class Animal {
	public Animal() {
		// TODO Auto-generated constructor stub
	}
	Animal(int a) {
		System.out.println(a);
	}
	void move() {
		System.out.println("Not Defined");
	}

	void eat() {
		System.out.println("Not Defined");
	}

}

class Horse extends Animal {

	void move() {
		System.out.println("Horse can move fastly.");
	}

	void eat() {
		System.out.println("Horse eat grass");
	}
}

class Tiger extends Animal {
	void move() {
		System.out.println("Tiger move fastly.");
	}

	void eat() {
		System.out.println("Tiger eat meat.");
	}
}

class Lion extends Animal {
	void move() {
		System.out.println("Lion move fastly.");
	}

	void eat() {
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

		System.out.println(new Object().toString());
	}
}