package com.celcom.day8;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOStreamExample1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

//		FileReader
		FileReader fr = new FileReader("E:\\Java_Core\\JavaTraining\\src\\com\\celcom\\day8\\Example.txt");
//		int ch = 0;
//		while ((ch = fr.read()) != -1) {
//			System.out.print((char) ch);
//
//		}
//		fr.close();

//		FileWriter
		FileWriter fw = new FileWriter("E:\\Java_Core\\JavaTraining\\src\\com\\celcom\\day8\\ExampleCopy.txt");
		int ch = 0;
		while ((ch = fr.read()) != -1) {
			fw.write(ch);

		}
		fr.close();
		fw.close();
		System.out.println("File copied Sucessfully.");
	}

}
