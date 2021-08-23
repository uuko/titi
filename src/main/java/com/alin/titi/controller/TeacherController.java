package com.alin.titi.controller;

import com.alin.titi.model.AuthorModel;
import com.alin.titi.model.RegisterTeacherModel;
import com.alin.titi.model.TeacherRelationPK;
import com.alin.titi.services.AuthorServices;
import com.alin.titi.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService service;
    @Autowired
    private AuthorServices bservice;
    @GetMapping("/list/teacher")
    public List<RegisterTeacherModel> list() {
        return service.listAll();
    }

    @PostMapping("/register/teacher")
    public void add(@RequestBody RegisterTeacherModel teacherModel) {
        service.registerTeacher(teacherModel);
    }

    @GetMapping("/teacher/{tchNumber}/{tchYear}/{tchSemester}")
    public ResponseEntity<RegisterTeacherModel> getTeacherList(@PathVariable Integer tchNumber
                                                                ,@PathVariable Integer tchYear,
                                                               @PathVariable Integer tchSemester
    ) {
        try {
            TeacherRelationPK pk=new TeacherRelationPK();
            pk.setTchNumber(tchNumber);
            pk.setTchSemester(tchSemester);
            pk.setTchYear(tchYear);
            RegisterTeacherModel product = service.findByTeacherRelationPK(pk);
            return new ResponseEntity<RegisterTeacherModel>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<RegisterTeacherModel>(HttpStatus.NOT_FOUND);
        }
    }
}
