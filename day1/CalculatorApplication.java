package com.celcom.day1;

import java.util.Scanner;

public class CalculatorApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char YorN = 'N';
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Enter Choice to preform operation");
			System.out.print("1. Addition\n2. Subraction\n3. Multiplication\n4. Division\nEnter the choice: ");
			int choice = input.nextInt();
			int number1;
			int number2;

			switch (choice) {
			case 1:
				System.out.print("Enter two number: ");
				number1 = input.nextInt();
				number2 = input.nextInt();
				int sum = number1 + number2;
				System.out.println("The Addition of numbers is " + sum);
				break;
			case 2:
				System.out.print("Enter two number: ");
				number1 = input.nextInt();
				number2 = input.nextInt();
				int sub = number1 - number2;
				System.out.println("The Subraction of numbers is " + sub);
				break;
			case 3:
				System.out.print("Enter two number: ");
				number1 = input.nextInt();
				number2 = input.nextInt();
				int mul = number1 * number2;
				System.out.println("The Multiplication of numbers is " + mul);
				break;
			case 4:
				System.out.print("Enter two number: ");
				number1 = input.nextInt();
				number2 = input.nextInt();
				int div = 0;
				try {
					div = number1 / number2;

				} catch (Exception e) {
					System.out.println("Invalid Number.");
				}
				System.out.println("The Division of numbers is " + div);
				break;
			default:
				System.out.println("Please enter the Choice correctly.");
				break;

			}
			System.out.print("Enter Y/y to Continue: ");
			YorN = input.next().charAt(0);
		} while (YorN == 'Y' || YorN == 'y');
		input.close();
	
	}

}
