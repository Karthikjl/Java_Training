package com.celcom.day7;

//Inner Class//
public class InnerClassExample1 {
	// Non-Static Class
	class InnerClass {
		void myMethod() {
			System.out.println("MyMethod from Non-Static innerclass");
		}
	}

	// Static class
	static class InnerClass1 {
		void myMethod() {
			System.out.println("MyMethod from Static innerclass");
		}
	}

	// Local Inner class
	void myMethod() {
		class InnerClass2 {
			void myMethod() {
				System.out.println("MyMethod from Local Static innerclass");
			}
		}

		InnerClass2 inner3 = new InnerClass2();
		inner3.myMethod();
	}

	public static void main(String[] args) {
		InnerClassExample1 obj = new InnerClassExample1();
		InnerClass inner = obj.new InnerClass();

		inner.myMethod();

		InnerClassExample1.InnerClass1 inner2 = new InnerClassExample1.InnerClass1();
		inner2.myMethod();
		
	
	}

}
