package com.celcom.Assignment2;

class Animal{
		
	void makeSound() {
		System.out.println("Not Declared");
	}
}

class Cat extends Animal{
	
	
	void makeSound() {
		System.out.println("meo meo");
	}
}

public class Program8 {

	public static void main(String[] args) {
		
		Animal catAnimal = new Cat();
		catAnimal.makeSound();
	}

}
