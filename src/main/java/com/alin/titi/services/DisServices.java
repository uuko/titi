package com.alin.titi.services;

import com.alin.titi.model.AcademicModel;
import com.alin.titi.model.DisModel;
import com.alin.titi.model.LoginModel;
import com.alin.titi.model.api.request.AcademicPostRequest;
import com.alin.titi.model.api.request.AcademicRequest;
import com.alin.titi.model.api.request.DisPostRequest;
import com.alin.titi.model.api.request.DisRequest;
import com.alin.titi.model.api.response.AcademicResponse;
import com.alin.titi.model.api.response.DisResponse;
import com.alin.titi.repository.AcademicRepository;
import com.alin.titi.repository.DisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class DisServices {
    @Autowired
    private DisRepository repo;

    public void addDisData(DisRequest postRequest){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int semester=0;
        if (month<8 && month>1){
            semester=1;
        }
        else {
            semester=2;
        }

        DisModel paperModel=new DisModel();
        paperModel.setTchSemester(semester);
        paperModel.setTchYear(year);
        paperModel.setDismainThesisName(postRequest.getDismainThesisName());
        paperModel.setDisReviewer(postRequest.isDisReviewer());
        paperModel.setDisAuthor(postRequest.getDisAuthor());
        paperModel.setDisCorreAuthor(postRequest.getDisCorreAuthor());
        paperModel.setDisSeminarName(postRequest.getDisSeminarName());
        paperModel.setDisHostCity(postRequest.getDisHostCity());
        paperModel.setDisHostCountry(postRequest.getDisHostCountry());
        paperModel.setDisFD(postRequest.getDisFD());
        paperModel.setDisProject(postRequest.getDisProject());
        paperModel.setDisPublishY(postRequest.getDisPublishY());
        paperModel.setDisCollection(postRequest.getDisCollection());
        paperModel.setDisIsCountry(postRequest.isDisIsCountry());
        paperModel.setDisED(postRequest.getDisED());
        paperModel.setMain_disYear(postRequest.getMain_disYear());

        //

        paperModel.setPublic(postRequest.isPublic());
        paperModel.setLoginModel(new LoginModel(postRequest.getLoginId()));
        repo.save(paperModel);

    }

    public void deleteDisData(DisPostRequest licenseRequest){
        repo.deleteById(licenseRequest.getDisId());
    }

    public DisResponse findDisData(Integer id){
        DisModel postRequest=repo.findByDisId(id);

        DisResponse paperModel=new DisResponse();
        paperModel.setTchSemester(postRequest.getTchSemester());
        paperModel.setTchYear(postRequest.getTchYear());

        paperModel.setTchSemester(postRequest.getTchSemester());
        paperModel.setTchYear(postRequest.getTchYear());
        paperModel.setDismainThesisName(postRequest.getDismainThesisName());
        paperModel.setDisReviewer(postRequest.isDisReviewer());
        paperModel.setDisAuthor(postRequest.getDisAuthor());
        paperModel.setDisCorreAuthor(postRequest.getDisCorreAuthor());
        paperModel.setDisSeminarName(postRequest.getDisSeminarName());
        paperModel.setDisHostCity(postRequest.getDisHostCity());
        paperModel.setDisHostCountry(postRequest.getDisHostCountry());
        paperModel.setDisFD(postRequest.getDisFD());
        paperModel.setDisProject(postRequest.getDisProject());
        paperModel.setDisPublishY(postRequest.getDisPublishY());
        paperModel.setDisCollection(postRequest.getDisCollection());
        paperModel.setDisIsCountry(postRequest.isDisIsCountry());
        paperModel.setDisED(postRequest.getDisED());
        paperModel.setMain_disYear(postRequest.getMain_disYear());
        //
        paperModel.setLoginId(postRequest.getLoginModel().getId());
        paperModel.setPublic(postRequest.isPublic());
        paperModel.setDisId(postRequest.getDisId());
        return paperModel;
    }

    public List<DisResponse> findAllDisData(Integer id){
        List<DisModel> list= repo.findByLoginModel(new LoginModel(id));

        List<DisResponse> responseList=new ArrayList<>();
        for (DisModel postRequest:list) {
            DisResponse paperModel=new DisResponse();
            paperModel.setTchSemester(postRequest.getTchSemester());
            paperModel.setTchYear(postRequest.getTchYear());

            paperModel.setTchSemester(postRequest.getTchSemester());
            paperModel.setTchYear(postRequest.getTchYear());
            paperModel.setDismainThesisName(postRequest.getDismainThesisName());
            paperModel.setDisReviewer(postRequest.isDisReviewer());
            paperModel.setDisAuthor(postRequest.getDisAuthor());
            paperModel.setDisCorreAuthor(postRequest.getDisCorreAuthor());
            paperModel.setDisSeminarName(postRequest.getDisSeminarName());
            paperModel.setDisHostCity(postRequest.getDisHostCity());
            paperModel.setDisHostCountry(postRequest.getDisHostCountry());
            paperModel.setDisFD(postRequest.getDisFD());
            paperModel.setDisProject(postRequest.getDisProject());
            paperModel.setDisPublishY(postRequest.getDisPublishY());
            paperModel.setDisCollection(postRequest.getDisCollection());
            paperModel.setDisIsCountry(postRequest.isDisIsCountry());
            paperModel.setDisED(postRequest.getDisED());
            paperModel.setMain_disYear(postRequest.getMain_disYear());

            //
            paperModel.setLoginId(postRequest.getLoginModel().getId());
            paperModel.setPublic(postRequest.isPublic());
            paperModel.setDisId(postRequest.getDisId());
            responseList.add(paperModel);
        }


        return responseList;
    }

    public void updateDisData(DisPostRequest postRequest){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int semester=0;
        if (month<8 && month>1){
            semester=1;
        }
        else {
            semester=2;
        }


        DisModel paperModel=repo.findByDisId(postRequest.getDisId());
        if (paperModel==null) {
            System.out.println("Name is null.");
        } else {


            paperModel.setTchSemester(semester);
            paperModel.setTchYear(year);

            paperModel.setDismainThesisName(postRequest.getDismainThesisName());
            paperModel.setDisReviewer(postRequest.isDisReviewer());
            paperModel.setDisAuthor(postRequest.getDisAuthor());
            paperModel.setDisCorreAuthor(postRequest.getDisCorreAuthor());
            paperModel.setDisSeminarName(postRequest.getDisSeminarName());
            paperModel.setDisHostCity(postRequest.getDisHostCity());
            paperModel.setDisHostCountry(postRequest.getDisHostCountry());
            paperModel.setDisFD(postRequest.getDisFD());
            paperModel.setDisProject(postRequest.getDisProject());
            paperModel.setDisPublishY(postRequest.getDisPublishY());
            paperModel.setDisCollection(postRequest.getDisCollection());
            paperModel.setDisIsCountry(postRequest.isDisIsCountry());
            paperModel.setDisED(postRequest.getDisED());
            paperModel.setMain_disYear(postRequest.getMain_disYear());
            //
            paperModel.setPublic(postRequest.isPublic());

            repo.save(paperModel);
        }




    }
}
