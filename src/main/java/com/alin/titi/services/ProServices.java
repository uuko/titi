package com.alin.titi.services;

import com.alin.titi.model.BookModel;
import com.alin.titi.model.ChangeVisibleRequest;
import com.alin.titi.model.ProModel;
import com.alin.titi.model.api.request.ProPostRequest;
import com.alin.titi.model.api.request.ProUpdateRequest;
import com.alin.titi.model.api.response.ProUpdateResponse;

import com.alin.titi.model.LoginModel;
import com.alin.titi.repository.AwardsRepository;
import com.alin.titi.repository.ProRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProServices {
    //實現方法
    @Autowired
    private ProRepository repo;
    public void  changeVisible(ChangeVisibleRequest request){
        Optional<ProModel> model=repo.findById(request.getId());
        model.ifPresent(bookModel -> bookModel.setOpen(request.isVisible()));
    }

    //純粹儲存
    public void addAwardsData(ProPostRequest postRequest){
        int year = Calendar.getInstance().get(Calendar.YEAR)-1911;
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int semester=0;
        if (month<8 && month>1){
            semester=1;
        }
        else {
            semester=2;
        }

        //舊資料表
        ProModel proModel=new ProModel();

        proModel.setTchSemester(semester);
        proModel.setTchYear(year);
        proModel.setProCaseName(postRequest.getProCaseName());
        proModel.setProContent(postRequest.getProContent());
        proModel.setProNature(postRequest.getProNature());
        proModel.setProSign(postRequest.getProSign());
        proModel.setProRebate(postRequest.getProRebate());
        proModel.setProYear(postRequest.getProYear());
        proModel.setProStartDate(postRequest.getProStartDate());
        proModel.setProStopDate(postRequest.getProStopDate());
        proModel.setProRemarks(postRequest.getProRemarks());
        proModel.setProVendor(postRequest.getProVendor());
        proModel.setProCaseNumber(postRequest.getProCaseNumber());
        proModel.setOpen(postRequest.ispublic());

        proModel.setLoginModel(new LoginModel(postRequest.getLoginId()));
        repo.save(proModel);

    }

    //純刪除
    public void deleteAwardsData(ProUpdateRequest licenseRequest){
        repo.deleteById(licenseRequest.getProId());
    }

    //找到特定的資料,指定的response
    public ProUpdateResponse findAwardsData(Integer id){
        //透過repo.finByAwaId 找出特定資料 傳回 postRequest
        ProModel postRequest=repo.findByProId(id);


        //回傳Response的容器(要回傳啥)
        ProUpdateResponse proModel=new ProUpdateResponse();
        //
        proModel.setLoginId(postRequest.getLoginModel().getId());
        proModel.setProId(postRequest.getProId());

        proModel.setTchSemester(postRequest.getTchSemester());
        proModel.setTchYear(postRequest.getTchYear());
        proModel.setProCaseName(postRequest.getProCaseName());
        proModel.setProContent(postRequest.getProContent());
        proModel.setProNature(postRequest.getProNature());
        proModel.setProSign(postRequest.getProSign());
        proModel.setProRebate(postRequest.getProRebate());
        proModel.setProYear(postRequest.getProYear());
        proModel.setProStartDate(postRequest.getProStartDate());
        proModel.setProStopDate(postRequest.getProStopDate());
        proModel.setProRemarks(postRequest.getProRemarks());
        proModel.setProVendor(postRequest.getProVendor());
        proModel.setProCaseNumber(postRequest.getProCaseNumber());
        proModel.setpublic(postRequest.isOpen());
        return proModel;
    }


    //找到所有資料,指定response
    public List<ProUpdateResponse> findAllawardsData(Integer id){
        //回給我所有
        List<ProModel> list= repo.findByLoginModel(new LoginModel(id));

        //存進去response
        List<ProUpdateResponse> responseList=new ArrayList<>();
        for (ProModel postRequest:list) {
            ProUpdateResponse proModel=new ProUpdateResponse();
            //迴圈丟
            proModel.setLoginId(postRequest.getLoginModel().getId());
            proModel.setProId(postRequest.getProId());
            proModel.setTchSemester(postRequest.getTchSemester());
            proModel.setTchYear(postRequest.getTchYear());
            proModel.setProCaseName(postRequest.getProCaseName());
            proModel.setProContent(postRequest.getProContent());
            proModel.setProNature(postRequest.getProNature());
            proModel.setProSign(postRequest.getProSign());
            proModel.setProRebate(postRequest.getProRebate());
            proModel.setProYear(postRequest.getProYear());
            proModel.setProStartDate(postRequest.getProStartDate());
            proModel.setProStopDate(postRequest.getProStopDate());
            proModel.setProRemarks(postRequest.getProRemarks());
            proModel.setProVendor(postRequest.getProVendor());
            proModel.setProCaseNumber(postRequest.getProCaseNumber());
            proModel.setpublic(postRequest.isOpen());
            responseList.add(proModel);
        }

        return responseList;
    }

    //更新一筆資料,對原本資料表做更新
    public void updatePaperData(ProUpdateRequest postRequest){
        int year = Calendar.getInstance().get(Calendar.YEAR)-1911;
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int semester=0;
        if (month<8 && month>1){
            semester=1;
        }
        else {
            semester=2;
        }


        ProModel proModel=repo.findByProId(postRequest.getProId());
        if (proModel==null) {
            System.out.println("Name is null.");
        } else {


//            proModel.setLoginModel(techModel.getLoginModel());
            proModel.setProId(postRequest.getProId());
            proModel.setTchSemester(semester);
            proModel.setTchYear(year);
            proModel.setProCaseName(postRequest.getProCaseName());
            proModel.setProContent(postRequest.getProContent());
            proModel.setProNature(postRequest.getProNature());
            proModel.setProSign(postRequest.getProSign());
            proModel.setProRebate(postRequest.getProRebate());
            proModel.setProYear(postRequest.getProYear());
            proModel.setProStartDate(postRequest.getProStartDate());
            proModel.setProStopDate(postRequest.getProStopDate());
            proModel.setProRemarks(postRequest.getProRemarks());
            proModel.setProVendor(postRequest.getProVendor());
            proModel.setProCaseNumber(postRequest.getProCaseNumber());
            proModel.setOpen(postRequest.ispublic());
            repo.save(proModel);
        }




    }
}
