package com.alin.titi.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "main_tech_change")
public class TechChangeModel {
    public TechChangeModel(Integer tecId) {
        this.tecId = tecId;
    }
    public TechChangeModel() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tecId ;

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    @Column(name = "open")
    private boolean open=false ;
    @NotNull
    @Column(name = "tecTransfer",columnDefinition = "")
    private String tecTransfer="";

    @NotNull
    @Column(name = "tecTransferName",columnDefinition = "")
    private String tecTransferName="" ;

    @Column(name = "tecContentPatent",columnDefinition = "")
    private String tecContentPatent ="" ;

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

    public String getTecNumber() {
        return tecNumber;
    }

    public void setTecNumber(String tecNumber) {
        this.tecNumber = tecNumber;
    }

    public Set<TechChgeCompanyModel> getTechChgeCompanyModels() {
        return techChgeCompanyModels;
    }

    public void setTechChgeCompanyModels(Set<TechChgeCompanyModel> techChgeCompanyModels) {
        this.techChgeCompanyModels = techChgeCompanyModels;
    }

    public LoginModel getLoginModel() {
        return loginModel;
    }

    public void setLoginModel(LoginModel loginModel) {
        this.loginModel = loginModel;
    }

    @Column(name = "tecNumber",columnDefinition = "")
    private String tecNumber  ="" ;

    @OneToMany()
    private Set<TechChgeCompanyModel>
            techChgeCompanyModels = new HashSet<>();


    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    private LoginModel loginModel ;
}
