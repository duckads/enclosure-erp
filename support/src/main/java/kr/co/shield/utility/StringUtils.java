package kr.co.shield.utility;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	
	public static final String CHARSET_EUC_KR   = "euc-kr";
	public static final String CHARSET_UTF_8    = "utf-8";
	
	public static String getString(Object value) {
		return getString(value, "");
	}
	public static String getString(Object value, String defaultStr) {
		String returnStr = null;
		if (value != null) {
			returnStr = value.toString();
		} else {
			returnStr = defaultStr;
		}
		return returnStr;
	}
	
	public static String replace(String str, Map<String, Object> params) {
		return replace("", str, params);
	}
	
	public static String replace(String charset, String str, Map<String, Object> params) {
		StringBuilder ret = new StringBuilder();
		
		Pattern p = Pattern.compile("\\{\\{[_0-9a-zA-Z]*\\}\\}");
		Matcher m = p.matcher(str);
		
		try {
			int pl = 0;
			while (m.find()) {
				int ps = m.start();
				int pe = m.end();
				
				if (pl == 0 && ps > 0) {
					ret.append(str.substring(0, ps));
				} else {
					ret.append(str.substring(pl, ps));
				}
				
				String param = m.group();
				param = param.substring("{{".length(), param.length() - "}}".length());
				String value = "";
				if (params.containsKey(param)) {
					value = StringUtils.getString(params.get(param));
				}
				
				if (charset.isBlank()) {
					ret.append(value);
				} else {
					ret.append(URLEncoder.encode(value, charset));
				}
				
				pl = pe;
			}
			if (pl < str.length()) {
				ret.append(str.substring(pl));
			}
		} catch (Exception e) {
			ret.setLength(0);
			e.printStackTrace();
		}
		
		return ret.toString();
	}
	
	// https://meyerweb.com/eric/tools/dencoder/
	// https://www.loc.gov/marc/specifications/specchareacc.html
	private static Pattern patternU = Pattern.compile("((%E[3-9A-F])(%[89AB][0-9A-F]){2})");
	private static Pattern patternE = Pattern.compile("((%((B[0-9A-F])|(C[0-8])))(%[A-F][0-9A-F]))");
	private static Pattern patternU16 = Pattern.compile("(%u[0-9a-f]{4})");
	public static String getDecode(String value) {
		String returnStr = value;
		if (value != null && value.length() > 0) {
			if (value.endsWith("%")) {
				value += "25";
			}
			if (value.indexOf("%&") > 0) {
				value = value.replaceAll("%&", "%25&");
			}
//			if (value.matches("(.*)(%25[0-9a-fA-F]{2})(.*)")) {
//				value = value.replaceAll("%25", "%");
//			}
			try {
				if(value.indexOf("%u") > -1 || value.indexOf("%U") > -1) {
					StringBuilder t = new StringBuilder();
					Matcher matcherU16 = patternU16.matcher(value.toLowerCase());
					int pointS = 0;
					int pointE = -1;
					while (matcherU16.find()) {
						pointS = matcherU16.start();
						if (pointS > 0 && pointE < 0) {
							t.append(value.substring(0, pointS));
						} else if (pointE > 0 && pointS != pointE) {
							t.append(value.substring(pointE, pointS));
						}
						pointE = matcherU16.end();
						t.append((char)Integer.parseInt(matcherU16.group().substring(2), 16));
					}
					if (pointE < value.length()) {
						t.append(value.substring(pointE));
					}
					returnStr = t.toString();
				} else {
					String v = value.toUpperCase();
					Matcher matcherU = patternU.matcher(v);
					Matcher matcherE = patternE.matcher(v);
					long cntU = matcherU.results().count();
					long cntE = matcherE.results().count();
					if (cntU + cntE == 0 || cntU >= cntE) {
						returnStr = URLDecoder.decode(value, CHARSET_UTF_8);
					} else {
						returnStr = URLDecoder.decode(value, CHARSET_EUC_KR);
					}
				}
			} catch (Exception e) {}
		}
		return returnStr;
	}
	
//	public static void main(String[] args) throws Exception {
//		String value = "%E6%B0%B4 %E6%9E%97 + %E7%AB%A0 @1034267";
//		System.out.println("UTF-8 :" + URLDecoder.decode(value, "utf-8"));
//		System.out.println("EUC-KR:" + URLDecoder.decode(value, "euc-kr"));
//		System.out.println("DECODE:" + getDecode(value));
//	}
//	
}
