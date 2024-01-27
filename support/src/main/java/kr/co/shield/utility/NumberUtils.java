package kr.co.shield.utility;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class NumberUtils {
	
	public static int getNumber(Object value) {
		return getNumber(Integer.class, value, 0);
	}
	
	public static <T extends Number> T getNumber(Class<T> cls, Object value) {
		return getNumber(cls, value, null);
	}
	public static <T extends Number> T getNumber(Class<T> cls, Object value, T defaultNum) {
		Number returnNum = null;
		NumberType numberType = null;
		try {
			numberType = NumberType.valueOf(cls.getSimpleName());
			if (value != null) {
				if (value instanceof String) {
					String v = (String)value;
					if (v.startsWith("+")) {
						v = v.substring(1);
					} else if (v.equals("NaN")) {
						throw new Exception();
					}
//					returnNum = NumberFormat.getInstance(Locale.KOREA).parse((String)value);
					returnNum = NumberFormat.getInstance().parse(v);
				} else {
					returnNum = ((Number)value);
				}
			} else if (defaultNum != null) {
				returnNum = defaultNum;
			}
			switch (numberType) {
			case Byte:
				returnNum = returnNum.byteValue(); break;
			case Short:
				returnNum = returnNum.shortValue(); break;
			case Float:
				returnNum = returnNum.floatValue(); break;
			case Long:
				returnNum = returnNum.longValue(); break;
			case Double:
				returnNum = returnNum.doubleValue(); break;
			case BigInteger:
				returnNum = BigInteger.valueOf(returnNum.longValue()); break;
			case BigDecimal:
				returnNum = new BigDecimal(returnNum.doubleValue()); break;
			case AtomicInteger:
				returnNum = new AtomicInteger(returnNum.intValue()); break;
			case AtomicLong:
				returnNum = new AtomicLong(returnNum.longValue()); break;
			default:
				returnNum = returnNum.intValue();
			}
		} catch (Exception e) {
			if (defaultNum == null) {
				switch (numberType) {
				case Byte:
					returnNum = (byte)0; break;
				case Short:
					returnNum = (short)0; break;
				case Float:
					returnNum = 0F; break;
				case Long:
					returnNum = 0L; break;
				case Double:
					returnNum = 0D; break;
				case BigInteger:
					returnNum = BigInteger.valueOf(0L); break;
				case BigDecimal:
					returnNum = BigDecimal.valueOf(0L); break;
				case AtomicInteger:
					returnNum = new AtomicInteger(0); break;
				case AtomicLong:
					returnNum = new AtomicLong(0L); break;
				default:
					returnNum = 0;
				}
			} else {
				returnNum = defaultNum;
			}
		}
		return cls.cast(returnNum);
	}
	
	public static <T extends Number> String format(T t, String pattern) {
		DecimalFormat df = new DecimalFormat(pattern);
		return df.format(t);
	}
	
	public static boolean isNumber(Object value) {
		boolean returnBool = false;
		
		String str = StringUtils.getString(value);
		str = str.replaceAll(",", "");
		
		if (str.matches("-?\\d+(\\.\\d+)?")) {
			returnBool = true;
		}
		
		return returnBool;
	}
	
	// AtomicInteger, AtomicLong, BigDecimal, BigInteger, Byte, Double, Float, Integer, Long, Short	
	enum NumberType {
		Byte,
		Short,
		Integer,
		Float,
		Long,
		Double,
		BigInteger,
		BigDecimal,
		AtomicInteger,
		AtomicLong,
		;
	}
	
//	@SuppressWarnings("unchecked")
//	public static void main(String[] args) {
//		System.out.println(isNumber("30xl3klz"));
//	}
//	
}
