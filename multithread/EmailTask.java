package com.multithread;

public class EmailTask implements Runnable {
    private String emailAddress;

    public EmailTask(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void run() {
        System.out.println("Starting Email task for: " + emailAddress);
        try {

            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Email task interrupted for: " + emailAddress);
        }
        System.out.println("Email sent to: " + emailAddress);
    }
}
