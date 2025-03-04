package com.celcom.day13;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegularEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputScanner = new Scanner(System.in);

//		System.out.print("Enter email: ");
//		String email = inputScanner.nextLine();
//		String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
//		System.out.println(Pattern.matches(emailPattern, email) ? "Valid email" : "Invalid Email");
//
		System.out.print("Enter Password (At least 8 character with 1 upper, lower, digit, special char: ");
		String password = inputScanner.nextLine();
		String passPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}$";
		System.out.println(Pattern.matches(passPattern, password) ? "Valid Password" : "Invalid Password");

//		String phonePattern = "^[0-9]{10}$";
//		String phonePattern = "^\\d{10}$";
//		System.out.print("Enter you phone number: ");
//		String phoneNumber = inputScanner.nextLine();
//		System.out.println(Pattern.matches(phonePattern, phoneNumber) ? "Valid number" : "Invalid Number");

		inputScanner.close();
	}

}
