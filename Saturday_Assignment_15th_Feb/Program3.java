package com.celcom.Saturday_Assignment_15th_Feb;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class CopyArrayList {
	List<Integer> list = new ArrayList<>();
	List<Integer> copyList = new ArrayList<>();
	CopyArrayList(List<Integer> list){
		this.list = list;
	}
	void copyList() {
		for(int val:list) {
			copyList.add(val);
		}
		
		System.out.print("Element in original list: ");
		for(int val:copyList) {
			System.out.print(val+" ");
		}
		
		System.out.print("\nElement in copied list: ");
		for(int val:copyList) {
			System.out.print(val+" ");
		}
		System.out.println("\nCopied Sucessfully.");
	}

}

public class Program3 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int input;
		System.out.print("Enter number of elements: ");
		input = scanner.nextInt();
		System.out.print("Enter number: ");
		for (int i = 0; i < input; i++) {
			list.add(scanner.nextInt());
		}
		CopyArrayList copyArrayList = new CopyArrayList(list);
		copyArrayList.copyList();
		scanner.close();

	}

}
