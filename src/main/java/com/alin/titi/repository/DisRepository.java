package com.alin.titi.repository;

import com.alin.titi.model.DisModel;
import com.alin.titi.model.GovModel;
import com.alin.titi.model.LoginModel;
import com.alin.titi.model.OneDashTwoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisRepository  extends JpaRepository<DisModel, Integer> {
    DisModel findByDisId(Integer disId);
    List<DisModel> findByLoginModel(LoginModel loginModel);
}
