package kr.co.shield.dto;

import kr.co.shield.ext.Option;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@Setter
@ToString
public class MemberDto extends Option {
	
	private int seq;
	private String memberNm;
	private String memberId;
	private String memberPw;
	private String memberOption;
	private String actSt;
	private Date regDt;
	private Date updDt;
	private int companySeq;
	
	@Override
	protected String getOption() {
		return memberOption;
	}
	@Override
	protected void setOption(String option) {
		this.memberOption = option;
	}

	private List<String> roles;
}
