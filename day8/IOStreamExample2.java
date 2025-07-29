package com.celcom.day8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOStreamExample2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

//		FileReader
		FileInputStream fr = new FileInputStream("E:\\Java_Core\\JavaTraining\\src\\com\\celcom\\day8\\Dog.png");
//		int ch1 = 0;
//		while ((ch1 = fr.read()) != -1) {
//			System.out.print((char) ch1);
//
//		}
//		fr.close();

//		FileWriter
		FileOutputStream fw = new FileOutputStream("E:\\Java_Core\\JavaTraining\\src\\com\\celcom\\day8\\DogCopy.png");
		int ch = 0;
		while ((ch = fr.read()) != -1) {
			fw.write(ch);

		}
		fr.close();
		fw.close();
		System.out.println("File copied Sucessfully.");
	}

}
