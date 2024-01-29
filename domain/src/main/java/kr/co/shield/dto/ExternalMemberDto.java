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
public class ExternalMemberDto extends Option {
    private int seq;
    private String externalMemberNm;
    private String externalMemberOption;
    private String externalMemberTp;
    private String actSt;
    private Date regDt;
    private Date updDt;

    @Override
    protected String getOption() {
        return externalMemberOption;
    }
    @Override
    protected void setOption(String option) {
        this.externalMemberOption = option;
    }
}
