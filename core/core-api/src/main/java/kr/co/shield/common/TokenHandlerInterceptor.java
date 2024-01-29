package kr.co.shield.common;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.shield.config.jwt.JwtTokenProvider;
import kr.co.shield.dto.MemberDto;
import kr.co.shield.common.exception.BadRequestException;
import kr.co.shield.service.inf.MemberService;
import kr.co.shield.util.HttpUtil;
import kr.co.shield.utility.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class TokenHandlerInterceptor implements HandlerInterceptor {
	
	private final MemberService memberService;
	private final JwtTokenProvider jwtTokenProvider;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		boolean rtn = false;
		
		if (log.isDebugEnabled()) {
			request.getHeaderNames().asIterator()
			.forEachRemaining(e -> log.info("H:{} -> {}", e, request.getHeader(e)));
		}
		
		if (HttpMethod.OPTIONS.matches(request.getMethod())) {
			rtn = true;
		} else {
			String token = this.jwtTokenProvider.parseToken(HttpUtil.getToken(request));
			log.info("Auth Pre Filter: token -> {}", token);

			if (token == null || token.isBlank()) {
				throw new BadRequestException("토큰값이 없습니다.");
			}

			if (!this.jwtTokenProvider.validateToken(token)) {
				throw new BadRequestException("토큰이 유효하지 않습니다.");
			}

			Authentication authentication = this.jwtTokenProvider.getAuthentication(token);
			log.info("Get authentication: {}", authentication);

			String subject = (String)authentication.getPrincipal();
			List<String> userRoles = authentication.getAuthorities().stream()
					.map(e -> e.getAuthority())
					.collect(Collectors.toList());

			// admin, team, role
			String userId = StringUtils.getString(subject);
			String userRole = StringUtils.getString(String.join(",", userRoles)); // ROLE_
			log.info("ACCESS {}[{}] @{}", userId, userRole, request.getRemoteAddr());
			
			MemberDto user = this.memberService.findMember(userId, userRole);
			
			if (user != null) {
				request.setAttribute(ShieldProperty.TKN_USER, user);
				rtn = true;
			} else {
				throw new BadRequestException("로그인 정보가 없습니다.");
			}
		}
		
		return rtn;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) throws Exception {
		
	}
}
