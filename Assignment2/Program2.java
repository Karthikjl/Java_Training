package com.celcom.Assignment2;


class Dog{
	private String name;
	private String breed;
	private int number;
	
	Dog(int number, String name,String breed) {
		this.number = number;
		this.name = name;
		this.breed = breed;
	}
	
	void nameSetter(String name) {
		this.name = name;
		displayDetails();
	}
	
	void breedSetter(String breed) {
		this.breed = breed;
		displayDetails();
	}
	
	void displayDetails() {
		System.out.println("Number : "+number);
		System.out.println("The name of dog: " + name);
		System.out.println("The breed of dog: " + breed+"\n");
	}
}

public class Program2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Dog ramboDog = new Dog(1,"Rambo","Pug");
		Dog simbaDog = new Dog(2,"Simba","Dachshund");
		
		ramboDog.displayDetails();
		simbaDog.displayDetails();
		
		ramboDog.nameSetter("Zorro");
		simbaDog.breedSetter("Poodle");

	}

}
