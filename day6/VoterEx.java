package com.celcom.day6;

import java.util.Scanner;

//Own exception method
class VoterException extends Exception {
	int age;

	public VoterException(int age) {
		// TODO Auto-generated constructor stub
		this.age = age;
	}

	public String toString() {
		return "Can't able to vote in this age "+age;
	}
}

//Exception

public class VoterEx {

	public static void main(String[] args) {
		int age;

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your age: ");

		age = sc.nextInt();

		if (age >= 18) {
			System.out.println("You can able to vote");
		} else {
//			System.out.println("You are not eligible");
			try {
				throw new VoterException(age);
			} catch (VoterException e) {

				System.out.println(e);
			}
		}

	}

}
