package com.alin.titi.model.api.request;

public class AdminChangeAuthorityRequest {
    private Integer loginId;
    private String grade;

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
