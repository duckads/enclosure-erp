package kr.co.shield.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "sh_estimate")
@ToString
public class LegacyEstimate {
    @Id
    @Column(name= "estimate_code", nullable = false)
    private String estimateCode;
    @Column(name= "project_code")
    private String projectCode;

    @Column(name= "estimate_title")
    private String estimateTitle;
    @Column(name= "estimate_buyer_com_name")
    private String estimateBuyerComName;
    @Column(name= "estimate_buyer_com_phone")
    private String estimateBuyerComPhone;
    @Column(name= "estimate_buyer_com_fax")
    private String estimateBuyerComFax;
    @Column(name= "estimate_buyer_com_email")
    private String estimateBuyerComEmail;

    @Column(name= "estimate_buyer_name")
    private String estimateBuyerName;
    @Column(name= "estimate_buyer_phone")
    private String estimateBuyerPhone;
    @Column(name= "estimate_buyer_email")
    private String estimateBuyerEmail;

    @Column(name= "estimate_prod_name")
    private String estimateProdName;
    @Column(name= "estimate_prod_phone")
    private String estimateProdPhone;
    @Column(name= "estimate_prod_fax")
    private String estimateProdFax;
    @Column(name= "estimate_prod_address")
    private String estimateProdAddress;
    @Column(name= "estimate_prod_status")
    private String estimateProdStatus;
    @Column(name= "estimate_prod_event")
    private String estimateProdEvent;
    @Column(name= "estimate_prod_email")
    private String estimateProdEmail;

    @Column(name= "estimate_manager")
    private String estimateManager;
    @Column(name= "estimate_manager_phone")
    private String estimateManagerPhone;
    @Column(name= "estimate_manager_email")
    private String estimateManagerEmail;

    @Column(name= "estimate_startdt")
    private String estimateStartdt;
    @Column(name= "estimate_expri")
    private String estimateExpri;
    @Column(name= "estimate_payment")
    private String estimatePayment;
    @Column(name= "estimate_scene")
    private String estimateScene;
    @Column(name= "estimate_textarea")
    private String estimateTextarea;
    @Column(name= "estimate_date_crtd")
    private String estimateDateCrtd;
    @Column(name= "estimate_progress")
    private String estimateProgress;
    @Column(name= "estimate_type")
    private String estimateType;
}
