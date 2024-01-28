package kr.co.shield.common;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.shield.dto.MemberDto;
import kr.co.shield.common.exception.BadRequestException;
import kr.co.shield.service.inf.MemberService;
import kr.co.shield.utility.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@RequiredArgsConstructor
@Slf4j
public class TokenHandlerInterceptor implements HandlerInterceptor {
	
	private final MemberService memberService;
	
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
			// admin, team, role
			String userId = StringUtils.getString(request.getHeader(ShieldProperty.RK_AUTHORIZATION_HEADER_USER));
			String userRole = StringUtils.getString(request.getHeader(ShieldProperty.RK_AUTHORIZATION_HEADER_ROLE)); // ROLE_
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
