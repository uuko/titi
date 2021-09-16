package com.alin.titi.repository;

import com.alin.titi.model.AuthorModel;
import com.alin.titi.model.LoginModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository extends CrudRepository<LoginModel, String> {

    LoginModel findByAccountAndPassword(String account,String password);
    LoginModel findByAccount(String account);
    LoginModel findById(Integer id);

    List<LoginModel> findByGradeNot(String grade);
    LoginModel findByIdAndGradeNot(Integer id,String grade);
}
