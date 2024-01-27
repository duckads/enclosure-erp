package kr.co.shield.domain;

import jakarta.persistence.*;
import kr.co.shield.dto.AdminDto;
import kr.co.shield.ext.Option;
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
@Table(name = "tb_admin")
@ToString
public class Admin extends Option {
	
	@Column(name= "seq", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int seq;
	@Column(name= "admin_nm", length = 256, nullable = false)
	@ColumnDefault("''")
	private String adminNm;
	@Column(name= "admin_id", length = 64, nullable = false)
	@ColumnDefault("''")
	private String adminId;
	@Column(name= "admin_pw", length = 64, nullable = false)
	@ColumnDefault("''")
	private String adminPw;
	@Column(name= "admin_option", columnDefinition = "TEXT")
	private String adminOption;
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
	@Column(name= "agency_seq", nullable = false)
	@ColumnDefault("'0'")
	private int agencySeq;
	
	@Override
	protected String getOption() {
		return adminOption;
	}
	@Override
	protected void setOption(String option) {
		this.adminOption = option;
	}
	
	public AdminDto getDto() {
		
		return AdminDto.builder()
				.seq(this.seq)
				.adminNm(this.adminNm)
				.adminId(this.adminId)
				.adminPw(this.adminPw.replaceAll(".", "*"))
				.adminOption(this.adminOption)
				.actSt(this.actSt)
				.regDt(this.regDt)
				.updDt(this.updDt)
				.agencySeq(this.agencySeq)
				.build();
	}
}
