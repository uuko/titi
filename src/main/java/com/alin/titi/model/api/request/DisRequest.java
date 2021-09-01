package com.alin.titi.model.api.request;

import java.util.Date;

public class DisRequest {
    private Integer loginId;
    private String dismainThesisName;
    private boolean disReviewer;
    private String disAuthor;
    private String disCorreAuthor;
    private String disSeminarName;
    private String disHostCountry;
    private String disHostCity;
    private Date disFD;
    private String disProject;
    private String disPublishY;
    private String disCollection;
    private boolean disIsCountry;
    private Date disED;
    private String main_disYear;
    private boolean ispublic=false;

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public String getDismainThesisName() {
        return dismainThesisName;
    }

    public void setDismainThesisName(String dismainThesisName) {
        this.dismainThesisName = dismainThesisName;
    }

    public boolean isDisReviewer() {
        return disReviewer;
    }

    public void setDisReviewer(boolean disReviewer) {
        this.disReviewer = disReviewer;
    }

    public String getDisAuthor() {
        return disAuthor;
    }

    public void setDisAuthor(String disAuthor) {
        this.disAuthor = disAuthor;
    }

    public String getDisCorreAuthor() {
        return disCorreAuthor;
    }

    public void setDisCorreAuthor(String disCorreAuthor) {
        this.disCorreAuthor = disCorreAuthor;
    }

    public String getDisSeminarName() {
        return disSeminarName;
    }

    public void setDisSeminarName(String disSeminarName) {
        this.disSeminarName = disSeminarName;
    }

    public String getDisHostCountry() {
        return disHostCountry;
    }

    public void setDisHostCountry(String disHostCountry) {
        this.disHostCountry = disHostCountry;
    }

    public String getDisHostCity() {
        return disHostCity;
    }

    public void setDisHostCity(String disHostCity) {
        this.disHostCity = disHostCity;
    }

    public Date getDisFD() {
        return disFD;
    }

    public void setDisFD(Date disFD) {
        this.disFD = disFD;
    }

    public String getDisProject() {
        return disProject;
    }

    public void setDisProject(String disProject) {
        this.disProject = disProject;
    }

    public String getDisPublishY() {
        return disPublishY;
    }

    public void setDisPublishY(String disPublishY) {
        this.disPublishY = disPublishY;
    }

    public String getDisCollection() {
        return disCollection;
    }

    public void setDisCollection(String disCollection) {
        this.disCollection = disCollection;
    }

    public boolean isDisIsCountry() {
        return disIsCountry;
    }

    public void setDisIsCountry(boolean disIsCountry) {
        this.disIsCountry = disIsCountry;
    }

    public Date getDisED() {
        return disED;
    }

    public void setDisED(Date disED) {
        this.disED = disED;
    }

    public String getMain_disYear() {
        return main_disYear;
    }

    public void setMain_disYear(String main_disYear) {
        this.main_disYear = main_disYear;
    }

    public boolean ispublic() {
        return ispublic;
    }

    public void setpublic(boolean aPublic) {
        ispublic = aPublic;
    }
}
