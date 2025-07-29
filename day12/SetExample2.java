package com.celcom.day12;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

// TreeSet

public class SetExample2 {

	public static void main(String[] args) {
		Set<Integer> treeSet = new TreeSet<Integer>();
		Set<String> treeSet1 = new TreeSet<String>();

		// TreeSet gets Automatically sort
//		treeSet.add(null);
		treeSet.add(11);
		treeSet.add(51);
		treeSet.add(234);
		treeSet.add(41);
		System.out.println(treeSet);

		treeSet1.add("Arun");
		treeSet1.add("Arjun");
		treeSet1.add("Akash");
//		treeSet1.add(null);

		System.out.println(treeSet1);

		System.out.println(treeSet.contains(234));
		System.out.println(treeSet.containsAll(treeSet));
		System.out.println(treeSet.equals(treeSet));
		System.out.println(treeSet.retainAll(treeSet));

		System.out.println(treeSet);

		Iterator<Integer> i = treeSet.iterator();
		while (i.hasNext()) {
			System.out.print(i.next() + " ");
		}

	}

}
