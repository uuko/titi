package com.alin.titi.controller;

import com.alin.titi.model.ChangeVisibleRequest;
import com.alin.titi.model.RegisterTeacherModel;
import com.alin.titi.model.api.request.ProPostRequest;
import com.alin.titi.model.api.request.ProUpdateRequest;
import com.alin.titi.model.api.response.ProUpdateResponse;
import com.alin.titi.services.ProServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProController {
    //api宣告
    @Autowired
    private ProServices proServices;
    @PostMapping("/teacher/pro/changeVisible")
    public void changeVisible(@RequestBody ChangeVisibleRequest bookRequest) {
        proServices.changeVisible(bookRequest);
    }
    //post
    @PostMapping("/teacher/pro")
    public void saveTeacherLicense(@RequestBody ProPostRequest proPostRequest) {
        proServices.addAwardsData(proPostRequest);
    }

    //update
    @PostMapping("/teacher/update/pro")
    public void updateTeacherLicense(@RequestBody ProUpdateRequest proUpdateRequest) {
        proServices.updatePaperData(proUpdateRequest);
    }

    //delete
    @DeleteMapping("/teacher/pro")
    public void deleteTeacherLicense(@RequestBody ProUpdateRequest licenseRequest) {
        proServices.deleteAwardsData(licenseRequest);
    }

    //get
    @GetMapping("/teacher/pro/theId/{theId}")
    public ResponseEntity<?> getTeacherPaper(@PathVariable Integer theId) {
        ProUpdateResponse licenseData=proServices.findAwardsData(theId);
        if (licenseData==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(licenseData);
        }
    }

    //get
    @GetMapping("/teacher/pro/loginId/{loginId}")
    public ResponseEntity<?> getAllTeacherLicense(@PathVariable Integer loginId) {
        List<ProUpdateResponse> licenseData=proServices.findAllawardsData(loginId);
        if (licenseData.size()==0){
            return new ResponseEntity<RegisterTeacherModel>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(licenseData);
        }
    }
}
