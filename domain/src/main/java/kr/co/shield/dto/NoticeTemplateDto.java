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
public class NoticeTemplateDto extends Option {
	
	private int seq;
	private String templateNm;
	private String templateTag;
	private String templateOption;
	private String subject;
	private String content;
	private String channelTp;
	private String actSt;
	private Date regDt;
	private Date updDt;
	
	@Override
	protected String getOption() {
		return templateOption;
	}
	@Override
	protected void setOption(String option) {
		this.templateOption = option;
	}
	
}
