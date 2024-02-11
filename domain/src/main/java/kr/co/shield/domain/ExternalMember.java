package kr.co.shield.domain;

import jakarta.persistence.*;
import kr.co.shield.dto.CompanyDto;
import kr.co.shield.dto.ExternalMemberDto;
import kr.co.shield.ext.Option;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "external_member")
@ToString
public class ExternalMember extends Option {
    @Column(name= "seq", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long seq;
    @Column(name= "external_member_nm", length = 256, nullable = false)
    @ColumnDefault("''")
    private String externalMemberNm;
    @Column(name= "external_member_option", columnDefinition = "TEXT")
    private String externalMemberOption;
    @Column(name= "external_member_tp", length = 64, nullable = false)
    @ColumnDefault("''")
    private String externalMemberTp;
    @Column(name= "act_st", length = 6, nullable = false)
    @ColumnDefault("''")
    private String actSt;
    @Column(name= "reg_dt", nullable = false)
    @ColumnDefault("'2021-01-01 00:00:00'")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDt;
    @Column(name= "upd_dt", nullable = false)
    @ColumnDefault("'2021-01-01 00:00:00'")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updDt;

    @Override
    protected String getOption() {
        return externalMemberOption;
    }
    @Override
    protected void setOption(String option) {
        this.externalMemberOption = option;
    }

    public ExternalMemberDto getDto() {

        return ExternalMemberDto.builder()
                .seq(this.seq)
                .externalMemberNm(this.externalMemberNm)
                .externalMemberOption(this.externalMemberOption)
                .externalMemberTp(this.externalMemberTp)
                .actSt(this.actSt)
                .regDt(this.regDt)
                .updDt(this.updDt)
                .build();
    }
}
