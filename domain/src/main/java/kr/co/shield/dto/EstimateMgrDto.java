package kr.co.shield.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class EstimateMgrDto {
     // 견적 담당자( 담당자, 전화번호, 이메일)
    private String name;
    private String phone;
    private String email;
}
