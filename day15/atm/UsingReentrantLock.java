package com.celcom.day15.atm;


import java.util.concurrent.locks.ReentrantLock;

class Account1 {
	private float balance = 100;
	ReentrantLock lock = new ReentrantLock();

	void withdraw(float withdrawAmt, String name) {
		lock.lock();
		try {
			if (balance >= withdrawAmt) {
				balance -= withdrawAmt;
				System.out.println("Withdrawn: " + withdrawAmt + " by " + name);
				System.out.println("Remaining Balance: " + balance);
			} else {
				System.out.println("Sorry " + name + ", Withdrawal amount " + withdrawAmt + " exceeds balance.");
				System.out.println("Insufficient balance: " + balance);
			}
		} finally {
			lock.unlock();
		}
	}
}

public class UsingReentrantLock {
	public static void main(String[] args) {
		Account1 account = new Account1();

		// Creating threads for withdrawal
		Thread t1 = new Thread(() -> account.withdraw(175, "Mohan"));
		Thread t2 = new Thread(() -> account.withdraw(75, "Arun"));
		Thread t3 = new Thread(() -> account.withdraw(5, "Kavin"));
		Thread t4 = new Thread(() -> account.withdraw(20, "Suresh"));

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
