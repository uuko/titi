package com.alin.titi.repository;

import com.alin.titi.model.AcademicModel;
import com.alin.titi.model.AwardsModel;
import com.alin.titi.model.LoginModel;
import com.alin.titi.model.PaperModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AwardsRepository extends JpaRepository<AwardsModel, Integer> {
    // 繼承的神祕鬼東西吃 資料表,int
    AwardsModel findByAwaId(Integer id);
    List<AwardsModel> findByLoginModel(LoginModel model);
    List<AwardsModel> findByLoginModelAndOpen(LoginModel model, Boolean open);
}
