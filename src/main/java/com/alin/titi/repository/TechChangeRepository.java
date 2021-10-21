package com.alin.titi.repository;

import com.alin.titi.model.LoginModel;
import com.alin.titi.model.TechChangeModel;
import com.alin.titi.model.TechChgeCompanyModel;
import com.alin.titi.model.TechModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TechChangeRepository extends JpaRepository<TechChangeModel, Integer> {
    TechChangeModel findByTecId(Integer tecId);
    List<TechChangeModel> findByLoginModel(LoginModel loginModel);
}
