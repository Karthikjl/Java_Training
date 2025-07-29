package com.celcom.day5;

interface Vehicle1 {
	void wheel();

	void tyre();

	void engine();

	void handleBar();
}

abstract class Vechicle2 implements Vehicle1 {
	@Override
	public void wheel() {
		System.out.println("Wheel in vechicle2");
	}

	@Override
	public void tyre() {
		System.out.println("tyre in vechicle2");
	}

	@Override
	public void engine() {
		System.out.println("engine in vechicle2");
	}

	@Override
	public void handleBar() {
		System.out.println("Handbar in vechicle2");
	}
}

class Car1 extends Vechicle2 {
	@Override
	public void wheel() {
		System.out.println("Wheel in car");
	}

	@Override
	public void handleBar() {

	}

}

public class InterfaceExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vehicle1 vec = new Car1();
		vec.wheel();
		vec.engine();

	}

}
