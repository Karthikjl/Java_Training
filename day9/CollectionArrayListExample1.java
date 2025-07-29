package com.celcom.day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CollectionArrayListExample1 {

	public static void main(String[] args) {
//		List<Object> list = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(3);
		list.add(124);
		list.add(20);
		list.add(211);
		list.add(4, 10);

//		list.add("Java");

//		Collections.sort(list);
		System.out.println(list);
		list.remove(new Integer(10));
		System.out.println(list);

		System.out.println(list.get(0));
		list.set(0, 3);
		System.out.println("List size: " + list.size());
		System.out.println(list);
//		list.clear();
//		System.out.println(list);

//		System.out.println("List size: " + list.size());
		System.out.println("Empty: " + list.isEmpty());
		System.out.println("Contains: " + list.contains(211));

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		for (int i : list) {
			System.out.print(i + " ");
		}
		System.out.println("\nIterator");
		Iterator<Integer> it = list.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());

		}

	}

}
