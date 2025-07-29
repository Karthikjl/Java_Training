package com.celcom.day9;

import java.util.LinkedList;

public class LinkedListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list = new LinkedList<Integer>();

		list.add(12);
		list.add(13);
		list.add(122);
		list.add(125);
		list.add(112);
		list.add(1112);
		System.out.println(list);
		System.out.println(list.add(1211));
		System.out.println(list.contains(5));
		System.out.println(list.isEmpty());
		System.out.println(list.remove(3));
		System.out.println(list);
	}

}
