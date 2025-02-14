package com.celcom.day8;

public class ImmutableString {

	public static void main(String[] arg) {
		String s1 = "Unite";

		// Assigns new Memory for this string
		// This is String is called Immutable
		s1 = s1.concat(" world");
		System.out.println(s1);

		StringBuffer s2 = new StringBuffer("Sanjay");

		// Thread Safe
		// It uses same memory for StringBuffer
		s2.append(" Kumar");
		System.out.println(s2);

		StringBuilder s3 = new StringBuilder("Sanjay");

		// Not - Thread Safe
		// It uses same memory for StringBuilder
		s3.append(" Kumar");
		System.out.println(s3);
		System.out.println(s3.capacity());

		System.out.println(s2.toString().equals("Sanjay Kumar"));


	}
}
