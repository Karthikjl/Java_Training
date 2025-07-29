package com.celcom.day9;

import java.util.ArrayList;

public class WrapperClassExample {

	@SuppressWarnings("removal")
	public static void main(String[] args) {
		int a = 10;
		Integer obj1 = new Integer(a);// Boxing
		int b = obj1.intValue();// Un-Boxing

		Integer obj2 = a; // Auto Boxing
		obj2 = a;// Auto Un-Boxing

		ArrayList<Integer> list = new ArrayList<>();
		list.add(9);
		list.add(a + 2);
		list.add(obj1 + 45);
		list.add(obj2 + 6);
		System.out.println(list);
		int sum = 0;
		for (int val : list) {
			sum += val;
		}
		System.out.println("Sum: " + sum);

	}

}
