package com.alin.titi.repository;

import com.alin.titi.model.LoginModel;
import com.alin.titi.model.PaperModel;
import com.alin.titi.model.RegisterTeacherModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaperRepository extends JpaRepository<PaperModel, Integer> {
    PaperModel findByTheId(Integer id);
    List<PaperModel> findByLoginModel(LoginModel model);
}
