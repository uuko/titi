package com.alin.titi.services;

import com.alin.titi.model.AcademicModel;
import com.alin.titi.model.LoginModel;
import com.alin.titi.model.OneDashTwoModel;
import com.alin.titi.model.api.request.AcademicPostRequest;
import com.alin.titi.model.api.request.AcademicRequest;
import com.alin.titi.model.api.request.OneDashTwoPostRquest;
import com.alin.titi.model.api.request.OneDashTwoRequest;
import com.alin.titi.model.api.response.AcademicResponse;
import com.alin.titi.model.api.response.OneDashTwoResponse;
import com.alin.titi.repository.AcademicRepository;
import com.alin.titi.repository.OneDashTwoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AcademicServices {
    @Autowired
    private AcademicRepository repo;

    public void addAcademicData(AcademicRequest postRequest){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int semester=0;
        if (month<8 && month>1){
            semester=1;
        }
        else {
            semester=2;
        }

        AcademicModel paperModel=new AcademicModel();
        paperModel.setTchSemester(semester);
        paperModel.setTchYear(year);
        paperModel.setEveYear(postRequest.getEveYear());
        paperModel.setEveName(postRequest.getEveName());
        paperModel.setEveCategory(postRequest.getEveCategory());
        paperModel.setEveClassRelated(postRequest.getEveClassRelated());
        paperModel.setEveLocation(postRequest.getEveLocation());
        paperModel.setEveStratDate(postRequest.getEveStratDate());
        paperModel.setEveStopDate(postRequest.getEveStopDate());
        paperModel.setEveSort(postRequest.getEveSort());
        paperModel.setEveHours(postRequest.getEveHours());
        paperModel.setEveStudyCertificate(postRequest.getEveStudyCertificate());
        paperModel.setEveSchSubsidy(postRequest.getEveSchSubsidy());

        //

        paperModel.setOpen(postRequest.ispublic());
        paperModel.setLoginModel(new LoginModel(postRequest.getLoginId()));
        repo.save(paperModel);

    }

    public void deleteAcademicData(AcademicPostRequest licenseRequest){
        repo.deleteById(licenseRequest.getEveNumber());
    }

    public AcademicResponse findAcademicData(Integer id){
        AcademicModel postRequest=repo.findByEveNumber(id);

        AcademicResponse paperModel=new AcademicResponse();
        paperModel.setTchSemester(postRequest.getTchSemester());
        paperModel.setTchYear(postRequest.getTchYear());
        paperModel.setEveYear(postRequest.getEveYear());
        paperModel.setEveName(postRequest.getEveName());
        paperModel.setEveCategory(postRequest.getEveCategory());
        paperModel.setEveClassRelated(postRequest.getEveClassRelated());
        paperModel.setEveLocation(postRequest.getEveLocation());
        paperModel.setEveStratDate(postRequest.getEveStratDate());
        paperModel.setEveStopDate(postRequest.getEveStopDate());
        paperModel.setEveSort(postRequest.getEveSort());
        paperModel.setEveHours(postRequest.getEveHours());
        paperModel.setEveStudyCertificate(postRequest.getEveStudyCertificate());
        paperModel.setEveSchSubsidy(postRequest.getEveSchSubsidy());
        //
        paperModel.setLoginId(postRequest.getLoginModel().getId());
        paperModel.setpublic(postRequest.isOpen());
        paperModel.setEveNumber(postRequest.getEveNumber());
        return paperModel;
    }

    public List<AcademicResponse> findAllAcademicData(Integer id){
        List<AcademicModel> list= repo.findByLoginModel(new LoginModel(id));

        List<AcademicResponse> responseList=new ArrayList<>();
        for (AcademicModel postRequest:list) {
            AcademicResponse paperModel=new AcademicResponse();
            paperModel.setTchSemester(postRequest.getTchSemester());
            paperModel.setTchYear(postRequest.getTchYear());

            paperModel.setTchSemester(postRequest.getTchSemester());
            paperModel.setTchYear(postRequest.getTchYear());
            paperModel.setEveYear(postRequest.getEveYear());
            paperModel.setEveName(postRequest.getEveName());
            paperModel.setEveCategory(postRequest.getEveCategory());
            paperModel.setEveClassRelated(postRequest.getEveClassRelated());
            paperModel.setEveLocation(postRequest.getEveLocation());
            paperModel.setEveStratDate(postRequest.getEveStratDate());
            paperModel.setEveStopDate(postRequest.getEveStopDate());
            paperModel.setEveSort(postRequest.getEveSort());
            paperModel.setEveHours(postRequest.getEveHours());
            paperModel.setEveStudyCertificate(postRequest.getEveStudyCertificate());
            paperModel.setEveSchSubsidy(postRequest.getEveSchSubsidy());

            //
            paperModel.setLoginId(postRequest.getLoginModel().getId());
            paperModel.setpublic(postRequest.isOpen());
            paperModel.setEveNumber(postRequest.getEveNumber());
            responseList.add(paperModel);
        }


        return responseList;
    }

    public void updateAcademicData(AcademicPostRequest postRequest){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int semester=0;
        if (month<8 && month>1){
            semester=1;
        }
        else {
            semester=2;
        }


        AcademicModel paperModel=repo.findByEveNumber(postRequest.getEveNumber());
        if (paperModel==null) {
            System.out.println("Name is null.");
        } else {


            paperModel.setTchSemester(semester);
            paperModel.setTchYear(year);

            paperModel.setEveYear(postRequest.getEveYear());
            paperModel.setEveName(postRequest.getEveName());
            paperModel.setEveCategory(postRequest.getEveCategory());
            paperModel.setEveClassRelated(postRequest.getEveClassRelated());
            paperModel.setEveLocation(postRequest.getEveLocation());
            paperModel.setEveStratDate(postRequest.getEveStratDate());
            paperModel.setEveStopDate(postRequest.getEveStopDate());
            paperModel.setEveSort(postRequest.getEveSort());
            paperModel.setEveHours(postRequest.getEveHours());
            paperModel.setEveStudyCertificate(postRequest.getEveStudyCertificate());
            paperModel.setEveSchSubsidy(postRequest.getEveSchSubsidy());

            //
            paperModel.setOpen(postRequest.ispublic());

            repo.save(paperModel);
        }




    }
}
