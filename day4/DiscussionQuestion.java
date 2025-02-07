package com.celcom.day4;

import java.util.Scanner;

class SuperClass{
	SuperClass(){
		System.out.println("A");
	}
//	
//	SuperClass(int i){
//		System.out.println("C");
//	}
	
}

class Subclass extends SuperClass{

//	Subclass(int i){
//		// super() by default it calls super emplty class without any argument class
//
//		System.out.println("B");
//	}/
	
	void method1() {
		
		System.out.println("D");
		
	}
}
public class DiscussionQuestion {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int a[] = {10,20,30,40},b[];
//		b = a;
//		System.out.println(b[2]);
		Object S = new Scanner(System.in);
	
//		System.out.print(o.getClass()+"\n");
		 Object o = new Subclass();
		System.out.println(o.getClass());
		((Scanner) S).nextInt();
	}

}
