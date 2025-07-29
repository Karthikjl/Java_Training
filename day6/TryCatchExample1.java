package com.celcom.day6;

public class TryCatchExample1 {

	public static void main(String[] args) {
		System.out.println("Before Exception");

		try {

			int arr[] = new int[] {12,12,12};
			System.out.println(arr[5]);
			

		} catch (NumberFormatException e) {

			System.out.println("NumberFormatException");
		} catch (NegativeArraySizeException e) {

			System.out.println("NegativeArraySizeException");
		} catch (Exception e) {

			System.out.println("Exception");
		} finally {
			System.out.println("Finally");
		}
	}

}
