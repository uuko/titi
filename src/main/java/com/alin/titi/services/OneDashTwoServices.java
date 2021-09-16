package com.alin.titi.services;

import com.alin.titi.model.GovModel;
import com.alin.titi.model.LoginModel;
import com.alin.titi.model.OneDashTwoModel;
import com.alin.titi.model.api.request.GovPostRequest;
import com.alin.titi.model.api.request.GovRequest;
import com.alin.titi.model.api.request.OneDashTwoPostRquest;
import com.alin.titi.model.api.request.OneDashTwoRequest;
import com.alin.titi.model.api.response.GovResponse;
import com.alin.titi.model.api.response.OneDashTwoResponse;
import com.alin.titi.repository.GovRepository;
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
public class OneDashTwoServices {
    @Autowired
    private OneDashTwoRepository repo;

    public void addOneDashTwoData(OneDashTwoRequest postRequest){
        int year = Calendar.getInstance().get(Calendar.YEAR)-1911;
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int semester=0;
        if (month<8 && month>1){
            semester=1;
        }
        else {
            semester=2;
        }

        OneDashTwoModel paperModel=new OneDashTwoModel();
        paperModel.setTchSemester(semester);
        paperModel.setTchYear(year);
        paperModel.setExpCategory(postRequest.getExpCategory());
        paperModel.setExpMechanismName(postRequest.getExpMechanismName());
        paperModel.setExpMechanismSort(postRequest.getExpMechanismSort());
        paperModel.setExpPFtime(paperModel.getExpCategory());
        paperModel.setExpJobtitle(postRequest.getExpJobtitle());
        paperModel.setExpRemarks(postRequest.getExpRemarks());
        paperModel.setExpStartDate(postRequest.getExpStartDate());
        paperModel.setExpStopDate(postRequest.getExpStopDate());

        //

        paperModel.setOpen(postRequest.ispublic());
        paperModel.setLoginModel(new LoginModel(postRequest.getLoginId()));
        repo.save(paperModel);

    }

    public void deleteOneDashTwoData(OneDashTwoPostRquest licenseRequest){
        repo.deleteById(licenseRequest.getExpNumber());
    }
    public OneDashTwoResponse findOneDashTwoData(Integer id){
        OneDashTwoModel postRequest=repo.findByExpNumber(id);

        OneDashTwoResponse paperModel=new OneDashTwoResponse();
        paperModel.setTchSemester(postRequest.getTchSemester());
        paperModel.setTchYear(postRequest.getTchYear());
        paperModel.setExpCategory(postRequest.getExpCategory());
        paperModel.setExpMechanismName(postRequest.getExpMechanismName());
        paperModel.setExpMechanismSort(postRequest.getExpMechanismSort());
        paperModel.setExpPFtime(paperModel.getExpCategory());
        paperModel.setExpJobtitle(postRequest.getExpJobtitle());
        paperModel.setExpRemarks(postRequest.getExpRemarks());
        paperModel.setExpStartDate(postRequest.getExpStartDate());
        paperModel.setExpStopDate(postRequest.getExpStopDate());
        //
        paperModel.setLoginId(postRequest.getLoginModel().getId());
        paperModel.setpublic(postRequest.isOpen());
        paperModel.setExpNumber(postRequest.getExpNumber());
        return paperModel;
    }

    public List<OneDashTwoResponse> findAllOneDashTwoData(Integer id){
        List<OneDashTwoModel> list= repo.findByLoginModel(new LoginModel(id));

        List<OneDashTwoResponse> responseList=new ArrayList<>();
        for (OneDashTwoModel postRequest:list) {
            OneDashTwoResponse paperModel=new OneDashTwoResponse();
            paperModel.setTchSemester(postRequest.getTchSemester());
            paperModel.setTchYear(postRequest.getTchYear());

            paperModel.setExpCategory(postRequest.getExpCategory());
            paperModel.setExpMechanismName(postRequest.getExpMechanismName());
            paperModel.setExpMechanismSort(postRequest.getExpMechanismSort());
            paperModel.setExpPFtime(paperModel.getExpCategory());
            paperModel.setExpJobtitle(postRequest.getExpJobtitle());
            paperModel.setExpRemarks(postRequest.getExpRemarks());
            paperModel.setExpStartDate(postRequest.getExpStartDate());
            paperModel.setExpStopDate(postRequest.getExpStopDate());

            //
            paperModel.setLoginId(postRequest.getLoginModel().getId());
            paperModel.setpublic(postRequest.isOpen());
            paperModel.setExpNumber(postRequest.getExpNumber());
            responseList.add(paperModel);
        }


        return responseList;
    }
    public void updateOneDashTwoData(OneDashTwoPostRquest postRequest){
        int year = Calendar.getInstance().get(Calendar.YEAR)-1911;
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int semester=0;
        if (month<8 && month>1){
            semester=1;
        }
        else {
            semester=2;
        }


        OneDashTwoModel paperModel=repo.findByExpNumber(postRequest.getExpNumber());
        if (paperModel==null) {
            System.out.println("Name is null.");
        } else {


            paperModel.setTchSemester(semester);
            paperModel.setTchYear(year);
            paperModel.setExpCategory(postRequest.getExpCategory());
            paperModel.setExpMechanismName(postRequest.getExpMechanismName());
            paperModel.setExpMechanismSort(postRequest.getExpMechanismSort());
            paperModel.setExpPFtime(paperModel.getExpCategory());
            paperModel.setExpJobtitle(postRequest.getExpJobtitle());
            paperModel.setExpRemarks(postRequest.getExpRemarks());
            paperModel.setExpStartDate(postRequest.getExpStartDate());
            paperModel.setExpStopDate(postRequest.getExpStopDate());


            //
            paperModel.setOpen(postRequest.ispublic());
            paperModel.setExpNumber(postRequest.getExpNumber());
            repo.save(paperModel);
        }




    }
}
