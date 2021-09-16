package com.alin.titi.services;

import com.alin.titi.model.LicenseModel;
import com.alin.titi.model.LoginModel;
import com.alin.titi.model.PaperModel;
import com.alin.titi.model.api.request.LicenseRequest;
import com.alin.titi.model.api.request.LicenseUpdateRequest;
import com.alin.titi.model.api.request.PaperPostRequest;
import com.alin.titi.model.api.request.PaperUpdateRequest;
import com.alin.titi.model.api.response.PaperUpdateResponse;
import com.alin.titi.repository.LicenseRepository;
import com.alin.titi.repository.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class PaperServices {
    @Autowired
    private PaperRepository repo;

    public void addPaperData(PaperPostRequest postRequest){
        int year = Calendar.getInstance().get(Calendar.YEAR)-1911;
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int semester=0;
        if (month<8 && month>1){
            semester=1;
        }
        else {
            semester=2;
        }

        PaperModel paperModel=new PaperModel();
        paperModel.setTchSemester(semester);
        paperModel.setTchYear(year);
        paperModel.setTheAuthor(postRequest.getTheAuthor());
        paperModel.setTheCollCategory(postRequest.getTheCollCategory());
        paperModel.setTheCorreAuthor(postRequest.getTheCorreAuthor());
        paperModel.setTheCoupons(postRequest.getTheCoupons());
        paperModel.setTheTransCooperation(postRequest.getTheTransCooperation());
        paperModel.setThemain_thesisName(postRequest.getThemain_thesisName());
        paperModel.setThePubmain_licatinNumber(postRequest.isThePubmain_licatinNumber());
        paperModel.setThePubmain_licationName(postRequest.getThePubmain_licationName());
        paperModel.setTheProject(postRequest.getTheProject());
        paperModel.setThePublishType(postRequest.getThePublishType());
        paperModel.setThePublishMonth(postRequest.getThePublishMonth());
        paperModel.setThePublishYear(postRequest.getThePublishYear());
        paperModel.setTheReviewer(postRequest.getTheReviewer());
        paperModel.setTheTransCooperation(postRequest.getTheTransCooperation());
        paperModel.setThePublishingcountry(postRequest.getThePublishingcountry());
        paperModel.setOpen(postRequest.ispublic());

        paperModel.setLoginModel(new LoginModel(postRequest.getLoginId()));
        repo.save(paperModel);

    }

    public void deletePaperData(PaperUpdateRequest licenseRequest){
        repo.deleteById(licenseRequest.getTheId());
    }
    public PaperUpdateResponse findPaperData(Integer id){
        PaperModel postRequest=repo.findByTheId(id);
        PaperUpdateResponse paperModel=new PaperUpdateResponse();
        paperModel.setLoginId(postRequest.getLoginModel().getId());
        paperModel.setTheId(postRequest.getTheId());
        //
        paperModel.setTchSemester(postRequest.getTchSemester());
        paperModel.setTchYear(postRequest.getTchYear());
        paperModel.setTheAuthor(postRequest.getTheAuthor());
        paperModel.setTheCollCategory(postRequest.getTheCollCategory());
        paperModel.setTheCorreAuthor(postRequest.getTheCorreAuthor());
        paperModel.setTheCoupons(postRequest.getTheCoupons());
        paperModel.setTheTransCooperation(postRequest.getTheTransCooperation());
        paperModel.setThemain_thesisName(postRequest.getThemain_thesisName());
        paperModel.setThePubmain_licatinNumber(postRequest.getThePubmain_licatinNumber());
        paperModel.setThePubmain_licationName(postRequest.getThePubmain_licationName());
        paperModel.setTheProject(postRequest.getTheProject());
        paperModel.setThePublishType(postRequest.getThePublishType());
        paperModel.setThePublishMonth(postRequest.getThePublishMonth());
        paperModel.setThePublishYear(postRequest.getThePublishYear());
        paperModel.setTheReviewer(postRequest.getTheReviewer());
        paperModel.setTheTransCooperation(postRequest.getTheTransCooperation());
        paperModel.setThePublishingcountry(postRequest.getThePublishingcountry());
        paperModel.setpublic(postRequest.isOpen());
        return paperModel;
    }

    public List<PaperUpdateResponse> findAllPaperData(Integer id){
        List<PaperModel> list= repo.findByLoginModel(new LoginModel(id));

        List<PaperUpdateResponse> responseList=new ArrayList<>();
        for (PaperModel postRequest:list) {
            PaperUpdateResponse paperModel=new PaperUpdateResponse();
            paperModel.setLoginId(postRequest.getLoginModel().getId());
            paperModel.setTheId(postRequest.getTheId());
            //
            paperModel.setTchSemester(postRequest.getTchSemester());
            paperModel.setTchYear(postRequest.getTchYear());
            paperModel.setTheAuthor(postRequest.getTheAuthor());
            paperModel.setTheCollCategory(postRequest.getTheCollCategory());
            paperModel.setTheCorreAuthor(postRequest.getTheCorreAuthor());
            paperModel.setTheCoupons(postRequest.getTheCoupons());
            paperModel.setTheTransCooperation(postRequest.getTheTransCooperation());
            paperModel.setThemain_thesisName(postRequest.getThemain_thesisName());
            paperModel.setThePubmain_licatinNumber(postRequest.getThePubmain_licatinNumber());
            paperModel.setThePubmain_licationName(postRequest.getThePubmain_licationName());
            paperModel.setTheProject(postRequest.getTheProject());
            paperModel.setThePublishType(postRequest.getThePublishType());
            paperModel.setThePublishMonth(postRequest.getThePublishMonth());
            paperModel.setThePublishYear(postRequest.getThePublishYear());
            paperModel.setTheReviewer(postRequest.getTheReviewer());
            paperModel.setTheTransCooperation(postRequest.getTheTransCooperation());
            paperModel.setThePublishingcountry(postRequest.getThePublishingcountry());
            paperModel.setpublic(postRequest.isOpen());
            responseList.add(paperModel);
        }


        return responseList;
    }
    public void updatePaperData(PaperUpdateRequest postRequest){
        int year = Calendar.getInstance().get(Calendar.YEAR)-1911;
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int semester=0;
        if (month<8 && month>1){
            semester=1;
        }
        else {
            semester=2;
        }


        PaperModel paperModel=repo.findByTheId(postRequest.getTheId());
        if (paperModel==null) {
            System.out.println("Name is null.");
        } else {

            paperModel.setTchSemester(semester);
            paperModel.setTchYear(year);
            paperModel.setTheAuthor(postRequest.getTheAuthor());
            paperModel.setTheCollCategory(postRequest.getTheCollCategory());
            paperModel.setTheCorreAuthor(postRequest.getTheCorreAuthor());
            paperModel.setTheCoupons(postRequest.getTheCoupons());
            paperModel.setTheTransCooperation(postRequest.getTheTransCooperation());
            paperModel.setThemain_thesisName(postRequest.getThemain_thesisName());
            paperModel.setThePubmain_licatinNumber(postRequest.isThePubmain_licatinNumber());
            paperModel.setThePubmain_licationName(postRequest.getThePubmain_licationName());
            paperModel.setTheProject(postRequest.getTheProject());
            paperModel.setThePublishType(postRequest.getThePublishType());
            paperModel.setThePublishMonth(postRequest.getThePublishMonth());
            paperModel.setThePublishYear(postRequest.getThePublishYear());
            paperModel.setTheReviewer(postRequest.getTheReviewer());
            paperModel.setTheTransCooperation(postRequest.getTheTransCooperation());
            paperModel.setThePublishingcountry(postRequest.getThePublishingcountry());
            paperModel.setOpen(postRequest.ispublic());

            paperModel.setLoginModel(new LoginModel(postRequest.getLoginId()));
            repo.save(paperModel);
        }




    }
}
