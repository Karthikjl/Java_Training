package com.celcom.day4;

public class MethodOverloadingExample2 {
	
	void addition(int a,int b) {
		System.out.println("Integer: " + a+b);
	}
	
	void addition(double a,double b) {
		System.out.println("Float: " + (a+b));
	}
	
	void addition(long a,long b) {
		System.out.println("Long: " + a+b);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodOverloadingExample2 method = new MethodOverloadingExample2();
		method.addition(2,4);
		method.addition(2.456776544, 4.94583740);
		method.addition(29217983284632L, 48237487432L);
	}

}
