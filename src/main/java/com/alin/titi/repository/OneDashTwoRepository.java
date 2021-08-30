package com.alin.titi.repository;

import com.alin.titi.model.DisModel;
import com.alin.titi.model.GovModel;
import com.alin.titi.model.LoginModel;
import com.alin.titi.model.OneDashTwoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OneDashTwoRepository  extends JpaRepository<OneDashTwoModel, Integer> {
    OneDashTwoModel findByExpNumber(Integer expNumber);
    List<OneDashTwoModel> findByLoginModel(LoginModel loginModel);
}
