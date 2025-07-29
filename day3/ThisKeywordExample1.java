package com.celcom.day3;


class ThisClass{
	String name;
	
	ThisClass(){
		this("Default Name");
	}
	
	ThisClass(String name){
		this.name = name;
		this.displayName(name);
	}
	
	void displayName(String name) {
//		this.name = name;
		System.out.println(name);
	}
}
public class ThisKeywordExample1 {

	public static void main(String[] args) {
		ThisClass Raju = new ThisClass("Raju");
		ThisClass Mani = new ThisClass();
		Mani.displayName("Mani");

	}

}
