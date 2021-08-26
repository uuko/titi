package com.alin.titi.repository;

import com.alin.titi.model.LoginModel;
import com.alin.titi.model.RegisterTeacherModel;
import com.alin.titi.model.TechModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TechRepository extends JpaRepository<TechModel, Integer> {
    TechModel findByTecSkillNumber(Integer techSkillNumber);
    List<TechModel> findByLoginModel(LoginModel loginModel);
}
