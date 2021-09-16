package com.alin.titi.model.api.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeacherLineOneResponse {

    //teacher

    /** getters and setters **/

    private Integer tchNumber;

    private String tchPicUrl;
    private String tchMainDepartment;
    private String tchName;
    private String tchNameEN;
    private String tchCoeDepartment;
    private String eMail;
    private String tchSchool;
    private String tchDepartment;
    private String tchDiploma;
    private String tchRireRank;
    private String introduce;

    //lic
    private List<LineLicOneResponse> licList = new ArrayList<>();
//    private String licType;
//    private String licName;
//    private String licService;

    //the
    private List<LineTheOneResponse> theList = new ArrayList<>();
//    private String thePublishMonth;
//    private String thePublishYear;
//    private String thePubmainLicationName;
//    private String theCoupons;
//    private String thePubmainLicatinNumber;
//    private String theCollCategory;
//    private String themainThesisName;
//    private String theAuthor;

    //tchinf
    private List<LineTchinfOneResponse> tchinfList = new ArrayList<>();
//    private String infName;
//    private String infPubmainLicYear;
//    private String infCategory;
//    private String infAuthorOrder;
//    private String infPublishHouse;
//    private String infISBN;

    //awards
    private List<LineAwardsOneResponse> awardsList = new ArrayList<>();
//    private String awaName;
//    private String awaMechanismName;
//    private String awaDate;

    //pro
    private List<LineProOneResponse> proList = new ArrayList<>();
//    private String proVendor;
//    private String proNature;
//    private String proCaseName;

    //onedashtwo
    private List<LineOneDashTwoOneResponse> oneDashTwoList = new ArrayList<>();
//    private String expMechanismName;
//    private String expJobtitle;
//    private String expStartDate;
//    private String expStopDate;

    //gov
    private List<LineGovOneResponse> govList = new ArrayList<>();
//    private String govProjectName;
//    private String govProbjectType;
//    private String govJobType;

    //dis
    private List<LineDisOneResponse> disList = new ArrayList<>();
//    private String dismainThesisName;
//    private String disAuthor;
//    private String disPublishY;
//    private String disCollection;
//    private String disSeminarName;
//    private String disHostCountry;

    //event
    private List<LineEventOneResponse> eventList = new ArrayList<>();
//    private String eveName;
//    private String eveCategory;
//    private String eveSort;


    public Integer getTchNumber() {
        return tchNumber;
    }

    public void setTchNumber(Integer tchNumber) {
        this.tchNumber = tchNumber;
    }


    public String getTchPicUrl() {
        return tchPicUrl;
    }

    public void setTchPicUrl(String tchPicUrl) {
        this.tchPicUrl = tchPicUrl;
    }

    public String getTchMainDepartment() {
        return tchMainDepartment;
    }

    public void setTchMainDepartment(String tchMainDepartment) {
        this.tchMainDepartment = tchMainDepartment;
    }

    public String getTchName() {
        return tchName;
    }

    public void setTchName(String tchName) {
        this.tchName = tchName;
    }

    public String getTchNameEN() {
        return tchNameEN;
    }

    public void setTchNameEN(String tchNameEN) {
        this.tchNameEN = tchNameEN;
    }

    public String getTchCoeDepartment() {
        return tchCoeDepartment;
    }

    public void setTchCoeDepartment(String tchCoeDepartment) {
        this.tchCoeDepartment = tchCoeDepartment;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getTchSchool() {
        return tchSchool;
    }

    public void setTchSchool(String tchSchool) {
        this.tchSchool = tchSchool;
    }

    public String getTchDepartment() {
        return tchDepartment;
    }

    public void setTchDepartment(String tchDepartment) {
        this.tchDepartment = tchDepartment;
    }

    public String getTchDiploma() {
        return tchDiploma;
    }

    public void setTchDiploma(String tchDiploma) {
        this.tchDiploma = tchDiploma;
    }

    public String getTchRireRank() {
        return tchRireRank;
    }

    public void setTchRireRank(String tchRireRank) {
        this.tchRireRank = tchRireRank;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public List<LineLicOneResponse> getLicList() {
        return licList;
    }

    public void setLicList(List<LineLicOneResponse> licList) {
        this.licList = licList;
    }

    public List<LineTheOneResponse> getTheList() {
        return theList;
    }

    public void setTheList(List<LineTheOneResponse> theList) {
        this.theList = theList;
    }

    public List<LineTchinfOneResponse> getTchinfList() {
        return tchinfList;
    }

    public void setTchinfList(List<LineTchinfOneResponse> tchinfList) {
        this.tchinfList = tchinfList;
    }

    public List<LineAwardsOneResponse> getAwardsList() {
        return awardsList;
    }

    public void setAwardsList(List<LineAwardsOneResponse> awardsList) {
        this.awardsList = awardsList;
    }

    public List<LineProOneResponse> getProList() {
        return proList;
    }

    public void setProList(List<LineProOneResponse> proList) {
        this.proList = proList;
    }

    public List<LineOneDashTwoOneResponse> getOneDashTwoList() {
        return oneDashTwoList;
    }

    public void setOneDashTwoList(List<LineOneDashTwoOneResponse> oneDashTwoList) {
        this.oneDashTwoList = oneDashTwoList;
    }

    public List<LineGovOneResponse> getGovList() {
        return govList;
    }

    public void setGovList(List<LineGovOneResponse> govList) {
        this.govList = govList;
    }

    public List<LineDisOneResponse> getDisList() {
        return disList;
    }

    public void setDisList(List<LineDisOneResponse> disList) {
        this.disList = disList;
    }

    public List<LineEventOneResponse> getEventList() {
        return eventList;
    }

    public void setEventList(List<LineEventOneResponse> eventList) {
        this.eventList = eventList;
    }
}
