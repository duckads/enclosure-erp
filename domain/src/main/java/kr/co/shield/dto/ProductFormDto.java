package kr.co.shield.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductFormDto {
    private String productNm; //품명
    private String productSize; //규격
    private String productQuantity; //수량
    private String productUnit; //단위
    private String productPrice; //단가
    private String productSupplyPrice; //공급가액
    private String productNote; //비고
    private String productTp; // 상품 타입
}
