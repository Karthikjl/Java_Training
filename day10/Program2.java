package com.celcom.day10;

class Product {
	private String productName;
	private boolean isProduced = false;

	public Product(String productName) {
		this.productName = productName;
	}

	public synchronized void produce() {
		while (isProduced) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Producing: " + productName);
		isProduced = true;
		notify();
	}

	public synchronized void consume() {
		while (!isProduced) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Consuming: " + productName);
		isProduced = false;
		notify();
	}
}

class Producer extends Thread {
	private final Product product;

	public Producer(Product product) {
		this.product = product;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			product.produce();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer extends Thread {
	private final Product product;

	public Consumer(Product product) {
		this.product = product;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			product.consume();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Program2 {
	public static void main(String[] args) {
		Product product = new Product("Bike");

		Producer producer = new Producer(product);
		Consumer consumer = new Consumer(product);

		producer.start();
		consumer.start();
	}
}
