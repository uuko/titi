package com.alin.titi.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "main_pro")
public class ProModel {
    //資料表宣告實體 主見1
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer proId;

    private String proYear;
    private String proVendor;
    private String proNature;
    private String proSign;
    private String proCaseNumber;
    private String proCaseName;
    private String proContent;
    private Date proStartDate  ;
    private Date proStopDate ;
    private String proRebate;
    private String proRemarks;
    private boolean isPublic=false;

    //自動 2
    private Integer tchYear;
    private Integer tchSemester;
    //外鍵 1
    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    private LoginModel loginModel ;


    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProYear() {
        return proYear;
    }

    public void setProYear(String proYear) {
        this.proYear = proYear;
    }

    public String getProVendor() {
        return proVendor;
    }

    public void setProVendor(String proVendor) {
        this.proVendor = proVendor;
    }

    public String getProNature() {
        return proNature;
    }

    public void setProNature(String proNature) {
        this.proNature = proNature;
    }

    public String getProSign() {
        return proSign;
    }

    public void setProSign(String proSign) {
        this.proSign = proSign;
    }

    public String getProCaseNumber() {
        return proCaseNumber;
    }

    public void setProCaseNumber(String proCaseNumber) {
        this.proCaseNumber = proCaseNumber;
    }

    public String getProCaseName() {
        return proCaseName;
    }

    public void setProCaseName(String proCaseName) {
        this.proCaseName = proCaseName;
    }

    public String getProContent() {
        return proContent;
    }

    public void setProContent(String proContent) {
        this.proContent = proContent;
    }

    public Date getProStartDate() {
        return proStartDate;
    }

    public void setProStartDate(Date proStartDate) {
        this.proStartDate = proStartDate;
    }

    public Date getProStopDate() {
        return proStopDate;
    }

    public void setProStopDate(Date proStopDate) {
        this.proStopDate = proStopDate;
    }

    public String getProRebate() {
        return proRebate;
    }

    public void setProRebate(String proRebate) {
        this.proRebate = proRebate;
    }

    public String getProRemarks() {
        return proRemarks;
    }

    public void setProRemarks(String proRemarks) {
        this.proRemarks = proRemarks;
    }

    public Integer getTchYear() {
        return tchYear;
    }

    public void setTchYear(Integer tchYear) {
        this.tchYear = tchYear;
    }

    public Integer getTchSemester() {
        return tchSemester;
    }

    public void setTchSemester(Integer tchSemester) {
        this.tchSemester = tchSemester;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }





    public LoginModel getLoginModel() {
        return loginModel;
    }

    public void setLoginModel(LoginModel loginModel) {
        this.loginModel = loginModel;
    }
}
