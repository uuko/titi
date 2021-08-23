package com.alin.titi.services;

import com.alin.titi.model.RegisterTeacherModel;
import com.alin.titi.model.TeacherRelationPK;
import com.alin.titi.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TeacherService {
    @Autowired
    private TeacherRepository repo;

    public List<RegisterTeacherModel> listAll() {
        return repo.findAll();
    }

    public void registerTeacher(RegisterTeacherModel teacherModel) {
        repo.save(teacherModel);
    }

    public RegisterTeacherModel findByTeacherRelationPK(TeacherRelationPK teacherRelationPK) {
        return repo.findByTeacherRelationPK(teacherRelationPK);
    }
}
