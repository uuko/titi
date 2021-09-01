package com.alin.titi.repository;

import com.alin.titi.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisRepository  extends JpaRepository<DisModel, Integer> {
    DisModel findByDisId(Integer disId);
    List<DisModel> findByLoginModel(LoginModel loginModel);
    List<DisModel> findByLoginModelAndOpen(LoginModel model, Boolean open);
}
