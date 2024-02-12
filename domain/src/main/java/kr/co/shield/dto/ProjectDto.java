package kr.co.shield.dto;

import kr.co.shield.ext.Option;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Builder
@Getter
@Setter
@ToString
public class ProjectDto extends Option {
	
	private Long seq;
	private String projectCode;
	private String projectNm;
	private String constructionNm;
	private String siteLocation;
	private String projectOption;
	private String siteManager;
	private String shieldSiteManager;
	private String actSt;
	private Date regDt;
	private Date updDt;
	private int companySeq;
	
	@Override
	protected String getOption() {
		return projectOption;
	}
	@Override
	protected void setOption(String option) {
		this.projectOption = option;
	}
}
