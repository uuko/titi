package com.alin.titi.services;

import com.alin.titi.model.RegisterTeacherModel;
import com.alin.titi.model.TeacherRelationPK;
import com.alin.titi.model.TechChangeModel;
import com.alin.titi.model.TechChgeCompanyModel;
import com.alin.titi.model.api.request.TechChgDeleteRequest;
import com.alin.titi.model.api.request.TechChgRequest;
import com.alin.titi.model.api.request.TechCompanyRequest;
import com.alin.titi.repository.TeacherRepository;
import com.alin.titi.repository.TechChangeRepository;
import com.alin.titi.repository.TechChgeCompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;

@Service
@Transactional
public class TechChgServices {
    @Autowired
    private TechChgeCompanyRepo repo;

    public void saveTchChg(TechCompanyRequest techChgRequest) {
        TechChgeCompanyModel model=new TechChgeCompanyModel();
        model.setTecEndDate(techChgRequest.getTecEndDate());
        model.setTecStratDate(techChgRequest.getTecStratDate());
        model.setTecTransferAmount(techChgRequest.getTecTransferAmount());
        model.setTecTransferNumber(techChgRequest.getTecTransferNumber());
        model.setTechChangeModel(new TechChangeModel(techChgRequest.getTecId()));
        model.setTecTransferVendor(techChgRequest.getTecTransferVendor());
        repo.save(model);
    }

    public void deleteOne(TechChgDeleteRequest request){
        TechChgeCompanyModel model=repo.findByTecCompanyId(request.getId());
        repo.delete(model);
    }
    public void updateTchChg(TechChgRequest techChgRequest){
        TechChgeCompanyModel model=repo.findByTecCompanyId(techChgRequest.getTecCompanyId());
        model.setTecEndDate(techChgRequest.getTecEndDate());
        model.setTecStratDate(techChgRequest.getTecStratDate());
        model.setTecTransferAmount(techChgRequest.getTecTransferAmount());
        model.setTecTransferNumber(techChgRequest.getTecTransferNumber());
        model.setTecTransferVendor(techChgRequest.getTecTransferVendor());
        repo.save(model);
    }

    public TechChgRequest getOne(Integer id){
        TechChgeCompanyModel model=repo.findByTecCompanyId(id);
        TechChgRequest techChgRequest=new TechChgRequest();
        if (model!=null){

            techChgRequest.setTecEndDate(model.getTecEndDate());
            techChgRequest.setTecStratDate(model.getTecStratDate());
            techChgRequest.setTecTransferAmount(model.getTecTransferAmount());
            techChgRequest.setTecTransferNumber(model.getTecTransferNumber());
            techChgRequest.setTecTransferVendor(model.getTecTransferVendor());
            techChgRequest.setTecCompanyId(model.getTecCompanyId());
        }

        return techChgRequest;

    }

}
