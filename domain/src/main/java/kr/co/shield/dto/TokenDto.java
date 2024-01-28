package kr.co.shield.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TokenDto {
	
	private String tokenType;
	private String token;
	
}
