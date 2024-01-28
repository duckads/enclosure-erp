package kr.co.shield.dto;

import kr.co.shield.common.ShieldProperty;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
//@JsonInclude(value = Include.NON_NULL)
public class ResponseDto {
	
	@Builder.Default
	private HttpStatus status = HttpStatus.OK;
	private String message;
	
	public void setMessage(String message) {
		if (message != null && message.startsWith(ShieldProperty.RK_RESULT_Y)) {
			this.message = ShieldProperty.RK_RESPONSE_FAILURE;
		} else {
			this.message = message;
		}
	}
	
}
