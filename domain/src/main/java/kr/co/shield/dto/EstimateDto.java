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
public class EstimateDto extends Option {
	
	private int seq;
	private String estimateCode;
	private String estimateNm;
	private String estimateOption;
	private String estimateDtl;
	private String estimateNote;
	private int producerSeq;
	private int memberSeq;
	private String actSt;
	private Date regDt;
	private Date updDt;
	
	@Override
	protected String getOption() {
		return estimateOption;
	}
	@Override
	protected void setOption(String option) {
		this.estimateOption = option;
	}
}
