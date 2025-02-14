package com.celcom.day9;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializationExample1 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		FileInputStream fi = new FileInputStream("E:\\Java_Core\\JavaTraining\\src\\com\\celcom\\day9\\ObjectFile.txt");
		ObjectInputStream obj1 = new ObjectInputStream(fi);
		Employee emp = (Employee) obj1.readObject();
		fi.close();
		obj1.close();
		System.out.println(emp);
		System.out.println("The entered date ⬆️");

	}

}
