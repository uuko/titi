package com.alin.titi.model;

import com.alin.titi.model.LoginModel;

import javax.persistence.*;

@Entity(name = "main_tchinf")
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    private Integer tchYear;
    private Integer tchSemester;
    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    private LoginModel loginModel ;

    private boolean open=false;

    private String infCorreAuthor;

    public String getinfCorreAuthor() {
        return infCorreAuthor;
    }

    public void setinfCorreAuthor(String bookCorreAuthor) {
        this.infCorreAuthor = bookCorreAuthor;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }




    public Integer getInfNumber() {
        return infNumber;
    }

    public void setInfNumber(Integer infNumber) {
        this.infNumber = infNumber;
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
