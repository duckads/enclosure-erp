package kr.co.shield.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import kr.co.shield.dto.EstimateDtlDto;
import kr.co.shield.dto.EstimateDto;
import kr.co.shield.ext.Option;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "estimate_dtl")
@ToString
public class EstimateDtl extends Option {
	
	@Column(name= "seq", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int seq;
	@Column(name= "prodcut_size") // 규격
	private String productSize;
	@Column(name= "product_quantity") //수량
	private String productQuantity;
	@Column(name= "prodcut_unit") //단위
	private String productUnit;
	@Column(name= "prodcut_price") //단가
	private int productPrice;
	@Column(name= "prodcut_supply_price") //공급가액
	private Long productSupplyPrice;
	@Column(name= "prodcut_tp")
	private String productTp;
	@Column(name= "prodcut_option") //비고
	private String productOption;
	@Column(name= "prodcut_note") //비고
	private String productNote;

	@Column(name= "material_cost", columnDefinition = "TEXT") // 재료비
	private String materialCost;
	@Column(name= "labor_cost", columnDefinition = "TEXT") // 노무비
	private String laborCost;
	@Column(name= "overhead_cost", columnDefinition = "TEXT") // 노무비
	private String overheadCost;


	@Column(name= "act_st", length = 6, nullable = false)
	@ColumnDefault("''")
	private String actSt;
	@Column(name= "reg_dt", nullable = false)
	@ColumnDefault("'2021-01-01 00:00:00'")
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDt;
	@Column(name= "upd_dt", nullable = false)
	@ColumnDefault("'2021-01-01 00:00:00'")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updDt;
	
	@Override
	protected String getOption() {
		return productOption;
	}
	@Override
	protected void setOption(String option) {
		this.productOption = option;
	}
	
	public EstimateDtlDto getDto() {

		return EstimateDtlDto.builder()
				.seq(this.seq)
				.productSize(this.productSize)
				.productQuantity(this.productQuantity)
				.productUnit(this.productUnit)
				.productPrice(this.productPrice)
				.productSupplyPrice(this.productSupplyPrice)
				.productTp(this.productTp)
				.productOption(this.productOption)
				.productNote(this.productNote)
				.materialCost(this.materialCost)
				.laborCost(this.laborCost)
				.overheadCost(this.overheadCost)
				.actSt(this.actSt)
				.regDt(this.regDt)
				.updDt(this.updDt)
				.build();
	}

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="estimate_seq")
	private Estimate estimate;
}
