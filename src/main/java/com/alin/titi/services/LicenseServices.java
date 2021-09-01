package com.alin.titi.services;

import com.alin.titi.model.LicenseModel;
import com.alin.titi.model.LoginModel;
import com.alin.titi.model.api.request.LicenseRequest;
import com.alin.titi.model.api.request.LicenseUpdateRequest;
import com.alin.titi.model.api.response.LicenseUpdateResponse;
import com.alin.titi.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LicenseServices {
    @Autowired
    private LicenseRepository repo;

    public void addLicenseData(LicenseRequest licenseRequest){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int semester=0;
        if (month<8 && month>1){
            semester=1;
        }
        else {
            semester=2;
        }

        LicenseModel licenseModel=new LicenseModel();
        licenseModel.setLicName(licenseRequest.getLicName());
        licenseModel.setLicService(licenseRequest.getLicService());
        licenseModel.setLicType(licenseRequest.getLicType());
        licenseModel.setLicNumber(licenseRequest.getLicNumber());
        licenseModel.setTchSemester(semester);
        licenseModel.setTchYear(year);
        licenseModel.setLoginModel(new LoginModel(licenseRequest.getLoginId()));
        System.out.println("    "+licenseRequest.isOpen());
        licenseModel.setOpen(licenseRequest.isOpen());
        repo.save(licenseModel);

    }

    public void deleteLicenseData(LicenseUpdateRequest licenseRequest){
        repo.deleteById(licenseRequest.getLicId());
    }
    public LicenseModel findLicenseData(Integer id){
        LicenseModel licenseRequest= repo.findByLicId(id);


        LicenseUpdateResponse licenseModel=new LicenseUpdateResponse();
        licenseModel.setLicId(licenseRequest.getLicId());
        licenseModel.setLoginId(licenseRequest.getLoginModel().getId());
        //
        licenseModel.setLicName(licenseRequest.getLicName());
        licenseModel.setLicService(licenseRequest.getLicService());
        licenseModel.setLicType(licenseRequest.getLicType());
        licenseModel.setLicNumber(licenseRequest.getLicNumber());
        licenseModel.setTchSemester(licenseRequest.getTchSemester());
        licenseModel.setTchYear(licenseRequest.getTchYear());
        licenseModel.setpublic(licenseRequest.isOpen());

        return licenseRequest;
    }

    public List<LicenseUpdateResponse> findAllLicenseData(Integer id){
        List<LicenseModel> licenseModelList= repo.findByLoginModel(new LoginModel(id));
        List<LicenseUpdateResponse> licenseUpdateResponseList=new ArrayList<>();
        for (LicenseModel licenseRequest:licenseModelList){
            LicenseUpdateResponse licenseModel=new LicenseUpdateResponse();
            licenseModel.setLicId(licenseRequest.getLicId());
            licenseModel.setLoginId(licenseRequest.getLoginModel().getId());
            //
            licenseModel.setLicName(licenseRequest.getLicName());
            licenseModel.setLicService(licenseRequest.getLicService());
            licenseModel.setLicType(licenseRequest.getLicType());
            licenseModel.setLicNumber(licenseRequest.getLicNumber());
            licenseModel.setTchSemester(licenseRequest.getTchSemester());
            licenseModel.setTchYear(licenseRequest.getTchYear());
            licenseModel.setpublic(licenseRequest.isOpen());
            licenseUpdateResponseList.add(licenseModel);
        }

        return licenseUpdateResponseList;
    }
    public void updateLicenseData(LicenseUpdateRequest licenseRequest){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int semester=0;
        if (month<8 && month>1){
            semester=1;
        }
        else {
            semester=2;
        }


        LicenseModel licenseModel=repo.findByLicId(licenseRequest.getLicId());
        if (licenseModel==null) {
            System.out.println("Name is null.");
        } else {
            licenseModel.setLicName(licenseRequest.getLicName());
            licenseModel.setLicService(licenseRequest.getLicService());
            licenseModel.setLicType(licenseRequest.getLicType());
            licenseModel.setLicNumber(licenseRequest.getLicNumber());
            licenseModel.setTchSemester(semester);
            licenseModel.setTchYear(year);
            licenseModel.setLoginModel(new LoginModel(licenseRequest.getLoginId()));
            licenseModel.setOpen(licenseRequest.ispublic());
            repo.save(licenseModel);
        }




    }
}
