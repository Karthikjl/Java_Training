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
            Thread.sleep(10000); // Simulating a 2-second download
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
        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        thread1.join();
        thread2.join();
    }
}
