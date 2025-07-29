package com.celcom.day7.MultithreadExamples;

public class FileDownloadWithThreads extends Thread {
    
    private String fileName;

    // Constructor to pass the file name
    public FileDownloadWithThreads(String fileName) {
        this.fileName = fileName;
    }

    // Method to simulate downloading a file
    @Override
    public void run() {
        try {
            System.out.println("Downloading " + fileName + "...");
            Thread.sleep(1000); // Simulating a 2-second download
            System.out.println(fileName + " downloaded!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Create two threads for downloading files concurrently
        Thread thread1 = new FileDownloadWithThreads("File 1");
        Thread thread2 = new FileDownloadWithThreads("File 2");

        // Start both threads
        thread2.start();
        thread2.join();
        thread1.start();
        thread1.join();

        // Wait for both threads to finish
    }
}
