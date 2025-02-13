package com.celcom.day8;

import java.util.StringTokenizer;

public class StringTokenizerExample {

	public static void main(String[] args) {
		String s1 = new String("Welcome to the world");
		StringTokenizer s2 = new StringTokenizer(s1, " ");
		System.out.println(s2.countTokens());
		while (s2.hasMoreTokens()) {
			System.out.println(s2.nextToken());
		}

	}

}
