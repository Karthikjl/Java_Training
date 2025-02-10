package com.celcom.day5;

//Multiple Inheritance

interface One {
	int a = 10; // public, static, final

	void print();

}

interface Two {
	int a = 20;

	void print();

}

interface Three extends One, Two {
	void addition();
}

class Addition implements Three {
	@Override
	public void addition() {
		// TODO Auto-generated method stub
		System.out.println(One.a + Two.a);

	}

	public void print() {
		System.out.println("add");
	}
}

public class MutipleInheritanceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Three add = new Addition();
//		add.addition();

		Addition obj = new Addition();
		obj.print();
		System.out.print("Result: ");
		obj.addition();

	}

}
