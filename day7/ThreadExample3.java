package com.celcom.day7;

class MyThread implements Runnable {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("My thread running..");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadExample3 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyThread());
        System.out.println("Thread name: " + t1.getName());
        t1.start();
        
        // Give the thread a moment to start
        Thread.sleep(1000);
        
        System.out.println("Thread ID: " + t1.getId());

        // You can interrupt the thread gracefully if needed
        t1.interrupt();
        System.out.println("Main thread finishes");
    }
}
