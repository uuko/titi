package com.alin.titi.services;

import com.alin.titi.model.BookModel;
import com.alin.titi.model.ChangeVisibleRequest;
import com.alin.titi.model.GovModel;
import com.alin.titi.model.LoginModel;
import com.alin.titi.model.api.request.BookRequest;
import com.alin.titi.model.api.request.BookUpdateRequest;
import com.alin.titi.model.api.request.GovPostRequest;
import com.alin.titi.model.api.request.GovRequest;
import com.alin.titi.model.api.response.BookResponse;
import com.alin.titi.model.api.response.GovResponse;
import com.alin.titi.repository.BookRepository;
import com.alin.titi.repository.GovRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class GovServices {
    @Autowired
    private GovRepository repo;
    public void  changeVisible(ChangeVisibleRequest request){
        Optional<GovModel> model=repo.findById(request.getId());
        model.ifPresent(bookModel -> bookModel.setOpen(request.isVisible()));
    }

    public void addGovData(GovRequest postRequest){
        int year = Calendar.getInstance().get(Calendar.YEAR)-1911;
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int semester=0;
        if (month<8 && month>1){
            semester=1;
        }
        else {
            semester=2;
        }

        GovModel paperModel=new GovModel();
        paperModel.setTchSemester(semester);
        paperModel.setTchYear(year);
        paperModel.setGovFD(postRequest.getGovFD());
        paperModel.setGovED(postRequest.getGovED());
        paperModel.setGovYear(postRequest.getGovYear());
        paperModel.setGovProbjectNumber(postRequest.getGovProbjectNumber());
        paperModel.setGovProjectAmount(postRequest.getGovProjectAmount());
        paperModel.setGovProjectNature(postRequest.getGovProjectNature());
        paperModel.setGovProjectName(postRequest.getGovProjectName());
        paperModel.setGovProbjectNumber(postRequest.getGovProbjectNumber());
        paperModel.setgovOthAmount (postRequest.getgovOthAmount ());
        paperModel.setGovJobType(postRequest.getGovJobType());
        paperModel.setGovmainGovAmount(postRequest.getGovmainGovAmount());
        paperModel.setGovEntAmount(postRequest.getGovEntAmount());
        paperModel.setGovSchAmount(postRequest.getGovSchAmount());
        paperModel.setGovMainfund(postRequest.getGovMainfund());
        paperModel.setGovSecAund(postRequest.getGovSecAund());
        paperModel.setGovMoneyState(postRequest.getGovMoneyState());
        paperModel.setGovBenefitDepartment(postRequest.getGovBenefitDepartment());
        paperModel.setGovComUnit(postRequest.getGovComUnit());
        paperModel.setGovTeamworkUnit(postRequest.getGovTeamworkUnit());
        paperModel.setGovOthIn(postRequest.getGovOthIn());
        paperModel.setGovUnitName(postRequest.getGovUnitName());
        paperModel.setGovToOth(postRequest.isGovToOth());

        //
        paperModel.setGovProbjectType(postRequest.getGovProbjectType());
        paperModel.setGovProjectType(postRequest.getGovProjectType());

        paperModel.setOpen(postRequest.ispublic());
        paperModel.setLoginModel(new LoginModel(postRequest.getLoginId()));
        repo.save(paperModel);

    }

    public void deleteGovData(GovPostRequest licenseRequest){
        repo.deleteById(licenseRequest.getGovId());
    }
    public GovResponse findGovData(Integer id){
        GovModel postRequest=repo.findByGovId(id);

        GovResponse paperModel=new GovResponse();
        paperModel.setTchSemester(postRequest.getTchSemester());
        paperModel.setTchYear(postRequest.getTchYear());
        paperModel.setGovFD(postRequest.getGovFD());
        paperModel.setGovED(postRequest.getGovED());
        paperModel.setGovYear(postRequest.getGovYear());
        paperModel.setGovProbjectNumber(postRequest.getGovProbjectNumber());
        paperModel.setGovProjectAmount(postRequest.getGovProjectAmount());
        paperModel.setGovProjectNature(postRequest.getGovProjectNature());
        paperModel.setGovProjectName(postRequest.getGovProjectName());
        paperModel.setGovProbjectNumber(postRequest.getGovProbjectNumber());
        paperModel.setgovOthAmount (postRequest.getgovOthAmount ());
        paperModel.setGovJobType(postRequest.getGovJobType());
        paperModel.setGovmainGovAmount(postRequest.getGovmainGovAmount());
        paperModel.setGovEntAmount(postRequest.getGovEntAmount());
        paperModel.setGovSchAmount(postRequest.getGovSchAmount());
        paperModel.setGovMainfund(postRequest.getGovMainfund());
        paperModel.setGovSecAund(postRequest.getGovSecAund());
        paperModel.setGovMoneyState(postRequest.getGovMoneyState());
        paperModel.setGovBenefitDepartment(postRequest.getGovBenefitDepartment());
        paperModel.setGovComUnit(postRequest.getGovComUnit());
        paperModel.setGovTeamworkUnit(postRequest.getGovTeamworkUnit());
        paperModel.setGovOthIn(postRequest.getGovOthIn());
        paperModel.setGovUnitName(postRequest.getGovUnitName());
        paperModel.setpublic(postRequest.isOpen());
        paperModel.setGovToOth(postRequest.isGovToOth());
        //
        paperModel.setGovProbjectType(postRequest.getGovProbjectType());
        paperModel.setGovProjectType(postRequest.getGovProjectType());

        //
        paperModel.setLoginId(postRequest.getLoginModel().getId());
        paperModel.setpublic(postRequest.isOpen());
        paperModel.setGovId(postRequest.getGovId());
        return paperModel;
    }

    public List<GovResponse> findAllGovData(Integer id){
        List<GovModel> list= repo.findByLoginModel(new LoginModel(id));

        List<GovResponse> responseList=new ArrayList<>();
        for (GovModel postRequest:list) {
            GovResponse paperModel=new GovResponse();
            paperModel.setTchSemester(postRequest.getTchSemester());
            paperModel.setTchYear(postRequest.getTchYear());
            paperModel.setGovFD(postRequest.getGovFD());
            paperModel.setGovED(postRequest.getGovED());
            paperModel.setGovYear(postRequest.getGovYear());
            paperModel.setGovProbjectNumber(postRequest.getGovProbjectNumber());
            paperModel.setGovProjectAmount(postRequest.getGovProjectAmount());
            paperModel.setGovProjectNature(postRequest.getGovProjectNature());
            paperModel.setGovProjectName(postRequest.getGovProjectName());
            paperModel.setGovProbjectNumber(postRequest.getGovProbjectNumber());
            paperModel.setgovOthAmount (postRequest.getgovOthAmount ());
            paperModel.setGovJobType(postRequest.getGovJobType());
            paperModel.setGovmainGovAmount(postRequest.getGovmainGovAmount());
            paperModel.setGovEntAmount(postRequest.getGovEntAmount());
            paperModel.setGovSchAmount(postRequest.getGovSchAmount());
            paperModel.setGovMainfund(postRequest.getGovMainfund());
            paperModel.setGovSecAund(postRequest.getGovSecAund());
            paperModel.setGovMoneyState(postRequest.getGovMoneyState());
            paperModel.setGovBenefitDepartment(postRequest.getGovBenefitDepartment());
            paperModel.setGovComUnit(postRequest.getGovComUnit());
            paperModel.setGovTeamworkUnit(postRequest.getGovTeamworkUnit());
            paperModel.setGovOthIn(postRequest.getGovOthIn());
            paperModel.setGovUnitName(postRequest.getGovUnitName());
            paperModel.setGovToOth(postRequest.isGovToOth());

            //
            paperModel.setLoginId(postRequest.getLoginModel().getId());
            paperModel.setpublic(postRequest.isOpen());
            paperModel.setGovId(postRequest.getGovId());
            //
            paperModel.setGovProbjectType(postRequest.getGovProbjectType());
            paperModel.setGovProjectType(postRequest.getGovProjectType());

            responseList.add(paperModel);
        }


        return responseList;
    }
    public void updateGovData(GovPostRequest postRequest){
        int year = Calendar.getInstance().get(Calendar.YEAR)-1911;
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int semester=0;
        if (month<8 && month>1){
            semester=1;
        }
        else {
            semester=2;
        }


        GovModel paperModel=repo.findByGovId(postRequest.getGovId());
        if (paperModel==null) {
            System.out.println("Name is null.");
        } else {


            paperModel.setTchSemester(semester);
            paperModel.setTchYear(year);
            paperModel.setGovFD(postRequest.getGovFD());
            paperModel.setGovED(postRequest.getGovED());
            paperModel.setGovYear(postRequest.getGovYear());
            paperModel.setGovProbjectNumber(postRequest.getGovProbjectNumber());
            paperModel.setGovProbjectType(postRequest.getGovProbjectType());
            paperModel.setGovProjectAmount(postRequest.getGovProjectAmount());
            paperModel.setGovProjectNature(postRequest.getGovProjectNature());
            paperModel.setGovProjectName(postRequest.getGovProjectName());
            paperModel.setGovProbjectNumber(postRequest.getGovProbjectNumber());
            paperModel.setGovProbjectType(postRequest.getGovProbjectType());
            paperModel.setgovOthAmount (postRequest.getgovOthAmount ());
            paperModel.setGovJobType(postRequest.getGovJobType());
            paperModel.setGovmainGovAmount(postRequest.getGovmainGovAmount());
            paperModel.setGovEntAmount(postRequest.getGovEntAmount());
            paperModel.setGovSchAmount(postRequest.getGovSchAmount());
            paperModel.setGovMainfund(postRequest.getGovMainfund());
            paperModel.setGovSecAund(postRequest.getGovSecAund());
            paperModel.setGovMoneyState(postRequest.getGovMoneyState());
            paperModel.setGovBenefitDepartment(postRequest.getGovBenefitDepartment());
            paperModel.setGovComUnit(postRequest.getGovComUnit());
            paperModel.setGovTeamworkUnit(postRequest.getGovTeamworkUnit());
            paperModel.setGovOthIn(postRequest.getGovOthIn());
            paperModel.setGovUnitName(postRequest.getGovUnitName());

            paperModel.setGovToOth(postRequest.isGovToOth());

            //
            paperModel.setOpen(postRequest.ispublic());
            paperModel.setGovId(postRequest.getGovId());
            //
            paperModel.setGovProbjectType(postRequest.getGovProbjectType());
            paperModel.setGovProjectType(postRequest.getGovProjectType());

            repo.save(paperModel);
        }




    }
}
