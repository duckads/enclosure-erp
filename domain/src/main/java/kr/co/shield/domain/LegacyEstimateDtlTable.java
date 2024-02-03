package kr.co.shield.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "sh_estimate_dtl_table")
@ToString
public class LegacyEstimateDtlTable {
    @Id
    @Column(name= "estimate_dtl_table_code")
    private String estimateDtlTableCode;
    @Column(name= "estimate_table_code", insertable=false, updatable=false)
    private String estimateTableCode;
    @Column(name= "estimate_code")
    private String estimateCode;
    @Column(name= "estimate_dtl_table_name")
    private String estimateDtlTableName;
    @Column(name= "estimate_dtl_table_standard")
    private String estimateDtlTableStandard;
    @Column(name= "estimate_dtl_table_quantity")
    private String estimateDtlTableQuantity;
    @Column(name= "estimate_dtl_table_unit")
    private String estimateDtlTableUnit;
    @Column(name= "estimate_dtl_table_unit_price")
    private String estimateDtlTableUnitPrice;
    @Column(name= "estimate_dtl_table_supply_price")
    private String estimateDtlTableSupplyPrice;
    @Column(name= "estimate_dtl_table_note")
    private String estimateDtlTableNote;
    @Column(name= "estimate_dtl_table_kinds_code")
    private String estimateDtlKindsCode;
}
