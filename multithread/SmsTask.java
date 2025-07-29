package com.celcom.multithread;

public class SmsTask implements Runnable {
	private String phoneNumber;

	public SmsTask(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void run() {
		System.out.println("Starting SMS task for phone number: " + phoneNumber);
		try {

			Thread.sleep(2000);
		} catch (InterruptedException e) {

			System.err.println("SMS task interrupted for phone number: " + phoneNumber);
		}
		System.out.println("SMS sent to: " + phoneNumber);
	}
}
