package kr.co.shield.domain;

import jakarta.persistence.*;
import kr.co.shield.dto.QnaDto;
import kr.co.shield.ext.Option;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "qna")
@ToString
public class Qna extends Option {
	
	@Column(name= "seq", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int seq;
	@Column(name= "qna_tp", length = 6, nullable = false)
	@ColumnDefault("''")
	private String qnaTp;
	@Column(name= "qna_option", columnDefinition = "TEXT")
	private String qnaOption;
	@Column(name= "subject", length = 256, nullable = false)
	@ColumnDefault("''")
	private String subject;
	@Column(name= "question", columnDefinition = "TEXT")
	private String question;
	@Column(name= "answering", columnDefinition = "TEXT")
	private String answering;
	@Column(name= "qna_st", length = 6, nullable = false)
	@ColumnDefault("''")
	private String qnaSt;
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
	@Column(name= "parent_seq", nullable = false)
	@ColumnDefault("'0'")
	private int parentSeq;
	
	@Override
	protected String getOption() {
		return qnaOption;
	}
	@Override
	protected void setOption(String option) {
		this.qnaOption = option;
	}
	
	public QnaDto getDto() {
		return QnaDto.builder()
				.seq(this.seq)
				.qnaTp(this.qnaTp)
				.qnaOption(this.qnaOption)
				.subject(this.subject)
				.question(this.question)
				.answering(this.answering)
				.qnaSt(this.qnaSt)
				.regDt(this.regDt)
				.updDt(this.updDt)
				.companySeq(this.companySeq)
				.memberSeq(this.memberSeq)
				.parentSeq(this.parentSeq)
				.build();
	}
	
}
