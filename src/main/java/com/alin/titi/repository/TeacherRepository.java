package com.alin.titi.repository;

import com.alin.titi.model.LoginModel;
import com.alin.titi.model.RegisterTeacherModel;
import com.alin.titi.model.TeacherRelationPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface  TeacherRepository extends JpaRepository<RegisterTeacherModel, Integer> {
    RegisterTeacherModel findByTeacherRelationPK(TeacherRelationPK tPk);
    RegisterTeacherModel findByTchPicUrl(String tchPicUrl);
    RegisterTeacherModel findByLoginModel(LoginModel loginModel);
    //    findByOrderBySeatNumberAsc
    List<RegisterTeacherModel> findAllByTeacherRelationPKTchNumber(Integer tchNumber);
//    RegisterTeacherModel findByTeacherNumber(int id);
}

