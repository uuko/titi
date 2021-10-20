package com.alin.titi.controller;

import com.alin.titi.model.ChangeVisibleRequest;
import com.alin.titi.model.RegisterTeacherModel;
import com.alin.titi.model.TechChgeCompanyModel;
import com.alin.titi.model.api.request.*;
import com.alin.titi.model.api.response.TechChangeAllLstResponse;
import com.alin.titi.services.TechChangeAllService;
import com.alin.titi.services.TechChgServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TechChangeController {
    @Autowired
    TechChgServices innerServices;

    @Autowired
    TechChangeAllService services;


//    @PostMapping("/teacher/book/changeVisible")
//    public void changeVisible(@RequestBody ChangeVisibleRequest bookRequest) {
//        techServices.changeVisible(bookRequest);
//    }
@PostMapping("/teacher/techChange/changeVisible")
public void changeVisible(@RequestBody ChangeVisibleRequest bookRequest) {
    services.changeVisible(bookRequest);
}
    /**
     * 第一層
     **/
    //post
    @PostMapping("/teacher/techChange")
    public ResponseEntity<?>  saveTeacherLicense(@RequestBody TechgAllPostRequest paperPostRequest) {
        return ResponseEntity.ok( services.saveOne(paperPostRequest));
    }

    @PostMapping("/teacher/techChange/update")
    public void updateOne(@RequestBody TechgAllPostRequest paperPostRequest) {
        services.updateOne(paperPostRequest);
    }

    @DeleteMapping("/teacher/techChange")
    public void delete(@RequestBody TechChgDeleteRequest paperPostRequest) {
        services.deleteOne(paperPostRequest);
    }

    @GetMapping("/teacher/techChange/loginId/{loginId}")
    public ResponseEntity<?> getAllTeacherLicense(@PathVariable Integer loginId) {
        List<TechChangeAllLstResponse> licenseData = services.getList(loginId);
        if (licenseData.size() == 0) {
            return new ResponseEntity<RegisterTeacherModel>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(licenseData);
        }
    }

    //get
    @GetMapping("/teacher/techChange/tecId/{tecId}")
    public ResponseEntity<?> getTeacherPaper(@PathVariable Integer tecId) {
        TechgAllResponse licenseData = services.getOne(tecId);
        if (licenseData == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(licenseData);
        }
    }


    @GetMapping("/teacher/techChange/list/tecId/{tecId}")
    public ResponseEntity<?> getInnerList(@PathVariable Integer tecId) {
        List<TechChgRequest> licenseData = services.getInnerList(tecId);
        if (licenseData == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(licenseData);
        }
    }

    /**
     * second
     **/
    @PostMapping("/teacher/techChange/inner")
    public void saveInner(@RequestBody TechCompanyRequest paperPostRequest) {
        innerServices.saveTchChg(paperPostRequest);
    }

    @PostMapping("/teacher/techChange/update/inner")
    public void updateOneA(@RequestBody TechChgRequest paperPostRequest) {
        innerServices.updateTchChg(paperPostRequest);
    }

    @DeleteMapping("/teacher/techChange/inner")
    public void deleteA(@RequestBody TechChgDeleteRequest paperPostRequest) {
        innerServices.deleteOne(paperPostRequest);
    }

    @GetMapping("/teacher/techChange/inner/tecCompanyId/{tecCompanyId}")
    public ResponseEntity<?> getAllTeacherLicenseA(@PathVariable Integer tecCompanyId) {
        TechChgRequest licenseData = innerServices.getOne(tecCompanyId);

        return ResponseEntity.ok(licenseData);
    }


}
