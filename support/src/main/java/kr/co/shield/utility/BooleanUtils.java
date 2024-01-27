package kr.co.shield.utility;

public class BooleanUtils {
	
	public static boolean getBoolean(Object value) {
		return getBoolean(value, false);
	}
	
	public static boolean getBoolean(Object value, boolean defaultBool) {
		Boolean returnBool = null;
		if (value != null) {
			if (value instanceof Boolean) {
				returnBool = (Boolean)value;
			} else {
				returnBool = value.toString().matches("(?i)(y|t|(true))");
			}
		} else {
			returnBool = defaultBool;
		}
		return returnBool;
	}
	
//	public static void main(String[] args) {
//		System.out.println(getBoolean("ttt"));
//	}
//	
}
