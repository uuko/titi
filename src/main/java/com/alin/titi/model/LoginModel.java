package com.alin.titi.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "main_login")
public class LoginModel {
    public LoginModel() {
    }

    public LoginModel(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String account="";

    private String password="";
    private String grade="";
    private int numberOfmain_logins=0;
    private Date lastTime=null;
    private String headUrl="";




    @OneToMany()
    private Set<RegisterTeacherModel> teacherModels = new HashSet<>();

    public Set<RegisterTeacherModel> getTeacherModels() {
        return teacherModels;
    }

    public void setTeacherModels(Set<RegisterTeacherModel> teacherModels) {
        this.teacherModels = teacherModels;
    }

    @OneToMany()
    private Set<LicenseModel> licenseModels = new HashSet<>();

    public Set<LicenseModel> getLicenseModels() {
        return licenseModels;
    }

    public void setLicenseModels(Set<LicenseModel> licenseModels) {
        this.licenseModels = licenseModels;
    }

    //
    @OneToMany()
    private Set<PaperModel> paperModels = new HashSet<>();

    public Set<PaperModel> getPaperModels() {
        return paperModels;
    }

    public void setPaperModels(Set<PaperModel> paperModels) {
        this.paperModels = paperModels;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getNumberOfmain_logins() {
        return numberOfmain_logins;
    }

    public void setNumberOfmain_logins(int numberOfmain_logins) {
        this.numberOfmain_logins = numberOfmain_logins;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }





}
