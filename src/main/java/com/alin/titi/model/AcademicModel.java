package com.alin.titi.model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "main_academicevents")
public class AcademicModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer eveNumber;
    private String eveYear="";
    private String eveName="";
    private String eveCategory="";
    private String eveClassRelated="";
    private String eveLocation="";
    @ColumnDefault(value="CURRENT_TIMESTAMP")
    @Generated(GenerationTime.INSERT)
    private Date eveStratDate;
    @ColumnDefault(value="CURRENT_TIMESTAMP")
    @Generated(GenerationTime.INSERT)
    private Date eveStopDate;
    private String eveSort="";
    private String eveHours="";
    private String eveStudyCertificate="";
    private String eveCertificateNumber="";
    private String eveSchSubsidy="";


    private boolean open =false;
    //
    private Integer tchYear=0;
    private Integer tchSemester=0;
    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    private LoginModel loginModel ;


    private String eveOrganizer="";

    private String  eveParticimainPation="";
    public String geteveParticimainPation() {
        return  eveParticimainPation;
    }

    public void seteveParticimainPation(String  eveParticimainPation) {
        this.eveParticimainPation=eveParticimainPation;
    }


    public String geteveOrganizer() {
        return eveOrganizer;
    }

    public void seteveOrganizer(String eveOrganizer) {
        this.eveOrganizer = eveOrganizer;
    }

    public String getEveSort() {
        return eveSort;
    }

    public void setEveSort(String eveSort) {
        this.eveSort = eveSort;
    }


    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
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



    public String getEveHours() {
        return eveHours;
    }

    public void setEveHours(String eveHours) {
        this.eveHours = eveHours;
    }

    public String getEveStudyCertificate() {
        return eveStudyCertificate;
    }

    public void setEveStudyCertificate(String eveStudyCertificate) {
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
