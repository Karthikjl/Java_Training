package com.celcom.day14;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class TaskFor5 implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i = 0; i <= 20; i++) {
			sum += i;
		}
		return sum;
	}

}

public class Task5 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newSingleThreadExecutor();
//		Integer value = executor.submit(new TaskFor5()).get();
//		System.out.println(value);

		Future<Integer> val = executor.submit(new TaskFor5());
		System.out.println(val.get());
		executor.shutdown();
	}

}
