package kr.co.shield.domain;

import jakarta.persistence.*;
import kr.co.shield.dto.OrdersDto;
import kr.co.shield.ext.Option;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "orders")
@ToString
public class Orders extends Option {
	
	@Column(name= "order_no", length = 64, nullable = false)
	@ColumnDefault("''")
	@Id
	private String orderNo;
	@Column(name= "order_option", columnDefinition = "TEXT")
	private String orderOption;
	@Column(name= "order_st", length = 6, nullable = false)
	@ColumnDefault("''")
	private String orderSt;
	@Column(name= "pay_tp", length = 6, nullable = false)
	@ColumnDefault("''")
	private String payTp;
	@Column(name= "price", nullable = false)
	@ColumnDefault("'0'")
	private double price;
	@Column(name= "issue", columnDefinition = "TEXT")
	private String issue;
	@Column(name= "reg_dt", nullable = false)
	@ColumnDefault("'2021-01-01 00:00:00'")
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDt;
	@Column(name= "upd_dt", nullable = false)
	@ColumnDefault("'2021-01-01 00:00:00'")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updDt;
	@Column(name= "agency_seq", nullable = false)
	@ColumnDefault("'0'")
	private int companySeq;
	@Column(name= "admin_seq", nullable = false)
	@ColumnDefault("'0'")
	private int memberSeq;
	
	@Override
	protected String getOption() {
		return orderOption;
	}
	@Override
	protected void setOption(String option) {
		this.orderOption = option;
	}
	
	public OrdersDto getDto() {
		return OrdersDto.builder()
				.orderNo(this.orderNo)
				.orderOption(this.orderOption)
				.orderSt(this.orderSt)
				.payTp(this.payTp)
				.price(this.price)
				.issue(this.issue)
				.regDt(this.regDt)
				.updDt(this.updDt)
				.companySeq(this.companySeq)
				.memberSeq(this.memberSeq)
				.build();
	}
	
}
