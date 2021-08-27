package com.alin.titi.model;

import javax.persistence.*;

@Entity(name = "main_lic")
public class LicenseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer licId;
    private String licType;
    private String licName;
    private String licService;
    private Integer licNumber;
    private Integer tchYear;
    private Integer tchSemester;
    private boolean isPublic=false;

    //login id
    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    private LoginModel loginModel ;



    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public Integer getLicId() {
        return licId;
    }

    public void setLicId(Integer licId) {
        this.licId = licId;
    }

    public String getLicType() {
        return licType;
    }

    public void setLicType(String licType) {
        this.licType = licType;
    }

    public String getLicName() {
        return licName;
    }

    public void setLicName(String licName) {
        this.licName = licName;
    }

    public String getLicService() {
        return licService;
    }

    public void setLicService(String licService) {
        this.licService = licService;
    }

    public Integer getLicNumber() {
        return licNumber;
    }

    public void setLicNumber(Integer licNumber) {
        this.licNumber = licNumber;
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

    public LoginModel getLoginModel() {
        return loginModel;
    }

    public void setLoginModel(LoginModel loginModel) {
        this.loginModel = loginModel;
    }
}
