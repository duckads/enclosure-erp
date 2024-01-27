package kr.co.shield.utility;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class FormatUtils {
	
	public static String getFormatString(int number, String pattern) {
		DecimalFormat df = new DecimalFormat(pattern);
		return df.format(number);
	}
	
	public static String getFormatString(long number, String pattern) {
		DecimalFormat df = new DecimalFormat(pattern);
		return df.format(number);
	}
	
	public static String getFormatString(double number, String pattern) {
		DecimalFormat df = new DecimalFormat(pattern);
		return df.format(number);
	}
	
	public static String getFormatString(Calendar date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date.getTime());
	}
	
	public static String getFormatString(Timestamp timestamp, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(timestamp);
	}
	
	public static String getFormatString(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	public static String getFormatString(Date date, String pattern, TimeZone timezone) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setTimeZone(timezone);
		return sdf.format(date);
	}
	
}
