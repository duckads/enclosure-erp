package kr.co.shield.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.shield.common.ShieldProperty;
import kr.co.shield.common.exception.BadRequestException;
import kr.co.shield.config.jwt.JwtTokenProvider;
import kr.co.shield.domain.User;
import kr.co.shield.dto.JoinDto;
import kr.co.shield.dto.ResponseDto;
import kr.co.shield.dto.SigninDto;
import kr.co.shield.dto.TokenDto;
import kr.co.shield.service.inf.JoinService;
import kr.co.shield.util.CookieUtil;
import kr.co.shield.utility.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    private final JoinService joinService;

    @Value("${jwt.access-token-validity-in-seconds:3600}")
    private Long accessTokenValidity;
    @Value("${jwt.refresh-token-validity-in-seconds:86400}")
    private Long refreshTokenValidity;

    @PostMapping(value = "/signin", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TokenDto> signinParam(HttpServletRequest request, HttpServletResponse response, @RequestBody SigninDto signinDto) {
        Map<String, Object> props = new HashMap<>();

        try {
            // sign-in 처리
            String userId = signinDto.getUsername();
            String userPw = signinDto.getPassword();

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userId, userPw);

            // CustomUserDetailsService.loadUserByUsername
            Authentication authentication = this.authenticationManager.authenticate(authenticationToken);

            User user = (User)authentication.getPrincipal();

            String userRoles = String.join(",", user.getRoles());

            props.put("userId", userId);
            props.put("userRoles", userRoles);
            props.put("setCookie", "Y");
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("아이디 또는 비밀번호를 잘못 입력했습니다.\r\n입력하신 내용을 다시 확인해주세요.");
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }

        // Generate token
        return generateResponse(props);
    }

    // 1. 쿠키(refresh_token) 꺼내기
    // 2. 인증 정보(user_id, user_role) 획득
    // 3. access_token, refresh_token(유효기간/2 경과시) 생성
    // 3. Response(access_token), 쿠키(refresh_token) 응답
    @PostMapping(value = "/access", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TokenDto> accessToken(HttpServletRequest request) {
        Map<String, Object> props = new HashMap<>();

        try {
            Cookie _refreshTokenCookie = CookieUtil.getCookie(request, ShieldProperty.RK_AUTHORIZATION_COOKEN_refreshToken).orElse(null);
            String _refreshToken = _refreshTokenCookie.getValue(); // cookie 없음. NullPointerException

            Jws<Claims> _refreshTokenClaims = this.jwtTokenProvider.parseClaims(_refreshToken);

            String userId = _refreshTokenClaims.getBody().getSubject();
            String userRoles = (String)_refreshTokenClaims.getBody().get(ShieldProperty.JWT_PAYLOAD_claim_roles);
            Date expireDt = _refreshTokenClaims.getBody().getExpiration();

            props.put("userId", userId);
            props.put("userRoles", userRoles);

            if (System.currentTimeMillis() - expireDt.getTime() < ShieldProperty.MILLISECOND_FOR_DAY / 2) {
                // 12시간 이내 만료이면 재발행
                props.put("setCookie", "Y");
            }

        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }

        return generateResponse(props);
    }

    @PostMapping(value = "/join", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> signup(@RequestBody JoinDto joinDto) {
        String rtnMsg = "회원 가입이 완료되었습니다.";

        // sign-up 처리
        this.joinService.join(joinDto);

        ResponseDto responseDto = ResponseDto.builder()
                .status(HttpStatus.OK)
                .message(rtnMsg)
                .build();

        return ResponseEntity.ok(responseDto);
    }

    private ResponseEntity<TokenDto> generateResponse(Map<String, Object> props) {
        ResponseEntity<TokenDto> responseEntity = null;

        long curTm = System.currentTimeMillis();

        String userId = StringUtils.getString(props.get("userId"));
        String userRoles = StringUtils.getString(props.get("userRoles"));
        String setCookie = StringUtils.getString(props.get("setCookie"));

        Map<String, Object> claims = new HashMap<>();
        claims.put(ShieldProperty.JWT_PAYLOAD_claim_roles, userRoles);

        ResponseCookie refreshTokenCookie = null;
        // refresh_token, 24H
        if (setCookie.equals("Y")) {
            String refreshToken = this.jwtTokenProvider.generateToken(userId, claims, curTm + this.refreshTokenValidity * ShieldProperty.MILLISECOND_FOR_SECOND);

            refreshTokenCookie = ResponseCookie.from(ShieldProperty.RK_AUTHORIZATION_COOKEN_refreshToken, refreshToken)
                    .path("/")
                    .httpOnly(true)
                    .sameSite(ShieldProperty.RK_CK_SameSite_Strict)
                    .secure(true)
                    .maxAge(this.refreshTokenValidity - ShieldProperty.SECOND_FOR_MINUTE) // 24H -1M, 쿠키 만료일을 token 만료일 보다 짧게 설정 (1분)
                    .build();
        }

        // access_token, 1H
        String accessToken =  this.jwtTokenProvider.generateToken(userId, claims, curTm + this.accessTokenValidity * ShieldProperty.MILLISECOND_FOR_SECOND);

        TokenDto accessTokenDto = TokenDto.builder()
                .tokenType(ShieldProperty.RK_AUTHORIZATION_BEARER.trim())
                .token(accessToken)
                .build();

        // ResponseBody
        if (setCookie.equals("Y")) {
            responseEntity = ResponseEntity.ok()
                    .header(HttpHeaders.SET_COOKIE, refreshTokenCookie.toString())
                    .body(accessTokenDto);
        } else {
            responseEntity = ResponseEntity.ok()
                    .body(accessTokenDto);
        }

        return responseEntity;
    }
}
