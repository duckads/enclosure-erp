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
public class QnaDto extends Option {
	
	private int seq;
	private String qnaTp;
	private String qnaOption;
	private String subject;
	private String question;
	private String answering;
	private String qnaSt;
	private Date regDt;
	private Date updDt;
	private int companySeq;
	private int memberSeq;
	private int parentSeq;
	
	@Override
	protected String getOption() {
		return qnaOption;
	}
	@Override
	protected void setOption(String option) {
		this.qnaOption = option;
	}
	
}
