package com.alin.titi.controller;

import com.alin.titi.model.ChangeVisibleRequest;
import com.alin.titi.model.RegisterTeacherModel;
import com.alin.titi.model.api.request.DisPostRequest;
import com.alin.titi.model.api.request.DisRequest;
import com.alin.titi.model.api.request.GovPostRequest;
import com.alin.titi.model.api.request.GovRequest;
import com.alin.titi.model.api.response.DisResponse;
import com.alin.titi.model.api.response.GovResponse;
import com.alin.titi.services.DisServices;
import com.alin.titi.services.GovServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class GovController {
    @Autowired
    private GovServices services;
    @PostMapping("/teacher/gov/changeVisible")
    public void changeVisible(@RequestBody ChangeVisibleRequest bookRequest) {
        services.changeVisible(bookRequest);
    }
    //post
    @PostMapping("/teacher/gov")
    public void saveTeacherLicense(@RequestBody GovRequest paperPostRequest) {
        services.addGovData(paperPostRequest);
    }

    //update
    @PostMapping("/teacher/update/gov")
    public void updateTeacherLicense(@RequestBody GovPostRequest paperUpdateRequest) {
        services.updateGovData(paperUpdateRequest);
    }

    //delete
    @DeleteMapping("/teacher/gov")
    public void deleteTeacherLicense(@RequestBody GovPostRequest licenseRequest) {
        services.deleteGovData(licenseRequest);
    }

    //get
    @GetMapping("/teacher/gov/govId/{govId}")
    public ResponseEntity<?> getTeacherPaper(@PathVariable Integer govId) {
        GovResponse licenseData=services.findGovData(govId);
        if (licenseData==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(licenseData);
        }
    }

    //get
    @GetMapping("/teacher/gov/loginId/{loginId}")
    public ResponseEntity<?> getAllTeacherLicense(@PathVariable Integer loginId) {
        List<GovResponse> licenseData=services.findAllGovData(loginId);
        if (licenseData.size()==0){
            return new ResponseEntity<RegisterTeacherModel>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(licenseData);
        }
    }
}
