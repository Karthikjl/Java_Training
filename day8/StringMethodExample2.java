package com.celcom.day8;

public class StringMethodExample2 {

	public static void main(String[] args) {
		String s1 = "Hello";
//		char ch[] = { 'H', 'e', 'l', 'l', 'o' };

//		for (int i = 0; i < s1.length(); i++) {
//			System.out.println(s1.charAt(i));
//		}

//		for (char val : s1.toCharArray()) {
//			System.out.println(val);
//		}

//		s1.chars().forEach(ch -> System.out.print((char) ch));
		
		String s2 = "Welcome to java";
		String[] temp = s2.split(" ");
		for(String val: temp) {
			System.out.println(val);
		}

	}

}
