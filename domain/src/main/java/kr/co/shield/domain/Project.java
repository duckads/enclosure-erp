package kr.co.shield.domain;

import jakarta.persistence.*;
import kr.co.shield.dto.ProjectDto;
import kr.co.shield.ext.Option;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "project")
@ToString
public class Project extends Option {
	
	@Column(name= "seq", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long seq;
	@Column(name= "project_code", length = 256, nullable = false)
	@ColumnDefault("''")
	private String projectCode;
	@Column(name= "project_nm", length = 256, nullable = false)
	@ColumnDefault("''")
	private String projectNm;
	@Column(name= "construction_nm", length = 64, nullable = false)
	@ColumnDefault("''")
	private String constructionNm;
	@Column(name= "site_location", length = 64, nullable = false)
	@ColumnDefault("''")
	private String siteLocation;
	@Column(name= "project_option", columnDefinition = "TEXT")
	private String projectOption;
	@Column(name= "site_manager", columnDefinition = "TEXT")
	private String siteManager;
	@Column(name= "shield_site_manager", columnDefinition = "TEXT")
	private String shieldSiteManager;
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
		return projectOption;
	}
	@Override
	protected void setOption(String option) {
		this.projectOption = option;
	}
	
	public ProjectDto getDto() {
		return ProjectDto.builder()
				.seq(this.seq)
				.projectCode(this.projectCode)
				.projectNm(this.projectNm)
				.constructionNm(this.constructionNm)
				.siteLocation(this.siteLocation)
				.projectOption(this.projectOption)
				.siteManager(this.siteManager)
				.shieldSiteManager(this.shieldSiteManager)
				.actSt(this.actSt)
				.regDt(this.regDt)
				.updDt(this.updDt)
				.build();
	}
}
