package com.celcom.day15.Railwayreservationsystem;

import java.util.concurrent.locks.ReentrantLock;

class Seat implements Runnable {
	private String name;
	private final ReentrantLock lock1;
	private final ReentrantLock lock2;

	Seat(String name, ReentrantLock lock1, ReentrantLock lock2) {
		this.name = name;
		this.lock1 = lock1;
		this.lock2 = lock2;
	}

	public void run() {
		while (true) {
			if (lock1.tryLock()) {
				try {
					System.out.println(name + " acquired " + lock1);

					Thread.sleep(1000);

					if (lock2.tryLock()) {
						try {
							System.out.println(name + " acquired " + lock2);
							System.out.println(name + " got the seat.");
							break;
						} finally {
							lock2.unlock();
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock1.unlock();
				}
			}
		}
	}
}

public class Main {
	public static void main(String args[]) {
		ReentrantLock lock1 = new ReentrantLock();
		ReentrantLock lock2 = new ReentrantLock();

		Thread t1 = new Thread(new Seat("Passenger A", lock1, lock2));
		Thread t2 = new Thread(new Seat("Passenger B", lock2, lock1));

		t1.start();
		t2.start();
	}
}
