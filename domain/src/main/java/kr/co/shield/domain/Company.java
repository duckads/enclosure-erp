package kr.co.shield.domain;

import jakarta.persistence.*;
import kr.co.shield.dto.CompanyDto;
import kr.co.shield.dto.EstimateDto;
import kr.co.shield.ext.Option;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "company")
@ToString
public class Company extends Option {
    @Column(name= "seq", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int seq;
    @Column(name= "company_nm", length = 256, nullable = false)
    @ColumnDefault("''")
    private String companyNm;
    @Column(name= "company_option", columnDefinition = "TEXT")
    private String companyOption;
    @Column(name= "manager_member_seq", nullable = false)
    @ColumnDefault("'0'")
    private int managerMemberSeq;
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
        return companyOption;
    }
    @Override
    protected void setOption(String option) {
        this.companyOption = option;
    }

    public CompanyDto getDto() {

        return CompanyDto.builder()
                .seq(this.seq)
                .companyNm(this.companyNm)
                .companyOption(this.companyOption)
                .managerMemberSeq(this.managerMemberSeq)
                .actSt(this.actSt)
                .regDt(this.regDt)
                .updDt(this.updDt)
                .build();
    }
}
