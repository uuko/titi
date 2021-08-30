package com.alin.titi.repository;

import com.alin.titi.model.GovModel;
import com.alin.titi.model.LoginModel;
import com.alin.titi.model.PaperModel;
import com.alin.titi.model.api.response.GovResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GovRepository extends JpaRepository<GovModel, Integer> {
    GovModel findByGovId(Integer govId);
    List<GovModel> findByLoginModel(LoginModel loginModel);
}
