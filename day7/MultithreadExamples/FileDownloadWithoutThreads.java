package com.celcom.day7.MultithreadExamples;

public class FileDownloadWithoutThreads {
    
    // Method to simulate downloading a file
    public static void downloadFile(String fileName) {
        try {
            System.out.println("Downloading " + fileName + "...");
            Thread.sleep(2000); // Simulating a 2-second download
            System.out.println(fileName + " downloaded!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        downloadFile("File 1");
        downloadFile("File 2");
    }
}
