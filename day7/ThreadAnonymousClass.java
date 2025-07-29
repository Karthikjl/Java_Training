package com.celcom.day7;

public class ThreadAnonymousClass {
	public static void main(String arg[]) {
		Runnable runnable = new Runnable() {
			public void run() {
				for (int i = 1; i <= 10; i++) {
//					System.out.println("Thread 1 is running...");
					System.out.println("2 * " + i + " = " + (i * 2));
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};

		Thread t1 = new Thread(runnable);

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
//					System.out.println("Thread 2 is running...");
					System.err.println("12 * " + i + " = " + (i * 12));
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}

		});

		t1.setPriority(1);
		t2.setPriority(10);
		t1.start();
		t2.start();
	}
}
