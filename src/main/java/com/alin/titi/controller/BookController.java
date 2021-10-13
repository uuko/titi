package com.alin.titi.controller;

import com.alin.titi.model.ChangeVisibleRequest;
import com.alin.titi.model.RegisterTeacherModel;
import com.alin.titi.model.api.request.BookRequest;
import com.alin.titi.model.api.request.BookUpdateRequest;
import com.alin.titi.model.api.request.TechRequest;
import com.alin.titi.model.api.request.TechUpdateRequest;
import com.alin.titi.model.api.response.BookResponse;
import com.alin.titi.model.api.response.TechResponse;
import com.alin.titi.services.BookServices;
import com.alin.titi.services.TechServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookServices bookServices;

    @PostMapping("/teacher/book/changeVisible")
    public void changeVisible(@RequestBody ChangeVisibleRequest bookRequest) {
        bookServices.changeVisible(bookRequest);
    }

    //post
    @PostMapping("/teacher/book")
    public void saveBookLicense(@RequestBody BookRequest bookRequest) {
        bookServices.addBookData(bookRequest);
    }

    //update
    @PostMapping("/teacher/update/book")
    public void updateTeacherLicense(@RequestBody BookUpdateRequest paperUpdateRequest) {
        bookServices.updateBookData(paperUpdateRequest);
    }

    //delete
    @DeleteMapping("/teacher/book")
    public void deleteTeacherLicense(@RequestBody BookUpdateRequest licenseRequest) {
        bookServices.deleteBookData(licenseRequest);
    }

    //get
    @GetMapping("/teacher/book/infNumber/{infNumber}")
    public ResponseEntity<?> getTeacherPaper(@PathVariable Integer infNumber) {
        BookResponse licenseData=bookServices.findBookData(infNumber);
        if (licenseData==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(licenseData);
        }
    }

    //get
    @GetMapping("/teacher/book/loginId/{loginId}")
    public ResponseEntity<?> getAllTeacherLicense(@PathVariable Integer loginId) {
        List<BookResponse> licenseData=bookServices.findAllBookData(loginId);
        if (licenseData.size()==0){
            return new ResponseEntity<RegisterTeacherModel>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(licenseData);
        }
    }
}
