package com.celcom.day8;

import java.util.Calendar;

public class UtilityExampleCalender {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);
		System.out.println(calendar.get(Calendar.MONTH));
		System.out.println(calendar.get(Calendar.DATE));
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.get(Calendar.HOUR));
		System.out.println(calendar.get(Calendar.MINUTE));
		System.out.println(calendar.get(Calendar.SECOND));
		System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));

	}

}
