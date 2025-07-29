package com.celcom.day11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CyberCrimeInvestigation {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		int sum;
		int element;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of transaction: ");
		element = scanner.nextInt();
		System.out.print("Enter transaction record: ");
		for (int i = 0; i < element; i++) {
			list.add(scanner.nextInt());
		}
		System.out.print("Enter Stolen heist amount: ");
		sum = scanner.nextInt();
		int checksum = 0;
		int length = list.size();
		for (int i = 0; i < length; i++) {
			List<Integer> dupList = new ArrayList<>();
			checksum = 0;
			for (int j = i; j < length; j++) {
				if ((checksum + list.get(j)) < sum) {
					dupList.add(list.get(j));
					checksum += list.get(j);
				} else if ((checksum + list.get(j)) == sum) {
					dupList.add(list.get(j));
					System.out.println(dupList);
					break;
				}
				else break;
			}

		}

		scanner.close();

	}

}
