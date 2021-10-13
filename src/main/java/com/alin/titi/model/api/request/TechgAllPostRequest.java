package com.alin.titi.model.api.request;

import com.alin.titi.model.TechChgeCompanyModel;

import java.util.ArrayList;
import java.util.List;

public class TechgAllPostRequest {


    private Integer loginId=0;
    private Integer tecId ;
    private String tecTransfer="";
    private String tecTransferName="" ;
    private String tecContentPatent ="" ;
    private String tecNumber="";
    public String getTecNumber() {
        return tecNumber;
    }

    public void setTecNumber(String tecNumber) {
        this.tecNumber = tecNumber;
    }



    public Integer getTecId() {
        return tecId;
    }

    public void setTecId(Integer tecId) {
        this.tecId = tecId;
    }
    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
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

    public String getTecContentPatent() {
        return tecContentPatent;
    }

    public void setTecContentPatent(String tecContentPatent) {
        this.tecContentPatent = tecContentPatent;
    }


}
