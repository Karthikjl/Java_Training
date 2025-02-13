package com.celcom.day7;


public class ThreadExample2 extends Thread{
	
	public void run() {
		for(int i = 0;i<10;i++) {
			System.out.println("My thread Running...");
			try {
				Thread.sleep(2000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		ThreadExample2 t1 = new ThreadExample2();
		ThreadExample2 t2 = new ThreadExample2();
		
		System.out.println(t1.getClass());
		System.out.println(t1.getState());
		System.out.println(t1.getId());
		System.out.println(t1.getName());
		System.out.println(t1.getPriority());
		t1.start();
//		for(int i = 0;i<50;i++) {
//			System.out.println("Main");
//		}
		Thread.sleep(2000);
		
		System.out.println("Main method");
	}
}
