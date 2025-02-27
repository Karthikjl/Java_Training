package com.celcom.day13;

import java.util.Arrays;

public class GenericEx2 {
	static <T> boolean CheckIfSameElement(T[] array1, T[] array2) {

		return Arrays.equals(array1, array2);

	}

	public static void main(String[] args) {
		Integer[] array1 = { 1, 2, 3, 4 };
		Integer[] array2 = { 1, 2, 3, 4 };
		System.out.println(GenericEx2.CheckIfSameElement(array1, array2));
	}

}
