package com.marketmobile.mobile.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {
	
	private static final String DATE_PATTERN="dd/MM/yyyy kk:mm:ss";
	
	private static final String TIME_PATTERN="kk:mm:ss";
	

	public static String dateToString(Date data) {
		if (data==null) {
			return null;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		
		return sdf.format(data);
	}
	
	public static Date stringToDate(String data) throws ParseException {
		if (data==null) {
			return null;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		
		return sdf.parse(data);
	}
	
	public static String timeToString(Date data) {
		if (data==null) {
			return null;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(TIME_PATTERN);
		
		return sdf.format(data);
	}
}
