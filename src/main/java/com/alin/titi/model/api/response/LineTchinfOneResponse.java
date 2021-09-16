package com.alin.titi.model.api.response;

import io.swagger.models.auth.In;

public class LineTchinfOneResponse {


    //tchinf
    private String infName;
    private Integer infPubmainLicYear;
    private String infCategory;
    private String infAuthorOrder;
    private String infPublishHouse;
    private String infISBN;

    public String getInfName() {
        return infName;
    }

    public void setInfName(String infName) {
        this.infName = infName;
    }

    public Integer getInfPubmainLicYear() {
        return infPubmainLicYear;
    }

    public void setInfPubmainLicYear(Integer infPubmainLicYear) {
        this.infPubmainLicYear = infPubmainLicYear;
    }

    public String getInfCategory() {
        return infCategory;
    }

    public void setInfCategory(String infCategory) {
        this.infCategory = infCategory;
    }

    public String getInfAuthorOrder() {
        return infAuthorOrder;
    }

    public void setInfAuthorOrder(String infAuthorOrder) {
        this.infAuthorOrder = infAuthorOrder;
    }

    public String getInfPublishHouse() {
        return infPublishHouse;
    }

    public void setInfPublishHouse(String infPublishHouse) {
        this.infPublishHouse = infPublishHouse;
    }

    public String getInfISBN() {
        return infISBN;
    }

    public void setInfISBN(String infISBN) {
        this.infISBN = infISBN;
    }
}
