package kr.co.shield.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SupplyComDto {
    // 수주처(회사명, 전화, 팩스, 회사 이메일)
    private String name; //회사명
    private String phone; //전화
    private String fax; //팩스
    private String email; //이메일
}
