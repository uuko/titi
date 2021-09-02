package com.alin.titi.services;

import com.alin.titi.model.LoginModel;
import com.alin.titi.model.PaperModel;
import com.alin.titi.model.TechModel;
import com.alin.titi.model.api.request.PaperPostRequest;
import com.alin.titi.model.api.request.PaperUpdateRequest;
import com.alin.titi.model.api.request.TechRequest;
import com.alin.titi.model.api.request.TechUpdateRequest;
import com.alin.titi.model.api.response.PaperUpdateResponse;
import com.alin.titi.model.api.response.TechResponse;
import com.alin.titi.repository.PaperRepository;
import com.alin.titi.repository.TechRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TechServices {
    @Autowired
    private TechRepository repo;

    public void addTechData(TechRequest postRequest){
        int year = Calendar.getInstance().get(Calendar.YEAR)-1911;
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int semester=0;
        if (month<8 && month>1){
            semester=1;
        }
        else {
            semester=2;
        }

        TechModel techModel=new TechModel();
        techModel.setTchSemester(semester);
        techModel.setTchYear(year);
        techModel.setLoginModel(new LoginModel(postRequest.getLoginId()));
        techModel.setOpen(postRequest.ispublic());
        techModel.setTecContentPatent(postRequest.getTecContentPatent());
        techModel.setTecYear(postRequest.getTecYear());
        techModel.setTecTransfer(postRequest.getTecTransfer());
        techModel.setTecTransferName(postRequest.getTecTransferName());
        techModel.setTecTransferAmount(postRequest.getTecTransferAmount());
        techModel.setTecContentPatent(postRequest.getTecContentPatent());
        techModel.setTecTransferVendor(postRequest.getTecTransferVendor());
        techModel.setTecStratDate(postRequest.getTecStratDate());
        techModel.setTecTransferNumber(postRequest.getTecTransferNumber());
        techModel.setTecPatentNumber(postRequest.getTecPatentNumber());

        repo.save(techModel);

    }

    public void deleteTechData(TechUpdateRequest licenseRequest){
        repo.deleteById(licenseRequest.getTecSkillNumber());
    }
    public TechResponse findTechData(Integer id){
        TechModel postRequest=repo.findByTecSkillNumber(id);
        TechResponse techModel=new TechResponse();
        //
        techModel.setTchSemester(postRequest.getTchSemester());
        techModel.setTchYear(postRequest.getTchYear());
        techModel.setTecSkillNumber(postRequest.getTecSkillNumber());
        techModel.setLoginId(postRequest.getLoginModel().getId());
        techModel.setpublic(postRequest.isOpen());
//
        techModel.setTecContentPatent(postRequest.getTecContentPatent());
        techModel.setTecYear(postRequest.getTecYear());
        techModel.setTecTransfer(postRequest.getTecTransfer());
        techModel.setTecTransferName(postRequest.getTecTransferName());
        techModel.setTecTransferAmount(postRequest.getTecTransferAmount());
        techModel.setTecContentPatent(postRequest.getTecContentPatent());
        techModel.setTecTransferVendor(postRequest.getTecTransferVendor());
        techModel.setTecStratDate(postRequest.getTecStratDate());
        techModel.setTecTransferNumber(postRequest.getTecTransferNumber());
        techModel.setTecPatentNumber(postRequest.getTecPatentNumber());
        return techModel;
    }

    public List<TechResponse> findAllTechData(Integer id){
        List<TechModel> list= repo.findByLoginModel(new LoginModel(id));

        List<TechResponse> responseList=new ArrayList<>();
        for (TechModel postRequest:list) {
            TechResponse techModel=new TechResponse();
            //
            techModel.setTchSemester(postRequest.getTchSemester());
            techModel.setTchYear(postRequest.getTchYear());
            techModel.setTecSkillNumber(postRequest.getTecSkillNumber());
            techModel.setLoginId(postRequest.getLoginModel().getId());
//
            techModel.setTecContentPatent(postRequest.getTecContentPatent());
            techModel.setTecYear(postRequest.getTecYear());
            techModel.setTecTransfer(postRequest.getTecTransfer());
            techModel.setTecTransferName(postRequest.getTecTransferName());
            techModel.setTecTransferAmount(postRequest.getTecTransferAmount());
            techModel.setTecContentPatent(postRequest.getTecContentPatent());
            techModel.setTecTransferVendor(postRequest.getTecTransferVendor());
            techModel.setTecStratDate(postRequest.getTecStratDate());
            techModel.setTecTransferNumber(postRequest.getTecTransferNumber());
            techModel.setTecPatentNumber(postRequest.getTecPatentNumber());
            techModel.setpublic(postRequest.isOpen());
            responseList.add(techModel);
        }


        return responseList;
    }
    public String updatePaperData(TechUpdateRequest postRequest){
        int year = Calendar.getInstance().get(Calendar.YEAR)-1911;
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int semester=0;
        if (month<8 && month>1){
            semester=1;
        }
        else {
            semester=2;
        }


        TechModel techModel=repo.findByTecSkillNumber(postRequest.getTecSkillNumber());
        if (techModel==null) {
            System.out.println("Name is null.");
            return "Null";
        } else {


            techModel.setTchSemester(semester);
            techModel.setTchYear(year);
            techModel.setTecSkillNumber(postRequest.getTecSkillNumber());
            techModel.setLoginModel(techModel.getLoginModel());
//
            techModel.setTecContentPatent(postRequest.getTecContentPatent());
            techModel.setTecYear(postRequest.getTecYear());
            techModel.setTecTransfer(postRequest.getTecTransfer());
            techModel.setTecTransferName(postRequest.getTecTransferName());
            techModel.setTecTransferAmount(postRequest.getTecTransferAmount());
            techModel.setTecContentPatent(postRequest.getTecContentPatent());
            techModel.setTecTransferVendor(postRequest.getTecTransferVendor());
            techModel.setTecStratDate(postRequest.getTecStratDate());
            techModel.setTecTransferNumber(postRequest.getTecTransferNumber());
            techModel.setTecPatentNumber(postRequest.getTecPatentNumber());
            techModel.setOpen(postRequest.ispublic());
            repo.save(techModel);
            return "ok";
        }




    }
}
