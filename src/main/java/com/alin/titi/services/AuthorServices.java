package com.alin.titi.services;

import com.alin.titi.model.AuthorModel;
import com.alin.titi.model.RegisterTeacherModel;
import com.alin.titi.repository.AuthorRepository;
import com.alin.titi.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AuthorServices {
    @Autowired
    private AuthorRepository repo;

    public List<AuthorModel> listAll() {
        return repo.findAll();
    }


    public void registerTeacher(AuthorModel teacherModel) {
        repo.save(teacherModel);
    }
}

