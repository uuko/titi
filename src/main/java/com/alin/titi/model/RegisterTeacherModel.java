package com.alin.titi.model;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "main_teacherbasedata")
public class RegisterTeacherModel  {

    @EmbeddedId
    private TeacherRelationPK teacherRelationPK;

    private String tchMainDepartment;
    private char tchIdType;
    private char tchIdNumberI;
    private char tchCountry;
    private String tchName;
    private String tchNameEN;
    private char Sex;
    private Date tchBirthday;
    private char tchIsAboriginal;
    private char tchAboriginal;
    private char tchCoeDepartment;
    private String eMail;
    private String tchState;
    private Date tchHureDate;
    private Date tchSchDate;
    private String tchOriginalUnit;
    private Date tchResignDate;
    private String tchAppointDate;
    private Date tchStopDate;
    private Date tchReinstateDate;
    private char tchEstablishment;
    private char tchKind;
    private char tchKindIndustry;
    private String tchKindDepartment;
    private char tchSceWhemain_ther;
    private String tchScePurpose;
    private String tchSecUnit;
    private String tchPartAdmini;
    private String tchAdminiJob;
    private char tchSchoolType;
    private String tchSchool;
    private String tchDepartment;
    private char tchDiploma;
    private String tchExpertise;
    private char tchType;
    private char tchRireRank;
    private char tchRireYear;
    private String tchCertificateRank;
    private String tchHireNumber;
    private String tchCertificateNumber;
    private String tchmain_licenseNumber;
    private String tchEvaNumber;
    private char tch106PaySalary;
    private char tch107PaySalary;
    private char tchFiestAssistant;
    private char tchFullTime;
    private char tchSixtyFive;
    private char tchTwoFour;
    private char tchComplyLaw;
    private String tchFullPartPosition;
    private char tchTow;

    private char tchIdNumberR;
    private char tchIdNumberP;
    private String tchValidationStatus;

    public TeacherRelationPK getTeacherRelationPK() {
        return teacherRelationPK;
    }

    public void setTeacherRelationPK(TeacherRelationPK teacherRelationPK) {
        this.teacherRelationPK = teacherRelationPK;
    }

    public String getTchMainDepartment() {
        return tchMainDepartment;
    }

    public void setTchMainDepartment(String tchMainDepartment) {
        this.tchMainDepartment = tchMainDepartment;
    }

    public char getTchIdType() {
        return tchIdType;
    }

    public void setTchIdType(char tchIdType) {
        this.tchIdType = tchIdType;
    }

    public char getTchIdNumberI() {
        return tchIdNumberI;
    }

    public void setTchIdNumberI(char tchIdNumberI) {
        this.tchIdNumberI = tchIdNumberI;
    }

    public char getTchCountry() {
        return tchCountry;
    }

    public void setTchCountry(char tchCountry) {
        this.tchCountry = tchCountry;
    }

    public String getTchName() {
        return tchName;
    }

    public void setTchName(String tchName) {
        this.tchName = tchName;
    }

    public String getTchNameEN() {
        return tchNameEN;
    }

    public void setTchNameEN(String tchNameEN) {
        this.tchNameEN = tchNameEN;
    }

    public char getSex() {
        return Sex;
    }

    public void setSex(char sex) {
        Sex = sex;
    }

    public Date getTchBirthday() {
        return tchBirthday;
    }

    public void setTchBirthday(Date tchBirthday) {
        this.tchBirthday = tchBirthday;
    }

    public char getTchIsAboriginal() {
        return tchIsAboriginal;
    }

    public void setTchIsAboriginal(char tchIsAboriginal) {
        this.tchIsAboriginal = tchIsAboriginal;
    }

    public char getTchAboriginal() {
        return tchAboriginal;
    }

    public void setTchAboriginal(char tchAboriginal) {
        this.tchAboriginal = tchAboriginal;
    }

    public char getTchCoeDepartment() {
        return tchCoeDepartment;
    }

