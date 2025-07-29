package com.celcom.day2;

public class StarPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		StringBuilder string = new StringBuilder();
//
//		for (int i = 0; i < 5; i++) {
//
//			System.out.println(string.append("* "));
//		}

//		double c= 10.51;
//		float b = (float)c;
//		float a = 10.51f;
//
//		System.out.println(a == b);

//		for (int i = 1; i <= 5; i++) {
//			for (int j = 1; j <= 5; j++) {
//
//				if (i == 1 || j == 1 || j == 5 || i == 5) {
//					System.out.print("* ");
//				}
//				else {
//					System.out.print("  ");
//				}
//			}
//			System.out.println();
//		}

//		for (int i = 1; i <= 5; i++) {
//			for (int j = 1; j <= 5; j++) {
//
//				if (5 == i || i + j == 6 || i == 1) {
//					System.out.print("* ");
//				} else {
//					System.out.print("  ");
//				}
//			}
//			System.out.println();
//		}

		for (int i = 1; i <= 5; i++) {

			for (int j = 1; j <= 5; j++) {
				if (i % 2 == 0 && j % 2 == 0 || (i+j)%4 == 0) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();

		}

	}

}
