package com.alin.titi.controller;

import com.alin.titi.model.*;
import com.alin.titi.services.LoginServices;
import com.alin.titi.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
public class LoginController {
    @Autowired
    private LoginServices loginServices;

    // post account pwd -> search -> return response foreign key
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest putuser) {
        try {
            LoginResponse response= loginServices.findAccountLoginStatus(putuser.getAccount(),putuser.getPassword());

            return ResponseEntity.ok(response);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
