package com.alin.titi.controller;

import com.alin.titi.model.*;
import com.alin.titi.model.api.response.ListTeacherResponse;
import com.alin.titi.model.base.TeacherBaseData;
import com.alin.titi.services.TeacherService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

//teacher register and update and get
@RestController


public class TeacherController {

    @Autowired
    private TeacherService service;

    @GetMapping("/teacher/photo/{tchNumber}")
    public ResponseEntity<?> getTeacherBaseData(@PathVariable Integer tchNumber) {
        TeacherBaseData data = service.getTeacherBaseData(tchNumber);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/teacher/list")
    public ResponseEntity<?> list() {

        List<RegisterTeacherModel> putuserList = service.listAll();
        List<ListTeacherResponse> listTeacherResponseList = new ArrayList<>();

        List<Integer> loginIdList = new ArrayList<>();
        for (RegisterTeacherModel lr : putuserList) {
            if (!loginIdList.contains(lr.getLoginModel().getId())) {
                loginIdList.add(lr.getLoginModel().getId());
            }
        }
        for (Integer id : loginIdList) {
            List<ListTeacherResponse> innerList = new ArrayList<>();
            for (RegisterTeacherModel putuser : putuserList) {
                if (putuser.getLoginModel().getId().equals(id)) {
                    ListTeacherResponse listTeacherResponse = new ListTeacherResponse();
                    listTeacherResponse.setTchNumber(putuser.getTeacherRelationPK().getTchNumber());
                    listTeacherResponse.setTchSemester(putuser.getTeacherRelationPK().getTchSemester());
                    listTeacherResponse.setTchYear(putuser.getTeacherRelationPK().getTchYear());
                    listTeacherResponse.setTchDepartment(putuser.getTchDepartment());
                    listTeacherResponse.setTchPicUrl(putuser.getTchPicUrl());
                    listTeacherResponse.setTchIdType(putuser.getTchIdType());
                    listTeacherResponse.setTchIdNumberI(putuser.getTchIdNumberI());
                    listTeacherResponse.setTchIdNumberR(putuser.getTchIdNumberR());
                    listTeacherResponse.setTchIdNumberP(putuser.getTchIdNumberP());
                    listTeacherResponse.setTchCountry(putuser.getTchCountry());
                    listTeacherResponse.setTchName(putuser.getTchName());
                    listTeacherResponse.setTchNameEN(putuser.getTchNameEN());
                    listTeacherResponse.setSex(putuser.getSex());
                    listTeacherResponse.setTchIsAboriginal(putuser.getTchIsAboriginal());
                    listTeacherResponse.setTchAboriginal(putuser.getTchAboriginal());
                    listTeacherResponse.setTchBirthday(putuser.getTchBirthday());
                    listTeacherResponse.setTchCoeDepartment(putuser.getTchCoeDepartment());
                    listTeacherResponse.seteMail(putuser.geteMail());
                    listTeacherResponse.setTchState(putuser.getTchState());
                    listTeacherResponse.setTchHureDate(putuser.getTchHureDate());
                    listTeacherResponse.setTchSchDate(putuser.getTchSchDate());
                    listTeacherResponse.setTchOriginalUnit(putuser.getTchOriginalUnit());
                    listTeacherResponse.setTchReinstateDate(putuser.getTchReinstateDate());
                    listTeacherResponse.setTchAppointDate(putuser.getTchAppointDate());
                    listTeacherResponse.setTchStopDate(putuser.getTchStopDate());
                    listTeacherResponse.setTchEstablishment(putuser.getTchEstablishment());
                    listTeacherResponse.setTchKind(putuser.getTchKind());
                    listTeacherResponse.setTchKindIndustry(putuser.getTchKindIndustry());
                    listTeacherResponse.setTchKindDepartment(putuser.getTchKindDepartment());
                    listTeacherResponse.setTchSceWhemain_ther(putuser.getTchSceWhemain_ther());
                    //
                    listTeacherResponse.setTchScePurpose(putuser.getTchScePurpose());
                    listTeacherResponse.setTchSecUnit(putuser.getTchSecUnit());
                    listTeacherResponse.setTchPartAdmini(putuser.getTchPartAdmini());
                    listTeacherResponse.setTchAdminiJob(putuser.getTchAdminiJob());
                    listTeacherResponse.setTchSchoolType(putuser.getTchSchoolType());
                    listTeacherResponse.setTchSchool(putuser.getTchSchool());
                    //
                    listTeacherResponse.setTchDepartment(putuser.getTchDepartment());
                    listTeacherResponse.setTchDiploma(putuser.getTchDiploma());
                    listTeacherResponse.setTchExpertise(putuser.getTchExpertise());
                    listTeacherResponse.setTchType(putuser.getTchType());
                    listTeacherResponse.setTchRireRank(putuser.getTchRireRank());
                    //
                    listTeacherResponse.setTchRireYear(putuser.getTchRireYear());
                    listTeacherResponse.setTchCertificateRank(putuser.getTchCertificateRank());
                    listTeacherResponse.setTchCertificateNumber(putuser.getTchCertificateNumber());
                    listTeacherResponse.setTchHireNumber(putuser.getTchHireNumber());
                    listTeacherResponse.setTchCertificateNumber(putuser.getTchCertificateNumber());
                    listTeacherResponse.setTchmain_licenseNumber(putuser.getTchmain_licenseNumber());
                    ;       //
                    listTeacherResponse.setTchEvaNumber(putuser.getTchEvaNumber());
                    listTeacherResponse.setTch106PaySalary(putuser.getTch106PaySalary());
                    listTeacherResponse.setTch107PaySalary(putuser.getTch107PaySalary());
                    listTeacherResponse.setTchFiestAssistant(putuser.getTchFiestAssistant());
                    listTeacherResponse.setTchFullTime(putuser.getTchFullTime());
                    listTeacherResponse.setTchSixtyFive(putuser.getTchSixtyFive());
                    //
                    listTeacherResponse.setTchMainDepartment(putuser.getTchMainDepartment());
                    listTeacherResponse.setTchTwoFour(putuser.getTchTwoFour());
                    listTeacherResponse.setTchComplyLaw(putuser.getTchComplyLaw());
                    listTeacherResponse.setTchFullPartPosition(putuser.getTchFullPartPosition());
                    listTeacherResponse.setTchTow(putuser.getTchTow());
                    listTeacherResponse.setTchValidationStatus(putuser.getTchValidationStatus());
                    listTeacherResponse.setIntroduce(putuser.getIntroduce());


                    //

                    innerList.add(listTeacherResponse);

                }
            }
            Comparator<ListTeacherResponse> m_studentComparator = (lhs, rhs) -> {
                return rhs.getTchYear().compareTo(lhs.getTchYear());  // Descending order
            };
            innerList.sort(m_studentComparator);
            Comparator<ListTeacherResponse> monthComparator = (lhs, rhs) -> {
                return rhs.getTchSemester().compareTo(lhs.getTchSemester());  // Descending order
            };
            innerList.sort(monthComparator);
            if (innerList.size() > 0) {
                listTeacherResponseList.add(innerList.get(0));
            }
        }


        return ResponseEntity.ok(listTeacherResponseList);
    }

    @PostMapping("/teacher/uploadFile")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file

            , @RequestParam("tchNumber") Integer tchNumber

    ) throws Exception {


//        TeacherRelationPK teacherRelationPK=new TeacherRelationPK();
//        teacherRelationPK.setTchNumber(tchNumber);
//        teacherRelationPK.setTchSemester(tchSemester);
//        teacherRelationPK.setTchYear(tchYear);

        String fileName = service.storeNewFile(file, tchNumber);


        String fileDownLoadUrL = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
        UpLoadFileResponse upLoadFileResponse = new UpLoadFileResponse();
        upLoadFileResponse.setPicUrl(fileDownLoadUrL);
        return ResponseEntity.ok(upLoadFileResponse);

    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) throws Exception {

        Resource resource = service.loadFileAsResource(fileName);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {

        }

        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    //update
    @PostMapping("/teacher/{tchNumber}/{tchYear}/{tchSemester}")
    public ResponseEntity<?> update(
            @RequestBody UpdateTeacherModel putuser
            , @PathVariable Integer tchNumber
            , @PathVariable Integer tchYear, @PathVariable Integer tchSemester) {
        try {

            TeacherRelationPK nowYearpk = new TeacherRelationPK();
            int year = Calendar.getInstance().get(Calendar.YEAR) - 1911;
            int month = Calendar.getInstance().get(Calendar.MONTH);
            int semester = 0;
            if (month < 8 && month > 1) {
                semester = 1;
            } else {
                semester = 2;
            }
            //
            if (year == tchYear && semester == tchSemester) {
                TeacherRelationPK teacherRelationPK = new TeacherRelationPK();
                teacherRelationPK.setTchNumber(tchNumber);
                teacherRelationPK.setTchSemester(tchSemester);
                teacherRelationPK.setTchYear(tchYear);
                RegisterTeacherModel teacherModel = service.findByTeacherRelationPK(teacherRelationPK);
                teacherModel.setTchDepartment(putuser.getTchDepartment());
                teacherModel.setTchPicUrl(putuser.getTchPicUrl());
                teacherModel.setTchIdType(putuser.getTchIdType());
                teacherModel.setTchIdNumberI(putuser.getTchIdNumberI());
                teacherModel.setTchIdNumberR(putuser.getTchIdNumberR());
                teacherModel.setTchIdNumberP(putuser.getTchIdNumberP());
                teacherModel.setTchCountry(putuser.getTchCountry());
                teacherModel.setTchName(putuser.getTchName());
                teacherModel.setTchNameEN(putuser.getTchNameEN());
                teacherModel.setSex(putuser.getSex());
                teacherModel.setTchIsAboriginal(putuser.getTchIsAboriginal());
                teacherModel.setTchAboriginal(putuser.getTchAboriginal());
                teacherModel.setTchBirthday(putuser.getTchBirthday());
                teacherModel.setTchCoeDepartment(putuser.getTchCoeDepartment());
                teacherModel.seteMail(putuser.geteMail());
                teacherModel.setTchState(putuser.getTchState());
                teacherModel.setTchHureDate(putuser.getTchHureDate());
                teacherModel.setTchSchDate(putuser.getTchSchDate());
                teacherModel.setTchOriginalUnit(putuser.getTchOriginalUnit());
                teacherModel.setTchReinstateDate(putuser.getTchReinstateDate());
                teacherModel.setTchAppointDate(putuser.getTchAppointDate());
                teacherModel.setTchStopDate(putuser.getTchStopDate());
                teacherModel.setTchEstablishment(putuser.getTchEstablishment());
                teacherModel.setTchKind(putuser.getTchKind());
                teacherModel.setTchKindIndustry(putuser.getTchKindIndustry());
                teacherModel.setTchKindDepartment(putuser.getTchKindDepartment());
                teacherModel.setTchSceWhemain_ther(putuser.getTchSceWhemain_ther());
                //
                teacherModel.setTchScePurpose(putuser.getTchScePurpose());
                teacherModel.setTchSecUnit(putuser.getTchSecUnit());
                teacherModel.setTchPartAdmini(putuser.getTchPartAdmini());
                teacherModel.setTchAdminiJob(putuser.getTchAdminiJob());
                teacherModel.setTchSchoolType(putuser.getTchSchoolType());
                teacherModel.setTchSchool(putuser.getTchSchool());
                //
                teacherModel.setTchDepartment(putuser.getTchDepartment());
                teacherModel.setTchDiploma(putuser.getTchDiploma());
                teacherModel.setTchExpertise(putuser.getTchExpertise());
                teacherModel.setTchType(putuser.getTchType());
                teacherModel.setTchRireRank(putuser.getTchRireRank());
                //
                teacherModel.setTchRireYear(putuser.getTchRireYear());
                teacherModel.setTchCertificateRank(putuser.getTchCertificateRank());
                teacherModel.setTchCertificateNumber(putuser.getTchCertificateNumber());
                teacherModel.setTchHireNumber(putuser.getTchHireNumber());
                teacherModel.setTchCertificateNumber(putuser.getTchCertificateNumber());
                teacherModel.setTchmain_licenseNumber(putuser.getTchmain_licenseNumber());
                ;       //
                teacherModel.setTchEvaNumber(putuser.getTchEvaNumber());
                teacherModel.setTch106PaySalary(putuser.getTch106PaySalary());
                teacherModel.setTch107PaySalary(putuser.getTch107PaySalary());
                teacherModel.setTchFiestAssistant(putuser.getTchFiestAssistant());
                teacherModel.setTchFullTime(putuser.getTchFullTime());
                teacherModel.setTchSixtyFive(putuser.getTchSixtyFive());
                //
                teacherModel.setTchMainDepartment(putuser.getTchMainDepartment());
                teacherModel.setTchTwoFour(putuser.getTchTwoFour());
                teacherModel.setTchComplyLaw(putuser.getTchComplyLaw());
                teacherModel.setTchFullPartPosition(putuser.getTchFullPartPosition());
                teacherModel.setTchTow(putuser.getTchTow());
                teacherModel.setTchValidationStatus(putuser.getTchValidationStatus());
                teacherModel.setIntroduce(putuser.getIntroduce());
                service.updateTeacher(teacherModel);
            } else {

                int nowYear = Calendar.getInstance().get(Calendar.YEAR) - 1911;
                int nowMonth = Calendar.getInstance().get(Calendar.MONTH);
                int nowSemester = 0;
                if (month < 8 && month > 1) {
                    nowSemester = 1;
                } else {
                    nowSemester = 2;
                }
                TeacherRelationPK teacherRelationPK = new TeacherRelationPK();
                teacherRelationPK.setTchNumber(tchNumber);
                teacherRelationPK.setTchSemester(nowSemester);
                teacherRelationPK.setTchYear(nowYear);

                RegisterTeacherModel teacherModel = new RegisterTeacherModel();
                teacherModel.setTeacherRelationPK(teacherRelationPK);
                teacherModel.setTchDepartment(putuser.getTchDepartment());
                teacherModel.setTchPicUrl(putuser.getTchPicUrl());
                teacherModel.setTchIdType(putuser.getTchIdType());
                teacherModel.setTchIdNumberI(putuser.getTchIdNumberI());
                teacherModel.setTchIdNumberR(putuser.getTchIdNumberR());
                teacherModel.setTchIdNumberP(putuser.getTchIdNumberP());
                teacherModel.setTchCountry(putuser.getTchCountry());
                teacherModel.setTchName(putuser.getTchName());
                teacherModel.setTchNameEN(putuser.getTchNameEN());
                teacherModel.setSex(putuser.getSex());
                teacherModel.setTchIsAboriginal(putuser.getTchIsAboriginal());
                teacherModel.setTchAboriginal(putuser.getTchAboriginal());
                teacherModel.setTchBirthday(putuser.getTchBirthday());
                teacherModel.setTchCoeDepartment(putuser.getTchCoeDepartment());
                teacherModel.seteMail(putuser.geteMail());
                teacherModel.setTchState(putuser.getTchState());
                teacherModel.setTchHureDate(putuser.getTchHureDate());
                teacherModel.setTchSchDate(putuser.getTchSchDate());
                teacherModel.setTchOriginalUnit(putuser.getTchOriginalUnit());
                teacherModel.setTchReinstateDate(putuser.getTchReinstateDate());
                teacherModel.setTchAppointDate(putuser.getTchAppointDate());
                teacherModel.setTchStopDate(putuser.getTchStopDate());
                teacherModel.setTchEstablishment(putuser.getTchEstablishment());
                teacherModel.setTchKind(putuser.getTchKind());
                teacherModel.setTchKindIndustry(putuser.getTchKindIndustry());
                teacherModel.setTchKindDepartment(putuser.getTchKindDepartment());
                teacherModel.setTchSceWhemain_ther(putuser.getTchSceWhemain_ther());
                //
                teacherModel.setTchScePurpose(putuser.getTchScePurpose());
                teacherModel.setTchSecUnit(putuser.getTchSecUnit());
                teacherModel.setTchPartAdmini(putuser.getTchPartAdmini());
                teacherModel.setTchAdminiJob(putuser.getTchAdminiJob());
                teacherModel.setTchSchoolType(putuser.getTchSchoolType());
                teacherModel.setTchSchool(putuser.getTchSchool());
                //
                teacherModel.setTchDepartment(putuser.getTchDepartment());
                teacherModel.setTchDiploma(putuser.getTchDiploma());
                teacherModel.setTchExpertise(putuser.getTchExpertise());
                teacherModel.setTchType(putuser.getTchType());
                teacherModel.setTchRireRank(putuser.getTchRireRank());
                //
                teacherModel.setTchRireYear(putuser.getTchRireYear());
                teacherModel.setTchCertificateRank(putuser.getTchCertificateRank());
                teacherModel.setTchCertificateNumber(putuser.getTchCertificateNumber());
                teacherModel.setTchHireNumber(putuser.getTchHireNumber());
                teacherModel.setTchCertificateNumber(putuser.getTchCertificateNumber());
                teacherModel.setTchmain_licenseNumber(putuser.getTchmain_licenseNumber());
                ;       //
                teacherModel.setTchEvaNumber(putuser.getTchEvaNumber());
                teacherModel.setTch106PaySalary(putuser.getTch106PaySalary());
                teacherModel.setTch107PaySalary(putuser.getTch107PaySalary());
                teacherModel.setTchFiestAssistant(putuser.getTchFiestAssistant());
                teacherModel.setTchFullTime(putuser.getTchFullTime());
                teacherModel.setTchSixtyFive(putuser.getTchSixtyFive());
                //
                teacherModel.setTchMainDepartment(putuser.getTchMainDepartment());
                teacherModel.setTchTwoFour(putuser.getTchTwoFour());
                teacherModel.setTchComplyLaw(putuser.getTchComplyLaw());
                teacherModel.setTchFullPartPosition(putuser.getTchFullPartPosition());
                teacherModel.setTchTow(putuser.getTchTow());
                teacherModel.setTchValidationStatus(putuser.getTchValidationStatus());
                teacherModel.setIntroduce(putuser.getIntroduce());
                LoginModel loginModel = new LoginModel();
                loginModel.setId(tchNumber);
                teacherModel.setLoginModel(loginModel);
                service.updateTeacher(teacherModel);
            }


            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //post
    @PostMapping("/teacher/register")
    public void registerTeacher(@RequestBody RegisterBaseModel baseModel) {
        RegisterTeacherModel teacherModel = new RegisterTeacherModel();
        teacherModel.seteMail(baseModel.getAccount());
        teacherModel.setTchName(baseModel.getTchName());
        TeacherRelationPK teacherRelationPK = new TeacherRelationPK();
        int year = Calendar.getInstance().get(Calendar.YEAR) - 1911;
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int semester = 0;
        if (month < 8 && month > 1) {
            semester = 1;
        } else {
            semester = 2;
        }
        teacherRelationPK.setTchYear(year);
        teacherRelationPK.setTchSemester(semester);
        teacherRelationPK.setTchNumber(0);
        teacherModel.setTchName(baseModel.getTchName());
        teacherModel.setTeacherRelationPK(teacherRelationPK);
        service.registerTeacher(teacherModel, baseModel);
        ;

    }


    // get by id
    @GetMapping("/teacher/{loginId}")
    public ResponseEntity<?> getTeacherList(@PathVariable Integer loginId
    ) {
        try {

            return ResponseEntity.ok(service.getTeacherByLoginId(loginId));
        } catch (NoSuchElementException e) {
            return new ResponseEntity<RegisterTeacherModel>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/teacher/logout")
    public ResponseEntity<Void> logout(HttpSession session, SessionStatus sessionStatus) {
        //讓token過期就好
        session.invalidate();
        sessionStatus.setComplete();
        service.logout();

        return ResponseEntity.ok().build();
    }

    @GetMapping("/teacher/{tchNumber}/{tchYear}/{tchSemester}")
    public ResponseEntity<?> getTeacherList(@PathVariable Integer tchNumber
            , @PathVariable Integer tchYear,
                                            @PathVariable Integer tchSemester
    ) {
        try {
            TeacherRelationPK pk = new TeacherRelationPK();
            pk.setTchNumber(tchNumber);
            pk.setTchSemester(tchSemester);
            pk.setTchYear(tchYear);
            RegisterTeacherModel putuser = service.findByTeacherRelationPK(pk);

            ListTeacherResponse listTeacherResponse = new ListTeacherResponse();
            listTeacherResponse.setTchNumber(putuser.getTeacherRelationPK().getTchNumber());
            listTeacherResponse.setTchSemester(putuser.getTeacherRelationPK().getTchSemester());
            listTeacherResponse.setTchYear(putuser.getTeacherRelationPK().getTchYear());
            listTeacherResponse.setTchDepartment(putuser.getTchDepartment());
            listTeacherResponse.setTchPicUrl(putuser.getTchPicUrl());
            listTeacherResponse.setTchIdType(putuser.getTchIdType());
            listTeacherResponse.setTchIdNumberI(putuser.getTchIdNumberI());
            listTeacherResponse.setTchIdNumberR(putuser.getTchIdNumberR());
            listTeacherResponse.setTchIdNumberP(putuser.getTchIdNumberP());
            listTeacherResponse.setTchCountry(putuser.getTchCountry());
            listTeacherResponse.setTchName(putuser.getTchName());
            listTeacherResponse.setTchNameEN(putuser.getTchNameEN());
            listTeacherResponse.setSex(putuser.getSex());
            listTeacherResponse.setTchIsAboriginal(putuser.getTchIsAboriginal());
            listTeacherResponse.setTchAboriginal(putuser.getTchAboriginal());
            listTeacherResponse.setTchBirthday(putuser.getTchBirthday());
            listTeacherResponse.setTchCoeDepartment(putuser.getTchCoeDepartment());
            listTeacherResponse.seteMail(putuser.geteMail());
            listTeacherResponse.setTchState(putuser.getTchState());
            listTeacherResponse.setTchHureDate(putuser.getTchHureDate());
            listTeacherResponse.setTchSchDate(putuser.getTchSchDate());
            listTeacherResponse.setTchOriginalUnit(putuser.getTchOriginalUnit());
            listTeacherResponse.setTchReinstateDate(putuser.getTchReinstateDate());
            listTeacherResponse.setTchAppointDate(putuser.getTchAppointDate());
            listTeacherResponse.setTchStopDate(putuser.getTchStopDate());
            listTeacherResponse.setTchEstablishment(putuser.getTchEstablishment());
            listTeacherResponse.setTchKind(putuser.getTchKind());
            listTeacherResponse.setTchKindIndustry(putuser.getTchKindIndustry());
            listTeacherResponse.setTchKindDepartment(putuser.getTchKindDepartment());
            listTeacherResponse.setTchSceWhemain_ther(putuser.getTchSceWhemain_ther());
            //
            listTeacherResponse.setTchScePurpose(putuser.getTchScePurpose());
            listTeacherResponse.setTchSecUnit(putuser.getTchSecUnit());
            listTeacherResponse.setTchPartAdmini(putuser.getTchPartAdmini());
            listTeacherResponse.setTchAdminiJob(putuser.getTchAdminiJob());
            listTeacherResponse.setTchSchoolType(putuser.getTchSchoolType());
            listTeacherResponse.setTchSchool(putuser.getTchSchool());
            //
            listTeacherResponse.setTchDepartment(putuser.getTchDepartment());
            listTeacherResponse.setTchDiploma(putuser.getTchDiploma());
            listTeacherResponse.setTchExpertise(putuser.getTchExpertise());
            listTeacherResponse.setTchType(putuser.getTchType());
            listTeacherResponse.setTchRireRank(putuser.getTchRireRank());
            //
            listTeacherResponse.setTchRireYear(putuser.getTchRireYear());
            listTeacherResponse.setTchCertificateRank(putuser.getTchCertificateRank());
            listTeacherResponse.setTchCertificateNumber(putuser.getTchCertificateNumber());
            listTeacherResponse.setTchHireNumber(putuser.getTchHireNumber());
            listTeacherResponse.setTchCertificateNumber(putuser.getTchCertificateNumber());
            listTeacherResponse.setTchmain_licenseNumber(putuser.getTchmain_licenseNumber());
            ;       //
            listTeacherResponse.setTchEvaNumber(putuser.getTchEvaNumber());
            listTeacherResponse.setTch106PaySalary(putuser.getTch106PaySalary());
            listTeacherResponse.setTch107PaySalary(putuser.getTch107PaySalary());
            listTeacherResponse.setTchFiestAssistant(putuser.getTchFiestAssistant());
            listTeacherResponse.setTchFullTime(putuser.getTchFullTime());
            listTeacherResponse.setTchSixtyFive(putuser.getTchSixtyFive());
            //
            listTeacherResponse.setTchMainDepartment(putuser.getTchMainDepartment());
            listTeacherResponse.setTchTwoFour(putuser.getTchTwoFour());
            listTeacherResponse.setTchComplyLaw(putuser.getTchComplyLaw());
            listTeacherResponse.setTchFullPartPosition(putuser.getTchFullPartPosition());
            listTeacherResponse.setTchTow(putuser.getTchTow());
            listTeacherResponse.setTchValidationStatus(putuser.getTchValidationStatus());
            listTeacherResponse.setIntroduce(putuser.getIntroduce());
            return ResponseEntity.ok(listTeacherResponse);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<RegisterTeacherModel>(HttpStatus.NOT_FOUND);
        }
    }
}