package com.celcom.day11;

import java.util.Scanner;

class Microwave {
	int item;
	float seconds;
	String foodName;
	String microwaveModel;

	public Microwave(int item, float seconds, String foodName, String microwaveModel) {
		this.item = item;
		this.seconds = seconds;
		this.foodName = foodName;
		this.microwaveModel = microwaveModel;
	}

	void cook() {
		float totalTime = 0;

		if (item == 1) {
			totalTime = seconds;
		} else if (item == 2) {
			totalTime = seconds + ((seconds * 50) / 100);
		} else {
			totalTime = seconds * 2;
		}

		if (foodName.equals("pasta")) {
			totalTime = totalTime + ((totalTime * 10) / 100);

		} else if (foodName.equals("frozen meal")) {
			totalTime = totalTime + ((totalTime * 20) / 100);
		} else if (foodName.equals("vegetables")) {
			
		}

		if (microwaveModel.equals("high")) {
			

		} if (microwaveModel.equals("medium")) {
			totalTime = totalTime - ((totalTime * 10) / 100);

		} else if (microwaveModel.equals("low")) {
			totalTime = totalTime + ((totalTime * 15) / 100);
		}

		System.out.print("The recommended heating time is: " + totalTime + " seconds.");

	}

}

public class MicrowaveHeating {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int item;
		float seconds;
		String foodName;
		String microwaveModel;

		System.out.print("Enter the number of items: ");
		item = scanner.nextInt();
		if (item >= 4 || item <= 0) {
			System.out.println("Invalid input.");
		} else {
			System.out.print("Enter the heating time for one item (in seconds): ");
			seconds = scanner.nextFloat();
			scanner.nextLine();
			System.out.print("Enter the type of food (e.g., pasta, frozen meal, vegetables): ");
			foodName = scanner.nextLine();
			foodName = foodName.toLowerCase();
			if (foodName.equals("pasta") || foodName.equals("frozen meal") || foodName.equals("vegetables")) {
				System.out.print("Enter the microwave model (high, medium, low): ");
				microwaveModel = scanner.nextLine();
				microwaveModel = microwaveModel.toLowerCase();
				if (microwaveModel.equals("high") || microwaveModel.equals("medium") || microwaveModel.equals("low")) {
					Microwave micro = new Microwave(item, seconds, foodName, microwaveModel);
					micro.cook();
				} else {
					System.out.println("Invalid model adjustment.");
				}
			} else {
				System.out.print("Invalid food type");
			}
		}
		scanner.close();

	}

}
