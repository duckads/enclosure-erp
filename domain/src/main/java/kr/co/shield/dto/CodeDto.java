package kr.co.shield.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class CodeDto {
	
	private String cdNo;
	private String cdAlias;
	private String cdNm;
	private String cdDesc;
	
}
