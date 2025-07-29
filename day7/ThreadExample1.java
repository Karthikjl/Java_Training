package com.celcom.day7;
 
public class ThreadExample1 {
	public static void main(String args[]) {
		Thread t = Thread.currentThread();
		System.out.println(t);
		System.out.println("Current Thread name is : " + t.getName());
		System.out.println("Current Thread's Priority is : " + t.getPriority());
	}
}
 
 