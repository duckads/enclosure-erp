package kr.co.shield.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

/**
 * 회원 가입
 */
@Getter
@Setter
public class JoinDto {

	private String origin; // gp,logger

	@NotBlank(message = "이메일 주소를 입력해 주세요.")
	@Email(message = "올바른 이메일 주소를 입력해 주세요.")
	private String username;
	@NotBlank(message = "비밀번호를 입력해 주세요.")
	@Size(min = 8, max = 32, message = "비밀번호는 8자 이상 32자 이하로 입력해 주세요.")
	private String password;

	@NotBlank(message = "담당자명을 입력해 주세요.")
	private String memberNm;
	@NotBlank(message = "휴대폰 번호를 입력해주세요.")
	@Pattern(regexp = "(01[016789])(\\d{3,4})(\\d{4})", message = "올바른 휴대폰 번호를 입력해주세요.")
	private String memberPhone;
}
