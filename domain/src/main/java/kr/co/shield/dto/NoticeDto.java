package kr.co.shield.dto;

import kr.co.shield.ext.Option;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Builder
@Getter
@Setter
@ToString
public class NoticeDto extends Option {
	
	private int seq;
	private String noticeTp;
	private String noticeOption;
	private String subject;
	private String content;
	private String noticeSt;
	private Date regDt;
	private Date updDt;
	
	@Override
	protected String getOption() {
		return noticeOption;
	}
	@Override
	protected void setOption(String option) {
		this.noticeOption = option;
	}
	
}
