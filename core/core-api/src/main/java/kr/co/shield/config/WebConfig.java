package kr.co.shield.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
	
	@Qualifier("tokenHandlerInterceptor")
	private final HandlerInterceptor tokenHandlerInterceptor;
	
	private final List<String> pathPattern = List.of("/**");
	private final List<String> excludePathPattern = new ArrayList<>(Arrays.asList("/swagger-ui/**"));
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
		.addMapping("/**")
		// 내 서버 데이터 응답시 json을 javascript에서 처리할 수 있도록
		.allowCredentials(true)
		// allowCredentials와 같이 사용 O
		.allowedOriginPatterns("*")
		// allowCredentials과 같이 사용 X
		// 모든 IP 응답을 허용
		.allowedOriginPatterns("http://localhost:[*]")
		// jwt를 담은 헤더를 리액트에서 확인할 수 있도록
//		.exposedHeaders("*")
		// 모든 헤더의 응답을 허용
		.allowedHeaders("*")
		// 모든 메소드의 응답을 허용
		.allowedMethods("GET,POST,PUT,DELETE".split(","));
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		this.excludePathPattern.addAll(List.of("/auth/access", "/auth/signin", "/auth/join"));
		
		registry
		.addInterceptor(this.tokenHandlerInterceptor)
		.addPathPatterns(this.pathPattern)
		.excludePathPatterns(this.excludePathPattern);
	}
	
}
