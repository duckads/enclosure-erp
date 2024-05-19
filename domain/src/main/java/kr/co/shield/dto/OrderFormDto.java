package kr.co.shield.dto;

import kr.co.shield.ext.Option;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@ToString
public class OrderFormDto extends Option {
    private Long seq;
    private String orderCode; // 발주 번호
    private String orderNm; // 발주 명
    private String orderOption; // 발주 옵션 ( 발주일자, 납기일자, 현장위치, 현장 담당)
    private String orderNote; // 비고, 메모
    private BusinessDealDto supplyCom; // 수주처(회사명, 전화, 팩스, 회사 이메일)
    private BusinessDealMgrDto supplyMgr; // 수주처 담당자(성함, 전화번호, 이메일)
    private ProducerDto producer; // 공급자 (회사명, 회사전화, 회사 주소, 회사 팩스, 회사 업태 회사 종목, 회사 이메일
    private EstimateMgrDto estimateMgr; // 견적 담당자( 담당자, 전화번호, 이메일)
    private int memberSeq; // 저장 및 수정한 사람
    private String actSt; //상태 값
    private Date regDt;
    private Date updDt;
    private int companySeq;

    @Override
    protected String getOption() {
        return orderOption;
    }
    @Override
    protected void setOption(String option) {
        this.orderOption = option;
    }

    private List<OrderFormDtlDto> orderDtl;
}
