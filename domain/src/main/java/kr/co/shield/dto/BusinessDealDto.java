package kr.co.shield.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class BusinessDealDto {
    // 수주처(회사명, 전화, 팩스, 회사 이메일) 똔느 발주처
    private String name; //회사명
    private String phone; //전화
    private String fax; //팩스
    private String email; //이메일
    private String type; //수주처 인지 발주처인지
}
