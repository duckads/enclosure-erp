package kr.co.shield.ext;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
public class ErrorDto {
	
	private HttpStatus status;
	private String message;
	
}
