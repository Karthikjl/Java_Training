package com.celcom.day1;

class CommandLineArgumet2 {

	public static void main(String args[]) {
		int argsLength = args.length;
		if (argsLength == 2) {
			int number1 = Integer.parseInt(args[0]);
			int number2 = Integer.parseInt(args[1]);
			int sum = number1 + number2;
			System.out.println("Addition: " + sum);
		} else {
			System.out.println("Expecting 2 numbers as command line input");
		}

	}
}