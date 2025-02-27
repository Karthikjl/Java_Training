package com.celcom.day14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task3Thread implements Runnable {
	public void run() {
//		try {
//			Thread.sleep(2000);
		System.out.println("Hello i am thread - " + Thread.currentThread().getId());

//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}
}

public class Task3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newCachedThreadPool();

		for (int i = 0; i < 10; i++) {
			Thread.sleep(2000);
			executor.submit(new Task3Thread());
		}
		executor.shutdown();

	}

}
