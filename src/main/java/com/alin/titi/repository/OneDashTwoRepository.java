package com.alin.titi.repository;

import com.alin.titi.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OneDashTwoRepository  extends JpaRepository<OneDashTwoModel, Integer> {
    OneDashTwoModel findByExpNumber(Integer expNumber);
    List<OneDashTwoModel> findByLoginModel(LoginModel loginModel);
    List<OneDashTwoModel> findByLoginModelAndOpen(LoginModel model, Boolean open);
}
