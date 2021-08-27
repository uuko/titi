package com.alin.titi.model.api.request;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class LicenseRequest {


    private Integer loginId;
    private String licType;
    private String licName;
    private String licService;
    private Integer licNumber;
    private boolean isPublic=false;
    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public String getLicType() {
        return licType;
    }

    public void setLicType(String licType) {
        this.licType = licType;
    }

    public String getLicName() {
        return licName;
    }

    public void setLicName(String licName) {
        this.licName = licName;
    }

    public String getLicService() {
        return licService;
    }

    public void setLicService(String licService) {
        this.licService = licService;
    }

    public Integer getLicNumber() {
        return licNumber;
    }

    public void setLicNumber(Integer licNumber) {
        this.licNumber = licNumber;
    }
}
