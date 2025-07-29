package com.celcom.day12;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample1 {

	public static void main(String[] args) {
		Map<Integer, String> hashMap = new LinkedHashMap<Integer, String>();
		hashMap.put(1, "Sugar");
		hashMap.put(2, "Rice");
		hashMap.put(3, "Dairy");


		System.out.println(hashMap.containsKey(1)); //true
		System.out.println(hashMap.containsValue("Rice")); //true

		System.out.println(hashMap); // {1=Sugar, 2=Rice, 3=Dairy}

		System.out.println(hashMap.equals(hashMap)); // true

		System.out.println(hashMap.get(1)); //Sugar

		System.out.println(hashMap.hashCode()); // 148580546

		System.out.println(hashMap.isEmpty()); //false

		System.out.println(hashMap.keySet()); // [1, 2, 3]
		hashMap.put(4, "Fruits");
		System.out.println(hashMap); // {1=Sugar, 2=Rice, 3=Dairy, 4=Fruits}


		for (Map.Entry<Integer, String> map : hashMap.entrySet()) {
			System.out.println(map.getKey() + " - " + map.getValue());
		}
//
		hashMap.merge(3, "Milk", (oldValue, newValue) -> oldValue + " " + newValue);
//
		System.out.println(hashMap);
//
		hashMap.putIfAbsent(5, "Chocho powder");
		System.out.println(hashMap);
//
		hashMap.put(2, "Cake");
		System.out.println(hashMap);

		hashMap.clear();
		System.out.println(hashMap);
		System.out.println(hashMap.isEmpty());
	}

}
