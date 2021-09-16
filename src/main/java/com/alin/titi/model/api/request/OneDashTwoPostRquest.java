package com.alin.titi.model.api.request;

import java.util.Date;

public class OneDashTwoPostRquest {
    private Integer expNumber;
    private Integer loginId;
    private String expCategory;
    private String expMechanismSort;
    private String expMechanismName;
    private String expPFtime;
    private String expJobtitle;
    private Date expStartDate;
    private Date expStopDate;
    private String expRemarks;
    private boolean ispublic=false;

    public Integer getExpNumber() {
        return expNumber;
    }

    public void setExpNumber(Integer expNumber) {
        this.expNumber = expNumber;
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public String getExpCategory() {
        return expCategory;
    }

    public void setExpCategory(String expCategory) {
        this.expCategory = expCategory;
    }

    public String getExpMechanismSort() {
        return expMechanismSort;
    }

    public void setExpMechanismSort(String expMechanismSort) {
        this.expMechanismSort = expMechanismSort;
    }

    public String getExpMechanismName() {
        return expMechanismName;
    }

    public void setExpMechanismName(String expMechanismName) {
        this.expMechanismName = expMechanismName;
    }

    public String getExpPFtime() {
        return expPFtime;
    }

    public void setExpPFtime(String expPFtime) {
        this.expPFtime = expPFtime;
    }

    public String getExpJobtitle() {
        return expJobtitle;
    }

    public void setExpJobtitle(String expJobtitle) {
        this.expJobtitle = expJobtitle;
    }

    public Date getExpStartDate() {
        return expStartDate;
    }

    public void setExpStartDate(Date expStartDate) {
        this.expStartDate = expStartDate;
    }

    public Date getExpStopDate() {
        return expStopDate;
    }

    public void setExpStopDate(Date expStopDate) {
        this.expStopDate = expStopDate;
    }

    public String getExpRemarks() {
        return expRemarks;
    }

    public void setExpRemarks(String expRemarks) {
        this.expRemarks = expRemarks;
    }

    public boolean ispublic() {
        return ispublic;
    }

    public void setpublic(boolean aPublic) {
        ispublic = aPublic;
    }
}
