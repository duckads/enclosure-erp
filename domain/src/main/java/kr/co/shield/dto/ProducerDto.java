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
public class ProducerDto extends Option {  //공급자
    private int seq;
    private String producerNm;
    private String producerOption;
    private String actSt;
    private Date regDt;
    private Date updDt;
    private int companySeq;

    @Override
    protected String getOption() {
        return producerOption;
    }
    @Override
    protected void setOption(String option) {
        this.producerOption = option;
    }
}
