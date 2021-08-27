package com.alin.titi.model;

import io.swagger.models.auth.In;

import javax.persistence.*;
import java.util.Date;
@Entity(name = "main_technologytransfer")
public class TechModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tecSkillNumber;
    private Integer tecYear;

    private String  tecTransfer;
    private String  tecTransferName;
    private String  tecTransferVendor;
    private String  tecTransferAmount;
    private Date tecStratDate;
    private Integer  tecTransferNumber;
    private String  tecContentPatent;
    private Integer  tecPatentNumber;

    private Integer tchYear;
    private Integer tchSemester;
    private boolean isPublic=false;
    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    private LoginModel loginModel ;

    public Integer getTecSkillNumber() {
        return tecSkillNumber;
    }
    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
    public void setTecSkillNumber(Integer tecSkillNumber) {
        this.tecSkillNumber = tecSkillNumber;
    }

    public Integer getTecYear() {
        return tecYear;
    }

    public void setTecYear(Integer tecYear) {
        this.tecYear = tecYear;
    }

    public Integer getTchSemester() {
        return tchSemester;
    }

    public void setTchSemester(Integer tchSemester) {
        this.tchSemester = tchSemester;
    }

    public Integer getTchYear() {
        return tchYear;
    }

    public void setTchYear(Integer tchYear) {
        this.tchYear = tchYear;
    }

    public String getTecTransfer() {
        return tecTransfer;
    }

    public void setTecTransfer(String tecTransfer) {
        this.tecTransfer = tecTransfer;
    }

    public String getTecTransferName() {
        return tecTransferName;
    }

    public void setTecTransferName(String tecTransferName) {
        this.tecTransferName = tecTransferName;
    }

    public String getTecTransferVendor() {
        return tecTransferVendor;
    }

    public void setTecTransferVendor(String tecTransferVendor) {
        this.tecTransferVendor = tecTransferVendor;
    }

    public String getTecTransferAmount() {
        return tecTransferAmount;
    }

    public void setTecTransferAmount(String tecTransferAmount) {
        this.tecTransferAmount = tecTransferAmount;
    }

    public Date getTecStratDate() {
        return tecStratDate;
    }

    public void setTecStratDate(Date tecStratDate) {
        this.tecStratDate = tecStratDate;
    }

    public Integer getTecTransferNumber() {
        return tecTransferNumber;
    }

    public void setTecTransferNumber(Integer tecTransferNumber) {
        this.tecTransferNumber = tecTransferNumber;
    }

    public String getTecContentPatent() {
        return tecContentPatent;
    }

    public void setTecContentPatent(String tecContentPatent) {
        this.tecContentPatent = tecContentPatent;
    }

    public Integer getTecPatentNumber() {
        return tecPatentNumber;
    }

    public void setTecPatentNumber(Integer tecPatentNumber) {
        this.tecPatentNumber = tecPatentNumber;
    }

    public LoginModel getLoginModel() {
        return loginModel;
    }

    public void setLoginModel(LoginModel loginModel) {
        this.loginModel = loginModel;
    }
}
