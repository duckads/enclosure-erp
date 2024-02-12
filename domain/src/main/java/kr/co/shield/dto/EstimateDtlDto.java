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
public class EstimateDtlDto extends Option {

	private Long seq;
	private String productSize;
	private String productQuantity;
	private String productUnit;
	private int productPrice;
	private Long productSupplyPrice;
	private String productOption;
	private String productNote;
	private List<ProductFormDto> materialCosts;//재료비
	private List<ProductFormDto> laborCosts;//노무비
	private List<ProductFormDto> overheadCosts;//경비비
	private String actSt;
	private Date regDt;
	private Date updDt;
	private int companySeq;

	@Override
	protected String getOption() {
		return productOption;
	}
	@Override
	protected void setOption(String option) {
		this.productOption = option;
	}
}
