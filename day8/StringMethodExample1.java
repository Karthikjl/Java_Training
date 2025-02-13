package com.celcom.day8;

public class StringMethodExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Hello world";

		System.out.println(s1.length());
		System.out.println(s1.charAt(0));
		System.out.println(s1.toLowerCase());
		System.out.println(s1.toUpperCase());

		System.out.println(s1.concat(" " + s1));
		System.out.println(s1.replace('o', 'z'));

		System.out.println(s1.toCharArray());
		System.out.println(s1.compareTo("Hello world"));

		System.out.println(s1.equals("Hello World"));
		System.out.println(s1.equalsIgnoreCase(s1));
		System.out.println(s1.startsWith("He"));
		System.out.println(s1.endsWith("ld"));

		System.out.println(s1.substring(2, 6));
		System.out.println(s1.substring(3));

	}

}
