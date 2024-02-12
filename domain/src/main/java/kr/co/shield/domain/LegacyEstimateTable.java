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
@Table(name = "sh_estimate_table")
@ToString
public class LegacyEstimateTable {
    @Id
    @Column(name= "estimate_table_code", nullable = false)
    private int estimateTableCode;
    @Column(name= "estimate_code", insertable=false, updatable=false)
    private String estimateCode;
    @Column(name= "estimate_table_name")
    private String estimateTableName;
    @Column(name= "estimate_table_standard")
    private String estimateTableStandard;
    @Column(name= "estimate_table_quantity")
    private String estimateTableQuantity;
    @Column(name= "estimate_table_unit")
    private String estimateTableUnit;
    @Column(name= "estimate_table_unit_price")
    private Integer estimateTableUnitPrice;
    @Column(name= "estimate_table_supply_price")
    private Long estimateTableSupplyPrice;
    @Column(name= "estimate_table_note")
    private String estimateTableNote;
    @Column(name= "estimate_table_kinds_code")
    private String estimateTableKindsCode;
}
