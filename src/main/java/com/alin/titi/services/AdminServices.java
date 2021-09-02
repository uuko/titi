package com.alin.titi.services;

import com.alin.titi.model.LoginModel;
import com.alin.titi.model.RegisterTeacherModel;
import com.alin.titi.model.TeacherRelationPK;
import com.alin.titi.model.api.request.AdminChangeAuthorityRequest;
import com.alin.titi.model.api.response.AdminResponse;
import com.alin.titi.repository.AcademicRepository;
import com.alin.titi.repository.LoginRepository;
import com.alin.titi.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AdminServices {
    @Autowired
    private LoginRepository repo;
    @Autowired
    private TeacherRepository teacherRepository;

    private final String ADMIN="A" ;
    public List<AdminResponse>  getAllUsersNotContainAdmin(){

       List<LoginModel> models=repo.findByGradeNot(ADMIN);

       List<AdminResponse> adminResponseList=new ArrayList<>();
       for (LoginModel loginModel:models){
           AdminResponse response=new AdminResponse();
           response.setAccount(loginModel.getAccount());
           response.setLoginId(loginModel.getId());
           List<RegisterTeacherModel> teacherModel=teacherRepository.findByLoginModel(new LoginModel(loginModel.getId()));
           if (teacherModel.size()>0){
               response.setPicUrl(teacherModel.get(0).getTchPicUrl());
               response.setTeacherName(teacherModel.get(0).getTchName());
           }
           adminResponseList.add(response);
       }


        return adminResponseList;


    }

    public String  changeUserAuthority(AdminChangeAuthorityRequest request){
        LoginModel loginModel=repo.findByIdAndGradeNot(request.getLoginId(),ADMIN);
        if (loginModel!=null){
            if (!request.getGrade().equals(ADMIN)){
                loginModel.setGrade(request.getGrade());
            }
            repo.save(loginModel);
            return "ok";
        }
        else {
            return "not find login id";
        }
    }

}
