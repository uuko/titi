package com.alin.titi.model.api.response;

import java.util.Date;

public class OneDashTwoResponse {


    private Integer loginId;
    private Integer expNumber;

    private String expCategory;
    private String expMechanismSort;
    private String expMechanismName;
    private String expPFtime;
    private String expJobtitle;
    private Date expStartDate;
    private Date expStopDate;
    private String expRemarks;

    //

    private Integer tchYear;
    private Integer tchSemester;
    private boolean isPublic=false;
    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }
    public Integer getExpNumber() {
        return expNumber;
    }

    public void setExpNumber(Integer expNumber) {
        this.expNumber = expNumber;
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
}
