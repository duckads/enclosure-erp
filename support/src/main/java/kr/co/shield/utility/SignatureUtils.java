package kr.co.shield.utility;

import java.security.MessageDigest;
import java.security.SignatureException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SignatureUtils {
	
	protected static final String UTF_8_Encoding            = "UTF-8";
	
	public static final String ALGORITHM_SHA256             = "SHA-256";
	public static final String ALGORITHM_HMAC_SHA1          = "HmacSHA1";
	public static final String ALGORITHM_HMAC_SHA256        = "HmacSHA256";
	
	public static final String SIGNATURE_KEYNAME            = "signKey";
	
	public static String makeSignature(Map<String, String> parameters) throws Exception {
		if (parameters != null && !parameters.isEmpty()) {
			String parametersString = calculateString(parameters);
			return hash(parametersString, "SHA-256");
		} else {
			throw new RuntimeException("Parameters can not be empty.");
		}
	}
	
	public static String hash(String data, String algorithm) throws Exception {
		MessageDigest md = MessageDigest.getInstance(algorithm);
		md.update(data.getBytes(UTF_8_Encoding));
		
		byte[] hash = md.digest();
		StringBuilder result = new StringBuilder();
		for (byte b : hash) {
			result.append(String.format("%02x", b));
		}
		
		return result.toString();
	}
	
	public static String normalizeAndHash(String data, String algorithm) throws Exception {
		String normalized = data.toLowerCase().replaceAll("\\s+", "");
		return hash(normalized, algorithm);
	}
	
	private static String calculateString(Map<String, String> parameters) throws SignatureException {
		StringBuilder str = new StringBuilder();
		
		Map<String, String> sortedParamMap = new TreeMap<>();
		sortedParamMap.putAll(parameters);
		
		for (Entry<String, String> entry : sortedParamMap.entrySet()) {
			String key = entry.getKey().trim();
			String value = entry.getValue().trim();
			
			if (str.length() > 0) {
				str.append("&");
			}
			str.append(key).append("=").append(value);
		}
		
		return str.toString();
	}
	
//	private String normalizeAndHash(MessageDigest digest, String s, boolean trimIntermediateSpaces) throws UnsupportedEncodingException {
//		// Normalizes by first converting all characters to lowercase, then trimming
//		// spaces.
//		String normalized = s.toLowerCase();
//		if (trimIntermediateSpaces) {
//			// Removes leading, trailing, and intermediate spaces.
//			normalized = normalized.replaceAll("\\s+", "");
//		} else {
//			// Removes only leading and trailing spaces.
//			normalized = normalized.trim();
//		}
//		// Hashes the normalized string using the hashing algorithm.
//		byte[] hash = digest.digest(normalized.getBytes("UTF-8"));
//		StringBuilder result = new StringBuilder();
//		for (byte b : hash) {
//			result.append(String.format("%02x", b));
//		}
//
//		return result.toString();
//	}
	
	
	public static void main(String[] args) throws Exception {
		System.out.println(normalizeAndHash("test@gmail.com", ALGORITHM_SHA256));
		System.out.println(normalizeAndHash("test.2@gmail.com", ALGORITHM_SHA256));
		System.out.println(normalizeAndHash("+1 234 5678910", ALGORITHM_SHA256));
		System.out.println(normalizeAndHash("John", ALGORITHM_SHA256));
		System.out.println(normalizeAndHash("Doe", ALGORITHM_SHA256));
		System.out.println(normalizeAndHash("+1 234 5678911", ALGORITHM_SHA256));
		System.out.println(normalizeAndHash("test3@gmail.com", ALGORITHM_SHA256));
//		System.out.println(hash("orderNumber=INIpayTest_1361252896871&price=1004&signKey=eAsYxldparufwvpdlvmTgw==&timestamp=1361252896871", ALGORITHM_SHA256));
//		System.out.println(hash("cardNoInterestQuota=11-2:3:4:5:6,34-2:6&cardQuotaBase=2:3:4:5:6&orderNumber=INIpayTest_1361253184589&price=50500&signKey=eAsYxldparufwvpdlvmTgw==&timestamp=1361253184589", ALGORITHM_SHA256));
	}
	
}
