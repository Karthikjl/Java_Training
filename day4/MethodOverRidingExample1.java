package com.celcom.day4;


//Method OverRiding
class Student {
	void myMethod() {
		System.out.println("From SuperClass");
	}
}

class SubClass extends Student{
	void myMethod() {
		System.out.println("From Subclass");
	}
}

public class MethodOverRidingExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		new SubClass().myMethod();
		
		
		Student student = new SubClass();
		student.myMethod();
		
	}

}
