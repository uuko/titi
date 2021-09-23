package com.alin.titi.controller;

import com.alin.titi.model.announce.ArticleAllResponse;
import com.alin.titi.model.api.request.AdminChangeAuthorityRequest;
import com.alin.titi.model.api.response.AdminResponse;
import com.alin.titi.model.base.BaseResponse;
import com.alin.titi.services.AcademicServices;
import com.alin.titi.services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private AdminServices services;


    @PostMapping("/admin/teacher/list")
    public ResponseEntity<?> getAllUsersNotContainAdmin()
    {
        List<AdminResponse> list = services.getAllUsersNotContainAdmin();
        if ( !(list.size()>0)){
            return  ResponseEntity.ok(new BaseResponse(""));
        }
        else {
            return  ResponseEntity.ok(list);
        }
    }

    @PostMapping("/admin/change/user/authority")
    public void changeUserAuthority(@RequestBody AdminChangeAuthorityRequest request)
    {
        services.changeUserAuthority(request);
    }

}
