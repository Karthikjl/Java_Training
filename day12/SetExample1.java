package com.celcom.day12;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// HashSet

public class SetExample1 {

	public static void main(String[] args) {
		Set<Integer> st = new HashSet<>();
		Set<Integer> st1 = new HashSet<>();

		Object a[] = st1.toArray();

		for (Object a1 : a) {
			System.out.print(a1 + " ");
		}
		st.add(1);
		st.add(2);
		st.add(3);
		st.add(4);
		st.add(5);
//		st1.add(3);
//		st1.add(123);
//		st1.add(17);
//		st1.add(56);
//		st1.add(23);

		Iterator<Integer> iterator = st.iterator();

		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
//		st.addAll(st1);
//		System.out.println(st);
//		System.out.println(st1.containsAll(st));
//		System.out.println(st.containsAll(st));
//		System.out.println(st.contains(12));
//		System.out.println(st.retainAll(st1));
//		System.out.println(st);
//		st.removeAll(st1);
//		System.out.println(st);
//		System.out.println(st.size());

	}

}
