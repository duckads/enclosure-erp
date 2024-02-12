package kr.co.shield.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import kr.co.shield.dto.EstimateDtlDto;
import kr.co.shield.dto.OrderDtlDto;
import kr.co.shield.ext.Option;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "order_dtl")
@ToString
public class OrderDtl {
	
	@Column(name= "seq", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long seq;

	@Column(name= "order_code", nullable = false)
	private String orderCode; //발주 번호
	@Column(name= "product_nm", nullable = false)
	private String productNm; //품명
	@Column(name= "product_size", nullable = false)
	private String productSize; //규격
	@Column(name= "product_quantity", nullable = false)
	private int productQuantity; //수량
	@Column(name= "product_unit", nullable = false)
	private String productUnit; //단위
	@Column(name= "product_price", nullable = false)
	private int productPrice; //단가
	@Column(name= "product_supply_price", nullable = false)
	private Long productSupplyPrice; //공급가액
	@Column(name= "product_note", nullable = false)
	private int productNote; //비고

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
	@Column(name= "company_seq", nullable = false)
	private int companySeq;

	public OrderDtlDto getDto() {
		return OrderDtlDto.builder()
				.seq(this.seq)
				.orderCode(this.orderCode)
				.productNm(this.productNm)
				.productSize(this.productSize)
				.productQuantity(this.productQuantity)
				.productUnit(this.productUnit)
				.productPrice(this.productPrice)
				.productSupplyPrice(this.productSupplyPrice)
				.productNote(this.productNote)
				.actSt(this.actSt)
				.regDt(this.regDt)
				.updDt(this.updDt)
				.companySeq(this.companySeq)
				.build();
	}

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="order_seq")
	private Order order;
}
