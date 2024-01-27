package kr.co.shield.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	public static <T extends Date> int diff(int field, T t1, T t2) {
		Calendar c1 = Calendar.getInstance(); c1.setTime(t1);
		Calendar c2 = Calendar.getInstance(); c2.setTime(t2);
		return diff(field, c1, c2);
	}
	public static int diff(int field, Calendar c1, Calendar c2) {
		long returnDiff = c2.getTimeInMillis() - c1.getTimeInMillis();
		long unit = 1000L;
		switch (field) {
		case Calendar.YEAR:
			unit *= 365; break;
		case Calendar.MONTH:
			unit *= 30; break;
		}
		switch (field) {
		case Calendar.YEAR:
		case Calendar.MONTH:
		case Calendar.DAY_OF_MONTH:
			unit *= 24;
		case Calendar.HOUR_OF_DAY:
			unit *= 60;
		case Calendar.MINUTE:
			unit *= 60;
		}
		return (int)(returnDiff / unit);
	}
	
	// 20230101 -> 2023-01-01
	public static String parse(String value) {
		String rtnStr = value;
		try {
			String pattern = null;
			if (value.length() == 10) {
				pattern = "yyyy-MM-dd";
			} else {
				// length == 6
				pattern = "yyyyMMdd";
			}
			Date date = new SimpleDateFormat(pattern).parse(value);
			rtnStr = FormatUtils.getFormatString(date, "yyyy-MM-dd");
		} catch (ParseException e) {}
		return rtnStr;
	}
	
	public static Date parse(String value, String pattern) {
		Date returnDt = null;
		try {
			DateFormat df = new SimpleDateFormat(pattern);
			returnDt = df.parse(value);
		} catch (ParseException e) {}
		return returnDt;
	}
	
	public static <T extends Date> String format(T t, String pattern) {
		DateFormat df = new SimpleDateFormat(pattern);
		return df.format(t);
	}
	public static String format(Calendar c, String pattern) {
		return format(c.getTime(), pattern);
	}
	
	public static long toMillis(LocalDateTime ldt) {
		return ldt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
	}
	
//	public static void main(String[] args) {
//		System.out.println(parse("2021-09-01", "yyyy-MM-dd"));
//	}
//	
}
