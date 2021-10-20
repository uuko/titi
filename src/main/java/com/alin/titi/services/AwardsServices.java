package com.alin.titi.services;

import com.alin.titi.model.*;
import com.alin.titi.model.api.request.AwardsUpdateRequest;
import com.alin.titi.model.api.response.AwardsUpdateResponse;
import com.alin.titi.model.AwardsModel;
import com.alin.titi.model.api.request.AwardsPostRequest;
import com.alin.titi.model.api.request.PaperPostRequest;
import com.alin.titi.model.api.request.PaperUpdateRequest;
import com.alin.titi.model.api.response.PaperUpdateResponse;
import com.alin.titi.repository.AwardsRepository;
import com.alin.titi.repository.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AwardsServices {
    //實現方法
    @Autowired
    private AwardsRepository repo;
    public void  changeVisible(ChangeVisibleRequest request){
        Optional<AwardsModel> model=repo.findById(request.getId());
        model.ifPresent(bookModel -> bookModel.setOpen(request.isVisible()));
    }

    //純粹儲存
    public void addAwardsData(AwardsPostRequest postRequest){
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
        AwardsModel awardsModel=new AwardsModel();

        awardsModel.setTchSemester(semester);
        awardsModel.setTchYear(year);
        awardsModel.setAwaAuthor(postRequest.getAwaAuthor());
        awardsModel.setAwaCampus(postRequest.getAwaCampus());
        awardsModel.setAwaCountry(postRequest.getAwaCountry());
        awardsModel.setAwaDate(postRequest.getAwaDate());
        awardsModel.setAwaName(postRequest.getAwaName());
        awardsModel.setAwaMechanismName(postRequest.getAwaMechanismName());
        awardsModel.setAwaPlan(postRequest.getAwaPlan());
        awardsModel.setAwaRemarks(postRequest.getAwaRemarks());
        awardsModel.setAwaSort(postRequest.getAwaSort());
        awardsModel.setAwaYear(postRequest.getAwaYear());
        awardsModel.setOpen(postRequest.ispublic());
        awardsModel.setLoginModel(new LoginModel(postRequest.getLoginId()));
        repo.save(awardsModel);

    }

    //純刪除
    public void deleteAwardsData(AwardsUpdateRequest licenseRequest){
        repo.deleteById(licenseRequest.getAwaId());
    }

    //找到特定的資料,指定的response
    public AwardsUpdateResponse findAwardsData(Integer id){
        //透過repo.finByAwaId 找出特定資料 傳回 postRequest
        AwardsModel postRequest=repo.findByAwaId(id);


        //回傳Response的容器(要回傳啥)
        AwardsUpdateResponse awardsModel=new AwardsUpdateResponse();
        //
        awardsModel.setLoginId(postRequest.getLoginModel().getId());
        awardsModel.setAwaId(postRequest.getAwaId());
        awardsModel.setTchSemester(postRequest.getTchSemester());
        awardsModel.setTchYear(postRequest.getTchYear());
        awardsModel.setAwaAuthor(postRequest.getAwaAuthor());
        awardsModel.setAwaDate(postRequest.getAwaDate());
        awardsModel.setAwaCampus(postRequest.getAwaCampus());
        awardsModel.setAwaName(postRequest.getAwaName());
        awardsModel.setAwaPlan(postRequest.getAwaPlan());
        awardsModel.setAwaSort(postRequest.getAwaSort());
        awardsModel.setAwaCountry(postRequest.getAwaCountry());
        awardsModel.setAwaMechanismName(postRequest.getAwaMechanismName());
        awardsModel.setAwaRemarks(postRequest.getAwaRemarks());
        awardsModel.setAwaYear(postRequest.getAwaYear());
        awardsModel.setpublic(postRequest.isOpen());
        return awardsModel;
    }


    //找到所有資料,指定response
    public List<AwardsUpdateResponse> findAllawardsData(Integer id){
        //回給我所有
        List<AwardsModel> list= repo.findByLoginModel(new LoginModel(id));

        //存進去response
        List<AwardsUpdateResponse> responseList=new ArrayList<>();
        for (AwardsModel postRequest:list) {
            AwardsUpdateResponse awardsModel=new AwardsUpdateResponse();
            //迴圈丟
            awardsModel.setLoginId(postRequest.getLoginModel().getId());
            awardsModel.setAwaId(postRequest.getAwaId());
            awardsModel.setTchSemester(postRequest.getTchSemester());
            awardsModel.setTchYear(postRequest.getTchYear());
            awardsModel.setAwaAuthor(postRequest.getAwaAuthor());;
            awardsModel.setAwaDate(postRequest.getAwaDate());
            awardsModel.setAwaCampus(postRequest.getAwaCampus());
            awardsModel.setAwaName(postRequest.getAwaName());
            awardsModel.setAwaPlan(postRequest.getAwaPlan());
            awardsModel.setAwaSort(postRequest.getAwaSort());
            awardsModel.setAwaCountry(postRequest.getAwaCountry());
            awardsModel.setAwaMechanismName(postRequest.getAwaMechanismName());
            awardsModel.setAwaRemarks(postRequest.getAwaRemarks());
            awardsModel.setAwaYear(postRequest.getAwaYear());
            awardsModel.setpublic(postRequest.isOpen());
            responseList.add(awardsModel);
        }

        return responseList;
    }

    //更新一筆資料,對原本資料表做更新
    public void updatePaperData(AwardsUpdateRequest postRequest){
        int year = Calendar.getInstance().get(Calendar.YEAR)-1911;
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int semester=0;
        if (month<8 && month>1){
            semester=1;
        }
        else {
            semester=2;
        }


        AwardsModel awardsModel=repo.findByAwaId(postRequest.getAwaId());
        if (awardsModel==null) {
            System.out.println("Name is null.");
        } else {


//            awardsModel.setLoginModel(techModel.getLoginModel());
            awardsModel.setAwaId(postRequest.getAwaId());
            awardsModel.setTchSemester(semester);
            awardsModel.setTchYear(year);
            awardsModel.setAwaAuthor(postRequest.getAwaAuthor());;
            awardsModel.setAwaDate(postRequest.getAwaDate());
            awardsModel.setAwaCampus(postRequest.getAwaCampus());
            awardsModel.setAwaName(postRequest.getAwaName());
            awardsModel.setAwaPlan(postRequest.getAwaPlan());
            awardsModel.setAwaSort(postRequest.getAwaSort());
            awardsModel.setAwaCountry(postRequest.getAwaCountry());
            awardsModel.setAwaMechanismName(postRequest.getAwaMechanismName());
            awardsModel.setAwaRemarks(postRequest.getAwaRemarks());
            awardsModel.setAwaYear(postRequest.getAwaYear());
            awardsModel.setOpen(postRequest.ispublic());
            repo.save(awardsModel);
        }




    }
}
