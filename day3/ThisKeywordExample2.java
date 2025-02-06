package com.celcom.day3;

public class ThisKeywordExample2 {

	ThisKeywordExample2() {
//		this("Arjun")
		this(20);
		System.out.println("Completed");
	}

	ThisKeywordExample2(int age) {
		this("Ramu");
		System.out.println(20);
	}

	ThisKeywordExample2(String name) {
		System.out.println("Ramu");

	}

	public static void main(String[] args) {
		ThisKeywordExample2 obj = new ThisKeywordExample2();
	}

}
