package com.alin.titi.model.api.response;

public class LoginWithGradeResponse {
    public Integer getTchNumber() {
        return tchNumber;
    }

    public void setTchNumber(Integer tchNumber) {
        this.tchNumber = tchNumber;
    }

    private Integer tchNumber;

    private String grade="";

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