    public void setTchCoeDepartment(char tchCoeDepartment) {
        this.tchCoeDepartment = tchCoeDepartment;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getTchState() {
        return tchState;
    }

    public void setTchState(String tchState) {
        this.tchState = tchState;
    }

    public Date getTchHureDate() {
        return tchHureDate;
    }

    public void setTchHureDate(Date tchHureDate) {
        this.tchHureDate = tchHureDate;
    }

    public Date getTchSchDate() {
        return tchSchDate;
    }

    public void setTchSchDate(Date tchSchDate) {
        this.tchSchDate = tchSchDate;
    }

    public String getTchOriginalUnit() {
        return tchOriginalUnit;
    }

    public void setTchOriginalUnit(String tchOriginalUnit) {
        this.tchOriginalUnit = tchOriginalUnit;
    }

    public Date getTchResignDate() {
        return tchResignDate;
    }

    public void setTchResignDate(Date tchResignDate) {
        this.tchResignDate = tchResignDate;
    }

    public String getTchAppointDate() {
        return tchAppointDate;
    }

    public void setTchAppointDate(String tchAppointDate) {
        this.tchAppointDate = tchAppointDate;
    }

    public Date getTchStopDate() {
        return tchStopDate;
    }

    public void setTchStopDate(Date tchStopDate) {
        this.tchStopDate = tchStopDate;
    }

    public Date getTchReinstateDate() {
        return tchReinstateDate;
    }

    public void setTchReinstateDate(Date tchReinstateDate) {
        this.tchReinstateDate = tchReinstateDate;
    }

    public char getTchEstablishment() {
        return tchEstablishment;
    }

    public void setTchEstablishment(char tchEstablishment) {
        this.tchEstablishment = tchEstablishment;
    }

    public char getTchKind() {
        return tchKind;
    }

    public void setTchKind(char tchKind) {
        this.tchKind = tchKind;
    }

    public char getTchKindIndustry() {
        return tchKindIndustry;
    }

    public void setTchKindIndustry(char tchKindIndustry) {
        this.tchKindIndustry = tchKindIndustry;
    }

    public String getTchKindDepartment() {
        return tchKindDepartment;
    }

    public void setTchKindDepartment(String tchKindDepartment) {
        this.tchKindDepartment = tchKindDepartment;
    }

    public char getTchSceWhemain_ther() {
        return tchSceWhemain_ther;
    }

    public void setTchSceWhemain_ther(char tchSceWhemain_ther) {
        this.tchSceWhemain_ther = tchSceWhemain_ther;
    }

    public String getTchScePurpose() {
        return tchScePurpose;
    }

    public void setTchScePurpose(String tchScePurpose) {
        this.tchScePurpose = tchScePurpose;
    }

    public String getTchSecUnit() {
        return tchSecUnit;
    }

    public void setTchSecUnit(String tchSecUnit) {
        this.tchSecUnit = tchSecUnit;
    }

    public String getTchPartAdmini() {
        return tchPartAdmini;
    }

    public void setTchPartAdmini(String tchPartAdmini) {
        this.tchPartAdmini = tchPartAdmini;
    }

    public String getTchAdminiJob() {
        return tchAdminiJob;
    }

    public void setTchAdminiJob(String tchAdminiJob) {
        this.tchAdminiJob = tchAdminiJob;
    }

    public char getTchSchoolType() {
        return tchSchoolType;
    }

    public void setTchSchoolType(char tchSchoolType) {
        this.tchSchoolType = tchSchoolType;
    }

    public String getTchSchool() {
        return tchSchool;
    }

    public void setTchSchool(String tchSchool) {
        this.tchSchool = tchSchool;
    }

    public String getTchDepartment() {
        return tchDepartment;
    }

    public void setTchDepartment(String tchDepartment) {
        this.tchDepartment = tchDepartment;
    }

    public char getTchDiploma() {
        return tchDiploma;
    }

    public void setTchDiploma(char tchDiploma) {
        this.tchDiploma = tchDiploma;
    }

    public String getTchExpertise() {
        return tchExpertise;
    }

    public void setTchExpertise(String tchExpertise) {
        this.tchExpertise = tchExpertise;
    }

    public char getTchType() {
        return tchType;
    }

    public void setTchType(char tchType) {
        this.tchType = tchType;
    }

    public char getTchRireRank() {
        return tchRireRank;
    }

    public void setTchRireRank(char tchRireRank) {
        this.tchRireRank = tchRireRank;
    }

    public char getTchRireYear() {
        return tchRireYear;
    }

    public void setTchRireYear(char tchRireYear) {
        this.tchRireYear = tchRireYear;
    }

    public String getTchCertificateRank() {
        return tchCertificateRank;
    }

    public void setTchCertificateRank(String tchCertificateRank) {
        this.tchCertificateRank = tchCertificateRank;
    }

    public String getTchHireNumber() {
        return tchHireNumber;
    }

    public void setTchHireNumber(String tchHireNumber) {
        this.tchHireNumber = tchHireNumber;
    }

    public String getTchCertificateNumber() {
        return tchCertificateNumber;
    }

    public void setTchCertificateNumber(String tchCertificateNumber) {
        this.tchCertificateNumber = tchCertificateNumber;
    }

    public String getTchmain_licenseNumber() {
        return tchmain_licenseNumber;
    }

    public void setTchmain_licenseNumber(String tchmain_licenseNumber) {
        this.tchmain_licenseNumber = tchmain_licenseNumber;
    }

    public String getTchEvaNumber() {
        return tchEvaNumber;
    }

    public void setTchEvaNumber(String tchEvaNumber) {
        this.tchEvaNumber = tchEvaNumber;
    }

    public char getTch106PaySalary() {
        return tch106PaySalary;
    }

    public void setTch106PaySalary(char tch106PaySalary) {
        this.tch106PaySalary = tch106PaySalary;
    }

    public char getTch107PaySalary() {
        return tch107PaySalary;
    }

    public void setTch107PaySalary(char tch107PaySalary) {
        this.tch107PaySalary = tch107PaySalary;
    }

    public char getTchFiestAssistant() {
        return tchFiestAssistant;
    }

    public void setTchFiestAssistant(char tchFiestAssistant) {
        this.tchFiestAssistant = tchFiestAssistant;
    }

    public char getTchFullTime() {
        return tchFullTime;
    }

    public void setTchFullTime(char tchFullTime) {
        this.tchFullTime = tchFullTime;
    }

    public char getTchSixtyFive() {
        return tchSixtyFive;
    }

    public void setTchSixtyFive(char tchSixtyFive) {
        this.tchSixtyFive = tchSixtyFive;
    }

    public char getTchTwoFour() {
        return tchTwoFour;
    }

    public void setTchTwoFour(char tchTwoFour) {
        this.tchTwoFour = tchTwoFour;
    }

    public char getTchComplyLaw() {
        return tchComplyLaw;
    }

    public void setTchComplyLaw(char tchComplyLaw) {
        this.tchComplyLaw = tchComplyLaw;
    }

    public String getTchFullPartPosition() {
        return tchFullPartPosition;
    }

    public void setTchFullPartPosition(String tchFullPartPosition) {
        this.tchFullPartPosition = tchFullPartPosition;
    }

    public char getTchTow() {
        return tchTow;
    }

    public void setTchTow(char tchTow) {
        this.tchTow = tchTow;
    }

    public char getTchIdNumberR() {
        return tchIdNumberR;
    }

    public void setTchIdNumberR(char tchIdNumberR) {
        this.tchIdNumberR = tchIdNumberR;
    }

    public char getTchIdNumberP() {
        return tchIdNumberP;
    }

    public void setTchIdNumberP(char tchIdNumberP) {
        this.tchIdNumberP = tchIdNumberP;
    }

    public String getTchValidationStatus() {
        return tchValidationStatus;
    }

    public void setTchValidationStatus(String tchValidationStatus) {
        this.tchValidationStatus = tchValidationStatus;
    }
}
