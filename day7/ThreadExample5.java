package com.celcom.day7;

class TwoTable extends Thread {
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("2  * " + i + " = " + (i * 2));
//			try {
//				Thread.sleep(2000);
//				
//			} catch (InterruptedException e) {
//				// TODO: handle exception
//			}
		}
	}
}

class TwelveTable extends Thread {
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.err.println("12 * " + i + " = " + (i * 12));
//			try {
//				Thread.sleep(2000);
//				
//			} catch (InterruptedException e) {
//				// TODO: handle exception
//			}
		}
	}
}

public class ThreadExample5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new TwoTable());
		Thread t2 = new Thread(new TwelveTable());
		t1.start();
		t2.start();

	}

}
