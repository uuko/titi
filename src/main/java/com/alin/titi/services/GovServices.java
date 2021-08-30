package com.alin.titi.services;

import com.alin.titi.model.BookModel;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class GovServices {
    @Autowired
    private GovRepository repo;

    public void addGovData(GovRequest postRequest){
        int year = Calendar.getInstance().get(Calendar.YEAR);
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
        paperModel.setGovYear(postRequest.getGovYear());
        paperModel.setGovProbjectNumber(postRequest.getGovProbjectNumber());
        paperModel.setGovProbjectType(postRequest.getGovProbjectType());
        paperModel.setGovProjectAmount(postRequest.getGovProjectAmount());
        paperModel.setGovProjectNature(postRequest.getGovProjectNature());
        paperModel.setGovProjectName(postRequest.getGovProjectName());
        paperModel.setGovProbjectNumber(postRequest.getGovProbjectNumber());
        paperModel.setGovProbjectType(postRequest.getGovProbjectType());
        paperModel.setGovStdAllowance(postRequest.getGovStdAllowance());
        paperModel.setGovJobType(postRequest.getGovJobType());
        paperModel.setGovmain_govAmount(postRequest.getGovmain_govAmount());
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
        paperModel.setPublic(postRequest.isPublic());
        paperModel.setGovToOth(postRequest.isGovToOth());

        //

        paperModel.setPublic(postRequest.isPublic());
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
        paperModel.setGovYear(postRequest.getGovYear());
        paperModel.setGovProbjectNumber(postRequest.getGovProbjectNumber());
        paperModel.setGovProbjectType(postRequest.getGovProbjectType());
        paperModel.setGovProjectAmount(postRequest.getGovProjectAmount());
        paperModel.setGovProjectNature(postRequest.getGovProjectNature());
        paperModel.setGovProjectName(postRequest.getGovProjectName());
        paperModel.setGovProbjectNumber(postRequest.getGovProbjectNumber());
        paperModel.setGovProbjectType(postRequest.getGovProbjectType());
        paperModel.setGovStdAllowance(postRequest.getGovStdAllowance());
        paperModel.setGovJobType(postRequest.getGovJobType());
        paperModel.setGovmain_govAmount(postRequest.getGovmain_govAmount());
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
        paperModel.setPublic(postRequest.isPublic());
        paperModel.setGovToOth(postRequest.isGovToOth());

        //
        paperModel.setLoginId(postRequest.getLoginModel().getId());
        paperModel.setPublic(postRequest.isPublic());
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
            paperModel.setGovYear(postRequest.getGovYear());
            paperModel.setGovProbjectNumber(postRequest.getGovProbjectNumber());
            paperModel.setGovProbjectType(postRequest.getGovProbjectType());
            paperModel.setGovProjectAmount(postRequest.getGovProjectAmount());
            paperModel.setGovProjectNature(postRequest.getGovProjectNature());
            paperModel.setGovProjectName(postRequest.getGovProjectName());
            paperModel.setGovProbjectNumber(postRequest.getGovProbjectNumber());
            paperModel.setGovProbjectType(postRequest.getGovProbjectType());
            paperModel.setGovStdAllowance(postRequest.getGovStdAllowance());
            paperModel.setGovJobType(postRequest.getGovJobType());
            paperModel.setGovmain_govAmount(postRequest.getGovmain_govAmount());
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
            paperModel.setPublic(postRequest.isPublic());
            paperModel.setGovToOth(postRequest.isGovToOth());

            //
            paperModel.setLoginId(postRequest.getLoginModel().getId());
            paperModel.setPublic(postRequest.isPublic());
            paperModel.setGovId(postRequest.getGovId());
            responseList.add(paperModel);
        }


        return responseList;
    }
    public void updateGovData(GovPostRequest postRequest){
        int year = Calendar.getInstance().get(Calendar.YEAR);
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
            paperModel.setGovYear(postRequest.getGovYear());
            paperModel.setGovProbjectNumber(postRequest.getGovProbjectNumber());
            paperModel.setGovProbjectType(postRequest.getGovProbjectType());
            paperModel.setGovProjectAmount(postRequest.getGovProjectAmount());
            paperModel.setGovProjectNature(postRequest.getGovProjectNature());
            paperModel.setGovProjectName(postRequest.getGovProjectName());
            paperModel.setGovProbjectNumber(postRequest.getGovProbjectNumber());
            paperModel.setGovProbjectType(postRequest.getGovProbjectType());
            paperModel.setGovStdAllowance(postRequest.getGovStdAllowance());
            paperModel.setGovJobType(postRequest.getGovJobType());
            paperModel.setGovmain_govAmount(postRequest.getGovmain_govAmount());
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
            paperModel.setPublic(postRequest.isPublic());
            paperModel.setGovToOth(postRequest.isGovToOth());

            //
            paperModel.setPublic(postRequest.isPublic());
            paperModel.setGovId(postRequest.getGovId());
            repo.save(paperModel);
        }




    }
}
