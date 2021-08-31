package com.alin.titi.repository;

import com.alin.titi.model.ProModel;
import com.alin.titi.model.LoginModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProRepository extends JpaRepository<ProModel, Integer> {
    // 繼承的神祕鬼東西吃 資料表,int
    ProModel findByProId(Integer id);
    List<ProModel> findByLoginModel(LoginModel model);
}
