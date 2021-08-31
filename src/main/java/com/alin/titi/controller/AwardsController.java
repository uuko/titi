package com.alin.titi.controller;

import com.alin.titi.model.RegisterTeacherModel;
import com.alin.titi.model.api.request.AwardsPostRequest;
import com.alin.titi.model.api.request.AwardsUpdateRequest;
import com.alin.titi.model.api.request.PaperPostRequest;
import com.alin.titi.model.api.request.PaperUpdateRequest;
import com.alin.titi.model.api.response.AwardsUpdateResponse;
import com.alin.titi.model.api.response.PaperUpdateResponse;
import com.alin.titi.repository.AwardsRepository;
import com.alin.titi.services.AwardsServices;
import com.alin.titi.services.PaperServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AwardsController {
    //api宣告
    @Autowired
    private AwardsServices awardsServices;

    //post
    @PostMapping("/teacher/awards")
    public void saveTeacherLicense(@RequestBody AwardsPostRequest paperPostRequest) {
        awardsServices.addAwardsData(paperPostRequest);
    }

    //update
    @PostMapping("/teacher/update/awards")
    public void updateTeacherLicense(@RequestBody AwardsUpdateRequest paperUpdateRequest) {
        awardsServices.updatePaperData(paperUpdateRequest);
    }

    //delete
    @DeleteMapping("/teacher/awards")
    public void deleteTeacherLicense(@RequestBody AwardsUpdateRequest licenseRequest) {
        awardsServices.deleteAwardsData(licenseRequest);
    }

    //get
    @GetMapping("/teacher/awards/theId/{theId}")
    public ResponseEntity<?> getTeacherPaper(@PathVariable Integer theId) {
        AwardsUpdateResponse licenseData=awardsServices.findAwardsData(theId);
        if (licenseData==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(licenseData);
        }
    }

    //get
    @GetMapping("/teacher/awards/loginId/{loginId}")
    public ResponseEntity<?> getAllTeacherLicense(@PathVariable Integer loginId) {
        List<AwardsUpdateResponse> licenseData=awardsServices.findAllawardsData(loginId);
        if (licenseData.size()==0){
            return new ResponseEntity<RegisterTeacherModel>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(licenseData);
        }
    }
}
