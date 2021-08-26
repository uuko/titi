package com.alin.titi.repository;

import com.alin.titi.model.LicenseModel;
import com.alin.titi.model.LoginModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.net.Inet4Address;
import java.util.List;
import java.util.Optional;

@Repository
public interface LicenseRepository extends CrudRepository<LicenseModel, Integer> {
    LicenseModel findByLoginModelIdAndTchSemesterAndTchYear(LoginModel loginModel,Integer tchSemester,Integer tchYear);
    List<LicenseModel> findByLoginModel(LoginModel loginModel);
     LicenseModel  findByLicId(Integer licId);
}
