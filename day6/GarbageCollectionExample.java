package com.celcom.day6;

class MyClass {
	static int a = 0;

	MyClass() {
		a++;
		System.out.println(a);
	}

	@Override
	protected void finalize() throws Throwable {
		a--;
		System.out.println(a);
	}
}

public class GarbageCollectionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClass obj1 = new MyClass();
		MyClass obj2 = new MyClass();

		
		//GarbageCollector Call
		obj1 = null;
		System.gc();
		
		obj2 = null;
		Runtime.getRuntime().gc();

	}

}
