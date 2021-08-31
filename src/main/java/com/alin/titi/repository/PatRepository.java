package com.alin.titi.repository;

import com.alin.titi.model.PatModel;
import com.alin.titi.model.LoginModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatRepository extends JpaRepository<PatModel, Integer> {
    // 繼承的神祕鬼東西吃 資料表,int
    PatModel findByPatId(Integer id);
    List<PatModel> findByLoginModel(LoginModel model);
}
