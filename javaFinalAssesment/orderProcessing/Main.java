package com.celcom.javaFinalAssesment.orderProcessing;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String args[]) {
		ScheduledExecutorService sExecutor = Executors.newScheduledThreadPool(1);
		sExecutor.scheduleAtFixedRate(() -> ProcessOrder.processOrder(), 0, 60, TimeUnit.SECONDS);
	}
}
