package kr.co.shield.dto;

import kr.co.shield.ext.Option;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@ToString
public class AdminDto extends Option {
	
	private int seq;
	private String adminNm;
	private String adminId;
	private String adminPw;
	private String adminOption;
	private String actSt;
	private Date regDt;
	private Date updDt;
	private int agencySeq;
	
	@Override
	protected String getOption() {
		return adminOption;
	}
	@Override
	protected void setOption(String option) {
		this.adminOption = option;
	}
}
