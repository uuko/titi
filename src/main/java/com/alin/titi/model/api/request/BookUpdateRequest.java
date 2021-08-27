package com.alin.titi.model.api.request;

public class BookUpdateRequest {

    private Integer loginId;
    private Integer infNumber;

    private Integer infYear;
    private String  infCategory;
    private String  infWhemain_ther;
    private String  infName;
    private String  infAudit;
    private String  infLanguage;
    private String  infCoop;
    private String  infAuthorOrder;
    private Integer  infPubmain_licYear;
    private Integer  infPubmain_licMonth;
    private String infPublishHouse;
    private String infISBN;
    private String infPlan;
    private boolean isPublic=false;
    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public Integer getInfNumber() {
        return infNumber;
    }

    public void setInfNumber(Integer infNumber) {
        this.infNumber = infNumber;
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

    public String getInfWhemain_ther() {
        return infWhemain_ther;
    }

    public void setInfWhemain_ther(String infWhemain_ther) {
        this.infWhemain_ther = infWhemain_ther;
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

    public Integer getInfPubmain_licYear() {
        return infPubmain_licYear;
    }

    public void setInfPubmain_licYear(Integer infPubmain_licYear) {
        this.infPubmain_licYear = infPubmain_licYear;
    }

    public Integer getInfPubmain_licMonth() {
        return infPubmain_licMonth;
    }

    public void setInfPubmain_licMonth(Integer infPubmain_licMonth) {
        this.infPubmain_licMonth = infPubmain_licMonth;
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
