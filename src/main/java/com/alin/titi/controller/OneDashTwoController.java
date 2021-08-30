package com.alin.titi.controller;

import com.alin.titi.model.RegisterTeacherModel;
import com.alin.titi.model.api.request.GovPostRequest;
import com.alin.titi.model.api.request.GovRequest;
import com.alin.titi.model.api.request.OneDashTwoPostRquest;
import com.alin.titi.model.api.request.OneDashTwoRequest;
import com.alin.titi.model.api.response.GovResponse;
import com.alin.titi.model.api.response.OneDashTwoResponse;
import com.alin.titi.services.GovServices;
import com.alin.titi.services.OneDashTwoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class OneDashTwoController {
    @Autowired
    private OneDashTwoServices services;

    //post
    @PostMapping("/teacher/one_dash_two")
    public void saveTeacherLicense(@RequestBody OneDashTwoRequest paperPostRequest) {
        services.addOneDashTwoData(paperPostRequest);
    }

    //update
    @PostMapping("/teacher/update/one_dash_two")
    public void updateTeacherLicense(@RequestBody OneDashTwoPostRquest paperUpdateRequest) {
        services.updateOneDashTwoData(paperUpdateRequest);
    }

    //delete
    @DeleteMapping("/teacher/one_dash_two")
    public void deleteTeacherLicense(@RequestBody OneDashTwoPostRquest licenseRequest) {
        services.deleteOneDashTwoData(licenseRequest);
    }

    //get
    @GetMapping("/teacher/one_dash_two/expNumber/{expNumber}")
    public ResponseEntity<?> getTeacherPaper(@PathVariable Integer expNumber) {
        OneDashTwoResponse licenseData=services.findOneDashTwoData(expNumber);
        if (licenseData==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(licenseData);
        }
    }

    //get
    @GetMapping("/teacher/one_dash_two/loginId/{loginId}")
    public ResponseEntity<?> getAllTeacherLicense(@PathVariable Integer loginId) {
        List<OneDashTwoResponse> licenseData=services.findAllOneDashTwoData(loginId);
        if (licenseData.size()==0){
            return new ResponseEntity<RegisterTeacherModel>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(licenseData);
        }
    }
}
