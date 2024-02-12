package kr.co.shield.domain;

import jakarta.persistence.*;
import kr.co.shield.dto.NoticeDto;
import kr.co.shield.ext.Option;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "notice")
@ToString
public class Notice extends Option {
	
	@Column(name= "seq", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int seq;
	@Column(name= "notice_tp", length = 6, nullable = false)
	@ColumnDefault("''")
	private String noticeTp;
	@Column(name= "notice_option", columnDefinition = "TEXT")
	private String noticeOption;
	@Column(name= "subject", length = 256, nullable = false)
	@ColumnDefault("''")
	private String subject;
	@Column(name= "content", columnDefinition = "TEXT")
	private String content;
	@Column(name= "notice_st", length = 6, nullable = false)
	@ColumnDefault("''")
	private String noticeSt;
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
		return noticeOption;
	}
	@Override
	protected void setOption(String option) {
		this.noticeOption = option;
	}
	
	public NoticeDto getDto() {
		return NoticeDto.builder()
				.seq(this.seq)
				.noticeTp(this.noticeTp)
				.noticeOption(this.noticeOption)
				.subject(this.subject)
				.content(this.content)
				.noticeSt(this.noticeSt)
				.regDt(this.regDt)
				.updDt(this.updDt)
				.build();
	}
	
}
