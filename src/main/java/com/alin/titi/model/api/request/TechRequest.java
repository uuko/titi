package com.alin.titi.model.api.request;

import java.util.Date;

public class TechRequest {
    private Integer loginId;
    //
    private Integer tecYear;
    private String  tecTransfer;
    private String  tecTransferName;
    private String  tecTransferVendor;
    private String  tecTransferAmount;
    private Date tecStratDate;
    private Integer  tecTransferNumber;
    private String  tecContentPatent;
    private Integer  tecPatentNumber;

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public Integer getTecYear() {
        return tecYear;
    }

    public void setTecYear(Integer tecYear) {
        this.tecYear = tecYear;
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
}
