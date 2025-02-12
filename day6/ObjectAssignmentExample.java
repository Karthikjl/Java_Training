package com.celcom.day6;

public class ObjectAssignmentExample {

	public static void main(String[] args) {
		// same reference copy
		ObjectAssignmentExample obj1 = new ObjectAssignmentExample();
		System.out.println(obj1.hashCode());
		ObjectAssignmentExample obj2 = obj1;
		System.out.print(obj2.hashCode());

	}

}
