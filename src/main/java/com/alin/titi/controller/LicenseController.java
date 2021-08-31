package com.alin.titi.controller;

import com.alin.titi.model.LicenseModel;
import com.alin.titi.model.RegisterBaseModel;
import com.alin.titi.model.RegisterTeacherModel;
import com.alin.titi.model.TeacherRelationPK;
import com.alin.titi.model.api.request.LicenseRequest;
import com.alin.titi.model.api.request.LicenseUpdateRequest;
import com.alin.titi.model.api.response.LicenseUpdateResponse;
import com.alin.titi.services.LicenseServices;
import com.alin.titi.services.LoginServices;
//import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
public class LicenseController {
    @Autowired
    private LicenseServices licenseServices;

    //post
    @PostMapping("/teacher/license")
    public void saveTeacherLicense(@RequestBody LicenseRequest licenseRequest) {
       licenseServices.addLicenseData(licenseRequest);
    }

    //update
    @PostMapping("/teacher/update/license")
    public void updateTeacherLicense(@RequestBody LicenseUpdateRequest licenseRequest) {
        licenseServices.updateLicenseData(licenseRequest);
    }

    //delete
    @DeleteMapping("/teacher/license")
    public void deleteTeacherLicense(@RequestBody LicenseUpdateRequest licenseRequest) {
        licenseServices.deleteLicenseData(licenseRequest);
    }

    //get
    @GetMapping("/teacher/license/licId/{licId}")
    public ResponseEntity<?> getTeacherLicense(@PathVariable Integer licId) {
        LicenseModel licenseData=licenseServices.findLicenseData(licId);
        if (licenseData==null){
            return new ResponseEntity<RegisterTeacherModel>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(licenseData);
        }
    }

    //get
    @GetMapping("/teacher/license/loginId/{loginId}")
    public ResponseEntity<?> getAllTeacherLicense(@PathVariable Integer loginId) {
        List<LicenseUpdateResponse> licenseData=licenseServices.findAllLicenseData(loginId);
        if (licenseData.size()==0){
            return new ResponseEntity<RegisterTeacherModel>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(licenseData);
        }
    }
}
