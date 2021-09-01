package com.alin.titi.repository;

import com.alin.titi.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcademicRepository extends JpaRepository<AcademicModel, Integer> {
    AcademicModel findByEveNumber(Integer eveNumber);
    List<AcademicModel> findByLoginModel(LoginModel loginModel);
    List<AcademicModel> findByLoginModelAndOpen(LoginModel model, Boolean open);
}
