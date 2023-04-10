package com.rediff.qa.utils;

import java.util.Date;

public class Utilities {

	public static String generateEmailWithTimeStamp() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "seleniumpanda" + timeStamp + "@rediffmail.com";
	}
	
	public static String generateNameforEmailWithTimeStamp() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
//		StringBuffer sb = new StringBuffer(timeStamp);
//		sb.delete(0, sb.length()-1);
//		System.out.println(timeStamp);
		String timeStamp1 = timeStamp.substring(8, 19).replace("_", "");
		return "seleniumpanda" + timeStamp1;

	}
	
	public static final int implicitWaitTime = 10; 
	public static final int pageLoadTime = 10;
	public static final int scriptTime = 1000;

}
