package kr.co.shield.domain;

import jakarta.persistence.*;
import kr.co.shield.dto.RoleDto;
import kr.co.shield.ext.Option;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "role")
@ToString
public class Role extends Option {
	
	@Column(name= "seq", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int seq;
	@Column(name= "role_nm", length = 256, nullable = false)
	@ColumnDefault("''")
	private String roleNm;
	@Column(name= "role_option", columnDefinition = "TEXT")
	private String roleOption;
	@Column(name= "reg_dt", nullable = false)
	@ColumnDefault("'2021-01-01 00:00:00'")
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDt;
	
	@Override
	protected String getOption() {
		return roleOption;
	}
	@Override
	protected void setOption(String option) {
		this.roleOption = option;
	}
	
	public RoleDto getDto() {
		return RoleDto.builder()
				.seq(this.seq)
				.roleNm(this.roleNm)
				.roleOption(this.roleOption)
				.regDt(this.regDt)
				.build();
	}
	
}
