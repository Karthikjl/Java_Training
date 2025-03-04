package com.celcom.day15.BankSystem;
import java.sql.Timestamp;

class Transaction {
	int id;
	double amount;
	Timestamp timestamp;
	String type;

	public Transaction(int id, double amount, Timestamp timestamp, String type) {
		this.id = id;
		this.amount = amount;
		this.timestamp = timestamp;
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	@Override
	public String toString() {
		return type + " Id=" + id + ", Amount=" + amount + ", Timestamp=" + timestamp;
	}
}