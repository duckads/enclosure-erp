package kr.co.shield.domain;

import jakarta.persistence.*;
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
@Table(name = "estimate")
@ToString
public class Estimate extends Option {
	
	@Column(name= "seq", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int seq;
	@Column(name= "estimate_nm", length = 256, nullable = false)
	@ColumnDefault("''")
	private String estimateNm;
	@Column(name= "estimate_option", columnDefinition = "TEXT")
	private String estimateOption;
	@Column(name= "estimate_dtl", length = 64, nullable = false)
	@ColumnDefault("''")
	private String estimateDtl;
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
		return estimateOption;
	}
	@Override
	protected void setOption(String option) {
		this.estimateOption = option;
	}
	
	public EstimateDto getDto() {

		return EstimateDto.builder()
				.seq(this.seq)
				.estimateNm(this.estimateNm)
				.estimateOption(this.estimateOption)
				.estimateDtl(this.estimateDtl)
				.actSt(this.actSt)
				.regDt(this.regDt)
				.updDt(this.updDt)
				.build();
	}
}
