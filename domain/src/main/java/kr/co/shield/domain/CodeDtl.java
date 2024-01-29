package kr.co.shield.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.shield.dto.CodeDtlDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
@Entity
@Getter
@Setter
@Table(name = "tb_code_dtl")
@ToString
public class CodeDtl {
	
	@Column(name= "cd_dtl_no", length = 6, nullable = false)
	@ColumnDefault("''")
	@Id
	private String cdDtlNo;
	@Column(name= "cd_no", length = 3, nullable = false)
	@ColumnDefault("''")
	private String cdNo;
	@Column(name= "cd_dtl_alias", length = 512, nullable = false)
	@ColumnDefault("''")
	private String cdDtlAlias;
	@Column(name= "cd_dtl_nm", length = 512, nullable = false)
	@ColumnDefault("''")
	private String cdDtlNm;
	@Column(name= "cd_dtl_desc", length = 512, nullable = false)
	@ColumnDefault("''")
	private String cdDtlDesc;
	
	public CodeDtlDto getDto() {
		return CodeDtlDto.builder()
				.cdDtlNo(this.cdDtlNo)
				.cdNo(this.cdNo)
				.cdDtlAlias(this.cdDtlAlias)
				.cdDtlNm(this.cdDtlNm)
				.cdDtlDesc(this.cdDtlDesc)
				.build();
	}
	
}
