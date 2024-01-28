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
public class RoleDto extends Option {
	
	private int seq;
	private String roleNm;
	private String roleOption;
	private Date regDt;
	
	@Override
	protected String getOption() {
		return roleOption;
	}
	@Override
	protected void setOption(String option) {
		this.roleOption = option;
	}
	
}
