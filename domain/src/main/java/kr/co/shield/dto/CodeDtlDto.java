package kr.co.shield.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class CodeDtlDto {
	
	private String cdDtlNo;
	private String cdNo;
	private String cdDtlAlias;
	private String cdDtlNm;
	private String cdDtlDesc;
	
}
