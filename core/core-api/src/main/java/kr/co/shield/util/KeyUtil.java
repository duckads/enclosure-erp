package kr.co.shield.util;

import io.jsonwebtoken.SignatureAlgorithm;
import org.bouncycastle.util.io.pem.PemReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class KeyUtil {
	
	private static final Map<String, Key> KEY_STORE_SIGNING = new ConcurrentHashMap<>();
	private static final Map<String, Key> KEY_STORE_PARSING = new ConcurrentHashMap<>();
	
	public static Key signingKey(SignatureAlgorithm signatureAlgorithm) {
		Key key = null;
		
		if (KEY_STORE_SIGNING.containsKey(signatureAlgorithm.name())) {
			key = KEY_STORE_SIGNING.get(signatureAlgorithm.name());
		}
		if (key == null) {
			try {
				String content;
				PemReader pemReader;
				PKCS8EncodedKeySpec spec;
				KeyFactory kf;
				
				switch (signatureAlgorithm) {
				case HS256:
					content = StreamUtils.copyToString(new ClassPathResource("jwt/hs256/secret.key").getInputStream(), StandardCharsets.UTF_8);
					key = new SecretKeySpec(DatatypeConverter.parseBase64Binary(content), signatureAlgorithm.getJcaName());
					break;
				case RS256:
					content = StreamUtils.copyToString(new ClassPathResource("jwt/rs256/rsa-private.pem").getInputStream(), StandardCharsets.UTF_8);
					pemReader = new PemReader(new StringReader(content));
					spec = new PKCS8EncodedKeySpec(pemReader.readPemObject().getContent());
					kf = KeyFactory.getInstance("RSA");
					key = kf.generatePrivate(spec);
					break;
				case ES256:
					content = StreamUtils.copyToString(new ClassPathResource("jwt/es256/ec-private.pkcs8").getInputStream(), StandardCharsets.UTF_8);
					pemReader = new PemReader(new StringReader(content));
					spec = new PKCS8EncodedKeySpec(pemReader.readPemObject().getContent());
					kf = KeyFactory.getInstance("EC"); // Elliptic Curve
					key = kf.generatePrivate(spec);
					break;
				default:
					throw new UnsupportedOperationException("Only support HS256, RS256, ES256");
				}
				KEY_STORE_SIGNING.put(signatureAlgorithm.name(), key);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return key;
	}
	
	public static Key parsingKey(SignatureAlgorithm signatureAlgorithm) {
		Key key = null;
		
		if (KEY_STORE_PARSING.containsKey(signatureAlgorithm.name())) {
			key = KEY_STORE_PARSING.get(signatureAlgorithm.name());
		}
		if (key == null) {
			try {
				String content;
				PemReader pemReader;
				X509EncodedKeySpec spec;
				KeyFactory kf;
				
				switch (signatureAlgorithm) {
				case HS256:
					content = StreamUtils.copyToString(new ClassPathResource("jwt/hs256/secret.key").getInputStream(), StandardCharsets.UTF_8);
					key = new SecretKeySpec(DatatypeConverter.parseBase64Binary(content), signatureAlgorithm.getJcaName());
					break;
				case RS256:
					content = StreamUtils.copyToString(new ClassPathResource("jwt/rs256/rsa-public.pem").getInputStream(), StandardCharsets.UTF_8);
					pemReader = new PemReader(new StringReader(content));
					spec = new X509EncodedKeySpec(pemReader.readPemObject().getContent());
					kf = KeyFactory.getInstance("RSA");
					key = kf.generatePublic(spec);
					break;
				case ES256:
					content = StreamUtils.copyToString(new ClassPathResource("jwt/es256/ec-public.pem").getInputStream(), StandardCharsets.UTF_8);
					pemReader = new PemReader(new StringReader(content));
					spec = new X509EncodedKeySpec(pemReader.readPemObject().getContent());
					kf = KeyFactory.getInstance("EC"); // Elliptic Curve
					key = kf.generatePublic(spec);
					break;
				default:
					throw new UnsupportedOperationException("Only support HS256, RS256, ES256");
				}
				KEY_STORE_PARSING.put(signatureAlgorithm.name(), key);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return key;
	}
	
}
