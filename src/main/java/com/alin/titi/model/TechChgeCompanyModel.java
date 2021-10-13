package com.alin.titi.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "tech_change_company")
public class TechChgeCompanyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tecCompanyId ;

    @Column(name = "tecTransferVendor",columnDefinition = "")
    private String tecTransferVendor ="";

    @Column(name = "tecTransferAmount",columnDefinition = "")
    private String tecTransferAmount  ="";

    @NotNull
    @Column(name = "tecStratDate",columnDefinition = "")
    private Date tecStratDate;

    @NotNull
    @Column(name = "tecEndDate",columnDefinition = "")
    private Date tecEndDate;

    @NotNull
    @Column(name = "tecTransferNumber ",columnDefinition = "")
    private Date tecTransferNumber ;

    public Integer getTecCompanyId() {
        return tecCompanyId;
    }

    public void setTecCompanyId(Integer tecCompanyId) {
        this.tecCompanyId = tecCompanyId;
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

    public TechChangeModel getTechChangeModel() {
        return techChangeModel;
    }

    public void setTechChangeModel(TechChangeModel techChangeModel) {
        this.techChangeModel = techChangeModel;
    }

    @ManyToOne
    @JoinColumn(name="tecId", nullable=false)
    private TechChangeModel techChangeModel ;
}
