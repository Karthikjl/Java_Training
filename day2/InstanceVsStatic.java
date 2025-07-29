package com.celcom.day2;

public class InstanceVsStatic {
	int a = 10;
	static int b = 10;

	public static void main(String[] args) {
		System.out.println("For Instance");
		InstanceVsStatic obj1 = new InstanceVsStatic();
		InstanceVsStatic obj2 = new InstanceVsStatic();
		
		obj1.a = 10;
		obj2.a = 15;

		System.out.println(obj1.a);
		System.out.println(obj2.a);
		
		System.out.println("\nFor Static");
		InstanceVsStatic obj3 = new InstanceVsStatic();
		InstanceVsStatic obj4 = new InstanceVsStatic();

		obj3.b = 10;
		obj4.b = 20;
		
		System.out.println(obj3.b);
		System.out.println(obj4.b);
		
	}

}
