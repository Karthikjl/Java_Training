package com.celcom.day8;

import java.util.Date;

//Date
public class UtilityExampleDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		System.out.println(date);
		System.out.println(date.getDate());
		System.out.println(date.getDay());
		System.out.println(date.getMonth());
		System.out.println(date.getSeconds());
		System.out.println(date.getYear() + 1900);
		System.out.println(date.getTimezoneOffset());
		System.out.println(date.toGMTString());

	}

}
