package com.alin.titi.repository;

import com.alin.titi.model.AcademicModel;
import com.alin.titi.model.DisModel;
import com.alin.titi.model.LoginModel;
import com.alin.titi.model.OneDashTwoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcademicRepository extends JpaRepository<AcademicModel, Integer> {
    AcademicModel findByEveNumber(Integer eveNumber);
    List<AcademicModel> findByLoginModel(LoginModel loginModel);
}
