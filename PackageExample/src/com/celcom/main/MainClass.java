package com.celcom.PackageExample.src.com.celcom.main;
//import com.celcom.pack1.MyClass1;
//import com.celcom.pack2.MyClass2;

//Static Import
import static java.lang.Math.PI;

import static java.lang.Integer.parseInt;

public class MainClass {

	public static void main(String[] args) {

//		Direct object creation using same class name in package		
//		com.celcom.pack1.MyClass1 obj1 = new com.celcom.pack1.MyClass1();	
//		com.celcom.pack2.MyClass1 obj2 = new com.celcom.pack2.MyClass1();
		
//		MyClass1 obj1 = new MyClass1();
//		MyClass2 obj2 = new MyClass2();
//		
//		obj1.myMethod1();
//		obj1.myMethod2();
//	
//		obj2.myMethod3();
		
		double pi = Math.PI;
		
 		System.out.println(pi);
		
		System.out.println(PI);
		
		System.out.println(parseInt("123"));
	}

}
 