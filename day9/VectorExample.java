package com.celcom.day9;

import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

public class VectorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vector<Integer> vector = new Vector<>(3, 2);

		System.out.println("Size: " + vector.size());
		System.out.println("Capacity: " + vector.capacity());
		vector.add(10);
		vector.add(2);
		vector.add(1);
		vector.add(15);
		System.out.println(vector);
		System.out.println("Size: " + vector.size());
		System.out.println("Capacity: " + vector.capacity());
//		Way1		
		System.out.println("\nElements:");
		for (int i = 0; i < vector.size(); i++) {
			System.out.println(vector.get(i));
		}
//		Way 2
		System.out.println("\nElements:");
		for (int val : vector) {
			System.out.println(val);
		}

//		Way 3		
		Enumeration<Integer> enu = vector.elements();
		System.out.println("\nElements:");

		while (enu.hasMoreElements()) {
			System.out.println(enu.nextElement());
		}

	}

}
