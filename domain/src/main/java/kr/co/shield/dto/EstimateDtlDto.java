package kr.co.shield.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import kr.co.shield.ext.Option;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Builder
@Getter
@Setter
@ToString
public class EstimateDtlDto extends Option {

	private int seq;
	private String productSize;
	private String productQuantity;
	private String productUnit;
	private int productPrice;
	private Long productSupplyPrice;
	private String productTp;
	private String productOption;
	private String productNote;
	private String materialCost;
	private String laborCost;
	private String overheadCost;
	private String actSt;
	private Date regDt;
	private Date updDt;

	@Override
	protected String getOption() {
		return productOption;
	}
	@Override
	protected void setOption(String option) {
		this.productOption = option;
	}
}
