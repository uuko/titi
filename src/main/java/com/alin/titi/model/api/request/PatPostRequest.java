package com.alin.titi.model.api.request;

import java.util.Date;

public class PatPostRequest {

    private Integer loginId;
    private String pat95Area ;
    private String pat96Area;
    private String patType;
    private String patCountry;
    private String patmainPatentName;
    private String patReportCode;
    private String patAppmainLicant;
    private String patProgressStatus;
    private Date patReportEdata ;
    private String patAuthor;
    private Date patEndDate ;
    private Date patAppmainLicationDate;
    private String patAppmainLicantType;
    private String patmainLicensingAgency;
    private String patCertificateNumber;
    private String patProject;
    private String patIsGet;
    private String patChang;
    private String patYear ;
    private boolean ispublic=false;

    public String getPat95Area() {
        return pat95Area;
    }

    public void setPat95Area(String pat95Area) {
        this.pat95Area = pat95Area;
    }

    public String getPat96Area() {
        return pat96Area;
    }

    public void setPat96Area(String pat96Area) {
        this.pat96Area = pat96Area;
    }

    public String getPatType() {
        return patType;
    }

    public void setPatType(String patType) {
        this.patType = patType;
    }

    public String getPatCountry() {
        return patCountry;
    }

    public void setPatCountry(String patCountry) {
        this.patCountry = patCountry;
    }

    public String getPatmainPatentName() {
        return patmainPatentName;
    }

    public void setPatmainPatentName(String patmainPatentName) {
        this.patmainPatentName = patmainPatentName;
    }

    public String getPatReportCode() {
        return patReportCode;
    }

    public void setPatReportCode(String patReportCode) {
        this.patReportCode = patReportCode;
    }

    public String getPatAppmainLicant() {
        return patAppmainLicant;
    }

    public void setPatAppmainLicant(String patAppmainLicant) {
        this.patAppmainLicant = patAppmainLicant;
    }

    public String getPatProgressStatus() {
        return patProgressStatus;
    }

    public void setPatProgressStatus(String patProgressStatus) {
        this.patProgressStatus = patProgressStatus;
    }

    public Date getPatReportEdata() {
        return patReportEdata;
    }

    public void setPatReportEdata(Date patReportEdata) {
        this.patReportEdata = patReportEdata;
    }

    public String getPatAuthor() {
        return patAuthor;
    }

    public void setPatAuthor(String patAuthor) {
        this.patAuthor = patAuthor;
    }

    public Date getPatEndDate() {
        return patEndDate;
    }

    public void setPatEndDate(Date patEndDate) {
        this.patEndDate = patEndDate;
    }

    public Date getPatAppmainLicationDate() {
        return patAppmainLicationDate;
    }

    public void setPatAppmainLicationDate(Date patAppmainLicationDate) {
        this.patAppmainLicationDate = patAppmainLicationDate;
    }

    public String getPatAppmainLicantType() {
        return patAppmainLicantType;
    }

    public void setPatAppmainLicantType(String patAppmainLicantType) {
        this.patAppmainLicantType = patAppmainLicantType;
    }

    public String getPatmainLicensingAgency() {
        return patmainLicensingAgency;
    }

    public void setPatmainLicensingAgency(String patmainLicensingAgency) {
        this.patmainLicensingAgency = patmainLicensingAgency;
    }

    public String getPatCertificateNumber() {
        return patCertificateNumber;
    }

    public void setPatCertificateNumber(String patCertificateNumber) {
        this.patCertificateNumber = patCertificateNumber;
    }

    public String getPatProject() {
        return patProject;
    }

    public void setPatProject(String patProject) {
        this.patProject = patProject;
    }

    public String getPatIsGet() {
        return patIsGet;
    }

    public void setPatIsGet(String patIsGet) {
        this.patIsGet = patIsGet;
    }

    public String getPatChang() {
        return patChang;
    }

    public void setPatChang(String patChang) {
        this.patChang = patChang;
    }

    public String getPatYear() {
        return patYear;
    }

    public void setPatYear(String patYear) {
        this.patYear = patYear;
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
