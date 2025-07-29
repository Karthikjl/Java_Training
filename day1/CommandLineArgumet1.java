package com.celcom.day1;

class CommandLineArgumet1 {

	public static void main(String args[]) {
		int argsLength = args.length;
		System.out.println("Total No of Arguments: " + argsLength);
		for (int i = 0; i < argsLength; i++) {
			System.out.println("Argument " + (i + 1) + ": " + args[i]);

		}
	}
}