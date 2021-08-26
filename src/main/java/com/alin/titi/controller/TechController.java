package com.alin.titi.controller;

import com.alin.titi.model.RegisterTeacherModel;
import com.alin.titi.model.api.request.PaperPostRequest;
import com.alin.titi.model.api.request.PaperUpdateRequest;
import com.alin.titi.model.api.request.TechRequest;
import com.alin.titi.model.api.request.TechUpdateRequest;
import com.alin.titi.model.api.response.PaperUpdateResponse;
import com.alin.titi.model.api.response.TechResponse;
import com.alin.titi.services.PaperServices;
import com.alin.titi.services.TechServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TechController {
    @Autowired
    private TechServices techServices;

    //post
    @PostMapping("/teacher/tech")
    public void saveTeacherLicense(@RequestBody TechRequest paperPostRequest) {
        techServices.addTechData(paperPostRequest);
    }

    //update
    @PostMapping("/teacher/update/tech")
    public void updateTeacherLicense(@RequestBody TechUpdateRequest paperUpdateRequest) {
        techServices.updatePaperData(paperUpdateRequest);
    }

    //delete
    @DeleteMapping("/teacher/tech")
    public void deleteTeacherLicense(@RequestBody TechUpdateRequest licenseRequest) {
        techServices.deleteTechData(licenseRequest);
    }

    //get
    @GetMapping("/teacher/tech/tecSkillNumber/{tecSkillNumber}")
    public ResponseEntity<?> getTeacherPaper(@PathVariable Integer tecSkillNumber) {
        TechResponse licenseData=techServices.findTechData(tecSkillNumber);
        if (licenseData==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(licenseData);
        }
    }

    //get
    @GetMapping("/teacher/tech/loginId/{loginId}")
    public ResponseEntity<?> getAllTeacherLicense(@PathVariable Integer loginId) {
        List<TechResponse> licenseData=techServices.findAllTechData(loginId);
        if (licenseData.size()==0){
            return new ResponseEntity<RegisterTeacherModel>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(licenseData);
        }
    }
}
