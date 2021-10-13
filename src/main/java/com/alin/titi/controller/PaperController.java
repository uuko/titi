package com.alin.titi.controller;

import com.alin.titi.model.ChangeVisibleRequest;
import com.alin.titi.model.LicenseModel;
import com.alin.titi.model.PaperModel;
import com.alin.titi.model.RegisterTeacherModel;
import com.alin.titi.model.api.request.LicenseRequest;
import com.alin.titi.model.api.request.LicenseUpdateRequest;
import com.alin.titi.model.api.request.PaperPostRequest;
import com.alin.titi.model.api.request.PaperUpdateRequest;
import com.alin.titi.model.api.response.PaperUpdateResponse;
import com.alin.titi.services.LicenseServices;
import com.alin.titi.services.PaperServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaperController {
    @Autowired
    private PaperServices paperServices;
    @PostMapping("/teacher/paper/changeVisible")
    public void changeVisible(@RequestBody ChangeVisibleRequest bookRequest) {
        paperServices.changeVisible(bookRequest);
    }
    //post
    @PostMapping("/teacher/paper")
    public void saveTeacherLicense(@RequestBody PaperPostRequest paperPostRequest) {
        paperServices.addPaperData(paperPostRequest);
    }

    //update
    @PostMapping("/teacher/update/paper")
    public void updateTeacherLicense(@RequestBody PaperUpdateRequest paperUpdateRequest) {
        paperServices.updatePaperData(paperUpdateRequest);
    }

    //delete
    @DeleteMapping("/teacher/paper")
    public void deleteTeacherLicense(@RequestBody PaperUpdateRequest licenseRequest) {
        paperServices.deletePaperData(licenseRequest);
    }

    //get
    @GetMapping("/teacher/paper/theId/{theId}")
    public ResponseEntity<?> getTeacherPaper(@PathVariable Integer theId) {
        PaperUpdateResponse licenseData=paperServices.findPaperData(theId);
        if (licenseData==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(licenseData);
        }
    }

    //get
    @GetMapping("/teacher/paper/loginId/{loginId}")
    public ResponseEntity<?> getAllTeacherLicense(@PathVariable Integer loginId) {
        List<PaperUpdateResponse> licenseData=paperServices.findAllPaperData(loginId);
        if (licenseData.size()==0){
            return new ResponseEntity<RegisterTeacherModel>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(licenseData);
        }
    }
}
