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
public class ProductDto extends Option {
	
	private int seq;
	private String productNm;
	private String productTp;
	private String productOption;
	private int listOrder;
	private String actSt;
	private Date regDt;
	
	@Override
	protected String getOption() {
		return productOption;
	}
	@Override
	protected void setOption(String option) {
		this.productOption = option;
	}
	
}
