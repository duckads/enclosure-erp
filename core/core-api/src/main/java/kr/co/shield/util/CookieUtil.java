package kr.co.shield.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.shield.common.ShieldProperty;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseCookie.ResponseCookieBuilder;

import java.util.Map;
import java.util.Optional;

public class CookieUtil {
	
	public static Optional<Cookie> getCookie(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					return Optional.of(cookie);
				}
			}
		}
		return Optional.empty();
	}
	
	public static void addCookie(HttpServletResponse response, Map<String, Object> cookie) {
		ResponseCookieBuilder cookieBuilder = ResponseCookie.from((String)cookie.get("name"), (String)cookie.get("value"))
				.domain(ShieldProperty.RK_CK_Domain)
				.path("/")
				.maxAge((Integer)cookie.get("maxAge"));
		
		if (cookie.containsKey(ShieldProperty.RK_CK_HttpOnly)) {
			cookieBuilder.httpOnly((Boolean)cookie.get(ShieldProperty.RK_CK_HttpOnly));
		}
		if (cookie.containsKey(ShieldProperty.RK_CK_SameSite)) {
			cookieBuilder.sameSite((String)cookie.get(ShieldProperty.RK_CK_SameSite));
		}
		if (cookie.containsKey(ShieldProperty.RK_CK_Secure)) {
			cookieBuilder.secure((Boolean)cookie.get(ShieldProperty.RK_CK_Secure));
		}
		
		response.addHeader("Set-Cookie", cookieBuilder.build().toString());
	}
	
}
