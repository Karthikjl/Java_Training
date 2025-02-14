package com.celcom.day9;

import java.io.FileOutputStream;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable {
	private int eId;
	private String eName;
	private int eSalary;

	public Employee(int eId, String eName, int eSalary) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.eSalary = eSalary;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public int geteSalary() {
		return eSalary;
	}

	public void seteSalary(int eSalary) {
		this.eSalary = eSalary;
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", eSalary=" + eSalary + "]";
	}

}

public class SerializationExample1 {

	public static void main(String[] args) throws IOException {
		Employee employee = new Employee(1, "Arjun", 20000);

		FileOutputStream fo = new FileOutputStream(
				"E:\\Java_Core\\JavaTraining\\src\\com\\celcom\\day9\\ObjectFile.txt");
		ObjectOutputStream objout = new ObjectOutputStream(fo);

		objout.writeObject(employee);
		objout.close();
		fo.close();
		fo = new FileOutputStream("E:\\Java_Core\\JavaTraining\\src\\com\\celcom\\day9\\ObjectFile.txt");
		objout = new ObjectOutputStream(fo);
		employee = new Employee(2, "Arun", 10000);
		objout.writeObject(employee);
		objout.close();
		fo.close();
		System.out.println("Object Saved");

	}

}
