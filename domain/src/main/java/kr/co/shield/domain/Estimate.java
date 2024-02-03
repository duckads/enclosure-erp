package kr.co.shield.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import kr.co.shield.dto.EstimateDto;
import kr.co.shield.ext.Option;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	@Column(name= "producer_seq")
	private int producerSeq;
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
				.estimateCode(this.estimateCode)
				.estimateNm(this.estimateNm)
				.estimateOption(this.estimateOption)
				.estimateDtl(this.estimateDtl)
				.estimateNote(this.estimateNote)
				.producerSeq(this.producerSeq)
				.memberSeq(this.memberSeq)
				.actSt(this.actSt)
				.regDt(this.regDt)
				.updDt(this.updDt)
				.build();
	}

	@OneToMany(mappedBy = "estimate")
	@JsonManagedReference
	private List<EstimateDtl> estimateDtl = new ArrayList<>();
}
