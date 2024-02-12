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
public class CompanyDto extends Option {
    private int seq;
    private String companyNm;
    private String companyOption;
    private int managerMemberSeq;
    private String actSt;
    private Date regDt;
    private Date updDt;

    @Override
    protected String getOption() {
        return companyOption;
    }
    @Override
    protected void setOption(String option) {
        this.companyOption = option;
    }
}
