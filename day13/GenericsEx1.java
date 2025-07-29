package com.celcom.day13;

import java.util.ArrayList;
import java.util.List;

public class GenericsEx1 {

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		l1.add(23);
		l1.add(2);
		l1.add(1);
		l1.add(45);

		l2.add(6);
		l2.add(243);
		l2.add(2);
		l2.add(56);
		GenericsEx1.listAdder(l1, l2);

	}

	static <T>void listAdder(List<T> l1, List<T> l2) {

		List<T> finalList = new ArrayList<>();
//		System.out.println(finalList.addAll(l1));
//		System.out.println(finalList.addAll(l2));

//		23 2 1 45
//		0  1  2  3
//		6 243 2 56
//		0  1  2  3
//
//		23 6 2 243 1 2 45 56
//		0  1 2  3  4 5 6  7

		int lengthOfList = l1.size() + l2.size();
		int i = 0;
		while (finalList.size() != lengthOfList) {
			if (i < l1.size()) {
				finalList.add(l1.get(i));
			}
			if (i < l2.size()) {
				finalList.add(l2.get(i));
			}
			i++;
		}
		System.out.println(finalList);

	}

}
