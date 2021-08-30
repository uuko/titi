package com.alin.titi.model.api.response;

import java.util.Date;

public class AcademicResponse {
    private Integer loginId;
    private Integer eveNumber;
    private String eveYear;
    private String eveName;
    private String eveCategory;
    private String eveClassRelated;
    private String eveLocation;
    private Date eveStratDate;
    private Date eveStopDate;
    private boolean eveSort;
    private Integer eveHours;
    private Integer eveStudyCertificate;
    private String eveCertificateNumber;
    private String eveSchSubsidy;
    private boolean isPublic=false;
    //
    private Integer tchYear;
    private Integer tchSemester;

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public Integer getEveNumber() {
        return eveNumber;
    }

    public void setEveNumber(Integer eveNumber) {
        this.eveNumber = eveNumber;
    }

    public String getEveYear() {
        return eveYear;
    }

    public void setEveYear(String eveYear) {
        this.eveYear = eveYear;
    }

    public String getEveName() {
        return eveName;
    }

    public void setEveName(String eveName) {
        this.eveName = eveName;
    }

    public String getEveCategory() {
        return eveCategory;
    }

    public void setEveCategory(String eveCategory) {
        this.eveCategory = eveCategory;
    }

    public String getEveClassRelated() {
        return eveClassRelated;
    }

    public void setEveClassRelated(String eveClassRelated) {
        this.eveClassRelated = eveClassRelated;
    }

    public String getEveLocation() {
        return eveLocation;
    }

    public void setEveLocation(String eveLocation) {
        this.eveLocation = eveLocation;
    }

    public Date getEveStratDate() {
        return eveStratDate;
    }

    public void setEveStratDate(Date eveStratDate) {
        this.eveStratDate = eveStratDate;
    }

    public Date getEveStopDate() {
        return eveStopDate;
    }

    public void setEveStopDate(Date eveStopDate) {
        this.eveStopDate = eveStopDate;
    }

    public boolean isEveSort() {
        return eveSort;
    }

    public void setEveSort(boolean eveSort) {
        this.eveSort = eveSort;
    }

    public Integer getEveHours() {
        return eveHours;
    }

    public void setEveHours(Integer eveHours) {
        this.eveHours = eveHours;
    }

    public Integer getEveStudyCertificate() {
        return eveStudyCertificate;
    }

    public void setEveStudyCertificate(Integer eveStudyCertificate) {
        this.eveStudyCertificate = eveStudyCertificate;
    }

    public String getEveCertificateNumber() {
        return eveCertificateNumber;
    }

    public void setEveCertificateNumber(String eveCertificateNumber) {
        this.eveCertificateNumber = eveCertificateNumber;
    }

    public String getEveSchSubsidy() {
        return eveSchSubsidy;
    }

    public void setEveSchSubsidy(String eveSchSubsidy) {
        this.eveSchSubsidy = eveSchSubsidy;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
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
