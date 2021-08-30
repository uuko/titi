package com.alin.titi.model.api.request;

import java.util.Date;

public class GovPostRequest {
    private Integer govId;
    private Integer loginId;
    private Date govFD;
    private String govYear;
    private String govProbjectType;
    private String govProbjectNumber;
    private String govProjectName;
    private String govProjectType;
    private String govProjectNature;
    private Date govStdAllowance;
    private String govJobType;

    private String govProjectAmount;
    private String govmain_govAmount;
    private Integer govEntAmount;
    private Integer govSchAmount;
    private String govMainfund;
    private String govSecAund;
    private String govMoneyState;
    private String govBenefitDepartment;
    private String govComUnit;
    private String govTeamworkUnit;
    private String govOthIn;
    private String govUnitName;
    private boolean isPublic=false;
    private boolean govToOth;
    public boolean isGovToOth() {
        return govToOth;
    }

    public void setGovToOth(boolean govToOth) {
        this.govToOth = govToOth;
    }

    public Integer getGovId() {
        return govId;
    }

    public void setGovId(Integer govId) {
        this.govId = govId;
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public Date getGovFD() {
        return govFD;
    }

    public void setGovFD(Date govFD) {
        this.govFD = govFD;
    }

    public String getGovYear() {
        return govYear;
    }

    public void setGovYear(String govYear) {
        this.govYear = govYear;
    }

    public String getGovProbjectType() {
        return govProbjectType;
    }

    public void setGovProbjectType(String govProbjectType) {
        this.govProbjectType = govProbjectType;
    }

    public String getGovProbjectNumber() {
        return govProbjectNumber;
    }

    public void setGovProbjectNumber(String govProbjectNumber) {
        this.govProbjectNumber = govProbjectNumber;
    }

    public String getGovProjectName() {
        return govProjectName;
    }

    public void setGovProjectName(String govProjectName) {
        this.govProjectName = govProjectName;
    }

    public String getGovProjectType() {
        return govProjectType;
    }

    public void setGovProjectType(String govProjectType) {
        this.govProjectType = govProjectType;
    }

    public String getGovProjectNature() {
        return govProjectNature;
    }

    public void setGovProjectNature(String govProjectNature) {
        this.govProjectNature = govProjectNature;
    }

    public Date getGovStdAllowance() {
        return govStdAllowance;
    }

    public void setGovStdAllowance(Date govStdAllowance) {
        this.govStdAllowance = govStdAllowance;
    }

    public String getGovJobType() {
        return govJobType;
    }

    public void setGovJobType(String govJobType) {
        this.govJobType = govJobType;
    }

    public String getGovProjectAmount() {
        return govProjectAmount;
    }

    public void setGovProjectAmount(String govProjectAmount) {
        this.govProjectAmount = govProjectAmount;
    }

    public String getGovmain_govAmount() {
        return govmain_govAmount;
    }

    public void setGovmain_govAmount(String govmain_govAmount) {
        this.govmain_govAmount = govmain_govAmount;
    }

    public Integer getGovEntAmount() {
        return govEntAmount;
    }

    public void setGovEntAmount(Integer govEntAmount) {
        this.govEntAmount = govEntAmount;
    }

    public Integer getGovSchAmount() {
        return govSchAmount;
    }

    public void setGovSchAmount(Integer govSchAmount) {
        this.govSchAmount = govSchAmount;
    }

    public String getGovMainfund() {
        return govMainfund;
    }

    public void setGovMainfund(String govMainfund) {
        this.govMainfund = govMainfund;
    }

    public String getGovSecAund() {
        return govSecAund;
    }

    public void setGovSecAund(String govSecAund) {
        this.govSecAund = govSecAund;
    }

    public String getGovMoneyState() {
        return govMoneyState;
    }

    public void setGovMoneyState(String govMoneyState) {
        this.govMoneyState = govMoneyState;
    }

    public String getGovBenefitDepartment() {
        return govBenefitDepartment;
    }

    public void setGovBenefitDepartment(String govBenefitDepartment) {
        this.govBenefitDepartment = govBenefitDepartment;
    }

    public String getGovComUnit() {
        return govComUnit;
    }

    public void setGovComUnit(String govComUnit) {
        this.govComUnit = govComUnit;
    }

    public String getGovTeamworkUnit() {
        return govTeamworkUnit;
    }

    public void setGovTeamworkUnit(String govTeamworkUnit) {
        this.govTeamworkUnit = govTeamworkUnit;
    }

    public String getGovOthIn() {
        return govOthIn;
    }

    public void setGovOthIn(String govOthIn) {
        this.govOthIn = govOthIn;
    }

    public String getGovUnitName() {
        return govUnitName;
    }

    public void setGovUnitName(String govUnitName) {
        this.govUnitName = govUnitName;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
}
