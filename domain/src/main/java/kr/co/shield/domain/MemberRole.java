package kr.co.shield.domain;

import jakarta.persistence.*;

import kr.co.shield.dto.MemberRoleDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Setter
@Table(name = "member_role")
@ToString
public class MemberRole {
	
	@Column(name= "seq", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int seq;
	@Column(name= "member_seq", nullable = false)
	@ColumnDefault("'0'")
	private int memberSeq;
	@Column(name= "role_seq", nullable = false)
	@ColumnDefault("'0'")
	private int roleSeq;
	public MemberRoleDto getDto() {
		return MemberRoleDto.builder()
				.seq(this.seq)
				.memberSeq(this.memberSeq)
				.roleSeq(this.roleSeq)
				.build();
	}
	
}
