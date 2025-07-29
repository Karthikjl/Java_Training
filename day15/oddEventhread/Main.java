package com.celcom.day15.oddEventhread;

class Printer {
	boolean isOddTurn = true;

	synchronized void printOdd(int num) {
		while (!isOddTurn) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(num);
		isOddTurn = false;
		notify();
	}

	synchronized void printEven(int num) {
		while (isOddTurn) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(num);
		isOddTurn = true;
		notify();
	}
}

public class Main {
	public static void main(String[] args) {
		Printer printer = new Printer();

		Thread oddThread = new Thread(() -> {
			for (int i = 1; i <= 10; i += 2) {
				printer.printOdd(i);
			}
		});

		Thread evenThread = new Thread(() -> {
			for (int i = 2; i <= 10; i += 2) {
				printer.printEven(i);
			}
		});

		oddThread.start();
		evenThread.start();
	}
}
