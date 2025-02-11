package com.celcom.day5;

interface VehiclePlan1 {
	void wheel();

	void tyre();

	void engine();

	void handleBar();
}

interface VehiclePlan2 {

	void run();

}

abstract class Vehicle4 implements VehiclePlan1, VehiclePlan2 {
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

class Car2 extends Vehicle4 {
	@Override
	public void wheel() {
		System.out.println("Wheel in car");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("I am running.. car");

	}

	@Override
	public void handleBar() {

	}

}

public class InterfaceExample2 {

	public static void main(String[] args) {

		Vehicle4 vec = new Car2();
		vec.wheel();
		vec.engine();
		vec.run();

	}

}
