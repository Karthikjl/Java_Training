package com.celcom.day3;

class Fruits {

}

class Apple extends Fruits{
	public Apple() {
		// TODO Auto-generated constructor stub
		System.out.println("I am Apple.");
	}
}

class Grapes extends Fruits{
	public Grapes() {
		// TODO Auto-generated constructor stub
		System.out.println("I am Grapes.");
	}
}

public class DynamicMethodDispatch {

	public static void main(String[] args) {
		Fruits fruits = new Apple();
		fruits = new Grapes();
		fruits = new Apple();
		
	}

}
