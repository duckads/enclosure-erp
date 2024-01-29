package kr.co.shield.config.jwt;

import com.google.common.reflect.TypeToken;
import io.jsonwebtoken.*;
import io.jsonwebtoken.Jwts;
import kr.co.shield.util.KeyUtil;
import kr.co.shield.common.ShieldProperty;
import kr.co.shield.common.exception.UnauthorizedException;
import kr.co.shield.utility.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

/**
 * https://velog.io/@chang626/JWT-코드-및-Security-설정
 * https://kdevkr.github.io/jwt/ ***
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class JwtTokenProvider { // implements InitializingBean {
	
	private SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.ES256;
	
	@Value("${jwt.key-id}")
	private String keyId;
	
	@SuppressWarnings("serial")
	private static final Type MAP_TYPE = new TypeToken<Map<String, String>>() {}.getType();

	public String generateToken(String subject, Map<String, Object> claims, long expiration) {
		String token = null;
		Key signingKey = KeyUtil.signingKey(signatureAlgorithm);
		if (signingKey != null) {
			long issuedAt = System.currentTimeMillis();
			token = Jwts.builder()
					.setHeaderParam(ShieldProperty.JWT_HEADER_key_id, this.keyId)
					.setHeaderParam(ShieldProperty.JWT_HEADER_type, ShieldProperty.JWT_HEADER_typ_JWT)
					.setSubject(subject)
					.setIssuedAt(new Date(issuedAt))
					.setExpiration(new Date(expiration))
					.addClaims(claims)
					.signWith(signingKey)
					.compact();
			log.debug("Create token: {} (~ {})", token, new Date(expiration));
		} else {
			throw new JwtException("Not found signingKey for " + signatureAlgorithm.name());
		}
		return token;
	}
	
	
	public Jws<Claims> parseClaims(String token) {
		Jws<Claims> claims = null;
		
		token = parseToken(token);
		log.debug("JWT# Parse token -> {}", token);
		
		String error = null;
		try {
			Key publicKey = KeyUtil.parsingKey(SignatureAlgorithm.forName(getAlgorithm(token)));
			JwtParser parser = Jwts.parser().setSigningKey(publicKey).build();
			claims = parser.parseClaimsJws(token);
		} catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
			error = "잘못된 JWT 서명입니다.";
		} catch (ExpiredJwtException e) {
			error = "만료된 JWT 토큰입니다.";
		} catch (UnsupportedJwtException e) {
			error = "지원하지 않는 JWT 토큰입니다.";
		} catch (IllegalArgumentException | NullPointerException e) {
			error = "JWT 토큰이 잘못되었습니다.";
		} catch (Exception e) {
			error = "잘못된 요청입니다.";
		}
		
		if (error != null) {
			throw new UnauthorizedException(error);
		}
		
		return claims;
	}

	public boolean validateToken(String token) {
		try {
			log.info("Validate token: {}", token);
			Key publicKey = KeyUtil.parsingKey(SignatureAlgorithm.forName(getAlgorithm(token)));
			Jwts.parser().setSigningKey(publicKey).build();
			return true;
		} catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
			log.info("잘못된 JWT 서명입니다.");
		} catch (ExpiredJwtException e) {
			log.info("만료된 JWT 토큰입니다.");
		} catch (UnsupportedJwtException e) {
			log.info("지원하지 않는 JWT 토큰입니다.");
		} catch (IllegalArgumentException | NullPointerException e) {
			log.info("JWT 토큰이 잘못되었습니다.");
		} catch (Exception e) {
			log.info("잘못된 요청입니다.");
		}
		return false;
	}


	public String parseToken(String token) {
		if (StringUtils.hasString(token)) {
			if (token.startsWith(ShieldProperty.RK_AUTHORIZATION_BEARER)) {
				token = token.substring(ShieldProperty.RK_AUTHORIZATION_BEARER.length());
			}
			return token;
		}
		return null;
	}

	public Authentication getAuthentication(String token) {
		Jws<Claims> claims = parseClaims(token);
		String subject = claims.getBody().getSubject();
		String userRoles = (String)claims.getBody().get(ShieldProperty.JWT_PAYLOAD_claim_roles);
		Collection<? extends GrantedAuthority> authorities = Arrays.stream(userRoles.split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		return new UsernamePasswordAuthenticationToken(subject, token, authorities);
	}
	
	private String getAlgorithm(String token) {
		String algorithm = null;
		String header = new String(Base64.getUrlDecoder().decode(token.substring(0, token.indexOf('.'))), StandardCharsets.UTF_8);
		Map<String, String> headerMap = ShieldProperty.GSON.fromJson(header, MAP_TYPE);
		algorithm = headerMap.get(ShieldProperty.JWT_HEADER_algorithm);
		return algorithm;
	}
	
}