package kr.co.shield.domain;

import jakarta.persistence.*;
import kr.co.shield.dto.CompanyDto;
import kr.co.shield.dto.ProducerDto;
import kr.co.shield.ext.Option;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "producer") //공급자
@ToString
public class Producer extends Option {
    @Column(name= "seq", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int seq;
    @Column(name= "producer_nm", length = 256, nullable = false)
    @ColumnDefault("''")
    private String producerNm;
    @Column(name= "producer_option", columnDefinition = "TEXT")
    private String producerOption;
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
    @Column(name= "company_seq", nullable = false)
    private int companySeq;

    @Override
    protected String getOption() {
        return producerOption;
    }
    @Override
    protected void setOption(String option) {
        this.producerOption = option;
    }

    public ProducerDto getDto() {

        return ProducerDto.builder()
                .seq(this.seq)
                .producerNm(this.producerNm)
                .producerOption(this.producerOption)
                .actSt(this.actSt)
                .regDt(this.regDt)
                .updDt(this.updDt)
                .companySeq(this.companySeq)
                .build();
    }
}
