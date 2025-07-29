package com.celcom.day11;

import java.util.Scanner;

public class CountPossibleDecoding {
	public static int numDecodings(Integer num) {
		int totalCount = 0;
		int flag = 0;
		if (num == 0) {
			return 0;
		}

		for (int i = 0; i < num.SIZE; i++) {
			totalCount++;
		}
		if (flag != 0) {
			return flag;
		} else
			return 0;
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		Integer num;

		System.out.print("Enter a number: ");
		num = scanner.nextInt();
		System.out.print(numDecodings(num));
		scanner.close();

	}

}
