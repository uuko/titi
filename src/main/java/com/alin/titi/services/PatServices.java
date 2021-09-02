package com.alin.titi.services;

import com.alin.titi.model.PatModel;
import com.alin.titi.model.api.response.PatUpdateResponse;

import com.alin.titi.model.LoginModel;
import com.alin.titi.model.api.request.PatPostRequest;
import com.alin.titi.model.api.request.PatUpdateRequest;

import com.alin.titi.repository.PatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class PatServices {
    //實現方法
    @Autowired
    private PatRepository repo;

    //純粹儲存
    public void addAwardsData(PatPostRequest postRequest){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int semester=0;
        if (month<8 && month>1){
            semester=1;
        }
        else {
            semester=2;
        }

        //舊資料表
        PatModel patModel=new PatModel();

        //除了ID
        patModel.setTchSemester(semester);
        patModel.setTchYear(year);
        patModel.setPat95Area(postRequest.getPat95Area());
        patModel.setPat96Area(postRequest.getPat96Area());
        patModel.setPatAuthor(postRequest.getPatAuthor());
        patModel.setPatAppmainLicant(postRequest.getPatAppmainLicant());
        patModel.setPatAppmainLicantType(postRequest.getPatAppmainLicantType());
        patModel.setPatAppmainLicationDate(postRequest.getPatAppmainLicationDate());
        patModel.setPatCertificateNumber(postRequest.getPatCertificateNumber());
        patModel.setPatCountry(postRequest.getPatCountry());
        patModel.setPatEndDate(postRequest.getPatEndDate());
        patModel.setPatChang(postRequest.getPatChang());
        patModel.setOpen(postRequest.ispublic());
        patModel.setPatYear(postRequest.getPatYear());
        patModel.setPatReportEdata(postRequest.getPatReportEdata());
        patModel.setPatReportCode(postRequest.getPatReportCode());
        patModel.setPatProgressStatus(postRequest.getPatProgressStatus());
        patModel.setPatmainPatentName(postRequest.getPatmainPatentName());
        patModel.setPatType(postRequest.getPatmainPatentName());
        patModel.setPatmainLicensingAgency(postRequest.getPatmainLicensingAgency());
        //
        patModel.setPatProject(postRequest.getPatProject());
        patModel.setPatIsGet(postRequest.getPatIsGet());


        patModel.setLoginModel(new LoginModel(postRequest.getLoginId()));
        repo.save(patModel);

    }

    //純刪除
    public void deleteAwardsData(PatUpdateRequest licenseRequest){
        repo.deleteById(licenseRequest.getPatId());
    }

    //找到特定的資料,指定的response
    public PatUpdateResponse findAwardsData(Integer id){
        //透過repo.finByAwaId 找出特定資料 傳回 postRequest
        PatModel postRequest=repo.findByPatId(id);


        //回傳Response的容器(要回傳啥)
        PatUpdateResponse patModel=new PatUpdateResponse();
        //
        patModel.setLoginId(postRequest.getLoginModel().getId());
        patModel.setPatId(postRequest.getPatId());

        patModel.setTchSemester(postRequest.getTchSemester());
        patModel.setTchYear(postRequest.getTchYear());
        patModel.setPat95Area(postRequest.getPat95Area());
        patModel.setPat96Area(postRequest.getPat96Area());
        patModel.setPatAuthor(postRequest.getPatAuthor());
        patModel.setPatAppmainLicant(postRequest.getPatAppmainLicant());
        patModel.setPatAppmainLicantType(postRequest.getPatAppmainLicantType());
        patModel.setPatAppmainLicationDate(postRequest.getPatAppmainLicationDate());
        patModel.setPatCertificateNumber(postRequest.getPatCertificateNumber());
        patModel.setPatCountry(postRequest.getPatCountry());
        patModel.setPatEndDate(postRequest.getPatEndDate());
        patModel.setPatChang(postRequest.getPatChang());
        patModel.setpublic(postRequest.isOpen());
        patModel.setPatYear(postRequest.getPatYear());
        patModel.setPatReportEdata(postRequest.getPatReportEdata());
        patModel.setPatReportCode(postRequest.getPatReportCode());
        patModel.setPatProgressStatus(postRequest.getPatProgressStatus());
        patModel.setPatmainPatentName(postRequest.getPatmainPatentName());
        patModel.setPatType(postRequest.getPatmainPatentName());
        patModel.setPatmainLicensingAgency(postRequest.getPatmainLicensingAgency());
        //
        patModel.setPatProject(postRequest.getPatProject());
        patModel.setPatIsGet(postRequest.getPatIsGet());


        return patModel;
    }


    //找到所有資料,指定response
    public List<PatUpdateResponse> findAllawardsData(Integer id){
        //回給我所有
        List<PatModel> list= repo.findByLoginModel(new LoginModel(id));

        //存進去response
        List<PatUpdateResponse> responseList=new ArrayList<>();
        for (PatModel postRequest:list) {
            PatUpdateResponse patModel=new PatUpdateResponse();
            //迴圈丟
            patModel.setLoginId(postRequest.getLoginModel().getId());
            patModel.setPatId(postRequest.getPatId());

            patModel.setTchSemester(postRequest.getTchSemester());
            patModel.setTchYear(postRequest.getTchYear());
            patModel.setPat95Area(postRequest.getPat95Area());
            patModel.setPat96Area(postRequest.getPat96Area());
            patModel.setPatAuthor(postRequest.getPatAuthor());
            patModel.setPatAppmainLicant(postRequest.getPatAppmainLicant());
            patModel.setPatAppmainLicantType(postRequest.getPatAppmainLicantType());
            patModel.setPatAppmainLicationDate(postRequest.getPatAppmainLicationDate());
            patModel.setPatCertificateNumber(postRequest.getPatCertificateNumber());
            patModel.setPatCountry(postRequest.getPatCountry());
            patModel.setPatEndDate(postRequest.getPatEndDate());
            patModel.setPatChang(postRequest.getPatChang());
            patModel.setpublic(postRequest.isOpen());
            patModel.setPatYear(postRequest.getPatYear());
            patModel.setPatReportEdata(postRequest.getPatReportEdata());
            patModel.setPatReportCode(postRequest.getPatReportCode());
            patModel.setPatProgressStatus(postRequest.getPatProgressStatus());
            patModel.setPatmainPatentName(postRequest.getPatmainPatentName());
            patModel.setPatType(postRequest.getPatmainPatentName());
            patModel.setPatmainLicensingAgency(postRequest.getPatmainLicensingAgency());
            //
            patModel.setPatProject(postRequest.getPatProject());
            patModel.setPatIsGet(postRequest.getPatIsGet());

            responseList.add(patModel);
        }

        return responseList;
    }

    //更新一筆資料,對原本資料表做更新
    public void updatePaperData(PatUpdateRequest postRequest){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int semester=0;
        if (month<8 && month>1){
            semester=1;
        }
        else {
            semester=2;
        }


        PatModel patModel=repo.findByPatId(postRequest.getPatId());
        if (patModel==null) {
            System.out.println("Name is null.");
        } else {


//            patModel.setLoginModel(techModel.getLoginModel());
            patModel.setPatId(postRequest.getPatId());

            patModel.setTchSemester(semester);
            patModel.setTchYear(year);
            patModel.setPat95Area(postRequest.getPat95Area());
            patModel.setPat96Area(postRequest.getPat96Area());
            patModel.setPatAuthor(postRequest.getPatAuthor());
            patModel.setPatAppmainLicant(postRequest.getPatAppmainLicant());
            patModel.setPatAppmainLicantType(postRequest.getPatAppmainLicantType());
            patModel.setPatAppmainLicationDate(postRequest.getPatAppmainLicationDate());
            patModel.setPatCertificateNumber(postRequest.getPatCertificateNumber());
            patModel.setPatCountry(postRequest.getPatCountry());
            patModel.setPatEndDate(postRequest.getPatEndDate());
            patModel.setPatChang(postRequest.getPatChang());
            patModel.setOpen(postRequest.ispublic());
            patModel.setPatYear(postRequest.getPatYear());
            patModel.setPatReportEdata(postRequest.getPatReportEdata());
            patModel.setPatReportCode(postRequest.getPatReportCode());
            patModel.setPatProgressStatus(postRequest.getPatProgressStatus());
            patModel.setPatmainPatentName(postRequest.getPatmainPatentName());
            patModel.setPatType(postRequest.getPatmainPatentName());
            patModel.setPatmainLicensingAgency(postRequest.getPatmainLicensingAgency());
            //
            patModel.setPatProject(postRequest.getPatProject());
            patModel.setPatIsGet(postRequest.getPatIsGet());

            repo.save(patModel);
        }




    }
}
