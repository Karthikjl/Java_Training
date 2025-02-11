package com.celcom.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TryCatchExample2 {

	static void m1() throws FileNotFoundException {
		FileReader fileReader = new FileReader("abc.txt");

	}

	static void m2() {
		try {
			m1();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		uncheck exception
//		int a[] = new int[-1];
//		int b = Integer.parseInt("123");

//		checked exception
//		try {
//			FileReader fileReader = new FileReader("abc.txt");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
////			e.printStackTrace();
//			System.out.println(e);
//		};

//		try {
//			FileReader fileReader= new FileReader("abc.txt");
//		}
//		catch(Exception e){
//			System.out.println(e);
//		}

		TryCatchExample2.m2();
	}

}
