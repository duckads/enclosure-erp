package kr.co.shield.domain;

import jakarta.persistence.*;
import kr.co.shield.dto.ProductDto;
import kr.co.shield.ext.Option;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "product")
@ToString
public class Product extends Option {
	
	@Column(name= "seq", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int seq;
	@Column(name= "product_nm", length = 256, nullable = false)
	@ColumnDefault("''")
	private String productNm;
	@Column(name= "product_tp", length = 6, nullable = false)
	@ColumnDefault("''")
	private String productTp;
	@Column(name= "product_option", columnDefinition = "TEXT")
	private String productOption;
	@Column(name= "list_order", nullable = false)
	@ColumnDefault("'0'")
	private int listOrder;
	@Column(name= "act_st", length = 6, nullable = false)
	@ColumnDefault("''")
	private String actSt;
	@Column(name= "reg_dt", nullable = false)
	@ColumnDefault("'2021-01-01 00:00:00'")
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDt;
	
	@Override
	protected String getOption() {
		return productOption;
	}
	@Override
	protected void setOption(String option) {
		this.productOption = option;
	}
	
	public ProductDto getDto() {
		return ProductDto.builder()
				.seq(this.seq)
				.productNm(this.productNm)
				.productTp(this.productTp)
				.productOption(this.productOption)
				.listOrder(this.listOrder)
				.actSt(this.actSt)
				.regDt(this.regDt)
				.build();
	}
	
}
