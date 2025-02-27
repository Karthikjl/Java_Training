package com.celcom.day12;

import java.util.Map;
import java.util.TreeMap;

//Tree map 

public class TreeMapExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer, String> treeMap = new TreeMap<Integer, String>();
		treeMap.put(1, "Sugar");
		treeMap.put(2, "Rice");
		treeMap.put(3, "Dairy");

//		treeMap.clear();

		System.out.println(treeMap.containsKey(1));
		System.out.println(treeMap.containsValue("Rice"));

		System.out.println(treeMap);

		System.out.println(treeMap.equals(treeMap));

		System.out.println(treeMap.get(1));

		System.out.println(treeMap.hashCode());

		System.out.println(treeMap.isEmpty());

		System.out.println(treeMap.keySet());
		treeMap.put(4, "Fruits");
		System.out.println(treeMap);

//		System.out.println(treeMap);
//
//		for (Map.Entry<Integer, String> map : treeMap.entrySet()) {
//			System.out.println(map.getKey() + " - " + map.getValue());
//		}
//
//		treeMap.merge(3, "Milk", (oldValue, newValue) -> oldValue + " " + newValue);
//
//		System.out.println(treeMap);
//
		treeMap.putIfAbsent(5, "Chocho powder");
		System.out.println(treeMap);
//
		treeMap.put(2, "Cake");
		System.out.println(treeMap);
	}

}
