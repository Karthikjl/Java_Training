package com.celcom.day3;

class A {
	A() {
		System.out.println("A");
	}
	A(int i){
		System.out.println("A 1");
	}
}

class B extends A {
	B() {
		System.out.println("B");
	}
	B(int i){
		super(12);
		System.out.println("B 1");
	}
}

public class SuperKeywordExample2 {

	
	public static void main(String[] args) {
		
		B b = new B(12);

	}

}
