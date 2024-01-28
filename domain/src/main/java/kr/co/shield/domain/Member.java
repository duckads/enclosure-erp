package kr.co.shield.domain;

import jakarta.persistence.*;
import kr.co.shield.dto.MemberDto;
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
@Table(name = "member")
@ToString
public class Member extends Option {
	
	@Column(name= "seq", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int seq;
	@Column(name= "member_nm", length = 256, nullable = false)
	@ColumnDefault("''")
	private String memberNm;
	@Column(name= "member_id", length = 64, nullable = false)
	@ColumnDefault("''")
	private String memberId;
	@Column(name= "member_pw", length = 64, nullable = false)
	@ColumnDefault("''")
	private String memberPw;
	@Column(name= "member_option", columnDefinition = "TEXT")
	private String memberOption;
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
		return memberOption;
	}
	@Override
	protected void setOption(String option) {
		this.memberOption = option;
	}
	
	public MemberDto getDto() {

		List<String> roles = this.roles.stream()
				.map(Role::getRoleNm)
				.collect(Collectors.toList());

		return MemberDto.builder()
				.seq(this.seq)
				.memberNm(this.memberNm)
				.memberId(this.memberId)
				.memberPw(this.memberPw.replaceAll(".", "*"))
				.memberOption(this.memberOption)
				.actSt(this.actSt)
				.regDt(this.regDt)
				.updDt(this.updDt)
				.roles(roles)
				.build();
	}

	@ManyToMany
	@JoinTable(name = "member_role",
			joinColumns = @JoinColumn(name = "member_seq"),
			inverseJoinColumns = @JoinColumn(name = "role_seq"))
	private final List<Role> roles = new ArrayList<>();
}
