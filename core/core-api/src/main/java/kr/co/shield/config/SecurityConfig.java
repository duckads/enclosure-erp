package kr.co.shield.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    //해당 설정에서 빈을 등록 해줘야 사용 가능
    // client -> authetnication -> authenticationManger -> authenticationProvider -> provider -> user -> dao
    private final AccessDeniedHandler jwtAccessDeniedHandler;
    private final AuthenticationEntryPoint jwtAuthenticationEntryPoint;
//	private final OncePerRequestFilter jwtOncePerRequestFilter;

    private final UserDetailsService customUserDetailsService;

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(this.customUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity

                .csrf(csrfConfigurer -> {
                    csrfConfigurer.disable();
//			csrfConfigurer.csrfTokenRepository(httpSessionCsrfTokenRepository());
                })
                // URL 접근 제한 설정.
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
                    authorizationManagerRequestMatcherRegistry.requestMatchers("/**").permitAll();
                    authorizationManagerRequestMatcherRegistry.anyRequest().authenticated();
                })
                // exception 처리.
                .exceptionHandling(exceptionHandlingConfigurer -> {
                    exceptionHandlingConfigurer.authenticationEntryPoint(this.jwtAuthenticationEntryPoint);
                    exceptionHandlingConfigurer.accessDeniedHandler(this.jwtAccessDeniedHandler);
                })
                .headers(headersConfigurer -> {
                    headersConfigurer.frameOptions(frameOptionsConfig -> {
                        frameOptionsConfig.sameOrigin();
                    });
                })
                // session 사용하지 않음.
                .sessionManagement(sessionManagementConfigurer -> {
                    sessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                });

        // sign in 처리.
//		httpSecurity.addFilterBefore(this.jwtOncePerRequestFilter, UsernamePasswordAuthenticationFilter.class);
//		httpSecurity.authenticationProvider(daoAuthenticationProvider());

        return httpSecurity.build();
    }
}
