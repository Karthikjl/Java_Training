package com.celcom.day7;

class MyThread3 implements Runnable {
	public void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName() + " Running");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadExample4 {
	public static void main(String[] arg) throws InterruptedException {
		Thread t1 = new Thread(new MyThread3());
		Thread t2 = new Thread(new MyThread3());

		t1.setName("T1");
		t2.setName("T2");
		
		
		t1.start();
		t1.join();
		t2.start();


	}
}
