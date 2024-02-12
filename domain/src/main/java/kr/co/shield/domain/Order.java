package kr.co.shield.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import kr.co.shield.dto.*;
import kr.co.shield.ext.JpaConverterJson;
import kr.co.shield.ext.Option;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Table(name = "orders")
@ToString
public class Order extends Option {
	
	@Column(name= "seq", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long seq;
	@Column(name= "order_code", length = 256, nullable = false)
	@ColumnDefault("''")
	private String orderCode; //발주 번호
	@Column(name= "order_nm", length = 256)
	@ColumnDefault("''")
	private String orderNm;
	@Column(name= "order_option", columnDefinition = "TEXT")
	private String orderOption;
	@Column(name= "order_note", columnDefinition = "TEXT")
	private String orderNote;

	@Column(name="supply_com", columnDefinition = "TEXT")
	@Convert(converter = JpaConverterJson.class)
	private BusinessDealDTO supplyCom;

	@Column(name="supply_mgr", columnDefinition = "TEXT")
	@Convert(converter = JpaConverterJson.class)
	private BusinessDealMgrDto supplyMgr;

	@Column(name= "producer_seq")
	private int producerSeq; // 공급자 정보 (거의 안 지워지기 때문에)

	@Column(name="estimate_mgr", columnDefinition = "TEXT") //견적 담당자
	@Convert(converter = JpaConverterJson.class)
	private EstimateMgrDto estimateMgrDto;

	@Column(name= "member_seq")
	private int memberSeq;
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

	@Override
	protected String getOption() {
		return orderOption;
	}
	@Override
	protected void setOption(String option) {
		this.orderOption = option;
	}
	
	public OrderDto getDto() {

		List<OrderDtlDto> orderDtlDtos = this.orderDtl.stream()
				.map(OrderDtl::getDto) // EstimateDtl을 EstimateDtlDto로 변환
				.collect(Collectors.toList()); // 변환된 요소를 리스트로 수집

		return OrderDto.builder()
				.seq(this.seq)
				.orderCode(this.orderCode)
				.orderNm(this.orderNm)
				.orderOption(this.orderOption)
				.orderDtl(orderDtlDtos)
				.orderNote(this.orderNote)
				.producer(null)
				.memberSeq(this.memberSeq)
				.actSt(this.actSt)
				.regDt(this.regDt)
				.updDt(this.updDt)
				.companySeq(this.companySeq)
				.build();
	}

	@OneToMany(mappedBy = "order")
	@JsonManagedReference
	private List<OrderDtl> orderDtl = new ArrayList<>();
}
