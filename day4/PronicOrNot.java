package com.celcom.day4;


import java.util.Scanner;

public class PronicOrNot {

	public static void main(String[] args) {
		int flag = 0;
		int num;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Number to find pronic or not: ");
		num = input.nextInt();
		if(num%2 != 0) {
			System.out.println("Not a Pronic number");
			System.exit(0);
		}
		for (int i = 1; i <= Math.sqrt(num); i++) {
			if((i * (i + 1)) == num) {
				flag++;
				break;
			}
		}
		
		if(flag == 1) {
			System.out.println("Pronic Number");
		}
		else {
			System.out.println("Not a Pronic number");
		}
	}

}
