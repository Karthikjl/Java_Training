package com.celcom.day14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TaskOfThread implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

public class Task2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newFixedThreadPool(6);

		for (int i = 0; i < 10; i++) {
			executor.submit(new TaskOfThread());
		}
		executor.shutdown();

	}

}
