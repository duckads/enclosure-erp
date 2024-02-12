package kr.co.shield.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class LegacyEstimateDto {
    private int estimateDtlTableCode;
    private int estimateTableCode;
    private String estimateCode;
    private String estimateDtlTableName;
    private String estimateDtlTableStandard;
    private String estimateDtlTableQuantity;
    private String estimateDtlTableUnit;
    private int estimateDtlTableUnitPrice;
    private int estimateDtlTableSupplyPrice;
    private String estimateDtlTableNote;
    private String estimateDtlTableKindsCode;
}
