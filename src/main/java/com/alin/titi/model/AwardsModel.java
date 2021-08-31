package com.alin.titi.model;

import javax.persistence.*;

@Entity(name = "main_awards")
public class AwardsModel {
    //資料表宣告實體 主見1
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer awaId;
    private String awaSort;
    private String awaYear;
    private String awaName;
    private String awaCountry;
    private String awaCampus;
    private String awaAuthor;
    private String awaMechanismName;
    private String awaDate;
    private  String awaPlan;
    private String awaRemarks;
    private boolean isPublic=false;

    //自動 2
    private Integer tchYear;
    private Integer tchSemester;
    //外鍵 1
    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    private LoginModel loginModel ;


    public Integer getAwaId() {
        return awaId;
    }

    public void setAwaId(Integer awaId) {
        this.awaId = awaId;
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
