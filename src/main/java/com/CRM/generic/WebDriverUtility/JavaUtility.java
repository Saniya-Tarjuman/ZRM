package com.CRM.generic.WebDriverUtility;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class JavaUtility {
public int getRandomNum(int num) {
	Random ran = new Random();
	int r = ran.nextInt(num);
	return r;
}
public String getSystemDate() {
	Date d = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String date = sdf.format(d);
	return date;
}
public String getRequiredDateyyyyMMdd(int days) {
	Date dobj = new Date();
	SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
	simple.format(dobj);
	Calendar cal = simple.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH, days);
	String reqDate = simple.format(cal.getTime());
	return reqDate;
}
}