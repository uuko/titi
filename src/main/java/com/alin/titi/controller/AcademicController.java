package com.alin.titi.controller;

import com.alin.titi.model.RegisterTeacherModel;
import com.alin.titi.model.api.request.AcademicPostRequest;
import com.alin.titi.model.api.request.AcademicRequest;
import com.alin.titi.model.api.request.OneDashTwoPostRquest;
import com.alin.titi.model.api.request.OneDashTwoRequest;
import com.alin.titi.model.api.response.AcademicResponse;
import com.alin.titi.model.api.response.OneDashTwoResponse;
import com.alin.titi.services.AcademicServices;
import com.alin.titi.services.OneDashTwoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AcademicController {
    @Autowired
    private AcademicServices services;

    //post
    @PostMapping("/teacher/acad")
    public void saveTeacherLicense(@RequestBody AcademicRequest paperPostRequest) {
        services.addAcademicData(paperPostRequest);
    }

    //update
    @PostMapping("/teacher/update/acad")
    public void updateTeacherLicense(@RequestBody AcademicPostRequest paperUpdateRequest) {
        services.updateAcademicData(paperUpdateRequest);
    }

    //delete
    @DeleteMapping("/teacher/acad")
    public void deleteTeacherLicense(@RequestBody AcademicPostRequest licenseRequest) {
        services.deleteAcademicData(licenseRequest);
    }

    //get
    @GetMapping("/teacher/acad/eveNumber/{eveNumber}")
    public ResponseEntity<?> getTeacherPaper(@PathVariable Integer eveNumber) {
        AcademicResponse licenseData=services.findAcademicData(eveNumber);
        if (licenseData==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(licenseData);
        }
    }

    //get
    @GetMapping("/teacher/acad/loginId/{loginId}")
    public ResponseEntity<?> getAllTeacherLicense(@PathVariable Integer loginId) {
        List<AcademicResponse> licenseData=services.findAllAcademicData(loginId);
        if (licenseData.size()==0){
            return new ResponseEntity<RegisterTeacherModel>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(licenseData);
        }
    }
}
