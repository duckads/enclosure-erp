package kr.co.shield.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "sh_project")
@ToString
public class LegacyProject {
    @Id
    @Column(name= "project_code", nullable = false)
    private String projectCode;
    @Column(name= "project_name")
    private String projectName;
    @Column(name= "project_progress")
    private String projectProgress;
    @Column(name= "project_buyer")
    private String projectBuyer;
    @Column(name= "project_contruction_name")
    private String projectContructionName;
    @Column(name= "projcet_site_location")
    private String projectSiteLocation;
    @Column(name= "project_startdt")
    private Date projectStartDt;
    @Column(name= "project_enddt")
    private Date projectEndDt;
    @Column(name= "project_work_startdt")
    private Date projectWorkStartDt;
    @Column(name= "project_work_enddt")
    private Date projectWorkEndDt;
    @Column(name= "project_buyer_manager")
    private String projectBuyerManager;
    @Column(name= "project_buyer_manager_nm")
    private String projectBuyerManagerNm;
    @Column(name= "project_shield_manager")
    private String projectShieldManager;
}
