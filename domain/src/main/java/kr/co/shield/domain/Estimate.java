package kr.co.shield.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import kr.co.shield.dto.*;
import kr.co.shield.ext.*;
import lombok.AccessLevel;
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
@Table(name = "estimate")
@ToString(exclude = "estimateDtl")
public class Estimate extends Option {
	
	@Column(name= "seq", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long seq;
	@Column(name= "estimate_code", length = 256, nullable = false)
	@ColumnDefault("''")
	private String estimateCode;
	@Column(name= "estimate_nm", length = 256)
	@ColumnDefault("''")
	private String estimateNm;
	@Column(name= "estimate_option", columnDefinition = "TEXT")
	private String estimateOption;
	@Column(name= "estimate_note", columnDefinition = "TEXT")
	private String estimateNote;

	@Column(name="customer_com", columnDefinition = "TEXT")
	@Convert(converter = BusinessDealDtoConverter.class)
	private BusinessDealDto customerCom;

	@Column(name="customer_mgr", columnDefinition = "TEXT")
	@Convert(converter = BusinessDealMgrDtoConverter.class)
	private BusinessDealMgrDto customerMgr;

	@Column(name= "producer_seq") //공급자
	private int producerSeq;

	@Column(name="estimate_mgr", columnDefinition = "TEXT") //견적 담당자
	@Convert(converter = EstimateMgrDtoConverter.class)
	private EstimateMgrDto estimateMgr;

	@Column(name= "member_seq")
	private int memberSeq;
	@Column(name= "estimate_tp", length = 256, nullable = false)
	@ColumnDefault("''")
	private String estimateTp;
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
	@Column(name= "project_seq", nullable = false)
	@ColumnDefault("'0'")
	private int projectSeq;
	@Column(name= "company_seq", nullable = false)
	private int companySeq;

	@Override
	protected String getOption() {
		return estimateOption;
	}
	@Override
	protected void setOption(String option) {
		this.estimateOption = option;
	}
	
	public EstimateDto getDto() {

		List<EstimateDtlDto> estimateDtlDtos = this.estimateDtl.stream()
				.map(EstimateDtl::getDto)
				.collect(Collectors.toList());

		return EstimateDto.builder()
				.seq(this.seq)
				.estimateCode(this.estimateCode)
				.estimateNm(this.estimateNm)
				.estimateOption(this.estimateOption)
				.estimateDtl(estimateDtlDtos)
				.estimateNote(this.estimateNote)
				.customerCom(this.customerCom)
				.customerMgr(this.customerMgr)
				.estimateMgr(this.estimateMgr)
				.producerSeq(this.producerSeq)
				.memberSeq(this.memberSeq)
				.estimateTp(this.estimateTp)
				.actSt(this.actSt)
				.regDt(this.regDt)
				.updDt(this.updDt)
				.projectSeq(this.projectSeq)
				.companySeq(this.companySeq)
				.build();
	}

	@OneToMany(mappedBy = "estimate", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<EstimateDtl> estimateDtl = new ArrayList<>();
}
