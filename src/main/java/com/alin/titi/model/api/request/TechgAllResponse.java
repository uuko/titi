package com.alin.titi.model.api.request;

import com.alin.titi.model.TechChgeCompanyModel;
import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

public class TechgAllResponse {

    private Integer tecId ;
    private String tecTransfer="";
    private String tecTransferName="" ;
    private String tecContentPatent ="" ;
    private List<TechChgRequest> techChgeCompanyModelList=new ArrayList<>();
    public Integer getTecId() {
        return tecId;
    }

    public void setTecId(Integer tecId) {
        this.tecId = tecId;
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

    public List<TechChgRequest> getTechChgeCompanyModelList() {
        return techChgeCompanyModelList;
    }

    public void setTechChgeCompanyModelList(List<TechChgRequest> techChgeCompanyModelList) {
        this.techChgeCompanyModelList = techChgeCompanyModelList;
    }


}
