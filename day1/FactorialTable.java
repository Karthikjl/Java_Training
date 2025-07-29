package com.celcom.day1;
import java.util.Scanner;

public class FactorialTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number to find Factorial Table: ");
		number = input.nextInt();
		int factorial = 1;
		for (int index = 1; index <= number; index++) {
			factorial *= index;
			System.out.println(index+"! = "+factorial);
		}
		input.close();
	}

}
