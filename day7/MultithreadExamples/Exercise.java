package com.celcom.day7.MultithreadExamples;

public class Exercise extends Thread {
	
	public void run() {
		System.out.println("Run from Main thread");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Exercise obj = new Exercise();
		obj.start();

	}

}
