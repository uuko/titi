package com.alin.titi.repository;

import com.alin.titi.model.LoginModel;
import com.alin.titi.model.TechChangeModel;
import com.alin.titi.model.TechChgeCompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechChgeCompanyRepo extends JpaRepository<TechChgeCompanyModel, Integer> {
    TechChgeCompanyModel findByTecCompanyId(Integer tecCompanyId);
    List<TechChgeCompanyModel> findByTechChangeModel(TechChangeModel loginModel);
}

