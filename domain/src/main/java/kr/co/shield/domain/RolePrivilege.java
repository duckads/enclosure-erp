package kr.co.shield.domain;

import jakarta.persistence.*;
import kr.co.shield.dto.RolePrivilegeDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
@Entity
@Getter
@Setter
@Table(name = "role_privilege")
@ToString
public class RolePrivilege {
	
	@Column(name= "seq", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int seq;
	@Column(name= "role_seq", nullable = false)
	@ColumnDefault("'0'")
	private int roleSeq;
	@Column(name= "privilege_seq", nullable = false)
	@ColumnDefault("'0'")
	private int privilegeSeq;
	
	public RolePrivilegeDto getDto() {
		return RolePrivilegeDto.builder()
				.seq(this.seq)
				.roleSeq(this.roleSeq)
				.privilegeSeq(this.privilegeSeq)
				.build();
	}
	
}
