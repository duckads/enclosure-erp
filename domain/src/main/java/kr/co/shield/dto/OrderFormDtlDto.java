package kr.co.shield.dto;

import kr.co.shield.ext.Option;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Builder
@Getter
@Setter
@ToString
public class OrderFormDtlDto {
    private Long seq;
    private String orderCode; //발주 번호
    private String productNm; //품명
    private String productSize; //규격
    private int productQuantity; //수량
    private String productUnit; //단위
    private int productPrice; //단가
    private Long productSupplyPrice; //공급가액
    private int productNote; //비고
    private String actSt;
    private Date regDt;
    private Date updDt;
    private int companySeq;
}
