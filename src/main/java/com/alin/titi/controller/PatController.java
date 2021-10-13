package com.alin.titi.controller;

import com.alin.titi.model.ChangeVisibleRequest;
import com.alin.titi.model.RegisterTeacherModel;
import com.alin.titi.model.api.request.PatPostRequest;
import com.alin.titi.model.api.request.PatUpdateRequest;
import com.alin.titi.model.api.response.PatUpdateResponse;
import com.alin.titi.services.PatServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatController {
    //api宣告
    @Autowired
    private PatServices patServices;
    @PostMapping("/teacher/pat/changeVisible")
    public void changeVisible(@RequestBody ChangeVisibleRequest bookRequest) {
        patServices.changeVisible(bookRequest);
    }
    //post
    @PostMapping("/teacher/pat")
    public void saveTeacherLicense(@RequestBody PatPostRequest patPostRequest) {
        patServices.addAwardsData(patPostRequest);
    }

    //update
    @PostMapping("/teacher/update/pat")
    public void updateTeacherLicense(@RequestBody PatUpdateRequest patUpdateRequest) {
        patServices.updatePaperData(patUpdateRequest);
    }

    //delete
    @DeleteMapping("/teacher/pat")
    public void deleteTeacherLicense(@RequestBody PatUpdateRequest licenseRequest) {
        patServices.deleteAwardsData(licenseRequest);
    }

    //get
    @GetMapping("/teacher/pat/theId/{theId}")
    public ResponseEntity<?> getTeacherPaper(@PathVariable Integer theId) {
        PatUpdateResponse licenseData=patServices.findAwardsData(theId);
        if (licenseData==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(licenseData);
        }
    }

    //get
    @GetMapping("/teacher/pat/loginId/{loginId}")
    public ResponseEntity<?> getAllTeacherLicense(@PathVariable Integer loginId) {
        List<PatUpdateResponse> licenseData=patServices.findAllawardsData(loginId);
        if (licenseData.size()==0){
            return new ResponseEntity<RegisterTeacherModel>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(licenseData);
        }
    }
}
