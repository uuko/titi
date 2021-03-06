package com.alin.titi.model.api.request;

public class PaperPostRequest {

    private Integer loginId;
    private String theCollCategory;
    private String theAuthor;
    private String theCorreAuthor;
    private String thePubmain_licationName;
    private String theCoupons;
    private String theReviewer;
    private String themain_thesisName;
    private String theTransCooperation;
    private String thePubmain_licatinNumber;

    private String thePublishingcountry;
    private String thePublishMonth;
    private String thePublishYear;

    private String thePublishType;
    private String theProject;
    private boolean ispublic=false;
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

    public String getTheCollCategory() {
        return theCollCategory;
    }

    public void setTheCollCategory(String theCollCategory) {
        this.theCollCategory = theCollCategory;
    }

    public String getTheAuthor() {
        return theAuthor;
    }

    public void setTheAuthor(String theAuthor) {
        this.theAuthor = theAuthor;
    }

    public String getTheCorreAuthor() {
        return theCorreAuthor;
    }

    public void setTheCorreAuthor(String theCorreAuthor) {
        this.theCorreAuthor = theCorreAuthor;
    }

    public String getThePubmain_licationName() {
        return thePubmain_licationName;
    }

    public void setThePubmain_licationName(String thePubmain_licationName) {
        this.thePubmain_licationName = thePubmain_licationName;
    }

    public String getTheCoupons() {
        return theCoupons;
    }

    public void setTheCoupons(String theCoupons) {
        this.theCoupons = theCoupons;
    }

    public String getTheReviewer() {
        return theReviewer;
    }

    public void setTheReviewer(String theReviewer) {
        this.theReviewer = theReviewer;
    }

    public String getThemain_thesisName() {
        return themain_thesisName;
    }

    public void setThemain_thesisName(String themain_thesisName) {
        this.themain_thesisName = themain_thesisName;
    }

    public String getTheTransCooperation() {
        return theTransCooperation;
    }

    public void setTheTransCooperation(String theTransCooperation) {
        this.theTransCooperation = theTransCooperation;
    }

    public String isThePubmain_licatinNumber() {
        return thePubmain_licatinNumber;
    }

    public void setThePubmain_licatinNumber(String thePubmain_licatinNumber) {
        this.thePubmain_licatinNumber = thePubmain_licatinNumber;
    }

    public String getThePublishingcountry() {
        return thePublishingcountry;
    }

    public void setThePublishingcountry(String thePublishingcountry) {
        this.thePublishingcountry = thePublishingcountry;
    }

    public String getThePublishMonth() {
        return thePublishMonth;
    }

    public void setThePublishMonth(String thePublishMonth) {
        this.thePublishMonth = thePublishMonth;
    }

    public String getThePublishYear() {
        return thePublishYear;
    }

    public void setThePublishYear(String thePublishYear) {
        this.thePublishYear = thePublishYear;
    }

    public String getThePublishType() {
        return thePublishType;
    }

    public void setThePublishType(String thePublishType) {
        this.thePublishType = thePublishType;
    }

    public String getTheProject() {
        return theProject;
    }

    public void setTheProject(String theProject) {
        this.theProject = theProject;
    }

}
