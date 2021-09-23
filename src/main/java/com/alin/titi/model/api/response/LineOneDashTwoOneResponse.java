package com.alin.titi.model.api.response;

import java.sql.DatabaseMetaData;
import java.util.Date;

public class LineOneDashTwoOneResponse {



    //onedashtwo
    private String expMechanismName;
    private String expJobtitle;
    private java.util.Date expStartDate;
    private java.util.Date expStopDate;

    public String getExpMechanismName() {
        return expMechanismName;
    }

    public void setExpMechanismName(String expMechanismName) {
        this.expMechanismName = expMechanismName;
    }

    public String getExpJobtitle() {
        return expJobtitle;
    }

    public void setExpJobtitle(String expJobtitle) {
        this.expJobtitle = expJobtitle;
    }

    public java.util.Date getExpStartDate() {
        return expStartDate;
    }

    public void setExpStartDate(java.util.Date expStartDate) {
        this.expStartDate = expStartDate;
    }

    public java.util.Date getExpStopDate() {
        return expStopDate;
    }

    public void setExpStopDate(java.util.Date expStopDate) {
        this.expStopDate = expStopDate;
    }
}
