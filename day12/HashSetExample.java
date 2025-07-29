package com.celcom.day12;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> hashSet1 = new HashSet<Integer>();
		Set<Integer> hashSet2 = new HashSet<Integer>();

		hashSet1.add(5);
		hashSet1.add(53);
		hashSet1.add(25);
		hashSet1.add(15);
		hashSet1.add(55);
		System.out.println(hashSet1);
		hashSet2.add(5);
		hashSet2.add(1);
		hashSet2.add(32);
		hashSet2.add(14);
		hashSet2.add(6);
		System.out.println(hashSet2);
		
		hashSet1.addAll(hashSet2);
		System.out.println(hashSet1);

	}

}
