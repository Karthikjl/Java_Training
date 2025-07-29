package com.celcom.day15.atm;

class Account {
	float balance = 100;

	synchronized void withdraw(float withdrawAmt, String name) {
		if (balance >= withdrawAmt) {
			balance -= withdrawAmt;
			System.out.println("Withdrawed: " + withdrawAmt + " by " + name);
			System.out.println("Balance: " + balance);
		} else {
			System.out.println("Sorry " + name + " Witdrawal amount " + withdrawAmt + " exceeds balance.");
			System.out.println("Insufficient balance: " + balance);
		}
	}

}

public class UsingSync {

	public static void main(String[] args) {
		Account amt = new Account();
		Thread t1 = new Thread(() -> amt.withdraw(175, "Mohan"));
		Thread t2 = new Thread(() -> amt.withdraw(75, "Arun"));
		t1.start();
		t2.start();

	}

}
