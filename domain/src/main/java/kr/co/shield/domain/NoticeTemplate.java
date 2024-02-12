package kr.co.shield.domain;

import jakarta.persistence.*;
import kr.co.shield.dto.NoticeTemplateDto;
import kr.co.shield.ext.Option;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "notice_template")
@ToString
public class NoticeTemplate extends Option {
	
	@Column(name= "seq", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int seq;
	@Column(name= "template_nm", length = 256, nullable = false)
	@ColumnDefault("''")
	private String templateNm;
	@Column(name= "template_tag", length = 256, nullable = false)
	@ColumnDefault("''")
	private String templateTag;
	@Column(name= "template_option", columnDefinition = "TEXT")
	private String templateOption;
	@Column(name= "subject", length = 256, nullable = false)
	@ColumnDefault("''")
	private String subject;
	@Column(name= "content", columnDefinition = "TEXT")
	private String content;
	@Column(name= "channel_tp", length = 6, nullable = false)
	@ColumnDefault("''")
	private String channelTp;
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
		return templateOption;
	}
	@Override
	protected void setOption(String option) {
		this.templateOption = option;
	}
	
	public NoticeTemplateDto getDto() {
		return NoticeTemplateDto.builder()
				.seq(this.seq)
				.templateNm(this.templateNm)
				.templateTag(this.templateTag)
				.templateOption(this.templateOption)
				.subject(this.subject)
				.content(this.content)
				.channelTp(this.channelTp)
				.actSt(this.actSt)
				.regDt(this.regDt)
				.updDt(this.updDt)
				.build();
	}
	
}
