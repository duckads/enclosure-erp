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
public class OrdersDto extends Option {
	
	private String orderNo;
	private String orderOption;
	private String orderSt;
	private String payTp;
	private double price;
	private String issue;
	private Date regDt;
	private Date updDt;
	private int companySeq;
	private int memberSeq;
	
	@Override
	protected String getOption() {
		return orderOption;
	}
	@Override
	protected void setOption(String option) {
		this.orderOption = option;
	}
	
}
