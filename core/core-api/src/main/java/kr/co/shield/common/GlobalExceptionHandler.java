package kr.co.shield.common;

import kr.co.shield.common.exception.BadRequestException;
import kr.co.shield.common.exception.RequestTimeoutException;
import kr.co.shield.common.exception.UnauthorizedException;
import kr.co.shield.common.exception.UserNotFoundException;
import kr.co.shield.ext.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 200 성공
 * 400 Bad Request
 *     field validation 실패시
 * 401 Unauthorized
 *     API 인증/인가 실패
 * 404 Not found
 *     해당 리소스가 없음
 * 500 Internal Server Error
 *     서버 에러
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorDto> badRequest(final BadRequestException e) {
		ErrorDto errorDto = ErrorDto.builder()
				.status(HttpStatus.BAD_REQUEST)
				.message(e.getMessage())
				.build();
		return ResponseEntity.badRequest().body(errorDto);
	}
	
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<ErrorDto> unauthozied(final UnauthorizedException e) {
		ErrorDto errorDto = ErrorDto.builder()
				.status(HttpStatus.UNAUTHORIZED)
				.message(e.getMessage())
				.build();
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorDto);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorDto> notFound(final UserNotFoundException e) {
		ErrorDto errorDto = ErrorDto.builder()
				.status(HttpStatus.NOT_FOUND)
				.message(e.getMessage())
				.build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
	}
	
	@ExceptionHandler(RequestTimeoutException.class)
	public ResponseEntity<ErrorDto> serverError(final RequestTimeoutException e) {
		ErrorDto errorDto = ErrorDto.builder()
				.status(HttpStatus.REQUEST_TIMEOUT)
				.message(e.getMessage())
				.build();
		return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body(errorDto);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDto> internalServerError(final Exception e) {
		ErrorDto errorDto = ErrorDto.builder()
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.message(e.getMessage())
				.build();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDto);
	}
	
}
