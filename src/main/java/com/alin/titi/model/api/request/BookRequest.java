package com.alin.titi.model.api.request;

public class BookRequest {

    private Integer loginId;

    private Integer infYear;
    private String  infCategory;
    private String  infWhemainTher;
    private String  infName;
    private String  infAudit;
    private String  infLanguage;
    private String  infCoop;
    private String  infAuthorOrder;
    private String  infPubmainLicYear;
    private String  infPubmainLicMonth;
    private String infPublishHouse;

    private String infISBN;
    private String infPlan;
    private boolean ispublic=false;

    private String infCorreAuthor;

    public String getinfCorreAuthor() {
        return infCorreAuthor;
    }

    public void setinfCorreAuthor(String bookCorreAuthor) {
        this.infCorreAuthor = bookCorreAuthor;
    }

    public boolean ispublic() {
        return ispublic;
    }

    public void setPublic(boolean aPublic) {
        ispublic = aPublic;
    }
    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public Integer getInfYear() {
        return infYear;
    }

    public void setInfYear(Integer infYear) {
        this.infYear = infYear;
    }

    public String getInfCategory() {
        return infCategory;
    }

    public void setInfCategory(String infCategory) {
        this.infCategory = infCategory;
    }

    public String getInfWhemainTher() {
        return infWhemainTher;
    }

    public void setInfWhemainTher(String infWhemainTher) {
        this.infWhemainTher = infWhemainTher;
    }

    public String getInfName() {
        return infName;
    }

    public void setInfName(String infName) {
        this.infName = infName;
    }

    public String getInfAudit() {
        return infAudit;
    }

    public void setInfAudit(String infAudit) {
        this.infAudit = infAudit;
    }

    public String getInfLanguage() {
        return infLanguage;
    }

    public void setInfLanguage(String infLanguage) {
        this.infLanguage = infLanguage;
    }

    public String getInfCoop() {
        return infCoop;
    }

    public void setInfCoop(String infCoop) {
        this.infCoop = infCoop;
    }

    public String getInfAuthorOrder() {
        return infAuthorOrder;
    }

    public void setInfAuthorOrder(String infAuthorOrder) {
        this.infAuthorOrder = infAuthorOrder;
    }

    public String getInfPubmainLicYear() {
        return infPubmainLicYear;
    }

    public void setInfPubmainLicYear(String infPubmainLicYear) {
        this.infPubmainLicYear = infPubmainLicYear;
    }

    public String getInfPubmainLicMonth() {
        return infPubmainLicMonth;
    }

    public void setInfPubmainLicMonth(String infPubmainLicMonth) {
        this.infPubmainLicMonth = infPubmainLicMonth;
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

    public String getInfPlan() {
        return infPlan;
    }

    public void setInfPlan(String infPlan) {
        this.infPlan = infPlan;
    }
}
