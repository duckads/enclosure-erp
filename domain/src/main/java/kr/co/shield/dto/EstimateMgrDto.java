package kr.co.shield.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EstimateMgrDto {
     // 견적 담당자( 담당자, 전화번호, 이메일)
    private String managerNm;
    private String managerPhone;
    private String managerEmail;
}
