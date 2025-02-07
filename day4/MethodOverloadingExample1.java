package com.celcom.day4;

public class MethodOverloadingExample1 {

	void commonMethod(int radius) {
		System.out.println("The Area of Circle: " + (3.14) * radius * radius);
	}
	
	void commonMethod(int length,int bredth) {
		System.out.println("The Area of Rectangle: " + (length) * (bredth));
	}
	void commonMethod(int length,float height) {
		System.out.println("The Area of Triangle: " + (.5) * (length*height));
	}
	
	public static void main(String[] args) {
		MethodOverloadingExample1 commonMethod = new MethodOverloadingExample1();
		
		commonMethod.commonMethod(2);
		commonMethod.commonMethod(2,2);
		commonMethod.commonMethod(2,2f);
		
	
	}

}
