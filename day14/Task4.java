package com.celcom.day14;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class Task2Thread implements Runnable {

	public void run() {

		SimpleDateFormat formatDate = new SimpleDateFormat("HH:mm:ss");
		String currentTime = formatDate.format(new Date());
		System.out.println("Current Time: " + currentTime);
	}
}

public class Task4 {
	public static void main(String[] args) {
		AtomicInteger counter = new AtomicInteger(0);
		ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();

		Runnable task = () -> {
			int count = counter.incrementAndGet();
			new Task2Thread().run();

			if (count >= 10) {
				scheduledExecutor.shutdown();
				System.out.println("Scheduler shut down after 10 executions.");
			}
		};

		scheduledExecutor.scheduleAtFixedRate(task, 0, 1500, TimeUnit.MILLISECONDS);
	}
}
