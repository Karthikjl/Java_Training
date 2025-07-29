package com.celcom.day4;


//Method Overloading
public class MethodOverloadingExample3 {
	void concate(int num1,int num2) {
		System.out.println("Concadination of two int: " + num1 +" " + num2);
	}
	void concate(String str1,String str2) {
		System.out.println("Concadination of two String: " + str1+" "+ str2);
	}
	void concate(float num1,float num2) {
		System.out.println("Concadination of two Float: " + num1 +" " + num2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodOverloadingExample3 concate = new MethodOverloadingExample3();
		
		concate.concate(1, 2);
		concate.concate("A","B");
		concate.concate(1.0f, 22.0f);

	}

}
