package kr.co.shield.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ProducerComDto {
    private String name; //회사명
    private String phone; //회사 전화
    private String address; //회사 주소
    private String fax; //회사 팩스
    private String type; //회사 업태
    private String field; //회사 종목
    private String email; //회사 이메일
}
