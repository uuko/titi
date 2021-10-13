package com.alin.titi.model.api.request;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class TechCompanyRequest {
    private String tecTransferVendor ="";
    private String tecTransferAmount  ="";
    private Date tecStratDate;
    private Date tecEndDate;
    private Date tecTransferNumber ;
    private Integer tecId=0;


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

    public Date getTecEndDate() {
        return tecEndDate;
    }

    public void setTecEndDate(Date tecEndDate) {
        this.tecEndDate = tecEndDate;
    }

    public Date getTecTransferNumber() {
        return tecTransferNumber;
    }

    public void setTecTransferNumber(Date tecTransferNumber) {
        this.tecTransferNumber = tecTransferNumber;
    }

    public Integer getTecId() {
        return tecId;
    }

    public void setTecId(Integer tecId) {
        this.tecId = tecId;
    }


}
