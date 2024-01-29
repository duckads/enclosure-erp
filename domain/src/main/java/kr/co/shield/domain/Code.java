package kr.co.shield.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.shield.dto.CodeDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
@Entity
@Getter
@Setter
@Table(name = "tb_code")
@ToString
public class Code {
	
	@Column(name= "cd_no", length = 3, nullable = false)
	@ColumnDefault("''")
	@Id
	private String cdNo;
	@Column(name= "cd_alias", length = 512, nullable = false)
	@ColumnDefault("''")
	private String cdAlias;
	@Column(name= "cd_nm", length = 512, nullable = false)
	@ColumnDefault("''")
	private String cdNm;
	@Column(name= "cd_desc", length = 512, nullable = false)
	@ColumnDefault("''")
	private String cdDesc;
	
	public CodeDto getDto() {
		return CodeDto.builder()
				.cdNo(this.cdNo)
				.cdAlias(this.cdAlias)
				.cdNm(this.cdNm)
				.cdDesc(this.cdDesc)
				.build();
	}
	
}
