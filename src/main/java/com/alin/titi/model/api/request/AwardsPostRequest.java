package com.alin.titi.model.api.request;

public class AwardsPostRequest {

    // 教師編號 tchYear >>int
    //學年度 tchSemester >>int
    private Integer loginId;
    private String awaYear;
    private String awaSort;
    private String awaName;
    private String awaCountry;
    private String awaCampus;
    private String awaAuthor;
    private String awaMechanismName;
    private String awaDate;
    private  String awaPlan;
    private String awaRemarks;
    private boolean ispublic=false;

    public String getAwaYear() {
        return awaYear;
    }

    public void setAwaYear(String awaYear) {
        this.awaYear = awaYear;
    }

    public String getAwaSort() {
        return awaSort;
    }

    public void setAwaSort(String awaSort) {
        this.awaSort = awaSort;
    }

    public String getAwaName() {
        return awaName;
    }

    public void setAwaName(String awaName) {
        this.awaName = awaName;
    }

    public String getAwaCountry() {
        return awaCountry;
    }

    public void setAwaCountry(String awaCountry) {
        this.awaCountry = awaCountry;
    }

    public String getAwaCampus() {
        return awaCampus;
    }

    public void setAwaCampus(String awaCampus) {
        this.awaCampus = awaCampus;
    }

    public String getAwaAuthor() {
        return awaAuthor;
    }

    public void setAwaAuthor(String awaAuthor) {
        this.awaAuthor = awaAuthor;
    }

    public String getAwaMechanismName() {
        return awaMechanismName;
    }

    public void setAwaMechanismName(String awaMechanismName) {
        this.awaMechanismName = awaMechanismName;
    }

    public String getAwaDate() {
        return awaDate;
    }

    public void setAwaDate(String awaDate) {
        this.awaDate = awaDate;
    }

    public String getAwaPlan() {
        return awaPlan;
    }

    public void setAwaPlan(String awaPlan) {
        this.awaPlan = awaPlan;
    }

    public String getAwaRemarks() {
        return awaRemarks;
    }

    public void setAwaRemarks(String awaRemarks) {
        this.awaRemarks = awaRemarks;
    }

    public boolean ispublic() {
        return ispublic;
    }

    public void setpublic(boolean aPublic) {
        ispublic = aPublic;
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }
}
