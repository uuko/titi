package com.alin.titi.controller;

import com.alin.titi.model.ChangeVisibleRequest;
import com.alin.titi.model.RegisterTeacherModel;
import com.alin.titi.model.api.request.DisPostRequest;
import com.alin.titi.model.api.request.DisRequest;
import com.alin.titi.model.api.request.PaperPostRequest;
import com.alin.titi.model.api.request.PaperUpdateRequest;
import com.alin.titi.model.api.response.DisResponse;
import com.alin.titi.model.api.response.PaperUpdateResponse;
import com.alin.titi.services.DisServices;
import com.alin.titi.services.PaperServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DisController {
    @Autowired
    private DisServices services;
    @PostMapping("/teacher/dis/changeVisible")
    public void changeVisible(@RequestBody ChangeVisibleRequest bookRequest) {
        services.changeVisible(bookRequest);
    }
    //post
    @PostMapping("/teacher/dis")
    public void saveTeacherLicense(@RequestBody DisRequest paperPostRequest) {
        services.addDisData(paperPostRequest);
    }

    //update
    @PostMapping("/teacher/update/dis")
    public void updateTeacherLicense(@RequestBody DisPostRequest paperUpdateRequest) {
        services.updateDisData(paperUpdateRequest);
    }

    //delete
    @DeleteMapping("/teacher/dis")
    public void deleteTeacherLicense(@RequestBody DisPostRequest licenseRequest) {
        services.deleteDisData(licenseRequest);
    }

    //get
    @GetMapping("/teacher/dis/disId/{disId}")
    public ResponseEntity<?> getTeacherPaper(@PathVariable Integer disId) {
        DisResponse licenseData=services.findDisData(disId);
        if (licenseData==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(licenseData);
        }
    }

    //get
    @GetMapping("/teacher/dis/loginId/{loginId}")
    public ResponseEntity<?> getAllTeacherLicense(@PathVariable Integer loginId) {
        List<DisResponse> licenseData=services.findAllDisData(loginId);
        if (licenseData.size()==0){
            return new ResponseEntity<RegisterTeacherModel>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(licenseData);
        }
    }
}
