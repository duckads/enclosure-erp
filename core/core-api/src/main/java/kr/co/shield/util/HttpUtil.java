package kr.co.shield.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import kr.co.shield.common.ShieldProperty;
import kr.co.shield.utility.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpCookie;
import org.springframework.http.server.reactive.ServerHttpRequest;

import java.util.Iterator;

@Slf4j
public class HttpUtil {
	
	public static String getToken(HttpServletRequest request) {
		if (log.isDebugEnabled()) {
			for (Iterator<String> iter = request.getHeaderNames().asIterator(); iter.hasNext();) {
				String name = iter.next();
				log.info("HEADER:: {} -> {}", name, request.getHeader(name));
			}
		}
		
		String token = request.getHeader(ShieldProperty.RK_AUTHORIZATION_KEY_HEADER); // header
		if (token == null || token.isBlank()) {
			log.info("No header::" + ShieldProperty.RK_AUTHORIZATION_KEY_HEADER);
		} else {
			log.info("Get header:: {}", token);
		}
		
		if (!StringUtils.hasString(token) && request.getCookies() != null) {
			for (Cookie cookie : request.getCookies()) {
				if (cookie.getName().equals(ShieldProperty.RK_AUTHORIZATION_KEY_COOKIE)) {
					token = cookie.getValue();
					log.info("Get cookie::" + token);
					break;
				}
			}
		}
		
		if (!StringUtils.hasString(token)) {
			token = request.getParameter(ShieldProperty.RK_AUTHORIZATION_KEY_PARAMETER);
			log.info("Get param::" + token);
		}
		
		return StringUtils.getString(token);
	}
	
	public static String getToken(ServerHttpRequest request) {
		String token = null;
		
		if (request.getHeaders().containsKey(ShieldProperty.RK_AUTHORIZATION_KEY_HEADER)) {
			token = request.getHeaders().get(ShieldProperty.RK_AUTHORIZATION_KEY_HEADER).get(0);
			log.info("Get header:: {}", token);
		} else if (request.getCookies().containsKey(ShieldProperty.RK_AUTHORIZATION_KEY_COOKIE)) {
			HttpCookie cookie = request.getCookies().getFirst(ShieldProperty.RK_AUTHORIZATION_KEY_COOKIE);
			token = cookie.getValue();
			log.info("Get cookie::" + token);
		}
		
		if (!StringUtils.hasString(token) && request instanceof HttpServletRequest) {
			token = ((HttpServletRequest)request).getParameter(ShieldProperty.RK_AUTHORIZATION_KEY_PARAMETER);
			log.info("Get param::" + token);
		}
		
		return StringUtils.getString(token);
	}
	
}
