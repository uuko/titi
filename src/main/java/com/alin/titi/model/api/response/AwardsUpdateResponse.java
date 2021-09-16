package com.alin.titi.model.api.response;

public class AwardsUpdateResponse {


    private Integer loginId;


    //普通
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

    //自動
    private Integer awaId;
    private Integer tchYear;
    private Integer tchSemester;

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

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

    public Integer getAwaId() {
        return awaId;
    }

    public void setAwaId(Integer awaId) {
        this.awaId = awaId;
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
}
