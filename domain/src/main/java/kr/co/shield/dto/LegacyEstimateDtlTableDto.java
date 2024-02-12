package kr.co.shield.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Builder
@Getter
@Setter
@ToString
public class LegacyEstimateDtlTableDto {
    private String estimateCode;
    private String projectCode;
    private String estimateTitle;
    private String estimateBuyerComName;
    private String estimateBuyerComPhone;
    private String estimateBuyerComFax;
    private String estimateBuyerComEmail;
    private String estimateBuyerName;
    private String estimateBuyerPhone;
    private String estimateBuyerEmail;
    private String estimateProdName;
    private String estimateProdPhone;
    private String estimateProdFax;
    private String estimateProdAddress;
    private String estimateProdStatus;
    private String estimateProdEvent;
    private String estimateProdEmail;
    private String estimateManager;
    private String estimateManagerPhone;
    private String estimateManagerEmail;
    private Date estimateStartDt;
    private String estimateExpri;
    private String estimatePayment;
    private String estimateScene;
    private String estimateTextarea;
    private Date estimateDateCrtd;
    private String estimateProgress;
    private String estimateType;
}
