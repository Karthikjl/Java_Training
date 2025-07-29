package com.celcom.day2;


public class TypesOfVariablesInJava {
	//Instance or Object variable
	int b = 23;
	
	//Static or Class variable
	static int c = 250;
	
	public static void main(String[] args) {
		//Local Variable
		int a = 25;
		System.out.println("Local Variable");
		System.out.println(a);
		
		
		System.out.println("\nInstance or Object Variable");
		TypesOfVariablesInJava b = new TypesOfVariablesInJava();
		System.out.println(b.b);
				
		System.out.println("\nStatic or Class Variable");
		System.out.println(TypesOfVariablesInJava.c);

	}

}
