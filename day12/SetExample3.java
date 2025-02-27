package com.celcom.day12;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetExample3 {

	public static void main(String[] args) {

		Set<Integer> linkedHashSet1 = new LinkedHashSet<Integer>();
		Set<Integer> linkedHashSet2 = new LinkedHashSet<Integer>();

		linkedHashSet1.add(4);
		linkedHashSet1.add(2);
		linkedHashSet1.add(54);
		linkedHashSet1.add(46);
		
		linkedHashSet2.add(4);
		linkedHashSet2.add(1);
		linkedHashSet2.add(3);
		linkedHashSet2.add(46);
		System.out.println(linkedHashSet1);
		linkedHashSet1.addAll(linkedHashSet2);
		System.out.println(linkedHashSet1);

	}

}
