package kr.co.shield.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BusinessDealMgrDto {
    // 수주처 담당자(성함, 전화번호, 이메일) 또는 발주처 담당자
    private String name; //성함
    private String phone; //전화 번호
    private String email; //이메일
    private String type; //수주처 담당자인지 발주처 담당자인지
}
