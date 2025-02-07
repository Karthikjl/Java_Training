package com.celcom.day4;

public class JavaBlock {
	{
		System.out.println("Instance Block");
	}
	static {
		System.out.println("Static");
	}

	public JavaBlock() {
		System.out.println("Constructor");
	}

	public String toString() {
		return "Method";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main method");
		JavaBlock objBlock = new JavaBlock();
		System.out.println(objBlock);
	}

}
